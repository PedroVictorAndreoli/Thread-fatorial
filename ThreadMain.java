public class ThreadMain {
    public static final int NUM_IT = 200000000;
    public static final double SUM_LIMIT = 100;

    public static void main(String[] args) throws InterruptedException {

        double start, end, time_t;
        start = System.currentTimeMillis();

        Worker t1 = new Worker(1, SUM_LIMIT / 2, NUM_IT / 2);
        t1.setName("Thread1");
        Worker t2 = new Worker((SUM_LIMIT / 2) + 1, SUM_LIMIT, NUM_IT / 2);
        t2.setName("Thread2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        end = System.currentTimeMillis();
        time_t = (end - start) / 1000;
        System.out.println("Tempo Decorrido ..: " + time_t + " segundos");

    }
}
class Worker extends Thread {
    private double first;
    private double last;
    private int iteration;
    private double sum;

    public Worker(double first, double last, int iteration) {
        this.first = first;
        this.last = last;
        this.iteration = iteration;
    }

    public double getSum() {
        return sum;
    }

    public void run() {
        for (double i = 0; i < iteration; i++) {
            sum = 1;
            for (double j = first; j <= last; j++) {
                sum *= j;
            }
        }
    }
}
