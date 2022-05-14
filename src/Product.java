import java.util.ArrayList;

public class Product {
    private static ArrayList<Product> alleProducten = new ArrayList<>();
    //private ArrayList onderdelen;
    private String productNaam;
    private String productMerk;
    private int productCode;
    private double inkoopPrijs;
    private double verkoopPrijs;
    private int inVoorraad;
    //levertijd

    public Product(String productNaam, String productMerk, int productCode, double inkoopPrijs, double verkoopPrijs, int inVoorraad) {
        this.productNaam = productNaam;
        this.productMerk = productMerk;
        this.productCode = productCode;
        this.inkoopPrijs = inkoopPrijs;
        this.verkoopPrijs = verkoopPrijs;
        this.inVoorraad = inVoorraad;
    }

    public static void addProduct(String productNaam, String productMerk, double inkoopPrijs, double verkoopPrijs, int inVoorraad) {
        int productCode = alleProducten.size() + 1;
        alleProducten.add(new Product(productNaam,productMerk,productCode,inkoopPrijs,verkoopPrijs, inVoorraad));
        System.out.println("Product succesvol toegevoegd.\nDe productcode is: " + productCode);
    }

    public static void removeProduct(int productCode) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getProductCode() == productCode) {
                alleProducten.remove(i);
                System.out.println("Product succesvol verwijderd.");
            }
        }
    }

    public int getProductCode() {return productCode;}

    public static Product getProduct(int productCode) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getProductCode() == productCode) {
                System.out.println("Naam: " + alleProducten.get(i).productNaam + "\nMerk: " + alleProducten.get(i).productMerk + "\nProductcode: " + alleProducten.get(i).productCode + "\nInkoopprijs: " + alleProducten.get(i).inkoopPrijs + " euro\nVerkoopprijs: " + alleProducten.get(i).verkoopPrijs + " euro\nIn voorraad: " + alleProducten.get(i).inVoorraad);
                return alleProducten.get(i);
            }
        }
        System.out.println("Dat product staat niet in het systeem");
        return null;
    }
}
