package conf;
import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 通过adb devices命令获取到能够链接的手机devices id 并同步对于设备使用的监听端口号，
 * 存入DevicesID.json
 * @author Jackie-yan on 2017/3/24.
 *
 **/
public class GetDevices {
    private static Logger logger = Logger.getLogger(GetDevices.class);

    public GetDevices(){
        String adb_command = "adb devices";
        saveDevicesID(adb_command);
    }

    private static void saveDevicesID(String command)  {
        try {
            Process process = Runtime.getRuntime().exec(command);
            // 从输入流中读取文本
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 构造一个写出流并指定输出文件保存路径
            FileWriter fw = new FileWriter(new File("DevicesID.json"));
            String line ;
            int port = 4725;
            List<Map<String,Integer>> onlinkdevices = Lists.newArrayList();
            List<Map<String,Integer>> unknowdevices = Lists.newArrayList();
            while (StringUtils.isNotBlank((line = reader.readLine()).trim())) {
                    String ids [] = line.split("\t");
                  try {
                      if (ids[1].equals("device")) {
                          Map<String, Integer> sidMap = Maps.newHashMap();
                          sidMap.put(ids[0], port=port+2);
                          onlinkdevices.add(sidMap);
                      }else {
                          Map<String, Integer> sidMap = Maps.newHashMap();
                          sidMap.put(ids[0], port=port+2);
                          unknowdevices.add(sidMap);
                      }
                  }catch (ArrayIndexOutOfBoundsException ignored){
                  }
            }
            String json = JSON.toJSONString(onlinkdevices,false);
            fw.write(json);
            // 刷新输出流
            fw.flush();
            // 关闭输出流
            fw.close();
            // 关闭输出流
            process.getOutputStream().close();
            logger.info(String.format("共有%s台设备可用：",onlinkdevices.size())+onlinkdevices+"\r\n"+String.format("共有%s台设备不可用：",unknowdevices.size())+unknowdevices);
        } catch (IOException e) {
            logger.error("未能成功启动adb获取devices id： "+e);
        }
    }
}