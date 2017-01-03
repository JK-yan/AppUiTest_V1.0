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
    private static String a = "androiddriver";
    public static void main(String[] args){


        switch (Test.a){
            case "androiddriver":
                System.out.println(a);
                break;
            case "asd":
                System.out.println("sda");
                break;
            default:
                System.out.println("默认");
                break;
        }

    }
}
