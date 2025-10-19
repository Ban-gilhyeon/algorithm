package problems.java.etc;

public class 사다리타기 {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        boolean[][] info = {
                {true, false, true, false},
                {false, true, false, false},
                {true, false, true, true}
        };
        int start = findStart(n, m, info);
        System.out.println(start);
    }
    private static int findStart(int n, int m, boolean[][] info){
        int pos = m - 1;

        for(int row = info.length - 1; row >= 0; row--){
            if(pos > 0 && info[row][pos - 1]){
                pos--;
            }else if(pos < n - 1 && info[row][pos]){
                pos++;
            }
        }

        return pos + 1;
    }
}
