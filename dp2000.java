package dynamic_programming1;

import java.util.Arrays;
import java.util.Scanner;

public class dp2000 {
	static int n, w;
	static int[][] d = new int[11][64001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(d[0], 64001);
		int[] N = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			N[i] = sc.nextInt();
		}
		w = sc.nextInt();
		System.out.println(dp2000(N));
	}

	public static String dp2000(int[] N) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				d[i][j] = d[i - 1][j];
				if (j - N[i] >= 0 && d[i][j] > d[i][j - N[i]] + 1) {
					d[i][j] = d[i][j - N[i]] + 1;
				}
				// System.out.println("(" + i + ", " + j + "): " + d[i][j]);
			}
		}

		if (d[n][w] == 64001) {
			return "impossible";
		} else {
			return d[n][w] + "";
		}
	}
}
