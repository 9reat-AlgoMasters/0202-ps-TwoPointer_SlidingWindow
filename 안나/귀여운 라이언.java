import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int[] honeyCute;
	static ArrayList<Integer> oneIndex; // 라이언인 인덱스를 모두 담음
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		honeyCute = new int[N];
		oneIndex = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			honeyCute[i] = Integer.parseInt(st.nextToken());
			if(honeyCute[i] ==1) {
				oneIndex.add(i);
			}
		}
		if(oneIndex.size() < K) {
			System.out.println(-1);
			return;
		}
		
		min = oneIndex.get(K-1) - oneIndex.get(0)+1;
		int size = min;
		for (int i = K; i < oneIndex.size(); i++) {
			size = oneIndex.get(i) - oneIndex.get(i-K+1)+1;
			min = Math.min(min, size);
		}
		System.out.println(min);
		
	}

}