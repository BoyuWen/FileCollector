package filecollector;

import java.io.File;
import java.util.regex.*;

/**
 * Created by Dr.Wen on 2017/5/25.
 *
 * 方法1、得到指定文件路径下的所有文件列表
 * 方法2：修改file文件名
 * 方法3：移动file到指定文件夹路径
 */
public class Collector {
    //private File file;   //指定文件路径


//    public Collector (File file){
//        //this.file = file;
//    }
    //1、得到指定文件路径下的所有文件列表
    public File[] getFiles(File file){
        int foot = 0;
        File[] result = new File[100]; //指定路径中所有文件列表

//        if (file.exists()){
//            File[] files = file.listFiles();
//            if (files != null){
//                for (int i=0;i<files.length;i++) {
//                    if (files[i].isDirectory()){
//                        getFiles(files[i]);
//                    }else {
//                        result[foot++] = files[i];
//                    }
//                }
//            }
//        }else{
//            System.out.println("系统中不存在此文件！");
//        }

        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                if (files != null){   //此file不为隐藏目录或文件
                    for (File ifile:files){
                        getFiles(ifile);
                    }
                }
            }else {
                result[foot++] = file;
                System.out.println(result[foot-1]);
            }
        }else {
            System.out.println("系统中不存在此文件！");
        }
        return result;
    }
    //2、修改file文件名并移动到指定目录
    public void reName(File file){
        String oldName = file.toString();

        //获取学号
        Pattern pat1 = Pattern.compile("^.*(2014011615|20150152[0-5][0-9])[^/]*$");
        Matcher mat1 = pat1.matcher(oldName);

        String number = null; //学号
        if (mat1.matches()){
            number = mat1.group(1);
            System.out.println(number);
        }
        //获取姓名
        Pattern pat2 = Pattern.compile("^.*([\\u4e00-\\u9fa5]{3})[^/]*$");
        Pattern pat3 = Pattern.compile("^.*([\\u4e00-\\u9fa5]{2})[^/]*$");
        Matcher mat2 = pat2.matcher(oldName);
        Matcher mat3 = pat3.matcher(oldName);

        String name = null; //姓名
        if (mat2.matches()){
            name = mat2.group(1);
        }else {
            mat3.matches();
            name = mat3.group(1);
        }
        //System.out.println(Name);
        String newName = number + name;

    }
    //3、移动file到指定文件夹路径
   // public void

}
