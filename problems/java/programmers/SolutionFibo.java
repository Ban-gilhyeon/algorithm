package problems.java.programmers;

public class SolutionFibo {
    public int fibo(int n){
        if(n == 0 || n == 1) return n;
        else return fibo(n-1) + fibo(n-2);
    }

    public int fiboDp(int n){
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        if(n >= 3){
            for(int i = 3; i <= n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public int solution(int n ){
        int answer =0;
        answer = fiboDp(n) % 1234567;
        return answer;
    }

    public int solution2(int n ){
        int answer =0;
        answer = fibo(n) % 1234567;
        return answer;
    }
}
