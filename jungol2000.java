/*
 * 동전 교환
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1273&sca=3050
 */

package dynamic_programming1;

import java.util.Arrays;
import java.util.Scanner;

public class jungol2000 {
	static int N, W;
	static int[][] d = new int[11][64001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Arrays.fill(d[0], 64001);
		int[] NN = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			NN[i] = sc.nextInt();
		}
		W = sc.nextInt();
		System.out.println(jungol2000(NN));
	}

	public static String jungol2000(int[] NN) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				d[i][j] = d[i - 1][j];
				if (j - NN[i] >= 0 && d[i][j] > d[i][j - NN[i]] + 1) {
					d[i][j] = d[i][j - NN[i]] + 1;
				}
				// System.out.println("(" + i + ", " + j + "): " + d[i][j]);
			}
		}

		if (d[N][W] == 64001) {
			return "impossible";
		} else {
			return d[N][W] + "";
		}
	}
}
