/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.7
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 10026_적록색약
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int n;
    static boolean[][] vis1;
    static boolean[][] vis2;
    static char[][] board1;
    static char[][] board2;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<Dot> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String args[]) throws IOException {
        n = Integer.parseInt(br.readLine());
        
        //R,G,B
        board1 = new char[n][n];
        board2 = new char[n][n];
        vis1 = new boolean[n][n];//정상
        vis2 = new boolean[n][n];//적록색약
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                char in = line.charAt(j);
                board1[i][j] = in;
                if(in == 'G') in = 'R';
                board2[i][j] = in;
            }
        }
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!vis1[i][j]){
                    q.offer(new Dot(i,j));
                    vis1[i][j] = true;
                    bfs1();
                    c1++;
                    q.clear();
                }
                if(!vis2[i][j]){
                    q.offer(new Dot(i,j));
                    vis2[i][j] = true;
                    bfs2();  
                    c2++;
                    q.clear();
                } 
            }
        }
        sb.append(c1).append(" ").append(c2);
        System.out.print(sb);
    }
    public static void bfs1(){
        while(!q.isEmpty()){
            Dot now = q.poll();
            char nc = board1[now.x][now.y];//현재 알파벳.R,G,B
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx <= -1 || ny <= -1 || nx >= n || ny >= n){
                    continue;
                }
                else if(board1[nx][ny] != nc || vis1[nx][ny]){
                    continue;
                }
                q.offer(new Dot(nx,ny));
                vis1[nx][ny] = true;
            }
        }
    }
    public static void bfs2(){
        while(!q.isEmpty()){
            Dot now = q.poll();
            char nc = board2[now.x][now.y];//현재 알파벳.R,G,B
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx <= -1 || ny <= -1 || nx >= n || ny >= n){
                    continue;
                }
                else if(board2[nx][ny] != nc || vis2[nx][ny]){
                    continue;
                }
                q.offer(new Dot(nx,ny));
                vis2[nx][ny] = true;
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
