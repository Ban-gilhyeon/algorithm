package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Beakjun10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Deck deck = new Deck();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str;
            int x;
            if(st.countTokens() >= 2){
                 str = st.nextToken();
                 x = Integer.parseInt(st.nextToken());
                 switch (str){
                     case "push_front" :
                         deck.push_front(x);
                         break;
                     case "push_back" :
                         deck.push_back(x);
                         break;
                 }
            }
            else{
                 str = st.nextToken();
                switch (str){
                    case "pop_front" :
                        deck.pop_front();
                        break;
                    case "pop_back" :
                        deck.pop_back();
                        break;
                    case "size" :
                        deck.size();
                        break;
                    case "empty" :
                        deck.empty();
                        break;
                    case "front" :
                        deck.front();
                        break;
                    case "back" :
                        deck.back();
                        break;
                }
            }
        }


    }
}

class Deck{
    Deque<Integer> deck;
    Deck(){
        deck = new ArrayDeque<>();
    }
    void push_front(int x){
        deck.addFirst(x);
    }
    void push_back(int x){
        deck.addLast(x);
    }

    void pop_front(){
        if(!deck.isEmpty()){
            int result = deck.getFirst();
            deck.removeFirst();
            System.out.println(result);
        }else {
            System.out.println("-1");
        }
    }
    void pop_back(){
        if(!deck.isEmpty()){
            int result = deck.getLast();
            deck.removeLast();
            System.out.println(result);
        }else {
            System.out.println("-1");
        }
    }

    void size(){
        int result = deck.size();
        System.out.println( result);
    }

    void empty(){
        if(deck.isEmpty()){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    void front(){
        if(!deck.isEmpty()){
            System.out.println(deck.getFirst());
        } else {
            System.out.println("-1");
        }
    }

    void back(){
        if(!deck.isEmpty()){
            System.out.println(deck.getLast());
        } else {
            System.out.println("-1");
        }
    }
}