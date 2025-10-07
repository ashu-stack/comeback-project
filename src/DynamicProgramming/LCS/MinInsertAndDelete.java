package DynamicProgramming.LCS;

public class MinInsertAndDelete {
    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";
        int m = x.length();
        int n = y.length();

        int ans = insertDelete(x,y,m,n);
        System.out.println(ans);
    }

    private static int insertDelete(String x, String y, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0 || j==0) t[i][j] = 0;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1 ; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int lcs = t[m][n];
        int deletions = x.length()-lcs;
        int insertions = y.length()-lcs;

        return deletions+insertions;
    }
}
