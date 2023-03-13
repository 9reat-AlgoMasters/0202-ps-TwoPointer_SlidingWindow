import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15961 {
    static int N, M, K, coupon;
    static int[] arr;
    static int[] sushiCount;
    static int maxCount = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        sushiCount = new int[M+1];


        Set<Integer> sushiSet = new HashSet<>();
        // 초기 세팅
        for (int i=0; i<K; i++) {
            sushiSet.add(arr[i]);
            sushiCount[arr[i]]++;
        }
        maxCount = sushiSet.contains(coupon) ? sushiSet.size() : sushiSet.size()+1;

        for (int i=K; i<N+K-1; i++) {
            // 1. i-K 인덱스 초밥 제외
            if (--sushiCount[arr[i - K]] == 0) {
                sushiSet.remove(arr[i - K]);
            }

            int addIndex = i%N;
            // i 인덱스 초밥 추가
            if (++sushiCount[arr[addIndex]] == 1) {
                sushiSet.add(arr[addIndex]);
            }

            maxCount = Math.max(maxCount, sushiSet.contains(coupon) ? sushiSet.size() : sushiSet.size()+1);
        }

        sb.append(maxCount);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
