package HelpMeAmStuck.Genge;

import java.util.Stack;

public class GengeStack {
    public static void Stacking() {
        Stack<Integer> stack = new Stack<>();


        stack.push(10);
        stack.push(20);
        stack.push(30);


        System.out.println("Stack: " + stack);


        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);


        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);


        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty? " + isEmpty);

        System.out.println("Stack: " + stack);
    }
}
