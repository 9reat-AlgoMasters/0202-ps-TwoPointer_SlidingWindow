import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N, K, cnt, ans = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        while(left < N && arr[left] != 1){
            left++;
        }
        int right = left;
        while(right < N && cnt < K){
            if(arr[right] == 1){
                cnt++;
            }
            right++;
        }
        if(cnt < K){
            System.out.println(-1);
        }else {
            right--;
            while(right < N) {
                ans = Math.min(ans, right - left + 1);
                left++;
                while (arr[left] != 1) {
                    left++;
                }
                right++;
                while (right < N && arr[right] != 1) {
                    right++;
                }
            }
            System.out.println(ans);
        }

    }

}
