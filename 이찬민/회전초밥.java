import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int d;
    static int k;
    static int c;
    static int[] list;
    static int[] eat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        //회전 초밥 받아옴, k-1만큼 더 붙이는 이유는 회전초밥의 마지막 부부네서도 k개 만큼 확인하기위해
        list=new int[N+k-1];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k - 1; i++) {
            list[N] = list[i];
            N++;
        }

        System.out.println(solve());
    }

    static int solve() {
        eat = new int[d + 1];
        int cnt = 0;

        // 쿠폰 처리
        eat[c]++;
        cnt++;

        // k개 만큼 넣음
        int start = 0;
        for (int i = 0; i < k; i++) {
            if (eat[list[i]] == 0) {
                cnt++;
            }
            eat[list[i]]++;
        }


        // 찾기 시작
        int answer = cnt;
        for (int i = k; i < list.length; i++) {
            eat[list[start]]--;

            // 첫번째 초밥이 제거됬을때 연속된 접시에서 완전히 없어지는 경우
            if (eat[list[start]] == 0) {
                cnt -= 1;
            }

            // 연속된 접시에 없는 초밥인경우
            if (eat[list[i]] == 0) {
                cnt += 1;
            }

            eat[list[i]]++;
            if(cnt >= answer) {
                answer = cnt;
            }
            start++;
        }
        return answer;
    }

}
