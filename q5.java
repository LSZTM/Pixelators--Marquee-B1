package model_assesment;
import java.util.Stack;
import java.util.Scanner;
public class q5 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Stack<String> redo = new Stack<>();
        Scanner s = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
        boolean flag = true;
        String curr_page = "";
        while (flag) {
            System.out.println("1.Type query");
            System.out.println("2.Undo");
            System.out.println("3.Show Current Page");
            System.out.println("4.Redo");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Type Query");
                    String a = inp.nextLine();
                    if (!curr_page.equals("")) stack.push(curr_page);
                    curr_page = a;
                    redo.clear();
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        System.out.println("No previous action!");
                        break;
                    }
                    redo.push(curr_page);
                    curr_page = stack.pop();
                    System.out.println("Undo successful. Current page: " + curr_page);
                    break;
                case 3:
                    System.out.println("Current Page: " + curr_page);
                    break;
                case 4:
                    if (redo.isEmpty()) {
                        System.out.println("No redo available!");
                        break;
                    }
                    stack.push(curr_page);
                    curr_page = redo.pop();
                    System.out.println("Redo successful. Current page: " + curr_page);
                    break;
                default:
                    System.out.println("Invalid action");
                    flag = false;
                    break;
            }
        }
    }
}
