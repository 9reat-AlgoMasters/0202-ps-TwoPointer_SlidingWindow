import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int[] map;
    static int[] map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] crypt = br.readLine().toCharArray();
            char[] origin = br.readLine().toCharArray();

            map = new int[26];
            map2 = new int[26];
            for (int j = 0; j < origin.length; j++) {
                map[origin[j]-97]++;
            }

            int len = origin.length;
            int ans = 0;
            boolean flag = false;

            for (int k = 0; k < len; k++) {
                map2[crypt[k]-97]++;
            }


            flag = check();

            for (int j = len; j < crypt.length; j++) {

                int t = crypt[j] - 97;
                int t2 = crypt[j - len] - 97;

                map2[t]++;
                map2[t2]--;

                if (check()) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (map[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
