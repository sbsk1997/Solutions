package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	static int num;
	static int[] arr;
	static int[] combi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			if(num == 0)	break;
			arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combi = new int[6];
			comb(0, 0);
			System.out.println();
		}

	}

	private static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < combi.length; i++) {
				if(i == combi.length - 1)
					System.out.print(combi[i]);
				else
					System.out.print(combi[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < num; i++) {
			combi[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}

