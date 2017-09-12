/*
 * 배낭 채우기2
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=561&sca=3050
 */

package dynamic_programming1;

import java.util.Scanner;

public class dp1278 {
	static int N, W;
	static int[][] d = new int[10001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		W = sc.nextInt();
		int[] Wi = new int[N + 1];
		int[] Pi = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Wi[i] = sc.nextInt();
			Pi[i] = sc.nextInt();
		}
		System.out.println(dp1278(Wi, Pi));
	}

	public static int dp1278(int[] Wi, int[] Pi) {
		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= N; j++) {
				d[i][j] = d[i][j - 1];
				// j번째 보석의 무게로 배낭을 채울 수 없는 경우 이전 보석으로 대체한다.
				if (i - Wi[j] >= 0 && d[i][j] < d[i - Wi[j]][j - 1] + Pi[j]) {
					// j번째 보석을 배낭의 남은 용량에 채울 수 있어야 한다.
					// j번째 보석을 넣었을 때의 가치가 최대가 되어야 한다.
					d[i][j] = d[i - Wi[j]][j - 1] + Pi[j];
				}
				// System.out.println("(" + i + ", " + j + "): " + d[i][j]);
			}
		}
		return d[W][N];
	}
}
