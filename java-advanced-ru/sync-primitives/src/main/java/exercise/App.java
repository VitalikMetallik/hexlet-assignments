package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        try {
            var safetyList = new SafetyList();

            ListThread thread1 = new ListThread(safetyList);
            ListThread thread2 = new ListThread(safetyList);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println(safetyList.getSize());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // END
    }
}