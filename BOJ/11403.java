/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.7
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] canGo = new int[n][n];//i->j로 갈 수 있으면 1
            
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //플로이드-와샬 알고리즘
        for(int k = 0; k < n; k++){//중간노드
            for(int i = 0; i < n; i++){//i -> j
                for(int j = 0; j < n; j++){
                    if(map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }   
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
