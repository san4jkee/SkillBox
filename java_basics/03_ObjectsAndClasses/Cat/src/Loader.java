import javax.swing.plaf.IconUIResource;

public class Loader
{
    private static Cat getKitten(){
        return new Cat(1100.00, "Персик", Color.WHITE);
    }

    public static void main(String[] args)
    {
        Cat persik = getKitten();
        System.out.println("Persik weight: " + persik.getWeight());
        Cat pushok = new Cat();
        System.out.println("Pushok weight: " + pushok.getWeight());
        Cat vasya = getKitten();
        System.out.println("Vasya weight: " + vasya.getWeight());
        Cat musya = getKitten();
        System.out.println("Musya weight: " + musya.getWeight());

        persik.setColor(Color.ORANGE);
        System.out.println("Persik color: " + persik.getColor());
        pushok.setColor(Color.WHITE);
        System.out.println("Pushok color: " + pushok.getColor());
        vasya.setColor(Color.BLACK);
        System.out.println("Vasya color: " + vasya.getColor());

        System.out.println("=============== Копирование объектов ===============");

        Cat vaska = new Cat();
        vaska.setName("Васька");
        vaska.setColor(Color.BLACK);
        System.out.println(vaska.getName() + " " + "весит: " + vaska.getWeight() + " " + "цвет: " + vaska.getColor());
        Cat murka = new Cat(vaska);
        murka.setName(vaska.getName());
        murka.setWeight(vaska.getWeight());
        murka.setColor(vaska.getColor());
        System.out.println(murka.getName() + " " + "весит: " + murka.getWeight() + " " + "цвет: " + murka.getColor());
    }
}