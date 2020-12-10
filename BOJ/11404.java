/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.10
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 11404_플로이드
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    static int inf = 1000000000;//Integer.MAX_VALUE로 하면 안된다. Integer.MAX_VALUE+1이라도 하면 int범위를 넘어서기 때문이다.
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());//도시의 개수
        int m = Integer.parseInt(br.readLine());//버스의개수
        
        int[][] map = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;//같은 도시면 비용 0
                map[i][j] = inf;
            }
        }
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b],c);//a->b 비용(이 문제의 입력에 주어지는 도시 i,j가 중복으로 다시 나올때가 있다..)
        }
        
        for(int k = 1; k <= n; k++){//거쳐가는 도시 k
            for(int i = 1; i <= n; i++){//시작도시 i
                for(int j = 1; j <= n; j++){//도착도시 j
                    if(map[i][k] + map[k][j] < map[i][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == inf) map[i][j] = 0;
                sb.append(map[i][j]).append(" ");           
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
