class FloatToBit
{
	public static void main(String[] args){
		double f = (double)0.625;
		System.out.println("Float value " + f + " in binary is " + doubleToBit3(f));
	}


	// My method did not do an "ERROR" check
	public static String doubleToBit(double num){
		char[] ch =  new char[32];
		ch[0] = '0';
		ch[1] = '.';
		int cnt = 29;
		int val = 0;
		while(cnt > 0 && num != 0){
			num *= 2;
			if(num >= 1){
				val = val | 1<<cnt;
				num -= 1;
			}
			cnt--;
		}
		int mask = 1<<29;
		for(int i=0; i<30; i++){
			if((mask & val) == 1 << 29)ch[i+2] = '1';
			else ch[i+2] = '0';
			val = val << 1;
		}
		return new String(ch);
	}

	// Better method using a StringBuilder
	public static String doubleToBit2(double num){
		if(num <= 0 || num >= 1) return "ERROR";
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		sb.append(".");
		while(num > 0){
			if(sb.length() >= 32) return "ERROR";
			num *= 2;
			if(num >= 1){
				sb.append("1");
				num -= 1;
			} else 
				sb.append("0");
		}
		return sb.toString();
	}
	
	// Another method using fraction 0.5, 0.25, 0.125, ....
	public static String doubleToBit3(double num){
		if(num <= 0 || num >= 1) return "ERROR";
		double frac = (double)0.5;
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		sb.append(".");
		while(num > 0){
			if(sb.length() >= 32) return "ERROR";
			if(num >= frac){
				sb.append("1");
				num -= frac;
			} else
				sb.append("0");
			frac /= 2;
		}
		return sb.toString();
	}
	
}
