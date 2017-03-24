package conf;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/3/24.
 */
public class GetDevices {
    private String adb_command = "adb devices";
    public GetDevices(){
        saveDevicesID(adb_command);
    }

    private void saveDevicesID(String command){
        try {
            Runtime.getRuntime().exec("adb kill-server");
            Thread.sleep(1000);
            Runtime.getRuntime().exec("adb start-server");
            Thread.sleep(1000);
            Process process = Runtime.getRuntime().exec(command);
            // 从输入流中读取文本
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // 构造一个写出流并指定输出文件保存路径
            FileWriter fw = new FileWriter(new File("CmdInfo.json"));

            String line ;

            // 循环读取
            int count =0;
            int port = 4725;
            List<Map<String,Integer>> jsonList = Lists.newArrayList();
            while (StringUtils.isNotBlank((line = reader.readLine()).trim())) {
                // 循环写入
//                fw.write(line + "\n");
                if (count>0){
                    System.out.println(line);
                    String ids [] = line.split("\t");
                    Map<String,Integer> sidMap = Maps.newHashMap();
                    sidMap.put(ids[0],port++);
                    jsonList.add(sidMap);
                }
                count++;
            }
            String json = JSON.toJSONString(jsonList,false);
            fw.write(json);
            // 刷新输出流
            fw.flush();
            // 关闭输出流
            fw.close();
            // 关闭输出流
            process.getOutputStream().close();
//            for (Map.Entry<String, Integer> entry : sidMap.entrySet()) {
//                System.out.println("sid:"+entry.getKey() + " port:" +entry.getValue());
//            }
            System.out.println("程序执行完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        GetDevices a = new GetDevices();
//        a.saveDevicesID(a.adb_command);
    }

}
