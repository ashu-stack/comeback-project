package DynamicProgramming.LCS;

import static DynamicProgramming.LCS.LongestCommonSubsequence.lcs;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String x = "agbcba";
        StringBuilder builder = new StringBuilder(x);
        String y = builder.reverse().toString();

        int lps = lcs(x,y,x.length(),y.length());
        System.out.println(lps);
        int minDeletions = x.length()-lps;
        int minInsertions = x.length()-lps;
        System.out.println(minInsertions + " " + minDeletions);
    }
}
