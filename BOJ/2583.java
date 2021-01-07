/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.7
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 2583_영역구하기
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
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
        int m = Integer.parseInt(st.nextToken());//세로
        int n = Integer.parseInt(st.nextToken());//가로
        int k = Integer.parseInt(st.nextToken());//줄개수
        
        //board = new int[m][n];
        vis = new boolean[m][n];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            //(a,b), (c,d)
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            for(int j = b; j < d; j++){
                for(int z = a; z < c; z++){
                    vis[j][z] = true;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;//영역의 넓이==poll()한 횟수.
                if(!vis[i][j]){
                    q.offer(new Dot(i,j));
                    vis[i][j] = true;
                    count++;
                    while(!q.isEmpty()){
                        Dot now = q.poll();
                        for(int z = 0; z < 4; z++){
                            int nx = now.x + dx[z];
                            int ny = now.y + dy[z];
                            
                            if(nx <= -1 || ny <= -1 || nx >= m || ny >= n){
                                continue;
                            }
                            else if(vis[nx][ny] == true){
                                continue;
                            }
                            vis[nx][ny] = true;
                            q.offer(new Dot(nx,ny));
                            count++;
                        }
                    }
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int i : list){
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
class Dot{
    int x,y;
    public Dot(int x,int y){
        this.x = x;
        this.y = y;
    }
}
