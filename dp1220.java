/*
 * 최장 공통 부분수열
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=503&sca=3050
 */

package dynamic_programming1;

import java.util.Scanner;

public class dp1220 {
	static int[][] lcs = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String[] l1 = s1.split("");
		String[] l2 = s2.split("");
		System.out.println(dp1220(l1, l2));
	}

	public static int dp1220(String[] l1, String[] l2) {
		for (int i = 1; i <= l1.length; i++) {
			for (int j = 1; j <= l2.length; j++) {
				if (l1[i - 1].equals(l2[j - 1])) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}
		return lcs[l1.length][l2.length];
	}
}
