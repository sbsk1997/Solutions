package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1224_계산기3 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> oper = new Stack<>();

		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			char[] str = br.readLine().toCharArray();

			for (int i = 0; i < len; i++) {
				if (Character.isDigit(str[i])) {
					sb.append(str[i]);
				}
				if (str[i] == '(')
					oper.push('(');
				else if (str[i] == ')') {
					while (oper.peek() != '(') {
						sb.append(oper.pop());
					}
					oper.pop(); // 열린 괄호 없애고
				}
				else {
					if(!oper.isEmpty() && oper.peek() == '+' && str[i] == '+') {
						oper.pop();
						sb.append(str[i]);
						oper.push(str[i]);
						continue;
					}
					else if(!oper.isEmpty() &&oper.peek() == '+' && str[i] == '*') {
						oper.push(str[i]);
						continue;
					}
					else if(!oper.isEmpty() &&oper.peek() == '*' && str[i] == '+') {
						while(!oper.isEmpty()) {
							sb.append(oper.pop());
						}
						oper.push(str[i]);
						continue;
					}
				}
				oper.push(str[i]);
			}
			while(!oper.isEmpty())
				sb.append(oper.pop());
			int answer = calc(sb);
			System.out.println("#" + tc + " " + answer);
		}
	}
	public static int calc(StringBuilder sb) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < sb.length(); i++) {
			if(Character.isDigit(sb.charAt(i)))
				stack.push(sb.charAt(i) - '0');
			else {	//연산자를 만났다
				if(!stack.isEmpty()) {
					int num1 = stack.pop() ;
					int num2 = stack.pop();
					stack.push(calc2(sb.charAt(i), num1, num2));
				}
			}
		}
		return (int)stack.pop();
	}
	public static int calc2(char op, int n, int m) {
		if(op == '+')
			return n + m;
		else if(op == '*')
			return n * m;
		return 0;
	}
}
