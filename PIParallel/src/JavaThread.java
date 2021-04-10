public class JavaThread extends Thread {

    private final int noOfThreads;
    private final int number;
    private final long n;
    private double sum  = 0;

    public JavaThread(int noOfThreads, int number, long n) {
        this.noOfThreads = noOfThreads;
        this.number = number;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = number; i <= n; i += noOfThreads) {
            sum += Math.pow(-1, i) / (2 * i + 1);
        }
    }

    public double getSum() {
        return sum;
    }
}