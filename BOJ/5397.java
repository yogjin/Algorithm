/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.29
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 5397_키로거
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();
        ListIterator it = list.listIterator(); 
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            int len = line.length();
            for(int j = 0; j < len; j++){
                char a = line.charAt(j);//문자
                if(a == '<'){//화살표
                  if(it.hasPrevious()) it.previous();
                }
                else if(a == '>'){//화살표
                  if(it.hasNext()) it.next();
                }
                else if(a == '-'){//백스페이스
                  if(it.hasPrevious()){
                    it.previous();
                    it.remove();
                  }
                }
                else{//그냥 알파벳
                    it.add(a);
                }
            }
            for(char a : list){
                sb.append(a);
            }
            sb.append("\n");
            list.clear();//list 초기화
            it = list.listIterator();//it도 초기화~
        }
        System.out.print(sb);
    }
}
