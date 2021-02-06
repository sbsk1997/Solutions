package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();

		int tmp = 1, answer = 0;
		for(int i = 0; i < str.length; i++) {
			switch(str[i]) {
				case '(':
					stack.push('(');
					tmp *= 2;
					break;
				case '[':
					stack.push('[');
					tmp *= 3;
					break;
				case ')':
					if(stack.isEmpty() || stack.peek() != '(') {
						answer = 0;
						break;
					}
					if(str[i - 1] == '(') 
						answer += tmp;
					stack.pop();
					tmp /= 2;
					break;
				case ']':
					if(stack.isEmpty() || stack.peek() != '[') {
						answer = 0;
						break;
					}
					if(str[i - 1] == '[') 
						answer += tmp;
					stack.pop();
					tmp /= 3;
					break;
					
			}	//switch 괄호
		}		//for문 괄호
		if(!stack.isEmpty())
			answer = 0;
		System.out.println(answer);
	}
}
