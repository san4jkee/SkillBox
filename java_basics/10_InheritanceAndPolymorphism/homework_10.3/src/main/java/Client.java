public abstract class Client {
    public double money;

    public double getAmount() {
        return money;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0.0){
            amountToPut = 0.0;
        }
        money += amountToPut;
    }

    public void take(double amountToTake) {
        if (amountToTake < 0.0){
            amountToTake = 0.0;
        }
        money -= amountToTake;
    }

}
