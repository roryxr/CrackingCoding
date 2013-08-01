class Calculation
{
	public static void main(String[] args){
		int a = 5, b = -8, c = 2, d = -9;
		System.out.println(a + " - " +  b + " = "  + minus(a,b));
		System.out.println(a + " - " + c + " = " + minus(a,c));
		System.out.println(b + " - " + d + " = " + minus(b,d));
		System.out.println(a + " * " + b + " = " + multiply(a, b));
		System.out.println(a + " * " + c + " = " + multiply(a, c));
		System.out.println(b + " * " + d + " = " + multiply(b, d));
		System.out.println(a + " / " + c + " = " + divide(a, c));
		System.out.println(d + " / " + c + " = " + divide(d, c));
		System.out.println(a + " / " + b + " = " + divide(a, b));
	}

	public static int minus(int a, int b){
		return a+negate(b);
	}

	public static int negate(int x){
		int sign = x > 0 ? -1:1;
		int res = 0;
		while(x != 0){
			res += sign;
			x += sign;
		}
		return res;
	}

	public static int multiply(int a, int b){
		if(a<b) return multiply(b, a);
		int absb = abs(b);
		int res = 0;
		for(int i=0; i< absb; i++){
			res += a;
		}
		if(b < 0) return negate(res);
		else return res;
	}

	public static int abs(int x){
		if(x < 0) x = negate(x);
		return x;
	}

	public static int divide(int a, int b) throws ArithmeticException{
		if( b == 0) throw new java.lang.ArithmeticException("ERROR");
		int absa = abs(a);
		int absb = abs(b);
		int res = 0, product = 0;
		while( product + absb <= absa){
			res++;
			product += absb;
		}
		if((a < 0 && b < 0) || (a > 0 && b > 0)) return res;
		else return negate(res);
	}
	
}
