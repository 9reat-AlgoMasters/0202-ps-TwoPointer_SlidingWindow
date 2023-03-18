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
        int lCnt = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] == 1) {
                lCnt++;
            }
        }


        if (lCnt < K) {
            System.out.println("-1");
        }
        if (lCnt >= K) {
            int size = 0;
            int start = 0;
            int end = 0;
            for (int i = 0; i < list.length; i++) {
                if (size == 0 & list[i] == 1) {
                    start = i;
                }
                if(list[i] == 1) {
                    size++;
                }
                if (size == K) {
                    end = i;
                    break;
                }
            }
            
            int windowSize = end - start + 1;

            int cnt = K;
            for (int i = end + 1; i < list.length; i++) {
                int a = list[i];
                int d = list[i - windowSize];
                if (a == 1) {
                    cnt++;
                }
                if (d == 1) {
                    cnt--;
                }

                if (cnt == K) {
                    int t = windowSize;
                    for (int j = t - 1; j >= 0; j--) {
                        if (list[i - j] == 2) {
                            windowSize--;
                        }
                        else if (list[i - j] == 1) {
                            break;
                        }
                    }
                }

            }

            System.out.println(windowSize);
        }

    }
}
