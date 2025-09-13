package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class Beakjun6603_로또 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String line = br.readLine();
            if(line.equals("0")) break;
            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for(int i = 0; i < k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> selected = new ArrayList<>();
            combination(0,selected, arr);
            System.out.println(" ");
        }
    }

    private static void combination(int start, List<Integer> selected, int[] arr){
        if(selected.size() == 6){
            for(int num : selected){
                System.out.print(num + " ");
            }
            System.out.println(" ");
            return;
        }

        for(int i = start; i < arr.length; i++){
            selected.add(arr[i]);
            combination(i + 1, selected, arr);
            selected.remove(selected.size() -1);
        }
    }
}
