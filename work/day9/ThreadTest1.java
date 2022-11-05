package day9;

/**
 * @ClassName TheradTest1
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/20 15:26
 * @Version 1.0
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadTest4());
        Thread thread2 = new Thread(new ThreadTest4());
        Thread thread3 = new Thread(new ThreadTest4());
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class ThreadTest4 implements Runnable {
    static int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (ThreadTest4.class) {
                System.out.println(Thread.currentThread().getName() + ":" + ticket);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
            }
        }
    }
}