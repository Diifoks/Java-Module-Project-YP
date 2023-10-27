import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float priceAllPeople;
        int human = 0;
        boolean limitTime = true;
        //Вызовим функцию для коректного ввода данных пользователю
        human = checkHuman(human);
        //Цикл для проверки на количество людей
        while (limitTime) {
            if (human > 1) {
                limitTime = false;
                //Вызываем функцию из класса калькулятор которая считает товары и вернёт их общую цену
                // Общую цену мы делим на количество людей и получаем цену для каждого человека
                priceAllPeople = Calculater.countProduct() / human;
                System.out.printf("Разделённый счёт: " + "%.2f %s \n", priceAllPeople, Calculater.determiningEnd(priceAllPeople));
            } else if (human == 1) {
                System.out.println("Вам не нужен калькулятор ;)");
                break;
            } else if (human < 1) {
                System.out.println("Пожалуйста, введите положительное число (больше нуля)");
                //Вызовим функцию для коректного ввода данных пользователю
                human = checkHuman(human);
            }
        }
    }

    public static int checkHuman (int humanTime){
        Scanner scanner = new Scanner(System.in);
        boolean checkWord = true;
        System.out.print("Введите количество людей: ");
        //Цикл для проверки ввода пользователя
        while (checkWord) {
            if (scanner.hasNextInt()) {
                checkWord = false;
                humanTime = scanner.nextInt();
            } else {
                System.out.println("Пожалуйста, введите положительное число (больше нуля)");;
                scanner.next();
            }
        }
        return humanTime;
    }
}