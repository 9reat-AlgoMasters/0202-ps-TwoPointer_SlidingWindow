import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2096 {
    static int[] DIR = {-1, 0, 1};
    static int FOUR_BIT_ON = (1<<4)-1;
    static int N;
    static int[] map;
    static int[][] dpMin;
    static int[][] dpMax;

    public static void setInputFile(String path, String fileName) throws FileNotFoundException {
        String curWorkingDir = System.getProperty("user.dir");
        System.setIn(new FileInputStream(curWorkingDir + path + fileName));
    }
    public static void main(String[] args) throws IOException {
        String remainPath = "\\solve\\tc\\";
        String fileName = "Q2096.txt";
        setInputFile(remainPath, fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        dpMax = new int[N + 1][3];
        dpMin = new int[N + 1][3];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                map[i] = set(map[i], j, Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=1; i<=N; i++) {
            Arrays.fill(dpMin[i], Integer.MAX_VALUE);
        }

//        printMap();
        solveDp();
//        System.out.println();

//        printDp(dpMax);
//        System.out.println();
//        printDp(dpMin);


        int min = Integer.MAX_VALUE;
        int max = -1;

        for (int i=0; i<3; i++) {
            min = Math.min(min, dpMin[N][i]);
            max = Math.max(max, dpMax[N][i]);
        }

        sb.append(max).append(" ").append(min);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void solveDp() {
        for (int i=1; i<=N; i++) {
            for (int j=0; j<3; j++) {
                for (int d : DIR) {
                    int nextY = j + d;
                    if (nextY >= 0 && nextY < 3) {
                        dpMax[i][j] = Math.max(dpMax[i][j], get(map[i], j) + dpMax[i-1][nextY]);
                        dpMin[i][j] = Math.min(dpMin[i][j], get(map[i], j) + dpMin[i-1][nextY]);
                    }
                }
            }
        }
    }

    public static int set(int mask, int index, int num) {
        return (mask & ~(FOUR_BIT_ON << (index << 2))) | num << (index << 2);
    }

    public static int get(int mask, int index) {
        return (mask >> (index << 2)) & FOUR_BIT_ON;
    }

    public static void printMap(int[] map) {
        for (int i=0; i<=N; i++) {
            printMask(map[i]);
        }
    }

    public static void printMask(int mask) {
        for (int i=0; i<3; i++) {
            System.out.printf("%d ", get(mask, i));
        }
        System.out.println();
    }

    public static void printDp(int[][] dp) {
        for (int i=0; i<=N; i++) {
            for (int j=0; j<3; j++) {
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }
    }

}
