package DynamicProgramming.LCS;

public class LongestCommonSubsequence {

    static int[][] t = new int[101][101];
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        StringBuilder xsub = new StringBuilder(x);
         String a = xsub.reverse().toString();
        System.out.println(a);
        int m = x.length();
        int n = y.length();

        int length = lcs(x,y,m,n);

        System.out.println(length);
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                t[i][j] = -1;
            }
        }


        int length2 = lcsMemo(x,y,m,n);
        System.out.println(length2);

        int length3 = lcsTopDown(x,y,m,n);
        System.out.println(length3);
    }

    private static int lcsTopDown(String x, String y, int m, int n) {

        int[][] t = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for(int j=0; j<n+1; j++){
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

    private static int lcsMemo(String x, String y, int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }
        if(t[m][n] != -1){
            return t[m][n];
        }

        if(x.charAt(m-1) == y.charAt(n-1)){
            t[m][n] = 1 + lcsMemo(x,y,m-1,n-1);
            return t[m][n];
        }
        else{
            t[m][n] = Math.max(lcsMemo(x,y,m-1,n), lcsMemo(x,y,m,n-1));
            return t[m][n];
        }
    }

    public static int lcs(String x, String y, int m, int n) {
        if(m == 0 || n == 0){
            return 0;
        }

        if(x.charAt(m-1) == y.charAt(n-1)){
            return 1 + lcs(x,y,m-1,n-1);
        }
        else{
            return Math.max(lcs(x,y,m-1,n), lcs(x,y,m,n-1));
        }
    }
}
