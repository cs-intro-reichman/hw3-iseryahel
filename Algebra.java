// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0)
		{
			for ( int i = 0 ; i < x2 ; i++ ) // we add 1 to x1, x2 times
			{
				x1++;
			} 
		}
		else if (x2 < 0)
		{
			for ( int i = 0 ; i > x2 ; i-- ) // doing the oposite if its negative number
			{
				x1--;
			} 
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 > 0)
		{
			for ( int i = 0 ; i < x2 ; i++ ) // we minus 1 to x1, x2 times
			{
				x1--;
			}
		}	
		else if (x2 < 0)
	{
		for ( int i = 0 ; i > x2 ; i-- ) // doing the oposite if its negative number
			{
				x1++;
			} 
	}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0 ;
		boolean negative = false ;
		if (x2 < 0) // if negative we chacnge to positive and at the ens switch the number again
		{
			negative= !negative;
			x2 = -x2 ; // here positive
		}
		if (x1< 0) // if negative we chacnge to positive and at the ens switch the number again
		{
			negative= !negative;
			x1 = -x1 ; // here positive
		}
		for ( int i = 0 ; i < x2 ; i++ )
		{
			sum = plus(sum,x1) ; // each time we add the number to the total x2 times
		}
		if (negative)// here change the number again
			sum = -sum;
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1 ;
		if (n < 0) // noe zero divisors
			return 0;

		for ( int i = 0 ; i < n ; i++ )
		{
			sum = times(sum,x) ; // each time we multiply the number to the total x2 times
		}
		
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		boolean negative = false ;
		int sum = 0;
		if (x2 == 0)
			return 0;
		if (x2 < 0) // checking to see if negative
		{
			negative= !negative;
			x2 = -x2 ;	
		}
		if (x1 < 0) // checking to see if negative
		{
			negative= !negative;
			x1 = -x1 ;	
		}
		while (x1 >= x2) // minus the number until we cant
		{
			x1 = minus(x1,x2);
			sum++;
		}
		if (negative)
			sum = -sum;
		return sum;	
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) // NO ZERO DIVISORS
		{
			return 0;
		}
		int first, seconed, last; 
		first = div (x1,x2); // מוציאים את החלק השלם
		seconed = times(first, x2); // רואים כמה פעמים נכנס החלק השלם
		last = minus(x1, seconed); // מחסרים את השלם
		return last;

	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) // no negative roots
		{
			return 0;
		}
		int num = 0 ;
		while ( times (num , num ) <= x ) 
		{
			num++;
		}
		return minus(num,1);

	}	  	  
}