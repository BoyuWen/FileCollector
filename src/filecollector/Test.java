package filecollector;

import java.io.File;

/**
 * Created by Dr.Wen on 2017/5/25.
 */
public class Test {
    public static void main(String[] args){
        File file = new File("/Users/Dr.Wen/Desktop/第4章\\ 桌面弹球.pdf");
        Collector c = new Collector(file);
        c.reName(file);
    }
}
