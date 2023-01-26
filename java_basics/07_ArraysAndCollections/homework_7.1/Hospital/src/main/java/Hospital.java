import java.util.Random;

public class Hospital {

    public static final int PATIENTS_COUNT = 30;
    public static final float MIN_TEMP = 32;
    public static final float MAX_TEMP = 40;
    public static final double MIN_TEMP_HEALTH = 36.2f;
    public static final double MAX_TEMP_HEALTH = 36.9f;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] patientTemperature = new float[patientsCount];

        for (int i = 0; i < patientTemperature.length; i++){
            float randomTemperature = nextFloat();
            patientTemperature[i] = randomTemperature;
        }
        return patientTemperature;
    }

    private static float nextFloat() {
        Random random = new Random();
        return random.nextFloat() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        float[] temperature = new float[temperatureData.length];
        String[] tempPatients = new String[PATIENTS_COUNT];
        float temp;
        float average = 0;
        float midTemp = 0;
        int healthQuality = 0;

        for (int i = 0; i < temperature.length; i++){
            temperature[i] = temperatureData[i];
            tempPatients[i] = Float.toString(temperatureData[i]);
            midTemp += temperature[i];
            temp = midTemp / temperature.length;
            average = Math.round(temp * 100)/100f;
            if (temperature[i] >= MIN_TEMP_HEALTH && temperature[i] <= MAX_TEMP_HEALTH){
                healthQuality ++;
            }
        }

        String report =
                "Температуры пациентов: "  + String.join(" ", tempPatients) +
                        "\nСредняя температура: " + average +
                        "\nКоличество здоровых: " + healthQuality ;

        return report;
    }
}
