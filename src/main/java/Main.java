import java.util.Scanner;

public class Main {
    public static float CalculatePrice (float totalPrice){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цену товара: ");
        float price = scanner.nextFloat();
        while (price <= 0){
            System.out.println("Прошлое чилсо не подходит.");
            System.out.print("Введите новую цену товара: ");
            price = scanner.nextFloat();
        }
        totalPrice += price;
        return totalPrice;
    }

    public static String CalculateName (String totalName){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя товара: ");
        String nameProduct = scanner.nextLine();
        totalName += nameProduct + " ";
        return totalName;
    }
    public static void CountProduct (){
        Scanner scanner = new Scanner(System.in);
        float totalPrice = 0;
        String totalName = "";
        boolean whileCheck = true;
        String answer;
        String answerTrue = "Завершить";
        while (whileCheck) {
            totalName = CalculateName(totalName);
            totalPrice = CalculatePrice(totalPrice);
            System.out.println("Желайте Завершить? ");
            answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(answerTrue)){
                whileCheck = false;
            }else{
                whileCheck = true;
            }
        }
        System.out.println("Список продуктов: " + totalName);
        // Переменные для вывода цены.
        float namberLast = totalPrice % 10;
        String rub;

        if (namberLast == 1) {
            rub = "рубль";
        } else if (namberLast >= 2 && namberLast <= 4) {
            rub = "рубля";
        } else {
            rub = "рублей";
        }
        System.out.printf("Цена за все продукты: " + "%.2f %s \n", totalPrice, rub);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество людей: ");
        int human = scanner.nextInt();
        boolean limitTime = true;
        while (limitTime){
            if (human > 1){
                limitTime = false;
                  for (int humanNambers = 1; humanNambers <= human; humanNambers++){
                      System.out.println("Человек №" + humanNambers );
                      CountProduct();
                  }
            }else if (human == 1) {
                System.out.println("Вам не нужен калькулятор ;)");
                break;
            }else if (human < 1){
                System.out.print("Введите коректное количество людей: ");
                human = scanner.nextInt();
            }
        }
    }
    //    public class Product{
//        String name;
//        float price;
//        Product(String productName,float productPrice){
//            name = productName;
//            price = productPrice;
//        }
//    }
}