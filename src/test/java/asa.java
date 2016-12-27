import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.platform.win32.Netapi32Util;
import org.apache.log4j.Logger;

/**
 * Created by jackiezero on 2016/12/27.
 */
public class asa {
    private static Logger logger = Logger.getLogger(asa.class);
    public static void main(String [] args){
        String text = "{\"name\":\"老张头\", \"age\":66}";

        /** 将JSON字符串转换为JSON对象 **/
        JSONObject json = JSON.parseObject(text);
        System.out.println(json);

        /** 将JSON字符串转换为JavaBean对象 **/
        Netapi32Util.User user = JSON.parseObject(text, Netapi32Util.User.class);
        System.out.println(user);

        /** 将JavaBean对象转换为JSON字符串 **/
        String jsonObject = JSON.toJSONString(user);
        System.out.println(jsonObject);
        logger.info(jsonObject+"sadsads");

        /** 将JavaBean对象转换为JSON对象，报错 **/
        //JSONObject userJson = (JSONObject) JSON.toJSON(user)
        //println userJson
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
