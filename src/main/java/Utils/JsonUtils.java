package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public class JsonUtils {
    private static Logger logger = Logger.getLogger(JsonUtils.class);
    //Gson gson = new GsonBuilder()
    //        //序列化null
    //        .serializeNulls()
    //        // 设置日期时间格式，另有2个重载方法
    //        // 在序列化和反序化时均生效
    //        .setDateFormat("yyyy-MM-dd")
    //        // 禁此序列化内部类
    //        .disableInnerClassSerialization()
    //        //生成不可执行的Json（多了 )]}' 这4个字符）
    //        .generateNonExecutableJson()
    //        //禁止转义html标签
    //        .disableHtmlEscaping()
    //        //格式化输出
    //        .setPrettyPrinting()
    //        .create();

    public static <T> T ReadGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        logger.info(result);
        return result;
}

    public static final <T> T parseObject(String text, Class<T> clazz)// 把JSON文本parse为JavaBean
    {
       T user = JSON.parseObject(text, clazz);
    return  user;
    }

    public static final Object parse(String text)// 把JSON文本parse为JSONObject或者JSONArray
    {
        JSON jsonObject = (JSON) JSON.parse(text);
        logger.info(jsonObject);
        return jsonObject;
    }

    public static final JSONObject parseObject(String text) // 把JSON文本parse成JSONObject
    {
        JSONObject jsonObject = JSONObject.parseObject(text);
        logger.info(jsonObject);
        return jsonObject;
    }

    public static final JSONArray parseArray(String text) // 把JSON文本parse成JSONArray
    {
        JSONArray jsonArray = JSONArray.parseArray(text);

        return jsonArray;
    }

    public static final <T> List<T> parseArray(String text, Class<T> clazz) //把JSON文本parse成JavaBean集合
    {
        T user = JSON.parseObject(text, clazz);
        return (List<T>) user;
    }

    public static final String toJSONString(Object object) // 将JavaBean序列化为JSON文本
    {
        return null;
    }

    public static final String toJSONString(Object object, boolean prettyFormat) // 将JavaBean序列化为带格式的JSON文本
    {
        return null;
    }

    public static final Object toJSON(Object javaObject) //将JavaBean转换为JSONObject或者JSONArray。

    {
        return null;
    }

}
