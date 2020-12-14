/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.14
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * BOJ 2206_안전영역
 */
import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    static int n = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int safe = 0;
    static int height = 0;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];//맵
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //물 높이는 0~100
        int max = 0;
        for(int a = 0; a <= 100; a++){
            safe = 0;//안전영역 초기화
            height = a;
            visited = new boolean[n][n];//초기화.
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > a && !visited[i][j]) {
                      dfs(new Dot(i,j));//0,0부터 시작
                      safe++;
                    }
                }
            }
            if(safe > max) max = safe;
        }
        System.out.print(max);
    }
    public static void dfs(Dot now){
        visited[now.x][now.y] = true;
        for(int i = 0; i < 4; i++){
            int nextX = now.x + dx[i];
            int nextY = now.y + dy[i];
            
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if(!visited[nextX][nextY] && map[nextX][nextY] > height){
                dfs(new Dot(nextX,nextY));
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