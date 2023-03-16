import java.io.*;
import java.util.Arrays;

public class Q9549 {
    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curWorkingDir = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curWorkingDir + path + fileName));
    }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\solve\\tc\\";
        String fileName = "Q9549.txt";
        setInputFile(remainPath, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
//            System.out.println("=====================================================");
            char[] password = br.readLine().toCharArray();
            char[] original = br.readLine().toCharArray();
            int[] originPwd = new int[26];
            int[] pwd = new int[26];

            for (int c : original) {
                originPwd[c - 'a']++;
            }

//            System.out.printf("originPwd : %s\n", Arrays.toString(originPwd));

            for (int i=0; i<original.length; i++) {
                pwd[password[i] - 'a']++;
            }

            int left = 0;
            int right = original.length-1;

            boolean findAns = false;
            while (true) {
//                System.out.printf("pwd : %s\n", Arrays.toString(pwd));
                if (isPossible(pwd, originPwd)) {
                    findAns = true;
                    break;
                }

                if (right == password.length - 1) {
                    break;
                }

                pwd[password[left++]-'a']--;
                pwd[password[++right]-'a']++;
            }

            if (findAns) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean isPossible(int[] pwd, int[] originPwd) {
        for (int i = 0; i < 26; i++) {
            if (pwd[i] != originPwd[i]) {
                return false;
            }
        }
        return true;
    }
}
