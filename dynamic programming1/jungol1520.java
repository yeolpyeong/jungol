/*
 * 계단 오르기 
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=792&sca=3050
 */

package dynamic_programming1;

import java.util.Scanner;

public class jungol1520 {
	static int[][] d = new int[301][3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n + 1];
		int i = 0;
		while (n-- > 0) {
			i += 1;
			s[i] = sc.nextInt();
		}
		System.out.println(jungol1520(s));
	}

	public static int jungol1520(int[] s) {
		for (int i = 1; i < s.length; i++) {
			d[i][0] = Math.max(d[i - 1][1], d[i - 1][2]);
			// i번째 계단을 밝지 않는 경우
			d[i][1] = d[i - 1][0] + s[i];
			// i번째 계단을 밝는 경우
			d[i][2] = d[i - 1][1] + s[i];
			// i-1, i번째 계단을 밝는 경우
			// System.out.println(i + "th: " + d[i][0] + " / " + d[i][1] + " / " + d[i][2]);
		}
		return Math.max(d[s.length - 1][1], d[s.length - 1][2]);
	}
}
