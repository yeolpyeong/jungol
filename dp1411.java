package dynamic_programming1;

import java.util.Scanner;

public class dp1411 {
	static int mod = 20100529;
	static int[] d = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d[1] = 1;
		d[2] = 3;
		int num = sc.nextInt();
		System.out.println(dp1411(num));
	}

	// public static int tiling(int n) {
	// if (d[n] > 0)
	// return d[n];
	// if (n == 1)
	// return 1;
	// if (n == 2)
	// return 3;
	// d[n] = tiling(n - 1) + 2 * tiling(n - 2);
	// d[n] %= mod;
	// return d[n];
	// }

	public static int dp1411(int n) {
		if (d[n] > 0)
			return d[n];
		for (int i = 3; i <= n; i++) {
			d[i] = d[i - 1] + 2 * d[i - 2];
			d[i] %= mod;
		}
		return d[n];
	}
}
