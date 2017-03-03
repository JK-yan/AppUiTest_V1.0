import com.google.gson.annotations.SerializedName;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * Created by jackiezero on 2016/12/26.
 */
public class Test {
    @SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
    public String emailAddress;
    public String name;
    public int age;
    //LinkedHashMap aa;
    //LinkedHashMap obj;
    //private static Logger logger = Logger.getLogger(Test.class);
    //public Test(){
    //    aa= (LinkedHashMap) YamlUtils.load();
    //}
    //public Test getValue(String key){
    //    obj = (LinkedHashMap) aa.get(key);
    //    return this;
    //}
    //public String get(String key){
    //    return obj.get(key).toString();
    //}
    private static String a = "androiddriver";
//    String te = Class.getResource("/");
    public static void main(String[] args) {

//URL te = getClassLoader.getResource("/");
//        InputStream te = Test.class.getClassLoader().getResourceAsStream("");
        InputStream te = Test.class.getResourceAsStream("/");
        Yaml yaml = new Yaml();
//        File f=new File(te);
        //读入文件
      /*  Object result= yaml.load(te);
        Object result= yaml.load(new FileInputStream(te));
        Object result= yaml.load(te);
        System.out.println(result);*/
        System.out.println(te);



    }
}
