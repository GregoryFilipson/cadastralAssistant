public class Deal {
    private final String name;
    private final double width;
    private final double length;
    private final double cost;

    public Deal(String name, double width, double length, double cost) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.cost = cost;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
