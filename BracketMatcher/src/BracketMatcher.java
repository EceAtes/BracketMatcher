import java.util.Scanner;
import java.util.Stack;

public class BracketMatcher {
	static Stack<Character> stackN = new Stack<>();
	static Stack<Character> stackC = new Stack<>();
	static Stack<Character> stackS = new Stack<>();

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		String input;
		
		
		System.out.print("Enter text: ");
		input = userIn.next();
		
		System.out.println(matcher(input,0));
		userIn.close();
	}
	
	public static int matcher(String input, int index) {
		if(index == input.length()) {
			if(stackN.size() == 0 && stackC.size() == 0 && stackS.size() == 0) {
				return 0;
			}
			return 1;
		}
		char curr = input.charAt(index);//
		//if(input.charAt(index) == '(') stack.push('(');
		//if(stack.size() > 0 && input.charAt(index) == ')') 	stack.pop();
		switch(curr) {
		case '(':
			stackN.push('(');
			break;
		case '{':
			stackC.push('{');
			break;
		case '[':
			stackS.push('}');
			break;
		case ')':
			if(stackN.size() > 0) stackN.pop();
			else return 1;
			break;
		case '}':
			if(stackC.size() > 0) stackC.pop();
			else return 1;
			break;
		case ']':
			if(stackS.size() > 0) stackS.pop();
			else return 1;
			break;	
		}
		return matcher(input, index+1);
	}

}