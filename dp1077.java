package dynamic_programming1;

import java.util.Scanner;

public class dp1077 {
	static int n, w;
	static int[][] d = new int[10001][5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		int[] wi = new int[n + 1];
		int[] pi = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			wi[i] = sc.nextInt();
			pi[i] = sc.nextInt();
		}
		System.out.println(dp1077(wi, pi));
	}

	public static int dp1077(int[] wi, int[] pi) {
		for (int i = 1; i <= w; i++) {
			for (int j = 1; j <= n; j++) {
				d[i][j] = d[i][j - 1];
				// j번째 보석의 무게로 배낭을 채울 수 없는 경우 이전 보석으로 대체한다.
				if (i - wi[j] >= 0 && d[i][j] < d[i - wi[j]][j] + pi[j]) {
					// j번째 보석을 배낭의 남은 용량에 채울 수 있어야 한다.
					// j번째 보석을 넣었을 때의 가치가 최대가 되야 한다.
					d[i][j] = d[i - wi[j]][j] + pi[j];
				}
				// System.out.println("(" + i + ", " + j + "): " + d[i][j]);
			}
		}
		return d[w][n];
	}
}
