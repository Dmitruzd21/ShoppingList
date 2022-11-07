import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> shoppingList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберете номер операции:");
            System.out.println("  1. Добавить");
            System.out.println("  2. Показать");
            System.out.println("  3. Удалить");
            System.out.println("  4. Поиск покупок по ключевым словам");
            String operationStr = scanner.nextLine();
            int operationNumber = Integer.parseInt(operationStr);

            switch (operationNumber) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String productToAdd = scanner.nextLine();
                    shoppingList.add(productToAdd);
                    int listSize = shoppingList.size();
                    System.out.println();
                    System.out.println("Итого в списке покупок: " + listSize);
                    break;
                case 2:
                    System.out.println();
                    showShoppingList(shoppingList);
                    System.out.println();
                    break;
                case 3:
                    showShoppingList(shoppingList);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    System.out.println();
                    String productToRemove = scanner.nextLine();
                    try {
                        int productNumberToRemove = Integer.parseInt(productToRemove);
                        productToRemove = shoppingList.get(productNumberToRemove - 1);
                        shoppingList.remove(productNumberToRemove - 1);
                    } catch (Exception exception) {
                        shoppingList.remove(productToRemove);
                    }
                    System.out.println();
                    System.out.println("Покупка " + productToRemove + " удалена, список покупок:");
                    showShoppingList(shoppingList);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Введите текст для поиска:");
                    String productToFind = scanner.nextLine();
                    String queryLower = productToFind.toLowerCase();
                    System.out.println("Найдено:");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        String itemLower = shoppingList.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + ". " + shoppingList.get(i));
                        }
                    }
                    break;
                default:
                    System.out.println("Данная операция не существует, повторите попытку");
                    break;
            }
        }
    }

    public static void showShoppingList(List<String> list) {
        System.out.println("Список покупок:");
        int listSize2 = list.size();
        for (int i = 0; i < listSize2; i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
