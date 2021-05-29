package TrainTickets;

public class test {
    public static void main(String[] args) {
        TrainTickets1 b = new TrainTickets1();
        new Thread(b, "Window 1").start();

        TrainTickets1 b1 = new TrainTickets1();
        new Thread(b1, "Window 2").start();

        TrainTickets1 b2 = new TrainTickets1();
        new Thread(b2, "Window 3").start();


    }
}
