package unit2.stack;

public class ParentheseExamples {
    public static void main(String[] args){
        String t1 = "[()]{}{[()()]()}";//true
        String t2 = "[(])";// false
        String t3 = "[[[]]]";// true
        String t4 = "[[]";// false

        System.out.println(parentheseMatch(t1));
        System.out.println(parentheseMatch(t2));
        System.out.println(parentheseMatch(t3));
        System.out.println(parentheseMatch(t4));


    }

    public static boolean match(char left, char right){
        return (left == '[' && right == ']') ||
                (left == '(' && right == ')')||
                (left == '{' && right == '}');
    }

    public  static boolean parentheseMatch(String expression){
        Stack<Character> s = new LinkedListStack<>();
        char[] chars  = expression.toCharArray();
        for(int i =0 ; i < chars.length; i ++){
            if(chars[i] == '[' || chars[i] == '(' || chars[i]== '{')
                s.push(chars[i]);
            else {
                char c = s.pop();
                if(!match(c, chars[i])) return false;
            }
        }
        return s.isEmpty();
    }
}
