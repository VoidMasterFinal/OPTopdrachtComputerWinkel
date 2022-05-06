/*import java.util.ArrayList;
import java.util.Scanner;

public class ProductList {
    public ArrayList alleProducten;
    private String productNaam;
    private int productCode;
    private double inkoopPrijs;
    private double verkoopPrijs;

    public void ProductList(String productNaam, int productCode, double inkoopPrijs, double verkoopPrijs) {
        this.productNaam = productNaam;
        this.productCode = productCode;
        this.inkoopPrijs = inkoopPrijs;
        this.verkoopPrijs = verkoopPrijs;
    }

    public void addProduct(String productNaam, int productCode, double inkoopPrijs, double verkoopPrijs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de naam van het product: ");
        productNaam = scanner.next();
        System.out.print("Geef de productcode: ");
        productCode = scanner.nextInt();
        System.out.print("Geef de inkoopprijs van het product: ");
        inkoopPrijs = scanner.nextDouble();
        System.out.print("Geef de verkoopprijs van het product: ");
        verkoopPrijs = scanner.nextDouble();
        alleProducten.add(productNaam, productCode, inkoopPrijs, verkoopPrijs);
    }

    public void printProducten() {
        for (int i = 0; i < alleProducten.size(); i++) {
            System.out.println(alleProducten.get(i));
        }
    }
}
*/