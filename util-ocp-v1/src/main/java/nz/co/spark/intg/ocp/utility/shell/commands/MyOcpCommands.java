//package com.yash.shell.commands;
//
//import com.yash.beans.RestOcpClient;
//import com.yash.exceptions.OcpException;
//import com.yash.ocp.db.service.ModuleRouteInfoService;
//import com.yash.ocp.db.service.ModuleSatService;
//import com.yash.ocp.db.service.PodListService;
//import com.yash.ocp.db.service.RefrenceMasterService;
//import com.yash.ocp.utils.OcpUtil;
//import com.yash.provider.ocp.json.CMlist.CMSuccessResponse;
//import com.yash.provider.ocp.json.dclist.DcSuccessResponse;
//import com.yash.provider.ocp.json.podlists.PodListSuccessResponse;
//import com.yash.provider.ocp.json.projectlist.ProjectResponseList;
//import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.table.Table;
//
//import java.security.NoSuchAlgorithmException;
//
//
//@ShellComponent
//public class MyOcpCommands {
//
//    private static final String OCP_COMMANDS = "Ocp Commands";
//
//    @Autowired
//    RestOcpClient client;
//
//    @Autowired
//    RefrenceMasterService masterService;
//
//    @Autowired
//    ModuleSatService moduleStatService;
//
//    @Autowired
//    ModuleRouteInfoService moduleRouteInfoService;
//
//    @Autowired
//    PodListService podListService;
//
//    @ShellMethod(value = "List Projects", group = OCP_COMMANDS, prefix = "-")
//    public Table listProjects() throws NoSuchAlgorithmException, OcpException {
//        ResponseEntity<ProjectResponseList> response = client.getProjectList();
//        return OcpUtil.getTable(response.getBody());
//    }
//
//    @ShellMethod(value = "Ocp Dump", group = OCP_COMMANDS, prefix = "-")
//    public void ocpDump() throws NoSuchAlgorithmException, OcpException {
//        {
//            ResponseEntity<DcSuccessResponse> response = client.getDCList();
//            ResponseEntity<CMSuccessResponse> cmResponse = client.getConfigMapList();
//
//            masterService.createVersion();
//            moduleStatService.createModuleStat(response.getBody(), cmResponse.getBody());
//        }
//
//        {
//            ResponseEntity<RouteListSuccessResponse> response = client.getRouteList();
//            moduleRouteInfoService.createInfo(response.getBody());
//        }
//
//        {
//            ResponseEntity<PodListSuccessResponse> response = client.getPodList();
//            podListService.createPodList(response.getBody());
//        }
//    }
//
//    @ShellMethod(value = "Compare OCP Module Dump", group = OCP_COMMANDS, prefix = "-")
//    public Table compareVersions(int from, int to){
//
//       Table table = moduleStatService.compareLastTwoVersions(from,to);
//        moduleRouteInfoService.compareLastTwoVersions(from,to);
////        moduleStatService.printEnvChanges();
//
//
//       return table;
//
//    }
//
//    @ShellMethod(value = "Compare OCP Route Dump", group = OCP_COMMANDS, prefix = "-")
//    public void compareRoutes(int from, int to){
//
//         moduleRouteInfoService.compareLastTwoVersions(from,to);
//
//    }
//
//    @ShellMethod(value = "Compare OCP PodList Dump", group = OCP_COMMANDS, prefix = "-")
//    public void comparePod(int from, int to){
//
//        podListService.compareLastTwoVersions(from,to);
//
//    }
//
//    @ShellMethod(value = "Print Properties Changes", group = OCP_COMMANDS, prefix = "-")
//    public void getPropChanges(){
//
//       moduleStatService.printPropChanges();
//
//    }
//
//
//    @ShellMethod(value = "Print CPU and MEM Changes", group = OCP_COMMANDS, prefix = "-")
//    public void getCpuChanges(){
//
//        moduleStatService.printEnvChanges();
//
//    }
//
//
//}