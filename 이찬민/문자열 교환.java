import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = br.readLine().split("");

        // a가 연속되도록 한다는것 => a개수를 크기로 가지는 슬라이딩 윈도우하나에 a가 다 있어야함
        int cnt = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].charAt(0) == 'a') {
                cnt++;
            }
        }

        // 슬라이딩 윈도우 크기내의 b의 갯수가 교환되어야할 횟수
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < list.length; i++) {
            int bCnt = 0;
            for (int j = i; j < i + cnt; j++) {
                if (list[j % list.length].charAt(0) == 'b') {
                    bCnt++;
                }
            }
            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);
    }
}
