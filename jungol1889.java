/*
 * N Queen
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1162&sca=3030
 */

package backtracking1;

import java.util.Scanner;

public class jungol1889 {
	static int N, res;
	static int[] cols = new int[14];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		jungol1889(0);
		System.out.println(res);
	}

	public static boolean jungol1889(int l) {
		if (!promising(l))
			return false;
		else if (l == N) {
			for (int i = 1; i <= N; i++) {
				System.out.println("(" + i + ", " + cols[i] + ")");
			}
			System.out.println();
			res += 1;
			return false;
		} else {
			for (int i = 1; i <= N; i++) {
				cols[l + 1] = i;
				if (jungol1889(l + 1))
					return true;
			}
		}
		return false;
	}

	public static boolean promising(int l) {
		for (int i = 1; i < l; i++) {
			if (cols[i] == cols[l])
				return false;
			if (l - i == Math.abs(cols[l] - cols[i]))
				return false;
		}
		return true;
	}
}
