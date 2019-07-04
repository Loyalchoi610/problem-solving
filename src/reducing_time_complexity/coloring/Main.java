package reducing_time_complexity.coloring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        // 0 - R, 1-G , 2-B
        int[][] dp = new int[N][3];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<3; i++) dp[0][i] = cost[0][i];

        for(int i=1; i<N; i++){

            for(int j=0; j<3; j++){
                int min = Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(j==k) continue;
                    min  = Math.min(min, dp[i-1][k] + cost[i][j]);
                }
                dp[i][j] = min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<3; i++) ans = Math.min(ans, dp[N-1][i]);
        System.out.println(ans);
    }
}
