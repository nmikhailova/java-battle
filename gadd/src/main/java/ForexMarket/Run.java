package ForexMarket;

/**
 * Created by gadd on 26.03.16.
 */
public class Run {
    public static void main(String[] args) {
        Forex forex = new Forex(1.13, 1, 1000);
        Strategy strategy = new Strategy(0.5, forex);
        Robot robot = new Robot(1000, forex, strategy);
        robot.start();
    }
}
