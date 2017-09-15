/*
 * 네 줄로 타일 깔기
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1400&sca=3050
 */

package dynamic_programming1;

import java.util.Scanner;

public class jungol2138 {
	static int[][] d = new int[10001][16];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		d[0][15] = 1;
		for (int i = 1; i <= n; i++) {
			d[i][0] = d[i - 1][15] % m;
			d[i][1] = d[i - 1][14] % m;
			d[i][2] = d[i - 1][13] % m;
			d[i][3] = d[i - 1][12] % m;
			d[i][4] = d[i - 1][11] % m;
			d[i][5] = d[i - 1][10] + d[i - 1][15] % m;
			d[i][6] = d[i - 1][9] % m;
			d[i][7] = d[i - 1][8] % m;
			d[i][8] = (d[i - 1][7] + d[i - 1][15]) % m;
			d[i][9] = d[i - 1][6] % m;
			d[i][10] = (d[i - 1][5] + d[i - 1][15]) % m;
			d[i][11] = (d[i - 1][4] + d[i - 1][12] + d[i - 1][14]) % m;
			d[i][12] = (d[i - 1][3] + d[i - 1][11]) % m;
			d[i][13] = (d[i - 1][2] + d[i - 1][14]) % m;
			d[i][14] = (d[i - 1][1] + d[i - 1][11] + d[i - 1][13]) % m;
			d[i][15] = (d[i - 1][0] + d[i - 1][5] + d[i - 1][8] + d[i - 1][10] + d[i - 1][15]) % m;
		}
		System.out.println(d[n][15]);
	}
}
