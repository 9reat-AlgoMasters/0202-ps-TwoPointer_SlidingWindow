import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Q1522 {
    static Set<Integer> charIdx = new HashSet<>();
    static int targetLen;
    static char[] input;
    static int N;

    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curWorkingDir = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curWorkingDir + path + fileName));
    }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\solve\\tc\\";
        String fileName = "Q1522.txt";
        setInputFile(remainPath, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        input = br.readLine().toCharArray();
        N = input.length;
        for (int i=0; i<input.length; i++) {
            if (input[i] == 'a') {
                charIdx.add(i);
            }
        }

        targetLen = charIdx.size();
        int minChange = 0;
        for (int i=0; i<targetLen; i++) {
            if (input[i] != 'a') {
                minChange++;
            }
        }

        int left = 0;
        int right = targetLen-1;

        int cnt = 0;
        int change = minChange;
        while (cnt < N) {
            if (input[left++] == 'b') change--;
            right = (right+1)%N;
            if (input[right] == 'b') change++;
            minChange = Math.min(minChange, change);
            cnt++;
        }

        sb.append(minChange);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
