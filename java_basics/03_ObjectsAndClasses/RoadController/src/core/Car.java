package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }

    public void setNumber(){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

    public void setHeight(){
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setWeight(){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public void setHasVehicle(){
        this.hasVehicle = hasVehicle;
    }

    public boolean getHasVehicle(){
        return hasVehicle;
    }

    public void setIsSpecial(){
        this.isSpecial = isSpecial;
    }

    public boolean getIsSpecial(){
        return isSpecial;
    }

}