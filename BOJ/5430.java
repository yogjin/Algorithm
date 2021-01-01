/* 
 * Author: Park Yeong-Jin
 * Date: 2021.1.1
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 5430_AC
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
       
        Deque<Integer> que = new LinkedList<>();
        int t = Integer.parseInt(br.readLine());//tc개수
        for(int i = 0; i < t; i++){
            boolean flag = false;
            String p = br.readLine();//수행할 함수
            int pl = p.length();//명령어 갯수
            int n = Integer.parseInt(br.readLine());//배열에 들어있는 수 개수
            String s = br.readLine();//배열
            s = s.substring(1,s.length()-1); //문자열 자르기. 1 <= s < s.length 리턴.
            st = new StringTokenizer(s,",");
            for(int j = 1; j <= n; j++){
                que.offerLast(Integer.parseInt(st.nextToken()));
            }
            boolean front = true;
            for(int k = 0; k < pl; k++){
                char cd = p.charAt(k);//R :뒤집기 D:첫번째 숫자 삭제
                int qs = que.size();
                if(cd == 'R'){
                  if(front == true) front = false;
                  else front = true;
                }
                else if(cd == 'D'){
                    if(qs == 0){
                        sb.append("error\n");
                        flag = true;
                        break;
                    } 
                    else if(front){
                      que.removeFirst();
                    }
                    else if(!front){
                      que.removeLast();
                    }
                }
            }
            if(!flag){
                sb.append("[");
                while(!que.isEmpty()){
                    sb.append(que.removeFirst());
                    if(que.size() != 0) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
