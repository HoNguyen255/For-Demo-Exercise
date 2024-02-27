package Exercise.One;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();
        Bicycle bicycle = new Bicycle();
        bicycle.stop();
        System.out.println(car.doors);
    }
}
