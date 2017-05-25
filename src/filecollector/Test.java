package filecollector;

import java.io.File;

/**
 * Created by Dr.Wen on 2017/5/25.
 */
public class Test {
    public static void main(String[] args){
        File file = new File("/Users/Dr.Wen/Desktop/班级工作");
        Collector c = new Collector();
        File[] files = c.getFiles(file);
        for (File i:files){
            System.out.println(i);
        }
    }
}
