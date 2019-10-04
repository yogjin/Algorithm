
import java.math.BigInteger;

public class poweringNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = 2;
		long n = 30;
	
		System.out.println("a^n = " + poweringNumber(a,n));
	}
	public static BigInteger poweringNumber(long a, long n) {
		BigInteger bigA = BigInteger.valueOf(a);
		if(n == 0) {
			return BigInteger.ONE;
		}
		else if(n == 1) {
			return bigA;
		}
		else if(n % 2 == 0) {//n == even
			return poweringNumber(a,n/2).multiply(poweringNumber(a,n/2));
			
		}
		else if(n % 2 != 0) {//n == odd
			return poweringNumber(a,n/2).multiply(poweringNumber(a,n/2)).multiply(bigA);
		}
		else {
			return BigInteger.valueOf(-1);
		}
	}
}
