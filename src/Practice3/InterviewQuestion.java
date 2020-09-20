package Practice3;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

public class InterviewQuestion {

    static Stack<String> stack1 = new Stack<String>();
    static Stack<String> stack2 = new Stack<String>();

    private static void enqueue(String item){
        stack1.push(item);
    }

    private static String dequeue(){
        String item;

        if(stack1.isEmpty() && stack2.isEmpty()){
            item = "\nStack이 비었어요!";
        }
        else if(!stack1.isEmpty() && stack2.isEmpty()){

            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            item = stack2.pop();
        }else{
            item = stack2.pop();
        }

        return item;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true) {
            System.out.println("\n수행할 연산을 선택해주세요.");
            System.out.println("1.Push 2.Pop 3.Exit");

            int n = s.nextInt();

            switch (n) {
                case 1:
                    System.out.println("\n알파벳을 입력하세요.");
                    String item = s.next();
                    enqueue(item);
                    break;

                case 2:
                    System.out.println("Pop 결과: ");
                    System.out.println(dequeue());
                    break;

                default:
                    exit(0);
                    break;
            }
        }
    }
}