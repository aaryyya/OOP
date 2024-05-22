import java.util.Scanner;
public class _16_Threads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create 5 threads");
            System.out.println("2. Synchronized methods to print tables");
            System.out.println("3. Demonstrate daemon thread");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createThreads();
                    break;
                case 2:
                    TablePrinter tablePrinter = new TablePrinter();
                    Thread t1 = new Thread(() -> tablePrinter.printTable2());
                    Thread t2 = new Thread(() -> tablePrinter.printTable5());
                    t1.start();
                    t2.start();
                    try {
                        t1.join();
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    demonstrateDaemonThread();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Create 5 threads
    public static void createThreads() {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new CustomThread(i));
            thread.start();
        }
    }

    // Class for custom threads
    static class CustomThread implements Runnable {
        private int threadNumber;

        public CustomThread(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadNumber + " is running.");
        }
    }

    // Class with synchronized methods to print tables
    static class TablePrinter {
        public synchronized void printTable2() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("2 x " + i + " = " + (2 * i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void printTable5() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("5 x " + i + " = " + (5 * i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Demonstrate daemon thread
    public static void demonstrateDaemonThread() {
        Thread daemonThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Daemon thread is running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(3000);  // Main thread sleeps for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is exiting. Daemon thread will also exit if all non-daemon threads finish.");
    }
}

