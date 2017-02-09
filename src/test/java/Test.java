import com.google.gson.annotations.SerializedName;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
    public static void main(String[] args) throws FileNotFoundException {


        Yaml yaml = new Yaml();
        File f=new File("E:\\Code\\AppUiTest_V1.0\\src\\main\\java\\conf\\base.yaml");
        //读入文件
        Object result= yaml.load(new FileInputStream(f));
        System.out.println(result.getClass());
        System.out.println( result);

    }
}
