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
    private File[] result = null; //指定路径中所有文件列表

    public Collector (File file){
        //this.file = file;
    }
    //1、得到指定文件路径下的所有文件列表
    public File[] getFiles(File file){
        int foot = 0;
        if (file.exists()){
            File[] files = file.listFiles();
            for (int i=0;i<files.length;i++) {
                if (files[i].isDirectory()){
                    getFiles(files[i]);
                }else {
                    result[foot] = files[i];
                }
            }
        }else{
            System.out.println("系统中不存在此文件！");
        }
        return result;
    }
    //2、修改file文件名并移动到指定目录
    public void reName(File file){
        String str = "/Users/Dr.Wen/Desktop/2015015236 温泊语.doc";
        // String oldName = file.toString();

        Pattern pat = Pattern.compile("(2014011615|20150152[0-5][0-9]).*$");
        Matcher mat = pat.matcher(str);
        if (mat.matches()){
            String s = mat.group();
            System.out.println(s);
        }else {
            System.out.println("NO");
        }
        //System.out.println(oldName);
    }
    //3、移动file到指定文件夹路径
   // public void

}
