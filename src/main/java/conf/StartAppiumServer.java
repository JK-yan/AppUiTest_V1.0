package conf;

import Utils.AppiumTestBase;
import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Jackie-yan on 2017/4/14.
 **/
public class StartAppiumServer extends AppiumTestBase {
    private static Logger logger = Logger.getLogger(StartAppiumServer.class);
    private static ArrayList<Integer> ports = new ArrayList<>();
    private static ArrayList<Process> processes = new ArrayList<>();

    private void waitTime(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *启动Appium服务，并于所有设备建立通信，创建Session
     **/
    public StartAppiumServer() {
        new GetDevices();
        String filepath = "Conf\\";
        String filenames = "base.yml";
        KillTask();
        waitTime(1000);
        String filename = "DevicesID.json";
        runServer(filename);
        waitTime(5000);
        for (Integer port : ports) {
            initializationAppiumConfiguration(filepath, filenames, port);
        }
        logger.info("所有设备全部与Appium建立通讯完成");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
   /* @AfterSuite
    public void tearDown(){
        destroyServer(processes);
    }*/

    /**
     * 启动Appium server 支持多设备运行
     **/
    private void runServer(String filename) {
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(filename));
            JSONArray jsonArray = JSONArray.parseArray(file.readLine());
            for (Object aJsonArray : jsonArray) {
                Map hashMap = (Map) aJsonArray;
                String udid = (String) hashMap.keySet().iterator().next();
                int port = (Integer) hashMap.get(udid);
                int bp = (Integer) hashMap.get(udid) + 1;
                String Command = "cmd.exe /K Appium -U " + udid + " -p " + port + " -bp " + bp + " >" + System.getProperty("user.dir") + "\\logs\\" + udid + ".log";
                Process process = Runtime.getRuntime().exec(Command);
//                System.out.println(process.exitValue());
               /* while (true){
                    if (process.waitFor() == 0){
                        break;
                    }
                }*/
                ports.add(port);
                processes.add(process);
                logger.info("启动appium Server: " + Command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void KillTask() {
        String Command = "taskkill /F /im " + "node.exe";
        logger.info("kill " + "node.exe" + " task ...");
        runCommand(Command);
    }

    private void runCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
//            System.out.println(process.exitValue());
//            int waitvailue = ;
            /*while (true){
                if (process.waitFor() == 0){
                    break;
                }
            }*/
            logger.info(command + " 执行成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void destroyServer(ArrayList<Process> processes) {
        for (Process process : processes) {
            process.destroy();
            logger.info("销毁nodejs进程：" + process);
        }
    }


}
