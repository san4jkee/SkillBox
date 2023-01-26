import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        List<String> arrayList = Arrays.asList(strings);
        Collections.reverse(arrayList);
        return arrayList.toArray(strings);
    }

}
