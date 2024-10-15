package problems.java.programmers;

//12916
public class SolutionCntPY {
    public boolean solution(String s) {
        int cntp = 0;
        int cnty = 0;
        char word[] = s.toLowerCase().toCharArray();
        System.out.println(word[0]);
        for(int i =0; i < s.length(); i++){
            if(word[i] == 'p') {
                cntp++;
                System.out.println("log");
            }
            else if(word[i] == 'y') {
                cnty++;
            }
        }
        if(cntp == cnty){
            System.out.println("cntp: " + cntp);
            System.out.println("cnty: " + cnty);
            return true;
        }
        else return false;
    }
}
