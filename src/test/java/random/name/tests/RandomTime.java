package random.name.tests;

public class RandomTime {
    public static void randomTime() throws InterruptedException {
        Thread.sleep((long)(Math.random() * 3000));
    }
}
