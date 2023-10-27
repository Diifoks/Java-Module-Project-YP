import java.util.Scanner;

public class Calculater {
    public static float calcPrice(float totalPrice) {
        Scanner scanner = new Scanner(System.in);
        boolean checkPrice = true;
        System.out.print("Введите цену товара: ");
        float price = 0;
        //цикл для проверки правильности ввода цены
        while (checkPrice) {
            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
                if (price >= 0) {
                    checkPrice = false;
                } else {
                    System.out.print("Пожалуйста, введите положительное число: ");
                }
            } else {
                System.out.print("Пожалуйста, введите положительное число: ");
                scanner.next();
            }
        }
        totalPrice += price;
        return totalPrice;
    }

    public static String calcName(String totalName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя товара: ");
        String nameProduct = scanner.nextLine();
        totalName += nameProduct + " ";
        return totalName;
    }

    public static float countProduct() {
        Scanner scanner = new Scanner(System.in);
        float totalPrice = 0;
        String totalName = "";
        //Переменная для цикла
        boolean whileCheck = true;
        //Текстовые переменные для проверки ответа пользователя
        String answer;
        String answerTrue = "Завершить";
        //Цикл который заполнит список всех товаров и суммирует их цену.
        while (whileCheck) {
            totalName = calcName(totalName);
            totalPrice = calcPrice(totalPrice);
            System.out.println("Желайте Завершить? ");
            answer = scanner.nextLine();
            //Проверка ответа на ригистр
            if (answer.equalsIgnoreCase(answerTrue)) {
                whileCheck = false;
            } else {
                whileCheck = true;
            }
        }
        //Вывод списка продуктов
        System.out.println("Список продуктов: " + totalName);
        //Вывод общей цены
        System.out.printf("Цена за все продукты: " + "%.2f %s \n", totalPrice, determiningEnd(totalPrice));

        return totalPrice;
    }

    public static String determiningEnd(float totalPrices) {
        float namberLast = totalPrices % 10;
        String rub;
        //Условие для вывода правильного окончания у цены
        if (namberLast == 1) {
            rub = "рубль";
        } else if (namberLast >= 2 && namberLast <= 4) {
            rub = "рубля";
        } else {
            rub = "рублей";
        }
        return rub;
    }
}
