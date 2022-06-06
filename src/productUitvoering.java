/*import java.util.ArrayList;
import java.util.Scanner;

public class productUitvoering {
    //public ArrayList productMethodes = new ArrayList();
    public int keuze;
    public final int readproduct = 1;
    public final int nieuwproduct = 2;
    public final int verwijderproduct = 3;

    public productUitvoering(int keuze) {
        this.keuze = keuze;
    }


    public void product(int type) {
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

    public void printProduct(ProductManager product_manager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de productcode van het product: ");
        int OpzoekenProduct = scanner.nextInt();

        product_manager.getProductByCode(OpzoekenProduct);
        // Main.getProduct(OpzoekenProduct);
    }
}
*/