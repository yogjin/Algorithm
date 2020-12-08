/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.8
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
        
        ArrayList<Dot> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Dot(x,y));
        }
        Collections.sort(list,(a,b)->{
            if(a.y == b.y){//y좌표가 같으면 x좌표가 증가하는 순서로 정렬
                return a.x - b.x;
            } 
            else{//y좌표가 증가하는 순으로 정렬
                return a.y - b.y;
            }
        });
        for(Dot dot : list){
            sb.append(dot.x).append(" ").append(dot.y);
            sb.append("\n");
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
