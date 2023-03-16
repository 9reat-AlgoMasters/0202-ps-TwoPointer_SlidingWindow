import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K, ans = Integer.MIN_VALUE;
    static int[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        cost = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(input[i]);
        }
     
      //(경로 중 가장 높은 비용)의 최솟값을 구하기위해 비용 높은 것들은 피해가야함
      //k번 이상 거부 못함 == k개 중 최소 하나는 의뢰 수락해야함
      //맨 앞에서부터 k개 잘라서 그중 최솟값을 찾아 이동
      //그 최솟값의 앞부터 또 k개 잘라서 최솟값 확인, 이런 과정 반복(n-k번에서부터 k개 자르는 경우까지)
      //각 최솟값들 중 최댓값 찾기
        for (int i = 0; i <= N-K; i++) {
            int min = Integer.MAX_VALUE;
            int idx = i;
            for (int j = 0; j < K; j++) {
                if(min >= cost[i+j]){
                    min = cost[i+j];
                    idx = i+j;
                }
            }
            i = idx;
            ans = Math.max(ans, min);
        }
        System.out.println(ans);
    }
}
