package problems.java.programmers;

public class SolutionCarpet {

    public int [] solution(int brown, int yellow){
        int []answer = new int[2];
        int carpet = brown + yellow;

        for(int i = 3; i <= carpet; i++){
            int row = i;
            int col = carpet / i;
            int YellowRow = row-2;
            int YellowCol = col-2;

            if(row < 3){
                continue;
            }
            if(row >= col){
                if(YellowRow * YellowCol == yellow){
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }
        return answer;
    }
}
