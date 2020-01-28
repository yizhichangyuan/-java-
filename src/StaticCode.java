import java.io.*;

import src.Queue;

import java.io.FileNotFoundException;

public class StaticCode {
    public int countLine = 0;

    public int code(String path){
        File file = new File(path);
        File[] fs = file.listFiles();
        for(int i = 0; i < fs.length; i++)
        {
            String fileName = fs[i].getName();
            if(fs[i].isFile() && fs[i].exists())
            {
               try{
                   FileReader fileReader = new FileReader(fs[i]);
                   BufferedReader bufferedReader = new BufferedReader(fileReader);
                   while(bufferedReader.readLine() != null){
                       countLine++;
                   }

               }catch (FileNotFoundException e){
                   e.printStackTrace();
            }catch (IOException e){
                   e.printStackTrace();
               }

            }
            else if(fs[i].isDirectory())
            {
                code(fs[i].getAbsolutePath());
            }
    }
    return countLine;
}

    public static void main(String[] args) {
        StaticCode staticCode = new StaticCode();
        int line = staticCode.code("/Users/yizhichangyuan/Desktop/算法练习题/src");
        System.out.println(line);
    }
    }
