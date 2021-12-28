import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author peixi
 * @Date 2021/12/28
 * @Description
 */
public class Test {
    private static Integer num = 0;
    private static AtomicInteger ai = new AtomicInteger(0);
    private static final Object obj = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 10; j++) {
                        //System.out.println(++num);
                        System.out.println(ai.addAndGet(1));
                    }
                }
            });
            thread.start();
        }
    }
}
