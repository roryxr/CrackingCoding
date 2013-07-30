class DrawLine
{
	public static final int WIDTH = 64;
	public static void main(String[] args){
		byte[] screen = new byte[48];
		drawLine(screen, WIDTH, 8, 39, 3);
	}
	
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int left_offset = x1 % 8;
		int start_byte = x1 / 8;
		if(left_offset != 0){
			start_byte++;
		}
		int right_offset = x2 % 8;
		int end_byte = x2 / 8;
		if(right_offset != 7){
			end_byte--;
		}

		for(int i = width/8*y+start_byte; i <= width/8*y+end_byte; i++){
			screen[i] = (byte) 0xff;
		}

		byte left_value = (byte) ((1 << 8-left_offset)-1);
		byte right_value = (byte) (~((1 << 7-right_offset)-1));
		//System.out.println(Integer.toBinaryString(left_value)+ ", "+Integer.toBinaryString(right_value));
		if(start_byte > end_byte){
			if(left_offset == 0) screen[start_byte + width/8*y] = (byte) (left_value & right_value);
			else screen[start_byte + width/8*y-1] = (byte) (left_value & right_value);
		} else {
			if(left_offset != 0)screen[start_byte+width/8*y-1] = (byte) left_value;
			if(right_offset != 7)screen[end_byte+width/8*y+1] = (byte) right_value;
		}
		printScreen(screen, width);
	}

	public static void printScreen(byte[] screen, int width){
		int i=0, j=0;
		while(i < screen.length){
				for(int k=7; k>=0; k--){
					if((screen[i] & (1 << k)) == 0) System.out.print(0);
					else System.out.print(1);
				}
					System.out.print("|");
				i++;
				j++;
				if(j == width/8){
					System.out.println();
					j = 0;
				}
		}
	}
}

