package Utils;

import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by admin on 2016/12/28.
 */
public class YamlUtils {
    private static Logger logger = Logger.getLogger(YamlUtils.class);
    public static Object load(){
        Yaml yaml = new Yaml();
        File f=new File(FileUtils.Path("/src/main/resources/test.yaml"));
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
    /*public static void aa(){
        Yaml yaml = new Yaml();
        File f=new File(FileUtils.Path("/src/main/resources/test.yaml"));
        //读入文件
        String result= null;
        try {
            result = yaml.addImplicitResolver(new Tag("!dice"), Pattern.compile(), "123456789");
        } catch (FileNotFoundException e) {
            logger.error(e);
            e.printStackTrace();
        }
        logger.info(result);
//        return result;

    }*/
    public static Iterable<Object> loadall(){
        Yaml yaml = new Yaml();
        File f = new File(FileUtils.Path("/src/main/resources/test.yaml"));
        Iterable<Object> result = null;
        try {
            result = yaml.loadAll(new FileInputStream(f));
        } catch (FileNotFoundException e) {

            logger.error(e);
            e.printStackTrace();
        }
        /*for (Object obj : result) {
            System.out.println(obj.getClass());
            System.out.println(obj);
        }*/
        logger.info(result);

        return result;
    }


}
