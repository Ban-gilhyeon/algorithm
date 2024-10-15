package problems.java.programmers;

public class SolutionJumpAndWorp {

    public int solution(int n){
        int current = 1;
        int dis = 1;
        int battery =1;

        while(current <= n){
            if((current + 1) * 2 == n){
                battery++;
                current = (current + 1)*2;
                break;
            }
            if(current+1 == n){
                current++;
                battery++;
                break;
            }
            current = dis *2;
            dis *= 2;
        }
        return battery;
    }
    public int solution2(int n){
        int ans = 0;
        while(n != 0){
            if(n % 2 == 0){
                n = n / 2;
            }
            else{
                n = n -1;
                ans++;
            }
        }
        return ans;
    }
}
