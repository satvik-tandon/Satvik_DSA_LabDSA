import java.util.*;

public class Brackets {

    public static boolean isValid(String str) {
        Map<Character, Character> bracket = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> stack = new ArrayDeque<Character>();

        for (Character i : str.toCharArray()) {
            if (bracket.containsKey(i)) {
                stack.push(i);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char ch = stack.pop();
            if (bracket.get(ch) != i)
                return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string:");
        String str = sc.nextLine();
        System.out.println(isValid(str.replaceAll("\\s+", "")) == true ? "The entered String has Balanced Brackets"
                : "The entered String do not contain Balanced Bracket");
        sc.close();

    }
}