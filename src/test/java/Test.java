import Utils.YamlUtils;
import com.google.gson.annotations.SerializedName;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;

/**
 * Created by jackiezero on 2016/12/26.
 */
public class Test {
    @SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
    public String emailAddress;
    public String name;
    public int age;
    LinkedHashMap aa;
    LinkedHashMap obj;
    private static Logger logger = Logger.getLogger(Test.class);
    public Test(){
        aa= (LinkedHashMap) YamlUtils.load();
    }
    public Test getValue(String key){
        obj = (LinkedHashMap) aa.get(key);
        return this;
    }
    public String get(String key){
        return obj.get(key).toString();
    }
    public static void main(String[] args){
        Test aa=new Test();
//        System.out.println(aa.getValue("spring").getValue("datasource").getValue("url"));
        System.out.println(aa.getValue("spring").getValue("datasource").get("url"));
    }
}
