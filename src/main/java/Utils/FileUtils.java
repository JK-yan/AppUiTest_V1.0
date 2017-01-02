package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/26.
 */
public class FileUtils {
    public static String Path(String path){
        String AbsolutePath=System.getProperty("user.dir");
        return AbsolutePath+path;
    }
    public static List  ReadFile(String filename){
        String encoding="UTF-8";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader read=null;
        String line;
        List<String> allLines=new ArrayList();
        try {
            fis=new FileInputStream(Path(filename));
            isr=new InputStreamReader(fis,encoding);
            read = new BufferedReader(isr);

            while ((line=read.readLine())!=null){
//                String s = read.readLine();
                allLines.add(line);

//                System.out.println(line);

//                continue;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                read.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     return allLines;
    }

}
