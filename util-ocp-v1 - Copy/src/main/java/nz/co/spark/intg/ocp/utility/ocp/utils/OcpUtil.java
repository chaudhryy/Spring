package nz.co.spark.intg.ocp.utility.ocp.utils;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OcpUtil {


//    public static Table getTable(ProjectResponseList response) {
//        if (response != null && !CollectionUtils.isEmpty(response.getItems())) {
//            String[][] data = new String[(response.getItems().size() +1)][2];
//            TableModel model = new ArrayTableModel(data);
//            TableBuilder tableBuilder = new TableBuilder(model);
//
//            int i = 0;
//
//            data[i][0] = "Namespace";
//
//            tableBuilder.on(at(i, 0)).addAligner(SimpleHorizontalAligner.left);
//            tableBuilder.on(at(i, 0)).addAligner(SimpleVerticalAligner.middle);
//            data[i][1] = "Description";
//
//            tableBuilder.on(at(i, 1)).addAligner(SimpleHorizontalAligner.left);
//            tableBuilder.on(at(i, 1)).addAligner(SimpleVerticalAligner.middle);
//            i++;
//            for(Item item : response.getItems()){
//                if(item.getMetadata() != null && item.getMetadata().getAnnotations() != null) {
//
//                    int j = 0;
//                    data[i][j] = item.getMetadata().getName();
//                    tableBuilder.on(at(i, j)).addAligner(SimpleHorizontalAligner.left);
//                    tableBuilder.on(at(i, j)).addAligner(SimpleVerticalAligner.middle);
//                    j++;
//                    data[i][j] = item.getMetadata().getAnnotations().getOpenshiftIoDescription();
//
//                    tableBuilder.on(at(i, j)).addAligner(SimpleHorizontalAligner.left);
//                    tableBuilder.on(at(i, j)).addAligner(SimpleVerticalAligner.middle);
//                    i++;
//                }
//            }
//
//            return tableBuilder.addFullBorder(BorderStyle.fancy_light_double_dash).build();
//        }
//        return null;
//
//    }

    public static String getHeapFormEnv(String string) {

            Pattern pattern = Pattern.compile("Xmx[0-9]*[a-zA-Z]");
            Matcher matcher = pattern.matcher(string);
            if (matcher.find())
            {
                return (matcher.group(0).replace("Xmx",""));
            }
            return "0";


    }

    public static Map<String, String> getEnvList(String envVariables) {
        Map<String, String> retMap=new HashMap<>();

        if (!StringUtils.isEmpty(envVariables)){
            String [] keyValueArr = envVariables.split(",");
            if(keyValueArr != null && keyValueArr.length >0){
                    for(String valueArr : keyValueArr){
                        if(!StringUtils.isEmpty(valueArr)){
                                String[] newArr =valueArr.split("=");
                            if(newArr != null && newArr.length >1){
                                retMap.put(newArr[0],newArr[1]);
                            }
                        }
                    }

            }
        }

        return  retMap;
    }

//    public static Table getPodListTable(PodListSuccessResponse response) {
//
//
//    }
}
