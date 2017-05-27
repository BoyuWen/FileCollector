package filecollector;

import java.io.*;
import java.util.regex.*;

/**
 * Created by Dr.Wen on 2017/4/13.
 *
 * 方法1、得到指定文件路径下的所有文件列表
 * 方法2：修改file文件名
 * 方法3：移动file到指定文件夹路径
 */
public class Collector {
    File[] result = new File[500]; //指定路径中所有文件列表
    private int i = 0; //文件数组下标

    //1、得到指定文件路径下的所有文件列表
    public File[] getFiles(File file){
        if (file.exists()){
            if (file.isDirectory()){
                File[] files = file.listFiles();
                if (files != null){   //此file不为隐藏目录或文件
                    for (File ifile:files){
                        getFiles(ifile);
                    }
                }
            }else {
                result[i++] = file;
            }
        }else {
            System.out.println("系统中不存在此文件！");
        }
        return result;
    }

    //2、返回新生成的文件名
    public void reName(File file,String str){ //要检查的文件、要移动的路径根目录
        boolean bool1,bool2=false,bool3=false,bool4;
        String oldName = file.toString();
        ////获取学号
        Pattern pat1 = Pattern.compile("^.*(2014011615|20150152[0-5][0-9])[^/]*$");
        Matcher mat1 = pat1.matcher(oldName);

        String number = null; //学号
        if (bool1 = mat1.matches()){
            number = mat1.group(1);
        }
        ////获取姓名
        Pattern pat2 = Pattern.compile("^.*([\\u4e00-\\u9fa5]{3})[^/]*$");
        Pattern pat3 = Pattern.compile("^.*([\\u4e00-\\u9fa5]{2})[^/]*$");
        Matcher mat2 = pat2.matcher(oldName);
        Matcher mat3 = pat3.matcher(oldName);

        String name = null; //姓名
        if (mat2.matches()){
            name = mat2.group(1);
            bool2 = true;
        }else if(bool3 = mat3.matches()){
            name = mat3.group(1);
        }
        ////获取后缀
        Pattern pat4 = Pattern.compile("^.*\\.([^/]*)$");
        Matcher mat4 = pat4.matcher(oldName);

        String suffix = null;
        if (bool4 = mat4.matches()){
            suffix = mat4.group(1);
        }
        if (bool1 && (bool2 || bool3) &&bool4){
            String newName = (str+"/"+number+" "+name+"."+suffix);
            copyFile(file,newName);
            file.delete();
        }
    }

    //////复制文件方法
    public void copyFile(File oldFile,String newFile){
        try{
            if (oldFile.exists()){
                InputStream input = new FileInputStream(oldFile);
                OutputStream output = new FileOutputStream(newFile);
                int data;
                while((data = input.read()) != -1){
                    output.write(data);
                }
                input.close();
                output.close();
            }
        }catch (IOException e){
            System.out.println("复制文件错误！");
        }
    }
}
