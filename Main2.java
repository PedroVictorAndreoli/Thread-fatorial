public class Main {
    public static final long NUM_IT = 200000000;
    public static final double SUM_LIMIT = 100;

    public static void main(String[] args) {

        double sum = 0, start, end, time_t;
        start = System.currentTimeMillis();

        for (long i = 0; i < NUM_IT; i++) {
            sum = 1;
            for (long j = 1; j <= SUM_LIMIT; j++) {
                sum *= j;
            }
        }

        end = System.currentTimeMillis();
        time_t = (end - start) / 1000;
        System.out.println("Tempo Decorrido ..: " + time_t + " segundos");

    }
}