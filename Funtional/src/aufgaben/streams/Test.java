package aufgaben.streams;

import java.util.Random;

public class Test {
    static Integer nextInt() {
        return new Random().nextInt();
    }
    
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println( nextInt() );
        }
    }
}