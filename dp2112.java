package dynamic_programming1;

import java.util.Scanner;

public class dp2112 {
	static int[][] d = new int[31][8];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[0][7] = 1;
		for (int i=1; i<=n; i++) {
			d[i][0] = d[i-1][7];
			d[i][1] = d[i-1][6];
//			d[i][2] = d[i-1][5];
			d[i][3] = d[i-1][4] + d[i-1][7];
			d[i][4] = d[i-1][3];
//			d[i][5] = d[i-1][2];
			d[i][6] = d[i-1][1] + d[i-1][7];
			d[i][7] = d[i-1][0] + d[i-1][3] + d[i-1][6];
		}
		System.out.println(d[n][7]);
	}
}
