import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15565 {
    static final int INF = Integer.MAX_VALUE;
    static final int RYAN = 1;
    static final int APEACH = 2;
    static int N, K;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curDirPath = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curDirPath + path + fileName));
    }
    public static void main(String[] args) throws IOException {
        String path = "\\solve\\tc\\";
        String fileName = "Q15565.txt";
        setInputFile(path, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = arr[left] == RYAN ? 1 : 0;

        while (right < N) {
            if (left == right || count < K) {
                right++;
                if (right < N && arr[right] == RYAN) {
                    count++;
                }
            } else {
                min = Math.min(min, right-left+1);
                if (arr[left] == RYAN) {
                    count--;
                }
                left++;
            }
        }

        sb.append(min == INF ? -1 : min);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
