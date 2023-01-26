public class LegalPerson extends Client {
    public double percentToTake;

    @Override
    public void take(double amountToTake){
        percentToTake = amountToTake * 0.01;
        if (amountToTake > money){
            amountToTake = 0.0;
        }else
        super.take(amountToTake + percentToTake);
    }

    @Override
    public void put(double amountToPut){
        if (amountToPut < 0.0){
            amountToPut = 0.0;
        }
        super.put(amountToPut);
    }
}
