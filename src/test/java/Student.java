import java.io.File;

/**
 * Created by admin on 2016/12/27.
 */
public class Student {


        public static void main(String[] args){
//            Student a= new Student();
//            InputStream aa = Student.class.getResourceAsStream("");
            File classRootPath=new File(System.getProperty("user.dir"));
            File appDir=new File(classRootPath,"Driver");
            File app =new File(appDir,"a.txt");

            System.out.println(app);
                }
        }



