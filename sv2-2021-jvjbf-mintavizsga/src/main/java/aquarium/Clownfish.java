package aquarium;

public class Clownfish extends Fish {
    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        weight++;
    }
}
