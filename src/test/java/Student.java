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

