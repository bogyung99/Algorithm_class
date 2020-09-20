package Practice2;

import java.util.Scanner;
import java.util.Iterator;

import static java.lang.System.exit;

public class ArrayStack {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        ResizingArrayStack<String> st = new ResizingArrayStack<String>();

        while(true){
            System.out.println("\n수행할 연산을 선택해주세요.");
            System.out.println("1.Push 2.Pop 3.Show Stack 4.exit");

            int n = s.nextInt();

            switch (n){
                case 1:
                    System.out.println("\nStack에 넣을 item을 입력하세요: ");
                    String item = s.next();

                    st.push(item);

                    break;

                case 2:
                    if(st.isEmpty())
                        System.out.println("\nStack이 비었어요!");
                    else
                        System.out.println("Pop 결과: " + st.pop());

                    break;

                case 3:
                    Iterator<String> r = st.iterator();

                    System.out.println("Stack 출력 결과 : ");

                    while (r.hasNext()) {
                        System.out.println(r.next());
                    }

                    break;

                default:
                    exit(0);
                    break;
            }
        }
    }
}
