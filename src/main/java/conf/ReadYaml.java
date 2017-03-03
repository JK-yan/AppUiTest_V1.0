package conf;

import Utils.YamlUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by admin on 2017/2/21.
 */
public class ReadYaml {
    public void setDesiredCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    }
    public static void main(String[] args){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        LinkedHashMap capability= (LinkedHashMap) YamlUtils.loadGetValue("E:\\Code\\AppUiTest_V1.0\\src\\main\\resources","base.yaml","androidCapability");
        for (Iterator it = capability.keySet().iterator(); it.hasNext(); ) {
            Object iterable = it.next();
            desiredCapabilities.setCapability(iterable.toString(),capability.get(iterable).toString());
        }
        System.out.println(desiredCapabilities);
        /*(Iability.entrySet().iterator().hasNext()){
            System.out.println(capability.entrySet().iterator().next() + "=" + capability.get(capability.keySet().iterator().next()));

        }*/


//            System.out.println(capability.values());
    }
}
