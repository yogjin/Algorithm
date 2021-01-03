/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.3
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 7569_토마토
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int n,m,h;//세로 가로 높이
    static int[][][] board;
    static boolean[][][] vis;
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<Dot> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());//가로
        n = Integer.parseInt(st.nextToken());//세로
        h = Integer.parseInt(st.nextToken());//높이
        
        board = new int[n][m][h];
        vis = new boolean[n][m][h];
        for(int k = 0; k < h; k++){
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a == 1){
                        q.offer(new Dot(i,j,k));//큐에 익은 토마토 넣기
                        vis[i][j][k] = true;
                    }
                    board[i][j][k] = a;
                }
            }
        }
        while(!q.isEmpty()){
            Dot now = q.poll();
            for(int i = 0; i < 6; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];
                
                if(nx <= -1 || nx >= n || ny <= -1 || ny >= m || nz <= -1 || nz >= h){
                    continue;
                }
                if(vis[nx][ny][nz] || board[nx][ny][nz] == -1){
                    continue;
                }
                q.offer(new Dot(nx,ny,nz));
                vis[nx][ny][nz] = true;
                board[nx][ny][nz] = board[now.x][now.y][now.z] + 1;
            }
        }
        int day = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < h; k++){
                    day = Math.max(day,board[i][j][k]);
                    if(board[i][j][k] == 0){
                        System.out.print(-1);
                        return;//안익은 토마토
                    }
                }
            }
        }
        System.out.print(day-1);
    }
}
class Dot{
    int x,y,z;
    public Dot(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
