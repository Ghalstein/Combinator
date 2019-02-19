import java.math.BigInteger;
public class Combo{
	private static BigInteger[] mapping;
	public static BigInteger mFac(int n){
		if (n == 1) return BigInteger.ONE;
		if(mapping[n] == null){ //not yet completed
		try{
		mapping[n] = BigInteger.valueOf(n).multiply((mFac(n-1)));
		} catch (StackOverflowError e){
			System.out.println("Sorry, this is too big. Please try a smaller input.");
			System.exit(0);
		}
		}
		return mapping[n];
	}
	public static BigInteger comb(int n, int k){
		if(n < 0 || k < 0){
			System.out.println("You cannot use negative numbers.");
			System.exit(0);
		}
		if(k==0) return BigInteger.ONE;
		if(n==0 && k > 0) return BigInteger.ZERO;
		BigInteger top = mFac(n);
		BigInteger bottom = mFac(k).multiply(mFac(n-k));
		return top.divide(bottom);
	}
	public static void main(String[] args){
		 if (args.length != 2) {
            System.out.println("Usage: java Combo n k");
            System.exit(0);
        }
		int n = 0;
		int k = 0;
			try{
				n = Integer.parseInt(args[0]);
				k = Integer.parseInt(args[1]);
			}catch (NumberFormatException e){
				System.out.print("Sorry you did not enter a number");
				System.exit(1);
			}
			
			if(n > 0 && k > n){System.out.println("n must be greater than or equal to k and greater than or equal to zero. Please try again.");
			System.exit(1);
			} else
			mapping = new BigInteger[n+1];
			System.out.println("The number of ways one can choose " + k + " out of " + n + " objects is " + comb(n, k));
		}
	} 