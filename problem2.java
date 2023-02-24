import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class problem2 {

    // public static final long MAX_RUNTIME = 5 * 1000; // terminates after five seconds

    static class Guest implements Runnable {

        public void run() {
            boolean inLine = false;
            boolean inRoom = false;
            int num = idx.getAndIncrement();

            while (true) // guests can requeue
            {
                if (!inLine) {
                    line.add(num);
                    inLine = true;
                } else if (line.peek() == num && isShowroomEmpty.get()) {
                    isShowroomEmpty.set(false);
                    inRoom = true;
                    inLine = false;
                    line.remove();

                } else if (inRoom) {
                    inRoom = false;
                    isShowroomEmpty.set(true);
                    // can requeue from here?
                }
            }
        }
    }

    static int n = 100; // guests
    static AtomicBoolean isShowroomEmpty = new AtomicBoolean(true);
    static ArrayBlockingQueue<Integer> line = new ArrayBlockingQueue<Integer>(n);
    static AtomicInteger idx = new AtomicInteger(0);

    public static void main(String[] args) throws Exception
    {
        ExecutorService service = Executors.newFixedThreadPool(n);

        for (int i = 0; i < n; i++)
        {
            service.submit(new Guest());
        }

        service.shutdown();
    }
}