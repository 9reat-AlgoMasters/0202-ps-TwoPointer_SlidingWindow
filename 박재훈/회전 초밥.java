import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, d, k, c, ans = -1;
    static int[] arr;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        c = Integer.parseInt(input[3]);
        arr = new int[N];
        visited = new int[d+1];
        
      //쿠폰으로 c번 초밥 먹기 가능. 이건 고정해놓고 시작
        visited[c]++;
      //먹을 수 있는 초밥 종류 수
        int cnt = 1;
        
      //접시 정보 입력받기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
          //최초 0번부터 k-1번까지 k개의 초밥을 연속으로 먹기
            if(i < k) {
              //처음 먹는 초밥이면 종류++
                if(visited[arr[i]] == 0) {
                    cnt++;
                }
                visited[arr[i]]++;
            }
        }
        
        ans = Math.max(ans, cnt);
        
      //N개의 원형 벨트에서 연속으로 k개를 택하는 경우의 수 : 시작이 0번~N-1번까지 총 N개
      //위의 0번에서 시작하는 건 이미 계산해놨으므로 나머지 N-1개 경우 조사
        for (int i = 0; i < N-1; i++) {
          //맨앞 접시 제외, 제외 후 그 초밥을 먹은 개수가 0이면 종류--
            visited[arr[i]]--;
            if(visited[arr[i]] == 0){
                cnt--;
            }
          //새로운 초밥 접시 선택, 처음 먹는 초밥이면 종류++            
            if(visited[arr[(k+i)%N]] == 0){
                cnt++;
            }
            visited[arr[(k+i)%N]]++;

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
