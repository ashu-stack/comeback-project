package Recursion;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
       // printPattern("" , 3,3);
        //System.out.println(printPatternRet("", 3, 3));
        //System.out.println(patternDiagonal("", 3,3));

        boolean[][] matrix = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        backTrack("", matrix, 0,0);
    }

    static void printPattern(String p, int r, int c){

        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r>1){
            printPattern(p+'D' , r-1,c);
        }
        if(c>1){
            printPattern(p + 'R', r,c-1);
        }
    }

    static ArrayList<String> printPatternRet(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(printPatternRet(p + 'D', r-1,c));
        }
        if(c>1){
            list.addAll(printPatternRet(p + 'R', r, c-1));
        }
        return list;
    }

    static int printPatternCount(String p, int r, int c){
        if(r == 1 && c == 1){
            return 1;
        }
        int count=0;
        if(r>1){
            count += printPatternCount(p+'D', r-1, c);
        }
        if(c>1){
            count += printPatternCount(p + 'R', r, c-1);
        }
        return count;
    }

    static ArrayList<String> patternDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(patternDiagonal(p + 'V', r-1,c));
        }
        if(c>1){
            list.addAll(patternDiagonal(p + 'H', r, c-1));
        }
        if(r>1 && c>1){
            list.addAll(patternDiagonal(p + 'D', r-1, c-1));
        }
        return list;
    }

    static void printObstacle(String p, boolean[][] matrix, int r, int c){
        if(r== matrix.length-1 && c== matrix[0].length-1){
            System.out.println(p);
            return;
        }
        if(!matrix[r][c]){
            return;
        }
        if(r<matrix.length-1){
            printObstacle(p + 'D', matrix,r+1, c);
        }
        if(c<matrix[0].length-1){
            printObstacle(p + 'R', matrix, r, c+1);
        }
    }

    static void backTrack(String p, boolean[][] vis, int r, int c){
        if(r== vis.length-1 && c== vis[0].length-1){
            System.out.println(p);
            return;
        }
        if(!vis[r][c]){
            return;
        }
        vis[r][c] = false;
        if(r < vis.length-1){
            backTrack(p + 'D', vis,r+1, c);
        }
        if(c < vis[0].length - 1){
            backTrack(p + 'R', vis, r, c+1);
        }
        if(r>0){
            backTrack(p + 'U', vis, r-1, c);
        }
        if(c>0){
            backTrack(p + 'L', vis, r, c-1);
        }
        vis[r][c] = true;
    }
}
