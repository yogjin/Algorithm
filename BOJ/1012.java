/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.6
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static int count = 0;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());//테스트 케이스 개수
        
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());   
            int m = Integer.parseInt(st.nextToken());//가로
            int n = Integer.parseInt(st.nextToken());//세로
            int k = Integer.parseInt(st.nextToken());//배추개수
            //초기화.
            map = new int[m][n];
            visited = new boolean[m][n];
            count = 0;
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for(int x = 0; x < m; x++){//모든 점을 순회하면서 dfs.->섬 구하기.
                for(int y = 0; y < n; y++){
                    if(!visited[x][y] && map[x][y] == 1){//방문하지 않은 배추에서만 dfs시작.
                        Dot dot = new Dot(x,y);
                        dfs(dot);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(Dot dot){
        visited[dot.x][dot.y] = true;
        for(int i = 0; i < 4; i++){
            int nextX = dot.x + dx[i];
            int nextY = dot.y + dy[i];
            
            if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length){
                continue;
            }
            if(map[nextX][nextY] == 0){//배추x
                continue;
            }
            if(!visited[nextX][nextY]){//방문하지 않았다면 이동.dfs
                dfs(new Dot(nextX, nextY));
            }
        }
    }
}
class Dot{
    int x,y;
    public Dot(int x,int y){
        this.x = x;
        this.y = y;
    }
}
