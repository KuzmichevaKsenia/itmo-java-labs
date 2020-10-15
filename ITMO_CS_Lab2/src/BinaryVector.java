import java.util.Arrays;
import java.util.Scanner;

public class BinaryVector {
    int n;
    int s;
    int[] w;
    int[] x;

    private int[] tr;  // отсортированный по возрастанию w[]
    private int[] X;   // удовлетворяющие условию значения tr[] по соответствующим индексам
    private int index; // каретка

    BinaryVector() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n -> ");
        n = in.nextInt();
        w = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Enter w" + (i + 1) + " -> ");
            w[i] = in.nextInt();
        }
        System.out.print("Enter s -> ");
        s = in.nextInt();

        X = new int[n];
        x = new int[n];

        tr = Arrays.copyOf(w, n);
        Arrays.sort(tr);
    }

    int search() {
        return searchSummand(n - 1, s);
    }

    private void printX() { // получение вектора х из Х и его печать
        for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (X[j] == w[i]) {
                        x[i] = 1;
                        X[j] = 0;
                        break;
                    }
                }
        }
        System.out.println(Arrays.toString(x));
    }

    private void highestIndex(int i, int sum) { // переводит каретку для tr[] на максимальный элемент в пределах sum
        index = -1;                            // или на -1, если такого элемента нет
        for (; i >= 0; --i) {
            if (tr[i] <= sum) {
                index = i;
                break;
            }
        }
    }

    private int searchSummand(int i, int sum) {
        highestIndex(i, sum);

        if (index == -1) { // если нужный элемент highestIndex не был найден, обнуляем наименьший значащий элемент
            do {          // первичного вектора Х и возвращаем его значение в sum, смещаемся по индексу влево
                for (int j = 0; j < n; ++j) {
                    if (X[j] > 0) {
                        sum += X[j];
                        X[j] = 0;
                        if (j != 0) {
                            return searchSummand(j - 1, sum);
                        } else continue;
                    }
                } // если все элементы Х нулевые, решения нет
                System.out.println("Binary vector doesn't exist");
                return 0;
            } while (true);
        }

        X[index] = tr[index];
        if (tr[index] == sum) { // если найденный элемент равен необходимому остатку от искомой суммы,
            printX();          // то решение найдено
            return 0;
        } // иначе сдвигаем каретку и продолжаем поиск остатка
        return searchSummand(index - 1, sum - tr[index]);
    }

    public static void main(String[] args) {
        BinaryVector X = new BinaryVector();
        X.search();
    }
}