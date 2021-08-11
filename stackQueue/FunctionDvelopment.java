package stackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // 배열 크기는 마지막에 정리.
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        int result = 0;
        for (int i = 0; i < progresses.length; i++) {
            que.add(progresses[i]);
        }
        
        while (!que.isEmpty()) {
          // 리턴값 존재하지 않는 리무브를 활용해보자.  
           
            for (int i = idx; i < speeds.length; i++) {
                que.offer(que.remove() + speeds[i]);
            }
            
            while (que.element() >= 100) {
                
                que.remove();
                idx++;
                result++;
                if (que.isEmpty()) {
                    break;
                }
            }
            if (result > 0) {
            list.add(result);
            result = 0;
            }
        }
        
        int[] temp = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }

        return temp;
    }//
}//

public class FunctionDvelopment {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };
        for (int i = 0; i < sol.solution(progresses, speeds).length; i++) {
            System.out.print(sol.solution(progresses, speeds)[i]);
        }
    }
}






