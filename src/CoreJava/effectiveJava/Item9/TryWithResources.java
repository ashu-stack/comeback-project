package CoreJava.effectiveJava.Item9;

import java.io.*;

import static CoreJava.effectiveJava.Item9.TryWithResources.firstLineOf;

public class TryWithResources {
    private static final int BUFFER_SIZE = 100;

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ashut\\Documents\\item9.txt";

        String dest = "C:\\Users\\ashut\\Documents\\Item10file.txt";
        firstLineOf(path);
      // copy(path,dest);

      //  System.out.println(firstLine);
    }

    public static void copy(String src, String str) throws IOException {
        try (InputStream in = new FileInputStream(src);OutputStream out = new FileOutputStream(str))
        {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while((n = in.read(buf)) >= 0){
                    out.write(buf, 0, n);

            }
        }
    }

    public static void firstLineOf(String path) throws IOException {
        // try-with resources
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while(br.ready()) {
                System.out.println(br.readLine()); ;
            }
        }
    }
}
