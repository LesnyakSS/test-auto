import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        float amount2=0; // переменная для подсчета значений
        float amountDeposit = 0; // итоговая сумма
        int numberOfMonths = 0;  // кол-во месяцев
        float percent = 1.07f; // Ставка

        Scanner scanner = new Scanner(System.in);

        // Сумма вклада, проверка на 0 и меньше нуля
        while (true) {
            System.out.print("Введите сумму вклада : ");
            amountDeposit = scanner.nextFloat();
            if (amountDeposit > 0) {
                break; // Выход из цикла, если сумма корректна
            } else {
                System.out.println("Не вверные данные для подсчета. Попробуйте еще раз.");
            }
        }

        // Ввод количества месяцев, проверка на 0 и меньше нуля
        while (true) {
            System.out.print("Введите количество месяцев: ");
            numberOfMonths = scanner.nextInt();
            if (numberOfMonths > 0) {
                break; // Выход из цикла, если количество месяцев корректно указано для подсчета
            } else {
                System.out.println("Не вверные данные для подсчета. Попробуйте еще раз. ");
            }
        }

        // Вычисление конечной суммы вклада с учетом процентов
        for (int i = 0; i < numberOfMonths; i++) {
            amount2 = amountDeposit * percent; // Начисление процентов, сделал умножение на 1.07(7 проц), дабы не брать проц от числа и суммировать
            amountDeposit = amount2;
        }

        System.out.printf("Через %d месяцев: итоговая сумма вклада %.3f%n", numberOfMonths, amountDeposit);
        scanner.close();
    }
}
