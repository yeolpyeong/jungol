/*
 * 단지번호붙이기
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=968&sca=3030
 */

package backtracking1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class jungol1695 {
	static int N, n, c;
	static ArrayList<Integer> res;
//	static int[] res;
	static int[][] d1 = new int[26][26];
	static int[][] d2 = new int[26][26];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			char[] line = str.toCharArray();
			for (int j = 1; j <= N; j++) {
				d1[i][j] = Character.getNumericValue(line[j - 1]);
			}
		}
		
		res = new ArrayList<Integer>(); 
//		res = new int[(int) Math.pow((int) N / 2, 2) + 1];
//		n = 1;
		jungol1695();
	}

	public static void jungol1695() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				c = 0;
				check(i, j);
				if (c != 0) {
					res.add(c);
//					res[n] = c;
//					n++;
				}
			}
		}
		
		System.out.println(res.size());
//		System.out.println(n - 1);
		Collections.sort(res);
//		for (int i = 1; i < n - 1; i++) {
//			for (int j = i + 1; j < n; j++) {
//				if (res[i] >= res[j]) {
//					int temp = res[i];
//					res[i] = res[j];
//					res[j] = temp;
//				}
//			}
//		}

		for (int i:res) {
			System.out.println(i);
		}
		
//		for (int i = 1; i < n; i++) {
//			System.out.println(res[i]);
//		}
	}
	
	public static void check(int x, int y) {
		if (x < 1 || y < 1 || x > N || y > N) {
			return;
		}

		if (d1[x][y] == 0 || d2[x][y] != 0) {
			return;
		}

		c++;
		d2[x][y] = 1;
//		d2[x][y] = n;
		check(x - 1, y); 
		check(x + 1, y);
		check(x, y - 1);
		check(x, y + 1);
	}
}
