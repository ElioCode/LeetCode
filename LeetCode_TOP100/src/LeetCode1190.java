import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode1190 {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] index = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                index[i] = j;
                index[j] = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        int flag = 1;
        for (int i = 0; i < s.length(); i += flag) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = index[i];
                flag = -flag;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
