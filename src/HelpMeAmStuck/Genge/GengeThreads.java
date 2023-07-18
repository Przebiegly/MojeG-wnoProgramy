package HelpMeAmStuck.Genge;

public class GengeThreads implements Runnable {

    public static void GimeMeThreads() {
        GengeThreads thread1 = new GengeThreads();
        GengeThreads thread2 = new GengeThreads();


        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();
    }


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
        }

    }
}
