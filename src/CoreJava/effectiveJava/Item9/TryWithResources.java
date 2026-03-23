package CoreJava.effectiveJava.Item9;

import java.io.*;

import static CoreJava.effectiveJava.Item9.TryWithResources.firstLineOf;

public class TryWithResources {
    private static final int BUFFER_SIZE = 100;

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ashut\\Documents\\Item9.txt";

        String dest = "C:\\Users\\ashut\\Documents\\Item10file.txt";

        //String firstLine = firstLineOf(path);
        copy(path,dest);

       // System.out.println(firstLine);
    }

    public static void copy(String src, String str) throws IOException {
        InputStream in = new FileInputStream(src);
        try{
            OutputStream out = new FileOutputStream(str);
            try{
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while((n = in.read(buf)) >= 0){
                    out.write(buf, 0, n);
                }
            }finally {
                out.close();
            }
        }finally{
            in.close();
        }
    }

    public static String firstLineOf(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
            return br.readLine();
        }finally {
            br.close();
        }
    }
}
