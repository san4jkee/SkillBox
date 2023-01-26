
public class Cat
{
    public static final int EYE_CAT = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 9000;
    private double width;
    private double minWidth;
    private double originWeight;
    private double weight;
    private double eaternFood = 0;
    private double minWeight;
    private double maxWeight;
    static int count = 0;
    public Color color;
    private String name;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

        count++;

    }

    public Cat(double weight, String name, Color type){
        this();
        this.weight = weight;
        this.color = color;
    }

    public Cat(Cat other){
        this.name = other.name;
        this.weight = other.weight;
        this.color = other.color;
    }

        public void meow()
    {
        if(weight > minWeight && weight < maxWeight) {
            weight = weight - 1;
            System.out.println("Meow");
            if (weight < minWeight || weight > maxWeight) {
                count--;
            }
        }
    }

    public void eat(Double amount) {
        if(weight > minWeight && weight < maxWeight) {
            eaternFood += amount;
            weight = weight + amount;
            if (weight < minWeight || weight > maxWeight) {
                count--;
            }
        }
    }

    public void pee() {
        System.out.println("Phew");
    }

    public void feed(Double amount) {
        if(weight > minWeight && weight < maxWeight) {
            weight = weight + amount;
            if (weight < minWeight || weight > maxWeight) {
                count--;
            }
        }
    }

    public void drink(Double amount)
    {
        if(weight > minWeight && weight < maxWeight) {
            weight = weight + amount;
        }
    }

    public boolean isAlive() {
        return weight > minWeight && weight < maxWeight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public Double getWeight()
    {
        return weight;
    }

    public Double getEat() {return eaternFood; }

    public static int getCount() {
        return count;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    public String getStatus()
    {
        if(weight < minWeight) {

            return "Dead";
        }
        else if(weight > maxWeight) {
            getCount();
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else if (isAlive()) {
            return "Кошка жива";
        }
        else {
            return "Playing";
        }
    }
}