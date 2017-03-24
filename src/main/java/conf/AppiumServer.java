package conf;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by admin on 2017/3/24.
 */
public class AppiumServer {
    private static Logger logger = Logger.getLogger(AppiumServer.class);

    public AppiumServer(int port,String udid){
        killTask("node.exe");
        logger.info("init appium server...");
        runServer(port,udid);
        logger.info("启动 appium server...");
    }
    private void killTask(String taskname){
        String Command = "taskkill /F /im " + taskname;
        logger.info("kill " + taskname + " task ...");
        runCommand(Command);
    }

    public void runServer(int port,String udid) {
        logger.info("run " + udid + " Appium Server in port " + port + "...");
        int bpport = port +1;
//        int chromeport = port + 4792;
        //多设备server端需要手动指定每台设备的udid,安卓无线连接下就是设备的ip:port..
        String Command = "appium.cmd -p " + port + " -bp " + bpport +" -U "
                + udid +  " >c://" + port + ".txt";
        logger.info(Command);
        runCommand(Command);
    }

    private void runCommand(String command){
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
