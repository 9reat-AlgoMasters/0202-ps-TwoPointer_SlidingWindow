import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static long min = Long.MAX_VALUE;
	static int[] arr, ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[3];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
    //오름차순 정렬
		Arrays.sort(arr);
    
		//맨왼쪽 용액 고정
		for (int i = 0; i < N-2; i++) {
      //나머지 두 용액의 합이 맨왼쪽 용액x(-1)에 가까우면 됨
			long target = arr[i]*(-1);
			int j = i+1;
			int k = N-1;
			while(j < k) {
				long sum = arr[j]+arr[k];
				if(min > Math.abs(sum - target)) {
					min = Math.abs(sum - target);
					ans[0] = arr[i];
					ans[1] = arr[j];
					ans[2] = arr[k];
				}
        //나머지 두 용액의 합이 맨왼쪽 용액x(-1)보다 크면 큰 쪽의 인덱스를 줄여줌
				if(sum - target > 0) {
					k--;
				}else if(sum - target < 0){
					j++;
          //나머지 두 용액의 합 == 맨왼쪽 용액x(-1) => 딱 0이니까 더 찾을 필요 x
				}else {
					break;
				}
			}
			if(min == 0) {
				break;
			}
		}
		
		for (int v : ans) {
			System.out.print(v+" ");
		}
	}

}
