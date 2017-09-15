package dynamic_programming1;

import java.util.Arrays;

public class test {
	static int N = 10;
	static int[][] d = new int[N+1][N+1];
	
	public static void main(String[] args) {
		Arrays.fill(d[1], 1);
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				System.out.print(d[i][j]);
			}
			System.out.println();
		}
	}
}