package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_2667_단지번호붙이기 {
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	static boolean[][] visit;
	static int[][] arr;
	static int size;
	static int[] house;
	static int danji;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		visit = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			String str = br.readLine();
			for(int j = 0; j < size; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		danji = 0;
		house = new int[25];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(arr[i][j] == 1 && !visit[i][j]) {
					search(1, i, j);
					danji++;
				}
			}
		}
		System.out.println(danji);
		Arrays.sort(house);
		for(int i = 0; i < house.length; i++) {
			if(house[i] == 0)
				continue;
			else System.out.println(house[i] + " ");
		}
	}
	
	//단지당 가구수
	public static void search(int depth, int i, int j) {
		visit[i][j] = true;
		house[danji]++;
		for(int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni >= 0 && ni < size && nj >= 0 && nj < size) {
				if(arr[ni][nj] == 1 && !visit[ni][nj]) {
					search(depth + 1, ni, nj);
				}
			}
		}
	}
}
