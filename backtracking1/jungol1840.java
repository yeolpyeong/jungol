/*
 * 치즈
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1113&sca=3030
 */

package backtracking1;

import java.util.Scanner;

public class jungol1840 {
	static int N, M, count1, count2, hour;
	static int[][] d1 = new int[101][101];
	static int[][] d2 = new int[101][101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				d1[i][j] = sc.nextInt();
				d2[i][j] = d1[i][j];
			}
		}

		jungol1840();
	}

	public static void jungol1840() {
		while (true) {
			count1 = 0;
			fill(1, 1);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (d1[i][j] == 1 && check(i, j)) {
						d1[i][j] = 0;
						count1++;
					}
				}
			}
			if (count1 == 0) {
				System.out.println(hour);
				System.out.println(count2);
				break;
			}
			hour++;
			copy();
		}
	}

	public static void fill(int n, int m) {
		if (n < 1 || m < 1 || n > N || m > M)
			return;

		if (d2[n][m] == 0) {
			d2[n][m] = 2;
			fill(n - 1, m);
			fill(n + 1, m);
			fill(n, m - 1);
			fill(n, m + 1);
		}
	}

	public static boolean check(int n, int m) {
		if (n < 1 || m < 1 || n > N || m > M)
			return false;

		if (d2[n - 1][m] == 2)
			return true;
		if (d2[n + 1][m] == 2)
			return true;
		if (d2[n][m - 1] == 2)
			return true;
		if (d2[n][m + 1] == 2)
			return true;
		return false;
	}

	public static void copy() {
		count2 = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (d2[i][j] == 1) {
					count2++;
				}
				d2[i][j] = d1[i][j];
			}
		}
	}
}
