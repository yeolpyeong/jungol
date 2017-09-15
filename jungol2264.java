/*
 * 색상환
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1525&sca=3050
 */

package dynamic_programming1;

import java.util.Scanner;

public class jungol2264 {
	static int[][] d = new int[1001][1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int mod = 1000000003;
		
		for (int i=1; i<=N; i++) {
			d[i][0] = 1;
			d[i][1] = i;
		}
		
		for (int i=4; i<=N; i++) {
			for (int j=1; j<=K; j++) {
				d[i][j] = (d[i-1][j] + d[i-2][j-1])%mod;
			}
		}
		
		System.out.println(d[N][K]);
	}
}
