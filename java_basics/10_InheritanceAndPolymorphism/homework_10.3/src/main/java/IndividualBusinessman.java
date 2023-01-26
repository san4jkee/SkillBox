public class IndividualBusinessman extends Client {
    public double percentToPut;

    @Override
    public void take(double amountToTake){
        if (amountToTake > money){
            amountToTake = 0.0;
        }
        super.take(amountToTake);
    }

    @Override
    public void put(double amountToPut){
        percentToPut = amountToPut * 0.01;
        if (amountToPut < 0.0){
            amountToPut = 0.0;
        }
        if (amountToPut >= 1000){
            percentToPut = amountToPut * 0.005;

        }
        super.put(amountToPut - percentToPut);
    }
}
