import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][]min, max;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = new int[N][3];
		min = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				int v = Integer.parseInt(input[j]);
				min[i][j] = v;
				max[i][j] = v;
			}
		}
	
    //0, 1, 2 칸
    //0번은 윗줄 0, 1중 선택
    //1번 : 윗줄 0, 1, 2중 선택
    //2번 : 윗줄 1,2 중 선택
    //선택기준 : min은 최솟값 찾는 거니까 후보들 중 가장 작은것, max는 가장 큰 것 선택
		for (int i = 0; i < N-1; i++) {
			 min[i + 1][0] += Math.min(min[i][0], min[i][1]);
			 max[i + 1][0] += Math.max(max[i][0], max[i][1]);
			 min[i + 1][1] += Math.min(min[i][0], Math.min(min[i][1], min[i][2]));
			 max[i + 1][1] += Math.max(max[i][0], Math.max(max[i][1], max[i][2]));
			 min[i + 1][2] += Math.min(min[i][1], min[i][2]);
			 max[i + 1][2] += Math.max(max[i][1], max[i][2]); 
		
		}
		int maxV = Integer.MIN_VALUE;
		int minV = Integer.MAX_VALUE;
    
    //맨 밑줄은 쭉 내려오면서 더한 최종결과 저장돼있음
		for (int i = 0; i < 3; i++) {
			maxV = Math.max(maxV, max[N-1][i]);
			minV = Math.min(minV, min[N-1][i]);
		}
		System.out.println(maxV+" "+ minV);
	}

}
