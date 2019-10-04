import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("연산방법");
		System.out.println("1 : Recursion");
		System.out.println("2 : Array");
		System.out.println("3 : Recursive squaring");
		

		Scanner scan = new Scanner(System.in);
		System.out.println("n은 몇으로 하겠습니까?");
		long n = scan.nextInt();
		System.out.println("어떤 연산을 사용하겠습니까?");
		int method = scan.nextInt();
		
		TimeChecker mTimeChecker = new TimeChecker();//시간측정.
		BigInteger result;
		if(method == 1) {//Recursion
			mTimeChecker.setStartTime();
			for(int i = 0; i <= n; i++) {
				//수행시간 측정.
				mTimeChecker.setStartTime();
				result = solveByRecursion(i);//재귀
				mTimeChecker.setEndTime();
				if(result.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO) {//print문 보기좋게하기 위한 작업
					System.out.println("---------------------------------------------------------");
				}
				System.out.print("f<"+i+"> = "+result+"                         ");
				System.out.println(mTimeChecker.calcTerm()+" sec");
			}
		}
		else if(method == 2) {//Array
			for(int i = 0; i <= n; i++) {
				BigInteger[] array = new BigInteger[i+1];
				mTimeChecker.setStartTime();
				result = solveByArray(array,i);
				mTimeChecker.setEndTime();
				if(result.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO) {//print문 보기좋게하기 위한 작업
					System.out.println("---------------------------------------------------------");
				}
				System.out.print("f<"+i+"> = "+result+"                         ");
				System.out.println(mTimeChecker.calcTerm()+" sec");
			}
		}
		else if(method == 3) {//Recursive squaring
			for(int i = 0; i <= n; i++) {
				mTimeChecker.setStartTime();
				result = solveByRecursiveSquaring(i);
				mTimeChecker.setEndTime();
				if(result.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO) {//print문 보기좋게하기 위한 작업
					System.out.println("---------------------------------------------------------");
				}
				System.out.print("f<"+i+"> = "+result+"                         ");
				System.out.println(mTimeChecker.calcTerm()+" sec");
			}
		}
		else {
			System.out.println("입력이 잘못되었습니다.");
		}
	}
	//method 1
	public static BigInteger solveByRecursion(long n) {//큰 숫자를 표현하기위해 bigInt사용
		if(n < 2) {
			return BigInteger.valueOf(n);
		}
		return solveByRecursion(n-1).add(solveByRecursion(n-2));
	}
	//method 2
	public static BigInteger solveByArray(BigInteger[] array,int n) {//메모이제이션
		array[0] = BigInteger.ZERO;
		if(n == 0) {//n이 0이거나 1이면 해당 숫자를 리턴.
			return array[0];
		}
		array[1] = BigInteger.ONE;
		if(n == 1) {
			return array[1];
		}
		for(int i = 2; i <= n; i++) {//배열값을 더해서 리턴.
			array[i] = array[i-1].add(array[i-2]);
		}
		return array[(int) n];
	}
	//method 3
	public static BigInteger solveByRecursiveSquaring(int n) {/* POW 호출 코드 */
		if(n == 0) {
			return BigInteger.ZERO;
		}
		// 1 1
		// 1 0 행렬.
		BigInteger[][] a = new BigInteger[2][2];
		a[0][0] = BigInteger.ONE; a[0][1] = BigInteger.ONE;
		a[1][0] = BigInteger.ONE; a[1][1] = BigInteger.ZERO;
		a = pow(a,n);
		
		return a[0][1];//f(n)리턴
		}
	public static BigInteger[][] pow(BigInteger[][] a,int n) {/* 지수의 홀짝에 따라 각각 다른 값을 return하는 코드 */
		if(n == 1) {
			return a;
		}
		else if(n > 1) {
			a = pow(a,n/2);
			a = mul(a,a);
			if(n%2 == 1) {//n이 홀수면 n/2했을때 .5가 누락되어 행렬이 한번더 곱해져야 한다.
				BigInteger[][] b = new BigInteger[2][2];
				b[0][0] = BigInteger.ONE; b[0][1] = BigInteger.ONE;
				b[1][0] = BigInteger.ONE; b[1][1] = BigInteger.ZERO;
				a = mul(a,b);
			}
		}
		return a;
	}
	public static BigInteger[][] mul(BigInteger[][] a,BigInteger[][] b) {/* 두 행렬 A, B를 곱하고 결과를 반환하는 코드 */
		BigInteger[][] c = new BigInteger [2][2];
		c[0][0] = (a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
		c[0][1] = (a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
		c[1][0] = (a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0]));
		c[1][1] = (a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));
		
		return c;
	}
	//시간 측정용 class
	public static class TimeChecker {
		private BigDecimal startTime;

		private BigDecimal endTime;

		private BigDecimal term;

		public void setStartTime(){
			startTime = new BigDecimal(System.nanoTime());
		}
		public void setEndTime(){
			endTime = new BigDecimal(System.nanoTime());
		}
		public BigDecimal calcTerm(){
			term = endTime.subtract(startTime);
			return term.divide(BigDecimal.valueOf(1000000000.0));
		}
	}

}
