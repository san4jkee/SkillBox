public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] massive = new char[size][size];

        for (int i = 0; i < massive.length; i++){
            for (int j = 0; j < massive.length; j++){
                if (i == j || i + j == (size - 1)){
                    massive[i][j] = symbol;
                }else {
                    massive[i][j] = ' ';
                }
            }
        }
        return massive;
    }
}
