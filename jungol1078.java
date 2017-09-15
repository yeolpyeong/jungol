/*
 * 1078 : 저글링 방사능 오염  
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=358&sca=3040
 */

package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class jungol1078 {
	static int M, N, Y, X;
	static int max = Integer.MIN_VALUE;
	static int[][] d = new int[101][101];
	static Queue<int[]> q = new LinkedList<int[]>();

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			char[] line = str.toCharArray();
			for (int j = 1; j <= M; j++) {
				d[i][j] = Character.getNumericValue(line[j - 1]);
			}
		}
		
		X = sc.nextInt();
		Y = sc.nextInt();

		d[Y][X] = 0;
		q.add(new int[] { Y, X, 3 });
		jungol1078(d, q);
		System.out.println(max);

		int r = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				r += d[i][j];
			}
		}
		System.out.println(r);
	}

	public static void jungol1078(int[][] d, Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] turn = q.poll();
			int y = turn[0];
			int x = turn[1];
			int t = turn[2];

			max = max < t ? t : max;

			for (int i = 0; i < 4; i++) {
				int yy = y + dy[i];
				int xx = x + dx[i];

				if (inRange(yy, xx) && d[yy][xx] == 1) {
					d[yy][xx] = 0;
					q.add(new int[] { yy, xx, t + 1 });
				}
			}
		}
	}

	public static boolean inRange(int y, int x) {
		if (y > 0 && x > 0 && y < 101 && x < 101)
			return true;
		return false;
	}
}
