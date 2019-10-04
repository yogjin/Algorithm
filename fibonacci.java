import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class fibonacci {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("������");
		System.out.println("1 : Recursion");
		System.out.println("2 : Array");
		System.out.println("3 : Recursive squaring");
		

		Scanner scan = new Scanner(System.in);
		System.out.println("n�� ������ �ϰڽ��ϱ�?");
		long n = scan.nextInt();
		System.out.println("� ������ ����ϰڽ��ϱ�?");
		int method = scan.nextInt();
		
		TimeChecker mTimeChecker = new TimeChecker();//�ð�����.
		BigInteger result;
		if(method == 1) {//Recursion
			mTimeChecker.setStartTime();
			for(int i = 0; i <= n; i++) {
				//����ð� ����.
				mTimeChecker.setStartTime();
				result = solveByRecursion(i);//���
				mTimeChecker.setEndTime();
				if(result.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO) {//print�� ���������ϱ� ���� �۾�
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
				if(result.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO) {//print�� ���������ϱ� ���� �۾�
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
				if(result.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO) {//print�� ���������ϱ� ���� �۾�
					System.out.println("---------------------------------------------------------");
				}
				System.out.print("f<"+i+"> = "+result+"                         ");
				System.out.println(mTimeChecker.calcTerm()+" sec");
			}
		}
		else {
			System.out.println("�Է��� �߸��Ǿ����ϴ�.");
		}
	}
	//method 1
	public static BigInteger solveByRecursion(long n) {//ū ���ڸ� ǥ���ϱ����� bigInt���
		if(n < 2) {
			return BigInteger.valueOf(n);
		}
		return solveByRecursion(n-1).add(solveByRecursion(n-2));
	}
	//method 2
	public static BigInteger solveByArray(BigInteger[] array,int n) {//�޸������̼�
		array[0] = BigInteger.ZERO;
		if(n == 0) {//n�� 0�̰ų� 1�̸� �ش� ���ڸ� ����.
			return array[0];
		}
		array[1] = BigInteger.ONE;
		if(n == 1) {
			return array[1];
		}
		for(int i = 2; i <= n; i++) {//�迭���� ���ؼ� ����.
			array[i] = array[i-1].add(array[i-2]);
		}
		return array[(int) n];
	}
	//method 3
	public static BigInteger solveByRecursiveSquaring(int n) {/* POW ȣ�� �ڵ� */
		if(n == 0) {
			return BigInteger.ZERO;
		}
		// 1 1
		// 1 0 ���.
		BigInteger[][] a = new BigInteger[2][2];
		a[0][0] = BigInteger.ONE; a[0][1] = BigInteger.ONE;
		a[1][0] = BigInteger.ONE; a[1][1] = BigInteger.ZERO;
		a = pow(a,n);
		
		return a[0][1];//f(n)����
		}
	public static BigInteger[][] pow(BigInteger[][] a,int n) {/* ������ Ȧ¦�� ���� ���� �ٸ� ���� return�ϴ� �ڵ� */
		if(n == 1) {
			return a;
		}
		else if(n > 1) {
			a = pow(a,n/2);
			a = mul(a,a);
			if(n%2 == 1) {//n�� Ȧ���� n/2������ .5�� �����Ǿ� ����� �ѹ��� �������� �Ѵ�.
				BigInteger[][] b = new BigInteger[2][2];
				b[0][0] = BigInteger.ONE; b[0][1] = BigInteger.ONE;
				b[1][0] = BigInteger.ONE; b[1][1] = BigInteger.ZERO;
				a = mul(a,b);
			}
		}
		return a;
	}
	public static BigInteger[][] mul(BigInteger[][] a,BigInteger[][] b) {/* �� ��� A, B�� ���ϰ� ����� ��ȯ�ϴ� �ڵ� */
		BigInteger[][] c = new BigInteger [2][2];
		c[0][0] = (a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
		c[0][1] = (a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
		c[1][0] = (a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0]));
		c[1][1] = (a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));
		
		return c;
	}
	//�ð� ������ class
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
