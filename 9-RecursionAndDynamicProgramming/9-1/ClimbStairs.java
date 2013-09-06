public class ClimbStairs {
	public static int num_stairs = 1000;
	public static void main(String[] args) {
		int[] array = new int[num_stairs];
		int[] map = new int[2000];
		for(int i = 0; i < map.length; i++) map[i] = -1;
		int ways = findWays(num_stairs, map);
		//climbStairs(array, 0, num_stairs);
		System.out.println("There are " + ways + " ways in total");
	}

	// space complexity: O(n), time complexity O(3^n)
	public static void climbStairs(int[] array, int curr, int rem) {
		if(rem == 0) {
			printArray(array, curr);
			return;
		}
		if (rem >= 3) {
			for(int i = 1; i <= 3; i++) {
				array[curr] = i;
				climbStairs(array, curr+1, rem-i);
			}
		} else {
			for(int i = 1; i <= rem; i++) {
				array[curr] = i;
				climbStairs(array, curr+1, rem-i);
			}
		}
	}
	public static void printArray(int[] array, int size) {
		for(int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	// find ways using dynamic programming
	public static int findWays(int n, int[] map){
		if(n < 0) return 0;
		if(n == 0) return 1;
		if(map[n] > -1) return map[n];
		map[n] = findWays(n-2, map) + findWays(n-1, map) + findWays(n-3, map);
		return map[n];
	}
}
