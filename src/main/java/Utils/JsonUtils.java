package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by admin on 2016/12/27.
 */
public class JsonUtils {
    Gson gson = new GsonBuilder()
            //序列化null
            .serializeNulls()
            // 设置日期时间格式，另有2个重载方法
            // 在序列化和反序化时均生效
            .setDateFormat("yyyy-MM-dd")
            // 禁此序列化内部类
            .disableInnerClassSerialization()
            //生成不可执行的Json（多了 )]}' 这4个字符）
            .generateNonExecutableJson()
            //禁止转义html标签
            .disableHtmlEscaping()
            //格式化输出
            .setPrettyPrinting()
            .create();

public static <T> T ReadJson(String jsonData, Class<T> type) {
    Gson gson = new Gson();
    T result = gson.fromJson(jsonData, type);
    return result;
}
public void WriteToJson(){

}
}
