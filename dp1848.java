package dynamic_programming1;

import java.util.Scanner;

public class dp1848 {
	static int[] d = new int[42];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int res = 1;
		int[] s = new int[m + 2];
		s[0] = 0;
		for (int i = 1; i <= m; i++) {
			s[i] = sc.nextInt();
		}
		s[m + 1] = n + 1;
		int[] t = new int[m + 1];
		for (int i = 0; i < m + 1; i++) {
			t[i] = s[i + 1] - s[i];
			res *= fivonacci(t[i]);
		}
		System.out.println(res);
	}

	public static int fivonacci(int n) {
		if (d[n] != 0)
			return d[n];

		if (n == 1 || n == 2)
			return 1;
		else
			return d[n] = fivonacci(n - 2) + fivonacci(n - 1);
	}
}
