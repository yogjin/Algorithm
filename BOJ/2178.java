/* 
 * Author: Park Yeong-Jin
 * Date: 2020.11.22
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
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());//세로
        int m = Integer.parseInt(st.nextToken());//가로
        
        int[][] maze = new int[m][n];//좌표
        
        for(int y = n-1; y >= 0; y--){
            String line = br.readLine();
            for(int x = 0; x < m; x++){
                maze[x][y] = line.charAt(x) - '0';//char to int
            }
        }
        
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(0,n-1));//행렬은 (1,1)
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(!queue.isEmpty()){
            Dot now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];
                if(nextX <= -1 || nextX >= m || nextY <= -1 || nextY >= n){
                    continue;
                }
                else if(maze[nextX][nextY] == 0){//길x
                    continue;
                }
                else if(maze[nextX][nextY] == 1){//한번도 들리지 않은경우
                    queue.add(new Dot(nextX,nextY));//이동개념.bfs
                    maze[nextX][nextY] = maze[now.x][now.y] + 1;//시작점부터의 거리
                }
            }
        }
        System.out.print(maze[m-1][0]);//도착점.
    }
}
class Dot{
    int x;
    int y;
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}
