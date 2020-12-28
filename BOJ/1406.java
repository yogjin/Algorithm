/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.28
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 * 1406_에디터
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        String line = br.readLine();//초기 입력 문자열
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < line.length(); i++){
            list.add(line.charAt(i));
        }
        int n = Integer.parseInt(br.readLine());//명령어 개수
        //명령어 : L D B P
        //int cursor = line.length();
        ListIterator cursor = list.listIterator();
        while(cursor.hasNext()) cursor.next();//초기 커서 위치.abcd가 입력됐으면 cursor는 4

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();//명령어
            if(c.equals("L")){//커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                if(cursor.hasPrevious()) cursor.previous();
            }
            else if(c.equals("D")){//서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                if(cursor.hasNext()) cursor.next();
            }
            else if(c.equals("B")){//커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                if(cursor.hasPrevious()){
                  cursor.previous();
                  cursor.remove();
                }
            }
            else if(c.equals("P")){//$라는 문자를 커서 왼쪽에 추가함
                cursor.add(st.nextToken().charAt(0));
            }
        }
        for(char i : list){
            sb.append(i);
        }
        System.out.print(sb);
    }
}
