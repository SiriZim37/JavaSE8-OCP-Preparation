package test;


public class InitOrder {

    public void play() {
        System.out.println("play-");
    }

    // Example of resource cleanup with AutoCloseable
    static class Resource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("clean-");
        }
    }

    public static void main(String[] args) {
    	
    
        InitOrder n = new InitOrder();
        n.play();
        try (Resource res = new Resource()) {
            // Resource will be automatically cleaned up
        }
        
        InitOrder r = new InitOrder();
        r.play();
    }
}