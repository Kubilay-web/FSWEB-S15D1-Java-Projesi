import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GroceryListApp {
    private static ArrayList<String> groceryList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter karakterini tüket

            switch (choice) {
                case 0:
                    exitApp();
                    break;
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                default:
                    System.out.println("Geçersiz seçenek, lütfen tekrar deneyin.");
            }

            printSortedGroceryList();
        }
    }

    private static void displayMenu() {
        System.out.println("Yapmak istediğiniz işlemi seçin:");
        System.out.println("0 - Uygulamayı Durdur");
        System.out.println("1 - Eleman Ekle");
        System.out.println("2 - Eleman Çıkar");
    }

    private static void exitApp() {
        System.out.println("Uygulama sonlandırılıyor.");
        scanner.close();
        System.exit(0);
    }

    private static void addItem() {
        System.out.println("Eklemek istediğiniz eleman(lar)ı girin (virgülle ayırarak veya tek bir eleman):");
        String input = scanner.nextLine();
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !groceryList.contains(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
    }

    private static void removeItem() {
        System.out.println("Çıkarmak istediğiniz eleman(lar)ı girin (virgülle ayırarak veya tek bir eleman):");
        String input = scanner.nextLine();
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && groceryList.contains(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
    }

    private static void printSortedGroceryList() {
        Collections.sort(groceryList);

        System.out.println("Alışveriş Listesi:");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    // Elemanın listede olup olmadığını kontrol etmek için metot
    private static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }
}
