/*
 * 극장 좌석
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1121&sca=3050 
 */

package dynamic_programming1;

import java.util.Scanner;

public class jungol1848 {
	static int[] d = new int[42];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int res = 1;
		int[] s = new int[N + 2];
		for (int i = 1; i <= M; i++) {
			s[i] = sc.nextInt();
		}
		s[M + 1] = N + 1;
		
		for (int i = 0; i < M + 1; i++) {
			res *= fivonacci(s[i + 1] - s[i]);
		}
		System.out.println(res);
	}

	public static int fivonacci(int N) {
		if (d[N] != 0)
			return d[N];

		if (N == 1 || N == 2)
			return 1;
		else
			return d[N] = fivonacci(N - 2) + fivonacci(N - 1);
	} 
}
