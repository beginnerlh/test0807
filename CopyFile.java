package io.filecopy;

import java.io.*;

class CopyFileUtil{

    public static boolean copyFile(File source,File dest) throws IOException {

        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(dest);
        byte[] bytes = new byte[1024];
        int len = 0;
        long start = System.currentTimeMillis();
        while((len = in.read(bytes)) !=-1){
            out.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+(end-start));
        in.close();
        out.close();
        return true;
    }
}

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("D:/IoTest/test/t/t.jpg");
        File destFile = new File("D:/IoTest/test/t/d.jpg");
        if(sourceFile.exists()){
            if(!destFile.getParentFile().exists()){
                System.out.println("目标目录不存在 创建目录..");
                destFile.getParentFile().mkdirs();
                System.out.println("目标目录创建完成");
            }
            if(CopyFileUtil.copyFile(sourceFile,destFile)){
                System.out.println("拷贝成功");
            }else {
                System.out.println("拷贝失败");
            }

        }else{
            System.out.println("源文件不存在，拷贝失败..");
        }

    }
}
