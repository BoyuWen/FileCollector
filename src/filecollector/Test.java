package filecollector;

import java.io.File;

/**
 * Created by Dr.Wen on 2017/4/13.
 *
 * 待增加功能：
 * 1、自动到 '/Users/Dr.Wen/Desktop/班级工作/作业' 目录下判断第几次作业并按照顺序创建新的文件目录存放文件
 * 2、实现窗口化
 * 3、设定截止时间，增加倒计时功能。（第一阶段：时间到后自动打包并提醒）（第二阶段：自动打包并发送）
 * 4、自动查找未交人数并列出此人学号姓名。
 *
 * 待改进模块：
 * 1、获取File列表用List实现
 *
 */
public class Test {
    public static void main(String[] args){
        File file = new File("/Users/Dr.Wen/Downloads");
        String str = "/Users/Dr.Wen/Desktop/123";
        Collector c = new Collector();
        File[] files = c.getFiles(file);
//        for (int i=0;i<files.length;i++){
//            System.out.println(files[i]);
//        }
        for (File sub:files){
            if (sub == null) break;
            c.reName(sub,str);
        }
    }
}
