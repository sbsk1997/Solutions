package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 }; // 상 우 하 좌
	static int row, col;
	static int[][] farm;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			farm = new int[row][col];
			visit = new boolean[row][col];

			int cnt = Integer.parseInt(st.nextToken());
			int bug = 0;
			for (int i = 0; i < cnt; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				farm[n][m] = 1; // 배추가 있는 곳은 1
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (farm[i][j] == 1 && !visit[i][j]) {
						search(i, j);
						bug++;
					}
				}
			}
			System.out.println(bug);
		}
	}

	public static void search(int i, int j) {
		visit[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < row && nj >= 0 && nj < col) { // 범위 안이고
				if (visit[ni][nj] == false && farm[ni][nj] == 1) {
					search(ni, nj);
				}
			}
		}
	}
}
