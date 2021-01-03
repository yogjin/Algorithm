/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.3
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 1926_그림
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int n,m;//세로 가로
    static boolean[][] vis;
    static int[][] board;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Dot> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());//세로
        m = Integer.parseInt(st.nextToken());//가로
        
        board = new int[n][m];
        vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int a = Integer.parseInt(st.nextToken());
                board[i][j] = a;
            }
        }
        int max = 0;//최소 그림크기 0
        int count = 0;//bfs호출 횟수
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && board[i][j] == 1){
                    q.add(new Dot(i,j));
                    vis[i][j] = true;
                    max = Math.max(bfs(), max);
                    count++;
                }
            }
        }
        System.out.print(count+"\n"+max);
    }
    public static int bfs(){//poll한 횟수 = 그림의 넓이
        int count = 0;
        while(!q.isEmpty()){
            Dot now = q.poll(); count += 1;
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx <= -1 || nx >= n || ny <= -1 || ny >= m) continue;
                if(vis[nx][ny] || board[nx][ny] == 0) continue;
                q.offer(new Dot(nx,ny));
                vis[nx][ny] = true;    
            }
        }
        return count;
    }
}
class Dot{
    int x,y;
    public Dot(int x,int y){
        this.x = x;
        this.y = y;
    }
}
