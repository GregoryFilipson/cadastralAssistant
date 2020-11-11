import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите стоимость земли в вашем регионе за м2!");
        double prise = 0;
        try {
            prise = Double.parseDouble(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Не правильный ввод! Все слудующие расчеты будут не корректны");
        }
        MyFunction function = (width, length, cost) -> cost / (width * length);
        Deal deal = new Deal("Саша", 5.5, 4.2, 550_000);
        Deal deal2 = new Deal("Паша", 6.5, 9.2, 712_000);
        Deal deal3 = new Deal("Дима", 8.5, 2.7, 238_000);

        isDealFair(deal.getName(), prise, function.calculatePrise(deal.getWidth(), deal.getLength(), deal.getCost()));
        isDealFair(deal2.getName(), prise, function.calculatePrise(deal2.getWidth(), deal2.getLength(), deal2.getCost()));
        isDealFair(deal3.getName(), prise, function.calculatePrise(deal3.getWidth(), deal3.getLength(), deal3.getCost()));
    }

    @FunctionalInterface
    public interface MyFunction {
        Double calculatePrise(Double width, Double length, Double cost);
    }

    public static void isDealFair(String name, Double allowedPrise, Double realPrise) {
        if (allowedPrise <= realPrise) {
            System.out.println("Сделка покупателя " + name + " честная! Разрешенная цена за м2 " + allowedPrise +
                    "руб, а фактическая " + realPrise + "руб");
        } else {
            System.out.println("Сделка покупателя " + name + " не честная! Разрешенная цена за м2 " + allowedPrise +
                    "руб, а фактическая " + realPrise + "руб");
        }
    }
}
