package day6;

import org.junit.Test;

import java.io.File;

/**
 * @ClassName fileTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/17 16:32
 * @Version 1.0
 */
public class fileTest {
    @Test
    public void filet1() {
        File file = new File("D:\\Game");
//        delFile(file);
        serCh(file, "w");
    }

    //        1.1.	实现删除目录功能
    public void delFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                delFile(file1);
            } else {
                if (file1.getName().startsWith("新")) {
                    file1.delete();
                }
            }
        }
    }

    //        1.2.	实现windows搜索功能
    public void serCh(File f, String s) {

        if (f.exists()) {
            File[] files = f.listFiles();
            for (File file : files) {
                if(file.isDirectory()){
                    serCh(file,s);
                }
                else{
                    if(file.getName().startsWith(s)){
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }

}
