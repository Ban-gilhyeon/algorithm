package problems.java.programmers;

public class Solution_택배상자꺼내기 {
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 11;

        int answer = 0;
        boolean dir = true;
        int cnt = 1;
        int stare = 0;
        int totalBox = n;
        int[][] stock = new int[n / w + 1][w];
        int x = 0; int y = 0;
        while(n > 0){
            if(dir){
                for(int i = 0; i < w; i++){
                    stock[stare][i] = cnt + i;
                    n--;
                    if(stock[stare][i] == num){
                        y = stare;
                        x = i;
                    }
                }
                dir = false;
            }else{
                int number = cnt + w - 1;
                for(int i = 0; i < w; i++){
                    if(number == num){
                        y = stare;
                        x = i;
                    }
                    if(number > totalBox){
                        stock[stare][i] = 0;
                        number--;
                    }else{
                        stock[stare][i] = number--;
                        n--;
                    }

                }
                dir = true;
            }
            stare++;
            cnt += w;

        }
        System.out.println("Y : " + y + "X :" + x);

        answer = stock.length - y;

        for(int i = stock.length - 1; i > y; i--){
            if(stock[i][x] == 0) answer--;
        }
        System.out.println(answer);
        for(int i = 0; i < stock.length; i++){
            System.out.println("");
            for(int j = 0; j < stock[i].length; j++){
                System.out.print(stock[i][j] + " ");
            }
        }

    }
}
