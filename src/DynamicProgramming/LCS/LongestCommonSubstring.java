package DynamicProgramming.LCS;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String x = "abcdef";
        String y = "abfce";
        int m = x.length();
        int n = y.length();

        int length = lcSubstring(x,y,m,n);
        System.out.println(length);
    }

    private static int lcSubstring(String x, String y, int m, int n) {

        int[][] t = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        for (int i = 1; i < m+1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = t[i-1][j-1] + 1;
                }
                else{
                    t[i][j] = 0;
                }
            }
        }

        return t[m][n];
    }
}
