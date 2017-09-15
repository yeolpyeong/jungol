/*
 * 두 줄로 타일 깔기
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=687&sca=3050
 */

package dynamic_programming1;

import java.util.Scanner;

public class jungol1411 {
	static int mod = 20100529;
	static int[] d = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d[1] = 1;
		d[2] = 3;
		int N = sc.nextInt();
		System.out.println(jungol1411(N));
	}

	// public static int jungol1411(int N) {
	// if (d[N] > 0)
	// return d[N];
	// if (N == 1)
	// return 1;
	// if (N == 2)
	// return 3;
	// d[N] = tiling(N - 1) + 2 * tiling(N - 2);
	// d[N] %= mod;
	// return d[N];
	// }

	public static int jungol1411(int N) {
		if (d[N] > 0)
			return d[N];
		for (int i = 3; i <= N; i++) {
			d[i] = d[i - 1] + 2 * d[i - 2];
			d[i] %= mod;
		}
		return d[N];
	}
}
