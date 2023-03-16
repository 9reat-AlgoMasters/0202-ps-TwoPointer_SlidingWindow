import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q25603 {
    static int N, K;
    static MyNumber[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new MyNumber[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = new MyNumber(i, Integer.parseInt(st.nextToken()));
        }
    
        PriorityQueue<MyNumber> pq = new PriorityQueue<>();
        int start = 0;
        int end = 0;
        int cnt = K;
        int maxValue = -1;
        while (start + K <= N) {
            for (int i = 0; i < cnt; i++) {
                pq.add(arr[end + i]);
            }
    
            while (pq.peek().index < start) {
                pq.poll();
            }
            MyNumber checkNum = pq.poll();
            maxValue = Math.max(maxValue, checkNum.num);
            cnt = checkNum.index - start + 1;
            end = start + K;
            start = checkNum.index + 1;
        }
    
        sb.append(maxValue);
    
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class MyNumber implements Comparable<MyNumber> {
        int index, num;
    
        public MyNumber(int index, int num) {
            this.index = index;
            this.num = num;
        }
    
        @Override
        public int compareTo(MyNumber o) {
            return this.num == o.num ? o.index - this.index : this.num - o.num;
        }
    }
}
