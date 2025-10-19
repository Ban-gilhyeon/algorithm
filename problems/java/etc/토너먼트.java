package problems.java.etc;

import java.util.ArrayList;
import java.util.List;

public class 토너먼트 {
    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        List<Integer> player = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            player.add(i);
        }

        while(player.size() > 1){
            List<Integer> next = new ArrayList<>();
            for(int i = 0; i < player.size(); i += 2){
                int a = player.get(i);
                int b = player.get(i + 1);

                if(a != m && b != m) {
                    next.add(Math.min(a, b));
                }else if(a == m){
                    next.add(a);
                }else{
                    next.add(b);
                }
            }
            player = next;
        }
    }
}
