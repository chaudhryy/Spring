package com.yash.ocp.db.service;

import com.yash.cache.LocalCache;
import com.yash.model.Pod;
import com.yash.cache.PodCache;
import com.yash.ocp.db.DbUtil;
import com.yash.ocp.db.dao.ModuleStatDao;
import com.yash.ocp.db.model.ModuleStat;
import com.yash.ocp.utils.OcpUtil;
import com.yash.provider.ocp.json.CMlist.CMSuccessResponse;
import com.yash.provider.ocp.json.dclist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.table.Table;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

@Service
public class ModuleSatService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ModuleStatDao dao;


    @Autowired
    LocalCache cache;

    @Autowired
    PodCache podCache;


   public void createModuleStat(DcSuccessResponse responseList, CMSuccessResponse cmResponse){
        if(responseList != null){

            if(!CollectionUtils.isEmpty(responseList.getItems())){
                long count= dao.count();
                for(Item item : responseList.getItems()){
                    if(item != null && item.getMetadata() != null && !item.getMetadata().getName().startsWith("amq")){
                       count++;
                        Metadata_ metadata = item.getMetadata();
                        ModuleStat stat = new ModuleStat();
                        stat.setVersion(cache.getLastVersion());
                        if (metadata.getLabels() != null) {
                            stat.setModule_Name(metadata.getLabels().getApp());
                        }
                        stat.setDc_Version(metadata.getName());
                        stat.setRelease(DbUtil.getRelease(metadata.getName()));
                        if (item.getSpec() != null ){
                                if(item.getSpec().getTemplate() != null &&
                                item.getSpec().getTemplate().getSpec() != null &&
                                item.getSpec().getTemplate().getSpec().getContainers() != null) {

                            for(Container container : item.getSpec().getTemplate().getSpec().getContainers()){
                                if(container!= null && container.getName() != null && container.getName().equals(stat.getModule_Name())) {
                                    if (container.getResources() != null) {
                                        Limits limits = container.getResources().getLimits();
                                        Requests requests = container.getResources().getRequests();
                                        stat.setCpu_Limit(limits.getCpu());
                                        stat.setMemory_Limit(limits.getMemory());
                                        stat.setCpu_Requests(requests.getCpu());
                                        stat.setMemory_Requests(requests.getMemory());

//                                        stat.setEnv_Variables(.);
                                    }
                                    if(!CollectionUtils.isEmpty(container.getEnv())){
                                        getAndSetEnvs(stat,container.getEnv());
                                    }
                                }
                                }
                            }
//                                    if(item.getSpec().getReplicas() != null){
                                        stat.setReplicas(item.getSpec().getReplicas());
//                                    }
                            stat.setId(count);
                            stat.setConfig_Map(getcmFromCMList(stat.getModule_Name(),cmResponse));
                        }
                        System.out.println("Successfully Processed POD " + stat.getModule_Name() + " ,Provisioned Version " + cache.getLastVersion());
                        dao.save(stat);

                    }
                }
            }

        }

    }

    private String getcmFromCMList(String module_name, CMSuccessResponse cmResponse) {
       if(cmResponse != null && !CollectionUtils.isEmpty(cmResponse.getItems())){
           for(com.yash.provider.ocp.json.CMlist.Item item : cmResponse.getItems()){
                if(item!= null && item.getMetadata() != null && item.getMetadata().getName().equalsIgnoreCase(module_name)){

                    return item.getData().getApplicationProperties();
                }
           }
       }
       return null;
    }

    private void getAndSetEnvs(ModuleStat stat, List<Env> envList) {
        StringJoiner joinerJavaArgs = new StringJoiner(",");
        StringJoiner joinerSecretArgs = new StringJoiner(",");

        for(Env env: envList){
                if(env != null ){
                    if("JAVA_OPTIONS".equals(env.getName()) || "JAVA_ARGS".equals(env.getName())){
                       String value =env.getValue().replace("-D","")
                               .replace("--","")
                                    .replace(" -",",")
                                        .replace(" ","");
                        joinerJavaArgs.add(value);
                    }else {
                        if(env.getValue() != null) {
                            joinerSecretArgs.add(env.getName() + "=" + env.getValue());
                        }else{
                            joinerSecretArgs.add(env.getName() + "=" + "Secret."+env.getValueFrom().getSecretKeyRef().getName()+"."+env.getValueFrom().getSecretKeyRef().getKey());
                        }
                    }
                }
            }

            stat.setJava_Options(joinerJavaArgs.toString());
            stat.setEnv_Variables(joinerSecretArgs.toString());
    }

    public Table compareLastTwoVersions(int from, int to) {

        Map<String, ModuleStat> recentVersion = new HashMap<>();
        Map<String,ModuleStat> prevVersion = new HashMap<>();

        {
            Iterable<ModuleStat> podList = dao.findAll();

            if (podList != null) {
                for (ModuleStat pod : podList) {
                    if (pod.getVersion() == from) {
                        recentVersion.put(pod.getModule_Name(), pod);
                    } else if (pod.getVersion() == to) {
                        prevVersion.put(pod.getModule_Name(), pod);
                    }
                }
            }
        }

        compare(recentVersion,prevVersion);

        return podCache.printStatistics();
    }

    private void compare(Map<String, ModuleStat> recentVersion, Map<String, ModuleStat> prevVersion) {

       for(Map.Entry<String, ModuleStat> entry: recentVersion.entrySet()){

           ModuleStat stat = prevVersion.get(entry.getKey());
           compareBuildConfig(entry, stat);
           compareMemoryCpu(entry.getValue(),stat);
           compareEnv(entry.getValue(),stat);
       }
    }

    private void compareEnv(ModuleStat nVersion, ModuleStat pVersion) {
       Pod pod = podCache.getPod(nVersion.getModule_Name());
       Map<String,String> nEnvList = OcpUtil.getEnvList(nVersion.getEnv_Variables());
        Map<String,String> oEnvList = new HashMap<>();
        if (pVersion != null) {
            oEnvList = OcpUtil.getEnvList(pVersion.getEnv_Variables());
        }

        for(Map.Entry<String, String> entry :  nEnvList.entrySet()){
            String val = oEnvList.get(entry.getKey());
            if(val == null){
                pod.getEnvVariablesAdded().add(entry.getKey()+"="+entry.getValue());
            }else if(!val.equals(entry.getValue())){
                pod.getEnvVariablesDiff().add(entry.getKey()+"="+entry.getValue());
            }
        }

        for(Map.Entry<String, String> entry :  oEnvList.entrySet()){
            String val = nEnvList.get(entry.getKey());
            if(val == null){
                pod.getEnvVariablesDeleted().add(entry.getKey()+"="+entry.getValue());
            }
        }


    }

    private void compareMemoryCpu(ModuleStat nVersion, ModuleStat pVersion) {
       Pod pod = podCache.getPod(nVersion.getModule_Name());
        pod.getReplicas().setNewVersion(nVersion.getReplicas()+"");
        pod.getCpuRequest().setNewVersion(nVersion.getCpu_Requests());
        pod.getCpuLimit().setNewVersion(nVersion.getCpu_Limit());
        pod.getMemLimit().setNewVersion(nVersion.getMemory_Limit());
        pod.getMemRequest().setNewVersion(nVersion.getMemory_Requests());

        String pHeap = null;
        if (pVersion != null) {
            pod.getReplicas().setPreviousVersion(pVersion.getReplicas()+"");
            pod.getCpuRequest().setPreviousVersion(pVersion.getCpu_Requests());
            pod.getCpuLimit().setPreviousVersion(pVersion.getCpu_Limit());
            pod.getMemLimit().setPreviousVersion(pVersion.getMemory_Limit());
            pod.getMemRequest().setPreviousVersion(pVersion.getMemory_Requests());


            pHeap = OcpUtil.getHeapFormEnv(pVersion.getJava_Options());
        }
        String nHeap = OcpUtil.getHeapFormEnv(nVersion.getJava_Options());

        pod.getHeap().setPreviousVersion(pHeap);
        pod.getHeap().setNewVersion(nHeap);
    }

    private void compareBuildConfig(Map.Entry<String, ModuleStat> entry, ModuleStat stat) {
        if(stat == null){
             podCache.getBothChange().add(entry.getKey());
             podCache.getNewDeploy().put(entry.getKey(),getPod(entry.getValue()));
        }else{
           boolean isChanged= compareConfig(entry.getValue(),stat);
           boolean isBuildChanged = compareBuild(entry.getValue(),stat);
           if(isBuildChanged && isChanged){
               podCache.getBothChange().add(entry.getKey());
           }else if(isBuildChanged){
               podCache.getBuildChange().add(entry.getKey());
           }else if (isChanged){
               podCache.getConfigChange().add(entry.getKey());
           }else{
               podCache.getNoChange().add(entry.getKey());
           }
        }
    }

    private boolean compareBuild(ModuleStat nStat, ModuleStat oStat) {
       boolean isChanged = false;
       if(oStat == null){
           return  true;
       }else if( !(nStat != null && nStat.getDc_Version().equals(oStat.getDc_Version()))){
            Pod pod= podCache.getPod(nStat.getModule_Name());
            pod.getBuild().setNewVersion(nStat.getDc_Version());
            pod.getBuild().setPreviousVersion(oStat.getDc_Version());
            pod.getRelease().setNewVersion(nStat.getRelease());
            pod.getRelease().setPreviousVersion(oStat.getRelease());
            isChanged = true;

       }
        return isChanged;
    }

    private boolean compareConfig(ModuleStat newV, ModuleStat oldV) {
       boolean isChanged = false;
       if(oldV.getConfig_Map().equalsIgnoreCase(newV.getConfig_Map())){
           return false;
       }else{
           try {
               Properties nProperties = new Properties();
               InputStream nVersion= new ByteArrayInputStream(newV.getConfig_Map().getBytes(Charset.forName("UTF-8")));

               nProperties.load(nVersion);

               Properties oProperties = new Properties();
               InputStream oVersion= new ByteArrayInputStream(oldV.getConfig_Map().getBytes(Charset.forName("UTF-8")));

               oProperties.load(oVersion);

               Enumeration<?> newPropEnumeration =nProperties.propertyNames();
               Enumeration<?> oldPropEnumeration =oProperties.propertyNames();

               while(newPropEnumeration.hasMoreElements()){
                    String nkey = (String) newPropEnumeration.nextElement();
                    String nValue = (String) nProperties.get(nkey);
                   String oValue = (String) oProperties.get(nkey);
                   if(oValue == null){
                       podCache.setPodPropAdded(newV.getModule_Name(),nkey,nValue);
                       isChanged = true;
                   }else if (!oValue.equals(nValue)){
                       podCache.setPodPropChange(newV.getModule_Name(),nkey,nValue);
                       isChanged = true;
                   }

               }

               while(oldPropEnumeration.hasMoreElements()){
                   String okey = (String) oldPropEnumeration.nextElement();
                   String nValue = (String) nProperties.get(okey);
                   String oValue = (String) oProperties.get(okey);

                   if ( nValue == null){
                       podCache.setPodPropDeleted(newV.getModule_Name(),okey,oValue);
                       isChanged = true;
                   }

               }


           } catch (IOException e) {
               System.out.println("Exception " + e.getLocalizedMessage());
           }

       }
     return isChanged;
    }



    private Pod getPod(ModuleStat value) {
        Pod pod = new Pod();
        pod.getBuild().setNewVersion(value.getDc_Version());
        pod.getRelease().setNewVersion(value.getRelease());
        pod.getCpuRequest().setNewVersion(value.getCpu_Requests());
        pod.getMemLimit().setNewVersion(value.getMemory_Limit());
        pod.getMemRequest().setNewVersion(value.getMemory_Requests());
        pod.getReplicas().setNewVersion(value.getReplicas()+"");

        String nHeap = OcpUtil.getHeapFormEnv(value.getJava_Options());
        pod.getHeap().setNewVersion(nHeap);

        return pod;
    }

    public void printPropChanges() {
       podCache.printPropInfo();
    }

    public void printEnvChanges() {

    }
}
