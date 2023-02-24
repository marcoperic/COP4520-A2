import java.util.*;
import java.util.concurrent.atomic.*;

public class problem1 {

	static class Guest implements Runnable {
		problem1 host;
		int id;
		boolean hasEaten = false;
		int count = 0;

		Guest(int id, problem1 instance) {
			this.host = instance;
			this.id = id;
		}

		@Override
		public void run() {
			if (host.cupcake.get() && !hasEaten) {
				host.last = id;
				hasEaten = true;
				host.cupcake.set(false);
			} else {
				if (!host.cupcake.get() && id == host.counter) {
					count++;
					host.cupcake.set(true); // put it back
				}
			}
			if (count == host.n) {
				host.running = false;
			}
		}

    }

		AtomicBoolean cupcake = new AtomicBoolean(true);
		static volatile boolean running = true;
		final int counter = 0;
		static int last = 0;
		static int n = 100;
		ArrayList<Guest> guests = new ArrayList<>();

		public static void main(String[] args) {
			problem1 instance = new problem1();
			Random r = new Random();
			long startTime;

			// start the clock
			startTime = System.nanoTime();

			for (int i = 0; i < n; i++) {
				Guest guest = new Guest(i, instance);
				instance.guests.add(guest);
			}

			while (running) {
				int first = r.nextInt(n);
				Thread th = new Thread(instance.guests.get(first));

				th.start();
				
				try {
					th.join();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// end
			long endTime = System.nanoTime();
			long executionTime = (endTime - startTime) / (int) 1e6;

			System.out.println("all done! elapsed time: " + executionTime + " ms");
		}
	}