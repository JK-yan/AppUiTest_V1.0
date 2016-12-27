import Utils.FileUtils;
import Utils.JsonUtils;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jackiezero on 2016/12/26.
 */
public class Test {
    @SerializedName(value = "emailAddress", alternate = {"email", "email_address"})
    public String emailAddress;
    public String name;
    public int age;




    public static void main(String[] args){
        String aa = "{\"_id\":1,\"id\":1,\"url\":\"http://webapp.fulihui.com/home/index/\",\"host\":\"webapp.fulihui.com\",\"path\":\"/home/index/\",\"method\":\"GET\",\"reqHeader\":{\"host\":\"webapp.fulihui.com\",\"proxy-connection\":\"keep-alive\",\"cache-control\":\"max-age=0\",\"upgrade-insecure-requests\":\"1\",\"user-agent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36\",\"accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"accept-language\":\"zh-CN,zh;q=0.8\",\"cookie\":\"CNZZDATA1259586382=1559642879-1481529975-%7C1481529975; JSESSIONID=FE266AED2C192B447120D9C362E6BA5C\",\"content-length\":0},\"startTime\":1481535281825,\"reqBody\":\"\",\"protocol\":\"http\",\"statusCode\":200,\"endTime\":1481535281858,\"resHeader\":{\"server\":\"openresty/1.9.15.1\",\"date\":\"Mon, 12 Dec 2016 09:34:42 GMT\",\"content-type\":\"text/html\",\"connection\":\"close\",\"last-modified\":\"Sun, 11 Dec 2016 06:38:30 GMT\",\"etag\":\"\\\"584cf466-3f3\\\"\",\"accept-ranges\":\"bytes\"},\"length\":1011,\"mime\":\"text/html\",\"duration\":33}\n" +
                "";
//        String aa = "{'_id':1,'id':1,'url':'http://webapp.fulihui.com/home/index/','host':'webapp.fulihui.com','path':'/home/index/','method':'GET','reqHeader':{'host':'webapp.fulihui.com','proxy-connection':'keep-alive','cache-control':'max-age=0','upgrade-insecure-requests':'1','user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36','accept':'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8','accept-language':'zh-CN,zh;q=0.8','cookie':'CNZZDATA1259586382=1559642879-1481529975-%7C1481529975; JSESSIONID=FE266AED2C192B447120D9C362E6BA5C','content-length':0},'startTime':1481535281825,'reqBody':'','protocol':'http','statusCode':200,'endTime':1481535281858,'resHeader':{'server':'openresty/1.9.15.1','date':'Mon, 12 Dec 2016 09:34:42 GMT','content-type':'text/html','connection':'close','last-modified':'Sun, 11 Dec 2016 06:38:30 GMT','etag':'584cf466-3f3','accept-ranges':'bytes'},'length':1011,'mime':'text/html','duration':33}}";

        List<String> json = FileUtils.ReadFile("/src/main/resources/aaab.json");
//        System.out.println(json);

            System.out.println(".................");
            System.out.println(json.get(1));
            for(int i=0;i<json.size();i++){
                gsontest aaa = JsonUtils.ReadJson(json.get(i), gsontest.class);
                System.out.println(aaa);
            }

//        String jsonData = "{'name':'John', 'age':20,'grade':{'course':'English','score':100,'level':'A'}}";
//              Student student = JsonUtils.ReadJson(FileUtils.ReadFile("/src/main/resources/aaab.json"), Student.class);
//               System.out.println(student);
//        ;

    }
}
