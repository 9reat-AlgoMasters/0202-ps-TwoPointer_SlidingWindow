import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N];

        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int rMax = -1;

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        for (int i = 0; i < K; i++) {
            if (list[i] <= min) {
                idx = i;
                min = list[i];
                rMax = min;
            }
        }
        int w = idx + 1;

        int cnt = 0;
        while(w <= N - K) {
            min = Integer.MAX_VALUE;
            cnt = 0;
            int t = w;
            int val = 0;
            for (int j = t; j < N; j++) {
                if (list[j] < rMax) {
                    w = j + 1;
                    break;
                } else {
                    if (list[j] < min) {
                        min = list[j];
                        val = j;
                    }
                    cnt++;
                    if (cnt == K){
                        w = val + 1;
                        rMax = min;
                        break;
                    }
                }
            }

        }
        System.out.println(rMax);

    }
}
