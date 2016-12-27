package Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sun.jna.platform.win32.Netapi32Util;

import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public class JsonUtils {
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

        return result;
}

    public static final <T> T parseObject(String text, Class<T> clazz)// 把JSON文本parse为JavaBean
    {
        Netapi32Util.User user = JSON.parseObject(text, Netapi32Util.User.class);
    return (T) user;
}

    public static final Object parse(String text)// 把JSON文本parse为JSONObject或者JSONArray
    {
        JSON jsonObject = (JSON) JSON.parse(text);
        return jsonObject;
    }

    public static final JSONObject parseObject(String text) // 把JSON文本parse成JSONObject
    {
        JSONObject jsonObject = JSONObject.parseObject(text);
        return jsonObject;
    }

    public static final JSONArray parseArray(String text) // 把JSON文本parse成JSONArray
    {
        JSONArray jsonArray = JSONArray.parseArray(text);

        return jsonArray;
    }

    public static final <T> List<T> parseArray(String text, Class<T> clazz) //把JSON文本parse成JavaBean集合
    {
        return null;
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


    public void WriteToJson(){

}
}
