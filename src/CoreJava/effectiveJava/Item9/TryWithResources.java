package CoreJava.effectiveJava.Item9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static CoreJava.effectiveJava.Item9.TryWithResources.firstLineOf;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\ashut\\Documents\\Item9.txt";
        String firstLine = firstLineOf(path);
        System.out.println(firstLine);
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
