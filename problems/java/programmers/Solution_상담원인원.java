package problems.java.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.*;

public class Solution_상담원인원 {

    public static void main(String[] args) throws IOException {
        int k = 3;
        int n = 5;
        int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};

        int surplus = n - k;
        //참여자들의 요청 큐
        Queue<Request> requestQueue = new LinkedList<>();
        // 멘토들의 큐
        PriorityQueue<Integer> mentors = new PriorityQueue<>();
        List<List<Request>> requestList = new ArrayList<>();
        int[] assignment = new int[k+1];

        Arrays.fill(assignment,1);

        for(int i = 0; i <= k; i++){
            requestList.add(new ArrayList<>());
        }
        for(int [] temp: reqs){
            Request req = new Request(temp[0],temp[1],temp[2]);
            requestList.get(temp[2]).add(req);
            requestQueue.add(req);
        }
        combination(1, assignment, surplus, requestQueue, mentors);

    }
    private static void combination(int index, int[] assignment, int surplus,  Queue<Request> requests, PriorityQueue<Integer> mentors){
        if(index == assignment.length){
            if(surplus == 0){
                System.out.println(Arrays.toString(assignment));
            }
            return;
        }

        for(int i = 0; i <= surplus; i++){
            assignment[index] += i;
            combination(index + 1, assignment, surplus -i, requests, mentors);
            assignment[index] -= i;
        }
    }
    private void simulate(int[] assignment, Queue<Request> requests, PriorityQueue<Integer> mentors){
        int totalWaitTime = 0;

    }
}

class Request{
    int waitTime;
    int duringTime;
    int type;

    Request(int waitTime, int duringTime, int type){
        this.waitTime = waitTime;
        this.duringTime = duringTime;
        this.type = type;
    }
}
