import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2473 {
    static final int SECOND = 0;
    static final int THIRD = 1;
    static final int RESULT = 2;
    static int N;
    static int[] arr;
    static long minDiff = Long.MAX_VALUE;
    static long[] answer = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i=0; i<N-2; i++) {
            long[] info = solve(i+1);
            if (info[RESULT] < minDiff) {
                answer[0] = arr[i];
                answer[1] = info[SECOND];
                answer[2] = info[THIRD];
                minDiff = info[RESULT];
            }
        }

        for (int i=0; i<3; i++) {
            sb.append(answer[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static long[] solve(int start) {
        long[] answer = new long[3];
        int left = start;
        int right = N-1;

        long res;
        answer[RESULT] = Long.MAX_VALUE;

        while (left < right) {
            res = (long)arr[start-1] + arr[left] + arr[right];
            if (Math.abs(res) < answer[RESULT]) {
                answer[SECOND] = arr[left];
                answer[THIRD] = arr[right];
                answer[RESULT] = Math.abs(res);
            }
            if (res == 0) {
                return answer;
            }

            if (res > 0) {
                right--;
            } else if (res < 0) {
                left++;
            }
        }
        return answer;
    }
}
