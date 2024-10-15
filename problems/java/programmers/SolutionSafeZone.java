package problems.java.programmers;

public class SolutionSafeZone {

    public int solution(int [][] board){
        int answer = 0;
        int danger = 0;
        int size = board.length * board[0].length;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==1){
                    danger++;
                    //좌우
                    if(j-1>=0 && board[i][j-1]==0){
                        board[i][j-1] = 2;
                        danger++;
                    }
                    if(j+1<board.length && board[i][j+1]==0){
                        board[i][j+1] = 2;
                        danger++;
                    }
                    //위
                    if(i-1>=0){
                        if(board[i-1][j]==0){
                            board[i-1][j]=2;
                            danger++;
                        }
                        //대각
                        if(j-1>=0 && board[i-1][j-1]==0){
                            board[i-1][j-1]=2;
                            danger++;
                        }
                        if(j+1<board[i].length && board[i-1][j+1]==0){
                            board[i-1][j+1]=2;
                            danger++;
                        }
                    }
                    //아래
                    if(i+1<board.length){
                        if(board[i+1][j]==0){
                            board[i+1][j]=2;
                            danger++;
                        }
                        if(j-1>=0 && board[i+1][j-1]==0){
                            board[i+1][j-1]=2;
                            danger++;
                        }
                        if(j+1<board[i].length && board[i+1][j+1]==0){
                            board[i+1][j+1]=2;
                            danger++;
                        }
                    }

                }
            }
        }
        answer = size - danger;
        for(int i=0;i<board.length;i++){
            System.out.println("");
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" ");
            }
        }
        return answer;
    }
}
