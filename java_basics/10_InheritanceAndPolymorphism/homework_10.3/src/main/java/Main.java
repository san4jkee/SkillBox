public class Main {
    public static void main(String[] args) {
        LegalPerson client = new LegalPerson();

        client.put(2000.0);
        client.take(2001.0);

        System.out.println(client.money);
    }
}
