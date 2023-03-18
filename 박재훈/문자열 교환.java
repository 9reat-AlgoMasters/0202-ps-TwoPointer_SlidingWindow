import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        int size = arr.length;
        int aCnt = 0;
      //a의 개수 세기
        for (int i = 0; i < size; i++) {
            if(arr[i]=='a'){
                aCnt++;
            }
        }

        int ans = Integer.MAX_VALUE;
      //a의 개수만큼 잘라서 봤을 때 그 안의 b의 개수의 최솟값이 교환의 최소
      // 원형으로 연결되어 있으므로 시작점이 0번인 경우 ~ 시작점이 마지막인 경우까지. 총 경우의 수 = 문자열 길이
        for (int i = 0; i < size; i++) {
            int bCnt = 0;
            for (int j = 0; j < aCnt; j++) {
                if(arr[(j+i)%size]=='b'){
                    bCnt++;
                }
            }
            ans = Math.min(ans, bCnt);
        }
        System.out.println(ans);
    }
}
