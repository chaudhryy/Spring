package nz.co.spark.intg.ocp.utility.ocp.db.service;

import nz.co.spark.intg.ocp.utility.cache.PodCache;
import nz.co.spark.intg.ocp.utility.model.ExcelPojoRow;
import nz.co.spark.intg.ocp.utility.model.Pod;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ReportGenerationService {

    @Autowired
    PodCache podCache;

    @Autowired
    ExcelService service;

    @Value("${fuse.max.cpu}")
    long cpuMaxValue;

    @Value("${fuse.max.memory}")
    String memMaxValue;

    List<ExcelPojoRow> pojoRowList = new LinkedList<>();

    public void generateReport(String release) {
        String header = release + " report";
        {
            ExcelPojoRow row = new ExcelPojoRow(header, header, header, header, header, header, header, header, header, header, header);
            pojoRowList.add(row);
            row.setColor(IndexedColors.GREY_50_PERCENT);
            row.setSize((short) 18);
            row.setBold(true);
            row.sethAllignment(HorizontalAlignment.CENTER);
            row.setStyle(BorderStyle.THICK);
        }
        {
            ExcelPojoRow row = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
            pojoRowList.add(row);
        }
        {
            String cellValue = (podCache.getNewDeploy().size()+podCache.getBothChange().size() + podCache.getBuildChange().size() + podCache.getConfigChange().size() + podCache.getNoChange().size()) + "";
            ExcelPojoRow row = new ExcelPojoRow("", "", "Total Deployed", cellValue, cellValue, cellValue, cellValue, "", "", "", "");
            ExcelPojoRow row1 = new ExcelPojoRow("", "", "BreakUp", "Total", "Build Change", "Config Change", "Both", "None", "", "", "");
            row1.setSize((short)11);
            row1.setBold(true);
            ExcelPojoRow row2 = new ExcelPojoRow("", "", "New Deploy", ""+podCache.getNewDeploy().size(), "0", "0", ""+podCache.getNewDeploy().size(), "0", "", "", "");
            String total = (+podCache.getBothChange().size() + podCache.getBuildChange().size() + podCache.getConfigChange().size() + podCache.getNoChange().size()) + "";

            ExcelPojoRow row3 = new ExcelPojoRow("", "", "Re Deploy", ""+total, ""+podCache.getBuildChange().size(), ""+podCache.getConfigChange().size(), ""+podCache.getBothChange().size(), ""+podCache.getNoChange().size(), "", "", "");

            pojoRowList.add(row);
            pojoRowList.add(row1);
            pojoRowList.add(row2);
            pojoRowList.add(row3);


        }


        {
            ExcelPojoRow row = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
            pojoRowList.add(row);
        }

        {
            ExcelPojoRow row = new ExcelPojoRow("", "Total Cpu Used", "Total Cpu Used", "Max Cpu", "Mem Used", " Max Mem", "", "","Large (500m)", "Medium (300m)", "Small(200m)");
            row.setSize((short)11);
            row.setBold(true);
            pojoRowList.add(row);
        }
            podCache.calculateCpuMem();
    
        {
            ExcelPojoRow row = new ExcelPojoRow("Post Deployment", podCache.getPostCpuLimit()+"", podCache.getPostCpuLimit()+"", cpuMaxValue+"", podCache.getPostMemLimit()+"", memMaxValue+"", "", "",getPod(500,podCache.getPostCpuLimit()), getPod(300,podCache.getPostCpuLimit()), getPod(200,podCache.getPostCpuLimit()));
            pojoRowList.add(row);
        }
        {
            ExcelPojoRow row = new ExcelPojoRow("Pre Deployment", podCache.getPreCpuLimit()+"", podCache.getPreCpuLimit()+"", cpuMaxValue+"", podCache.getPreCpuLimit()+"", memMaxValue +"","", "",getPod(500,podCache.getPreCpuLimit()), getPod(300,podCache.getPreCpuLimit()), getPod(200,podCache.getPreCpuLimit()));
            pojoRowList.add(row);
        }

        {
            ExcelPojoRow row = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
            pojoRowList.add(row);
        }

        {
            String nHeader = "Configuration Statistics";
            ExcelPojoRow row = new ExcelPojoRow(nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader);
            pojoRowList.add(row);
            row.setColor(IndexedColors.GREY_25_PERCENT);
            row.setSize((short) 14);
            row.setBold(true);
        }
        {
            ExcelPojoRow row = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
            pojoRowList.add(row);
        }

        {
            ExcelPojoRow row = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
            pojoRowList.add(row);
        }
        {
            String nHeader = "Modular Statistics";
            ExcelPojoRow row = new ExcelPojoRow(nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader);
            pojoRowList.add(row);
            row.setColor(IndexedColors.GREY_25_PERCENT);
            row.setSize((short) 14);
            row.setBold(true);
            row.sethAllignment(HorizontalAlignment.CENTER);
        }
        {
            String nHeader = "New Fuse Modules";
            ExcelPojoRow row = new ExcelPojoRow(nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader, nHeader);
            row.setColor(IndexedColors.GREY_25_PERCENT);
            row.setSize((short) 12);
            row.setBold(true);
        }
        
        fillFuseModules();
        service.createExcel(pojoRowList,release);
    }

    private void fillFuseModules() {

        Map<String, Pod> podDiff = podCache.getPodDiff();

        for(Map.Entry<String, Pod> pod : podDiff.entrySet()){
            {
                    Pod aValue =pod.getValue();
                ExcelPojoRow row = new ExcelPojoRow("Fuse Module", pod.getKey(), pod.getKey(),  "Build","Build",aValue.getBuild().getNewVersion(), aValue.getBuild().getNewVersion(), "Release","Release" ,aValue.getBuild().getNewVersion(),aValue.getBuild().getNewVersion());
                pojoRowList.add(row);

                if(aValue.getBuild().getPreviousVersion() != null){
                    ExcelPojoRow row1 = new ExcelPojoRow("", "", "", "Previous Build", "Previous Build", aValue.getBuild().getPreviousVersion(), aValue.getBuild().getPreviousVersion(), "Previous Release", "Previous Release",aValue.getBuild().getPreviousVersion(),aValue.getBuild().getPreviousVersion());
                    pojoRowList.add(row1);
                    {
                        ExcelPojoRow emptyRow = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
                        pojoRowList.add(emptyRow);
                    }
                    {
                        ExcelPojoRow row2 = new ExcelPojoRow("","", "", "Post", "Post", "Pre", "Pre","","","Post","Pre");
                        row2.setColor(IndexedColors.GREY_25_PERCENT);
                        row2.setBold(true);
                        pojoRowList.add(row2);
                    }

                    {

                        ExcelPojoRow row2 = new ExcelPojoRow("","Request", "Request", aValue.getCpuRequest().getNewVersion(), aValue.getMemRequest().getNewVersion(), aValue.getCpuRequest().getPreviousVersion(), aValue.getMemRequest().getPreviousVersion(),"","Heap",aValue.getHeap().getNewVersion(),aValue.getHeap().getPreviousVersion());
                        pojoRowList.add(row2);
                    }
                    {

                        ExcelPojoRow row2 = new ExcelPojoRow("","Limit", "Limit", aValue.getCpuLimit().getNewVersion(), aValue.getMemLimit().getNewVersion(), aValue.getCpuLimit().getPreviousVersion(), aValue.getMemLimit().getPreviousVersion(),"","","","");
                        pojoRowList.add(row2);
                    }

                    {
                        ExcelPojoRow emptyRow = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
                        pojoRowList.add(emptyRow);
                    }

                    {
                        String header = "Endpoint List";
                        ExcelPojoRow headerRow = new ExcelPojoRow(header, header, header, header, header, header,header,header, header,header, header);
                        headerRow.setBold(true);
                        headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                        pojoRowList.add(headerRow);

                    }
                    {
                        int count = aValue.getSoapListAdded().size() +aValue.getSoapListDeleted().size() +aValue.getSoapListDiff().size();
                        if (count >0) {
                            String header = "Soap List";
                            ExcelPojoRow headerRow = new ExcelPojoRow(header, header, header, header, header, header,header,header, header,header, header);
                            headerRow.setBold(true);
                            headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                            pojoRowList.add(headerRow);
                            if(aValue.getSoapListAdded().size() >0){
                                String value = "Endpoints Added";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                {
                                    String jKey = "Endpoint Tag";
                                    String jValue = "EndPoint Value";

                                    ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                                    headerRow.setBold(true);
                                    pojoRowList.add(jeheaderRow);
                                }
                                for(Map.Entry<String, String> entry : aValue.getSoapListAdded().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), url, url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }
                            if(aValue.getSoapListDeleted().size() >0){
                                String value = "Endpoints Deleted";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                {
                                    String jKey = "Endpoint Tag";
                                    String jValue = "EndPoint Value";

                                    ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                                    headerRow.setBold(true);
                                    pojoRowList.add(jeheaderRow);
                                }
                                for(Map.Entry<String, String> entry : aValue.getSoapListDeleted().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), url, url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }

                            if(aValue.getSoapListDiff().size() >0){
                                String value = "Endpoints Changed";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                {
                                    String jKey = "Endpoint Tag";
                                    String jValue = "EndPoint Value";

                                    ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                                    headerRow.setBold(true);
                                    pojoRowList.add(jeheaderRow);
                                }
                                for(Map.Entry<String, String> entry : aValue.getSoapListDiff().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), url, url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }

                        }

                    }
                    {
                        int count = aValue.getRestListAdded().size() +aValue.getRestListDeleted().size() +aValue.getRestListDiff().size();
                        if (count >0) {
                            String header = "Rest List";
                            ExcelPojoRow headerRow = new ExcelPojoRow(header, header, header, header, header, header,header,header, header,header, header);
                            headerRow.setBold(true);
                            headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                            pojoRowList.add(headerRow);
                            if(aValue.getRestListAdded().size() >0){
                                String value = "Endpoints Added";

                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                {
                                    String jKey = "Endpoint Tag";
                                    String jValue = "EndPoint Value";

                                    ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                                    headerRow.setBold(true);
                                    pojoRowList.add(jeheaderRow);
                                }
                                for(Map.Entry<String, String> entry : aValue.getRestListAdded().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), url, url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }
                            if(aValue.getRestListDeleted().size() >0){
                                String value = "Endpoints Deleted";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                {
                                    String jKey = "Endpoint Tag";
                                    String jValue = "EndPoint Value";

                                    ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                                    headerRow.setBold(true);
                                    pojoRowList.add(jeheaderRow);
                                }
                                for(Map.Entry<String, String> entry : aValue.getRestListDeleted().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), url, url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }

                            if(aValue.getRestListDiff().size() >0){
                                String value = "Endpoints Changed";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                {
                                    String jKey = "Endpoint Tag";
                                    String jValue = "EndPoint Value";

                                    ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                                    headerRow.setBold(true);
                                    pojoRowList.add(jeheaderRow);
                                }
                                for(Map.Entry<String, String> entry : aValue.getRestListDiff().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), url, url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }

                        }

                    }
                    {
                        ExcelPojoRow emptyRow = new ExcelPojoRow("", "", "", "", "", "", "", "", "", "", "");
                        pojoRowList.add(emptyRow);
                    }
                    {
                        int count = aValue.getConfigAdded().size() +aValue.getConfigDeleted().size() +aValue.getConfigDiff().size();
                        if (count >0) {
                            String header = "Properties List";
                            ExcelPojoRow headerRow = new ExcelPojoRow(header, header, header, header, header, header,header,header, header,header, header);
                            headerRow.setBold(true);
                            headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                            pojoRowList.add(headerRow);

                            String jKey = "Property Key";
                            String jValue = "Property Value";

                            ExcelPojoRow jeheaderRow = new ExcelPojoRow(jKey, jKey, jKey, jValue, jValue, jValue,jValue,jValue, jValue,jValue, jValue);
                            headerRow.setBold(true);
//                            headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                            pojoRowList.add(jeheaderRow);

                            if(aValue.getConfigAdded().size() >0){
                                String value = "Properties Added";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                for(Map.Entry<String, String> entry : aValue.getConfigAdded().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), entry.getKey(), url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }
                            if(aValue.getConfigDeleted().size() >0){
                                String value = "Properties Deleted";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                for(Map.Entry<String, String> entry : aValue.getConfigDeleted().entrySet() ){
                                    String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), entry.getKey(), url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }

                            if(aValue.getConfigDiff().size() >0){
                                String value = "Properties Changed";
                                ExcelPojoRow record = new ExcelPojoRow(value, value, value, value, value, value,value,value, value,value, value);
                                headerRow.setBold(true);
//                                headerRow.setColor(IndexedColors.GREY_25_PERCENT);
                                pojoRowList.add(record);
                                for(Map.Entry<String, String> entry : aValue.getConfigDiff().entrySet() ){
                                     String url = entry.getValue();
                                    ExcelPojoRow nrecord = new ExcelPojoRow(entry.getKey(), entry.getKey(), entry.getKey(), url, url, url,url,url, url,url, url);
                                    pojoRowList.add(nrecord);
                                }
                            }

                        }

                    }
                }
            }
        }

    }

    private String getPod(int limit, long used) {
            long remaining=cpuMaxValue - used;
            long value = (remaining)/limit;
            return value+"";
    }





}
