import java.util.ArrayList;
import java.util.Scanner;

public class productUitvoering {
    public ArrayList productMethodes = new ArrayList();
    public int keuze;
    public static final int readproduct = 1;
    public static final int nieuwproduct = 2;
    public static final int verwijderproduct = 3;

    public productUitvoering(int keuze) {
        this.keuze = keuze;
    }


    public static void product(int type) {
        if (type == 1) {
            printProduct();
        }
        if (type == 2) {
            addProduct();
        }
        if (type == 3) {
            removeProduct();
        }
    }

    public static void printProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de productcode van het product: ");
        int OpzoekenProduct = scanner.nextInt();
        Product.getProduct(OpzoekenProduct);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de naam van het product dat u wilt toevoegen:");
        String productNaamSelected = scanner.nextLine();
        System.out.println("Geef het merk van het product dat u wilt toevoegen:");
        String productMerkSelected = scanner.nextLine();
        System.out.println("Geef de inkoopprijs van het product dat u wilt toevoegen:");
        Double inkoopPrijsSelected = scanner.nextDouble();
        System.out.println("Geef de verkoopprijs van het product dat u wilt toevoegen:");
        Double verkoopPrijsSelected = scanner.nextDouble();
        System.out.println("Geef de voorraad van het product dat u wilt toevoegen:");
        int voorraadProduct = scanner.nextInt();
        Product.addProduct(productNaamSelected,productMerkSelected,inkoopPrijsSelected,verkoopPrijsSelected,voorraadProduct);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public static void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de productcode van het product dat u wilt verwijderen:");
        int productCodeSelected = scanner.nextInt();
        Product.removeProduct(productCodeSelected);
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }
}
