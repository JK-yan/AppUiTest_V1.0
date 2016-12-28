import Utils.YamlUtils;
import com.google.gson.annotations.SerializedName;

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

    public static void main(String[] args){

        //getValue("spring","datasource","driverClassName");
        //System.out.println(getValue("spring"));
        //Object aa=YamlUtils.load();
        //System.out.println(aa.toString());
//        System.out.println(aa.getValue("spring").getValue("datasource").getValue("url"));
//        System.out.println(YamlUtils.LoadallgetValue("spring","application","cruncher"));
//        System.out.println(YamlUtils.Loadallgetvalue("spring","application","cruncher"));
        System.out.println(YamlUtils.Loadallgetvalue(1,"spring","application","name"));
    }
}
