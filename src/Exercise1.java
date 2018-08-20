public class Exercise1
{

    public static void main(String[] args) throws Exception
    {
        Thread t1 = new Thread(() -> {
            long result = 0;
            for (long i = 1; i <= 1_000_000_000l; i++)
                result += i;

            System.out.println(result);
        });

        Thread t2 = new Thread(() -> {
            for (int x = 1; x <= 5; x++) {
                System.out.println(x);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Task3  task3 = new Task3();
        Thread t3    = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10_000);
        task3.stop();
    }

    static class Task3 implements Runnable
    {

        private boolean isRunning = true;

        public void stop()
        {
            isRunning = false;
        }

        @Override public void run()
        {
            for (long x = 10; x <= Long.MAX_VALUE; x++) {
                if (!isRunning)
                    return;
                System.out.println(x);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
