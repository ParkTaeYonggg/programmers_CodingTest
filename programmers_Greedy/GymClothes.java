package programmers_Greedy;

public class GymClothes {
    public static void main(String[] args) {

        int n = 8;
        int[] lost = { 1,2,3,4,5 };
        int[] reserve = { 4,5,6 };
        System.out.println(solution(n, lost, reserve));

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int num = lost.length;

        //////////////////////////////// 변수
        for(int i = 0; i < reserve.length; i++) {
            for(int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    reserve[i] = 0;
                    lost[j] = 0;
                }
            }
        }

        for(int i = 0; i < reserve.length; i++) {
            boolean key = true;
            for(int j = 0; j < lost.length; j++) {
                if(reserve[i] + 1 == lost[j] && reserve[i] !=0) {
                    lost[j] = 0;
                    reserve[i] = 0;
                    key = false;
                }
                if(reserve[i] - 1 == lost[j] && key && reserve[i] -1 != 0){
                    lost[j] = 0;
                    reserve[i] = 0;
                }
            }
        }
        
        for(int s : lost) {
            if (s == 0) {
                num--;
            }
        }
        
        
        answer = n - num;

        if (answer > n) {
            answer = n;
        }
        if (answer < 0) {
            answer = 0;
        }
        return answer;
    }

}
