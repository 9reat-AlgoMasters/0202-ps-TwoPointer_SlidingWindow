import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max;
    static int min;
    static int[] x;
    static int[] y;


    static int[][] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        x = new int[3];
        y = new int[3];
        list = new int[3][2];

        StringTokenizer st = null;
        if(N == 1){
           st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                int t = Integer.parseInt(st.nextToken());
                if (t < min) {
                    min = t;
                }
                if (t >= max) {
                    max = t;
                }
            }

        } else {
            st = new StringTokenizer(br.readLine());
            x[0] = Integer.parseInt(st.nextToken());
            x[1] = Integer.parseInt(st.nextToken());
            x[2] = Integer.parseInt(st.nextToken());

            makeYArray(br.readLine());

            list[0][0] = Math.min(y[0] + x[0], y[0] + x[1]);
            list[0][1] = Math.max(y[0] + x[0], y[0] + x[1]);
            list[1][0] = Math.min(y[1] + x[0], Math.min(y[1] +x[1], y[1] + x[2]));
            list[1][1] = Math.max(y[1] + x[0], Math.max(y[1] +x[1], y[1] + x[2]));
            list[2][0] = Math.min(y[2] + x[1], y[2] +x[2]);
            list[2][1] = Math.max(y[2] + x[1], y[2] +x[2]);
            
            // 각3자리에 대한 최대, 최소값이 list에 담겨있게 되고 
            // 이 list를 이용해 게속 최대 최소를 갱신해 나간다
            for (int i = 0; i < N - 2; i++) {
                makeYArray(br.readLine());
                int[][] temp = new int[3][2];
                temp[0][0] = Math.min(list[0][0],  list[1][0]) + y[0];
                temp[0][1] = Math.max(list[0][1], list[1][1]) + y[0];
                temp[1][0] = Math.min(list[0][0] , Math.min(list[1][0] , list[2][0] )) + y[1];
                temp[1][1] = Math.max(list[0][1], Math.max(list[1][1], list[2][1]))+ y[1];
                temp[2][0] = Math.min(list[1][0], list[2][0]) + y[2];
                temp[2][1] = Math.max(list[1][1], list[2][1]) + y[2];
                list = temp;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    min = Math.min(min, list[i][j]);
                    max = Math.max(max, list[i][j]);
                }
            }

        }

        System.out.println(max + " " + min);
    }

    static void makeYArray(String s) {
        StringTokenizer st = new StringTokenizer(s);
        y[0] = Integer.parseInt(st.nextToken());
        y[1] = Integer.parseInt(st.nextToken());
        y[2] = Integer.parseInt(st.nextToken());
    }
}
