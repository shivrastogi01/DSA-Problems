class ZeroEvenOdd {
    private int n;
    private java.util.concurrent.Semaphore zeroS 
        = new java.util.concurrent.Semaphore(1);
    private java.util.concurrent.Semaphore evenS 
        = new java.util.concurrent.Semaphore(0);
    private java.util.concurrent.Semaphore oddS 
        = new java.util.concurrent.Semaphore(0);


    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean freeEven = false;
        for (int i = 0; i < n; i++) {
            zeroS.acquire();
            printNumber.accept(0);
            if (freeEven) {
                evenS.release();
                freeEven = false;
            } else {
                oddS.release();
                freeEven = true;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) continue;
            evenS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) continue;
            oddS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }
}