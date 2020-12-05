/* 
 * Author: Park Yeong-Jin
 * Date: 2020.12.05
 * email: youngjin988@gmail.com
 * 
 * https://github.com/yogjin/Algorithm
 */
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String args[]) {
        //Date 클래스 사용.
        Date today = new Date();//현재시간.
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);//한국시간을 출력.
        System.out.print(sf.format(today));//today를 지정한 형식으로 변환.
    }
}