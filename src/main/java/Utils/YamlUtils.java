package Utils;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * Created by admin on 2016/12/28.
 * 读取Yaml文件
 * @ load读取所有单类
 * @ LoadgetValue根据key读取value
 * @ Loadall 读取多层次Yaml文件
 * @ Loadallgetvalue根据List下标和key读取value
 */
public class YamlUtils {
    private static Logger logger = Logger.getLogger(YamlUtils.class);

@Test
    public static Object Load(String filepath,String filename){
        Yaml yaml = new Yaml();
        File f=new File(filepath,filename);
//        String f = filepath+"\\"+filename;
System.out.println(f);
        //读入文件
        Object result= null;
        try {
            result = yaml.load(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            logger.error(e);
            e.printStackTrace();
        }
        logger.info(result);
        return result;

    }

    public static Object LoadgetValue(String filepath,String filename,String ...te){

        LinkedHashMap aa= (LinkedHashMap) Load(filepath,filename);
        for (int i=0;i<te.length-1;i++){
            aa = (LinkedHashMap) aa.get(te[i]);
        }
        aa.get(te[te.length-1]);
        return  aa.get(te[te.length-1]);
    }
    public static List Loadall(String filepath,String filename){
        Yaml yaml = new Yaml();
        File f = new File(FileUtils.Path(filepath,filename));
        Iterable<Object> result = null;
        //Object object = null;
        List list =new ArrayList();
        try {
            result = yaml.loadAll(new FileInputStream(f));

            for (Object obj:result){
                //object=obj;
                list.add(obj);
            }
        } catch (FileNotFoundException e) {

            logger.error(e);
            e.printStackTrace();
        }

        logger.info(list);

        return list;
    }
    public static Object Loadallgetvalue(String filepath,String filename,int a,String ...te){
        LinkedHashMap aa= (LinkedHashMap) Loadall(filepath,filename).get(a);
        for (int i=0;i<te.length-1;i++){
            aa = (LinkedHashMap) aa.get(te[i]);
        }
        logger.info(aa.get(te[te.length-1]));
        return  aa.get(te[te.length-1]);
    }

}
