package problems.java.programmers;
import java.util.stream.Stream;

//12932
public class SolutionReverse {
    //Long -> String -> Reverse -> int[]
    public int[] solution(long n) {
        String str = Long.toString(n);
        StringBuffer reverseStr = new StringBuffer(str);
        int answer[] = Stream.of(reverseStr.reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
        return answer;
    }

    /*   public List<int[]> solution(long n){
           String str = Long.toString(n);
           int arr[] = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
           List<int[]> list = asList(arr);
           Collections.reverse(list);
           return list;
       }*/
    public int[] ssol(long n) {
        StringBuffer str = new StringBuffer(Long.toString(n));
        int answer[] = Stream.of(str.reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
        return answer;
    }

    public int[] debugging(long n){
        System.out.println("n :" + n);

        String str = Long.toString(n);
        System.out.println("str : "+str);

        StringBuffer reStr = new StringBuffer(str);
        System.out.println("reStr : " + reStr);

        System.out.println(">>" + reStr.reverse());
        System.out.println("toString() >> "+ reStr.toString().split(""));
        int answer[] = Stream.of(reStr.toString().split("")).mapToInt(Integer::parseInt).toArray();
        System.out.println(answer);
        return answer;
    }

}