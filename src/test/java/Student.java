import Utils.FileUtils;
import Utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public class Student {


        public static void main(String[] args){
            String jsonStr = "{\"JACKIE_ZHANG\":\"张学友\",\"ANDY_LAU\":\"刘德华\",\"LIMING\":\"黎明\",\"Aaron_Kwok\":\"郭富城\"}" ;
            String jsonSsstr = "{\"_id\":1,\"id\":1,\"url\":\"http://webapp.fulihui.com/home/index/\",\"host\":\"webapp.fulihui.com\",\"path\":\"/home/index/\",\"method\":\"GET\",\"reqHeader\":{\"host\":\"webapp.fulihui.com\",\"proxy-connection\":\"keep-alive\",\"cache-control\":\"max-age=0\",\"upgrade-insecure-requests\":\"1\",\"user-agent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36\",\"accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"accept-language\":\"zh-CN,zh;q=0.8\",\"cookie\":\"CNZZDATA1259586382=1559642879-1481529975-%7C1481529975; JSESSIONID=FE266AED2C192B447120D9C362E6BA5C\",\"content-length\":0},\"startTime\":1481535281825,\"reqBody\":\"\",\"protocol\":\"http\",\"statusCode\":200,\"endTime\":1481535281858,\"resHeader\":{\"server\":\"openresty/1.9.15.1\",\"date\":\"Mon, 12 Dec 2016 09:34:42 GMT\",\"content-type\":\"text/html\",\"connection\":\"close\",\"last-modified\":\"Sun, 11 Dec 2016 06:38:30 GMT\",\"etag\":\"\\\"584cf466-3f3\\\"\",\"accept-ranges\":\"bytes\"},\"length\":1011,\"mime\":\"text/html\",\"duration\":33}\n" ;
            List<String> json = FileUtils.ReadFile("/src/main/resources/aaab.json");
            //做5次测试

                for (int a = 0; a < json.size(); a++) {
                    JSON jsonObject = (JSON) JSON.parse(json.get(a));
                    //JSONObject aa = (JSONObject) JsonUtils.parse(json.get(a));

                    //JSONObject jsonObject = <T> JSON.parseObject(json.get(a),Class<T> clazz);
                    //public static final <T> T parseObject(String text, Class<T> clazz)
                    //jsonObject.toString();
                    JSONObject jsona = (JSONObject) JsonUtils.parseObject(json.get(a)).get("reqHeader");
                    System.out.println(JsonUtils.parse(json.get(a)).toString());//用来换行
                    System.out.println(JsonUtils.parseObject(json.get(a)).get("reqHeader"));//用来换行
                    System.out.println(jsona.get("host"));
                    //System.out.println(aa.get("host"));
                }
        }

}

