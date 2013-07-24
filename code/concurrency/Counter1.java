import java.util.concurrent.atomic.*;



public class Counter1 {
    public static AtomicLong counter = new AtomicLong(0l);

    static class CountTask implements Runnable {
        // This is the entry point for the second thread.
        public void run() {
            for (;;) {
                if (Counter1.counter.incrementAndGet() >= 100000000l) {
                    return;
                }
            }
        }
    }

    public static void main (String[] args) {
        for (int i = 0; i< 2; i++) {
            Thread t = new Thread (new CountTask(), "");
            t.start();
        }
    }
}



