package hash;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;



class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<Integer,String> map = new TreeMap<>();
        Map<Integer,String> map2 = new TreeMap<>();
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        
        for (int i = 0; i < participant.length; i++) {
            map.put(i, participant[i]);
          if (i < completion.length) {
              map2.put(i, completion[i]);
          }
        }
        
        
        Iterator<String> it = map.values().iterator();
        Iterator<String> it2 = map2.values().iterator();
      
        
        while (it.hasNext()) {
           answer = it.next();
           String temp = "";
           if (it2.hasNext()) {
               temp = it2.next();
           }
           if (!answer.equals(temp)) {
               return answer;
           }
        }
            
            
            
        
       
        return answer;
        // 베열 자체를 넣는 것은 정의가 안된다.
        // 배열의 인덱스를 이용해서 키를 빼낸다면?
        // 시간적합도를 위해
        // 한번씩만 돌면서 공통된 업무는 생략할 변수로 접근해야 한다.
        // 동명이인이 있을 때, 없을때
        
    }
}

public class Maraton {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };
        System.out.println(sol.solution(participant, completion));

    }
}
