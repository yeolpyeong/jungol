/*
 * 장기 
 * * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=386&sca=3040
 */

package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs1106 {
	static int N, M, R, C, S, K, T;
	static int min = Integer.MAX_VALUE;
	static int[][] d1 = new int[101][101];
	static int[][] d2 = new int[101][101];
	static Queue<int[]> q = new LinkedList<int[]>();

	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		S = sc.nextInt();
		K = sc.nextInt();
		T = 0;

		q.add(new int[] { R, C, T });
		bfs1106();
		System.out.println(d2[S][K]);
	}

	public static void bfs1106() {
		while (!q.isEmpty()) {
			int[] turn = q.poll();
			int x = turn[0];
			int y = turn[1];
			int t = turn[2];

			min = min < t ? min : t;

			for (int i = 0; i < 8; i++) {
				if (inRange(x + dx[i], y + dy[i]) && d2[x + dx[i]][y + dy[i]] == 0) {
					q.add(new int[] { x + dx[i], y + dy[i], t + 1 });
					d2[x + dx[i]][y + dy[i]] = t + 1;
				}
			}
			
			if (d2[S][K] > 0)
				return;
		}

	}

	public static boolean inRange(int y, int x) {
		if (y > 0 && x > 0 && y < 101 && x < 101)
			return true;
		return false;
	}
}
