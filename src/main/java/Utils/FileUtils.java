package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/26.
 */
public class FileUtils {
    public static String Path(String filepath,String filename){
//        String AbsolutePath=System.getProperty("user.dir");
        File classRootPath=new File(System.getProperty("user.dir"));
        File appDir=new File(classRootPath,filepath);
        File app =new File(appDir,filename);
        return app.getAbsolutePath();
    }

    public static List  ReadFile(String filepath,String filename){
        String encoding="UTF-8";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader read=null;
        String line;
        List<String> allLines=new ArrayList();
        try {
            fis=new FileInputStream(Path(filepath,filename));
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
