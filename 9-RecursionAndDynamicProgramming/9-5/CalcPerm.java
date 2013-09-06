public class CalcPerm {
		public static void main(String[] args) {
			String s = "abcd";
			calcPerm(s.toCharArray());
		}

		public static void calcPermStart(char[] arr, int curr, int n) {
			if(curr == n){
				printArray(arr, n);
				return;
			}
			for(int i = curr; i < n; i++){
				swap(arr, i, curr);
				calcPermStart(arr, curr+1, n);
				swap(arr, i, curr);
			}
		}

		public static void calcPerm(char[] arr) {
			calcPermStart(arr, 0, arr.length);
		}

		public static void swap(char[] arr, int x, int y) {
			char temp = arr[x];
			arr[x] = arr[y];
			arr[y] = temp;
		}

		public static void printArray(char[] arr, int len){
			for(int i = 0; i < len; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
}
