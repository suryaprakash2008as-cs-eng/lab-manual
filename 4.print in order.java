import java.util.concurrent.atomic.AtomicInteger;

class Foo {
    private AtomicInteger count = new AtomicInteger(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count.incrementAndGet(); // Move state to 1
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() completes
        while (count.get() < 1) {
            // Busy-wait loop
        }
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        count.incrementAndGet(); // Move state to 2
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() completes
        while (count.get() < 2) {
            // Busy-wait loop
        }
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
