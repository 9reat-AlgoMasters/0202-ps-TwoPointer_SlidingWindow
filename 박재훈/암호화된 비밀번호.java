import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T;
    static String enc, org;
    static int[] orgVisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            orgVisited = new int[26];
            enc = br.readLine();
            org = br.readLine();
            search();
        }
        System.out.println(sb);
    }
    static void search() {
      //원래 비번에 들어간 알파벳 추적
        char[] orgArr = org.toCharArray();
        int oSize = orgArr.length;
        for (int i = 0; i < oSize; i++) {
            char temp = orgArr[i];
            int val = temp-'a';
            orgVisited[val]++;
        }

        int[] encVisited = new int[26];

      //암호화 후 비번 앞에서부터 원래 비번 길이만큼 자른 후 들어간 알파벳 추적
        char[] encArr = enc.toCharArray();
        int eSize = encArr.length;
        for (int i = 0; i < oSize; i++) {
            char temp = encArr[i];
            int val = temp-'a';
            encVisited[val]++;
        }
        int cnt = 0;
      //개수 비교
        for (int j = 0; j < 26; j++) {
            if(encVisited[j] == orgVisited[j]){
                cnt += encVisited[j];
            }
        }
      //같은 알파벳의 총 개수가 원래 비번 길이와 같다 == 원래 비번 알파벳과 구성요소가 같다
        if(cnt == oSize){
            sb.append("YES\n");
            return;
        }

      //맨 앞 알파벳 빼고 뒤의 알파벳을 추가
        for (int i = 0; i < eSize - oSize; i++) {
            char temp = encArr[i];
            int val = temp-'a';
            encVisited[val]--;

            temp = encArr[oSize + i];
            val = temp - 'a';
            encVisited[val]++;
            cnt = 0;
            for (int j = 0; j < 26; j++) {
                if(encVisited[j] == orgVisited[j]){
                    cnt += encVisited[j];
                }
            }
            if(cnt == oSize){
                sb.append("YES\n");
                return;
            }
        }
        sb.append("NO\n");
    }
}
