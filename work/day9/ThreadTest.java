package day9;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/20 15:19
 * @Version 1.0
 */
public class ThreadTest {
public static void main(String[]args){
        Thread1 t1 = new Thread1();
        t1.setName("线程一");
        t1.start();
}
}

class Thread1 extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName()+":"+ticket);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
        }
    }
}
