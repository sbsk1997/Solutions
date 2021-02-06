package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	static int memo[][] = new int[30][30];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			//mCn구하기
			answer = comb(M, N);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	public static int comb(int m, int n) {
		if(memo[m][n] > 0) return memo[m][n];
		if(m == n || n == 0) return memo[m][n] = 1;
		return memo[m][n] = comb(m - 1, n - 1) + comb(m - 1, n);
		
	}
}
