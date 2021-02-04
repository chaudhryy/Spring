package nz.co.spark.intg.ocp.utility.ocp.utils;

import nz.co.spark.intg.ocp.utility.ocp.db.model.RootRefrenceMaster;
import org.apache.commons.codec.binary.Base64;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbUtil {

    public static int getNextId(Iterable<RootRefrenceMaster> iterable) {
      int max =0;
        if (iterable != null) {
            for(RootRefrenceMaster master:iterable){
                Integer version = master.getVersion();
                if(master != null && version != null && max < version){
                    max=version;
                }

            }

        }

    return  max++;
    }

    public static String getRelease(String name) {

        Pattern pattern = Pattern.compile("release-[0-9]*-[0-9]*");
        Matcher matcher = pattern.matcher(name);
        if (matcher.find())
        {
            return matcher.group(0);
        }
        return name;
    }

    public static void main(String[] args) {
        getRelease("wib-manage-v1-release-20-2-54887");
    }

    public static String decodeBase64(String encodedString) {
        byte[] byteArray = Base64.decodeBase64(encodedString.getBytes());


       return new String(byteArray);
    }
}
