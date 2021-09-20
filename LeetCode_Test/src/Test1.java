import sun.security.timestamp.TSRequest;

import java.util.Comparator;
import java.util.concurrent.Executors;

public class Test1 {
    static class A{
        A(){
            System.out.println("A");
        }
    }
    static class B{
        B(){
            System.out.println("B");
        }
    }
    {
        System.out.println("123");
    }
    static
    {
        System.out.println("1");
    }
    static {
        System.out.println("2");
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        Test1 test1 = new Test1();
        String s = new String();
        System.out.println(f(47,-42));
        System.out.println("6"+1.0+8);
        int[] i = new int[0];
    }

    static int f(int a, int b) {
        int c;
        do {
            c = a ^ b;
            b = a & b << 1;
            a = c;
        } while (b != 0);
        return c;
    }
}
