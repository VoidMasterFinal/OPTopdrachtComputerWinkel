import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String naam;
    private String merk;
    private int code;
    private double inkoopPrijs;
    private double verkoopPrijs;
    private int voorraad;
    protected String product_type;
    //TODO: Levertijd, onderdelen

    public Product(String naam, String merk, int code, double inkoopPrijs, double verkoopPrijs, int voorraad) {
        this.naam = naam;
        this.merk = merk;
        this.code = code;
        this.inkoopPrijs = inkoopPrijs;
        this.verkoopPrijs = verkoopPrijs;
        this.voorraad = voorraad;
        this.product_type = "Algemeen";
    }

    public int getCode() {
        return code;
    }

    public int getVoorraad() {
        return voorraad;
    }

    public String getNaam() {
        return naam;
    }

    public String getMerk() {
        return merk;
    }

    public double getInkoopPrijs() {
        return inkoopPrijs;
    }

    public double getVerkoopPrijs() {
        return verkoopPrijs;
    }

    public void print() {
        System.out.println("Naam: " + naam + "" +
                            "\nMerk: " + merk + "" +
                            "\nProductcode: " + code +
                            "\nType: " + product_type +
                            "\nInkoopprijs: " + inkoopPrijs + " euro" +
                            "\nVerkoopprijs: " + verkoopPrijs + " euro" +
                            "\nIn voorraad: " + voorraad);
    }
}


/*
    public double getPrijs(double verkoopPrijs, int leeftijd) {
        if (leeftijd >= 10 && leeftijd <= 15)
            return this.verkoopPrijs * 0.8;
        if (leeftijd >= 18 && leeftijd <= 24)
            return this.verkoopPrijs * 0.75;
        if (leeftijd >= 65)
            return this.verkoopPrijs * 0.85;
        else
            return this.verkoopPrijs;
    }

    public double getTotaalPrijs(int soortProduct, int leeftijd, boolean medewerker, boolean kortingscode) {
        double totaalprijs;
        double totaleKorting = 0;
        if (soortProduct == 1)
            totaalprijs = 600;
        else
            totaalprijs = 680;
        if (leeftijd >= 18 && leeftijd <= 24)
            totaleKorting += 0.25;
        if (leeftijd >= 65)
            totaleKorting += 0.15;
        if (medewerker == true)
            totaleKorting += 0.05;
        if (kortingscode == true)
            totaleKorting += 0.15;
        return totaalprijs * (1 - totaleKorting);
    }
*/

class LaptopProduct extends Product {
    private float screen_inch;
    private boolean has_fingerprint_reader;

    public LaptopProduct(String naam, String merk, int code, double inkoopPrijs, double verkoopPrijs, int voorraad, float screen_inch, boolean has_fingerprint_reader) {
        super(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad);
        this.screen_inch = screen_inch;
        this.has_fingerprint_reader = has_fingerprint_reader;
        this.product_type = "Laptop";
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Screen Inch: " + screen_inch +
                            "\nHas Fingerprint Reader: " + has_fingerprint_reader);
    }
}

class PrinterProduct extends Product {
    private float weightKG;
    private boolean has_display;

    public PrinterProduct(String naam, String merk, int code, double inkoopPrijs, double verkoopPrijs, int voorraad, float weightKG, boolean has_display) {
        super(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad);
        this.weightKG = weightKG;
        this.has_display = has_display;
        this.product_type = "Printer";
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Weight in KG: " + weightKG +
                "\nHas a display: " + has_display);
    }
}

class ProductManager {
    private ArrayList<Product> alleProducten = new ArrayList<>();

    public void bootstrap() {
        alleProducten.add(new LaptopProduct("Intel9C","Intel", alleProducten.size() + 1,300,450, 3, 15, true));
        alleProducten.add(new PrinterProduct("Colorer10","COLOR", alleProducten.size() + 1,100,250, 5, 8, true));
        addProductSilent("Intel5D","Intel",500,600,5);
        addProductSilent("DELLG2","DELL",580,680,3);
    }

    public ArrayList<Product> getProductList() {
        return alleProducten;
    }

    public void informationToAddProduct() {
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
        addProduct(productNaamSelected,productMerkSelected,inkoopPrijsSelected,verkoopPrijsSelected,voorraadProduct);
    }

    public void addProductSilent(String naam, String merk, double inkoopPrijs, double verkoopPrijs, int voorraad) {
        int code = alleProducten.size() + 1;
        alleProducten.add(new Product(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad));
    }


    public void addProduct(String naam, String merk, double inkoopPrijs, double verkoopPrijs, int voorraad) {
        int code = alleProducten.size() + 1;
        if (alleProducten.add(new Product(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad))) {
            System.out.println("Product succesvol toegevoegd.\nDe productcode is: " + code);
        }
        else {
            System.out.println("Product niet toegevoegd, kon product niet toevoegen aan ArrayList");
        }
    }
/*
    public void addProduct(Product product) {
        product.set_code(alleProducten.size() + 1);
        alleProducten.add(product);
    }
*/
    public boolean removeProduct(Product product) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getCode() == product.getCode()) {
                alleProducten.remove(i);
                return true;
            }
        }
        return false;
    }
/*
    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de productcode van het product dat u wilt verwijderen:");
        int productCodeSelected = scanner.nextInt();
        if (Main.removeProduct(productCodeSelected))
            System.out.println("Product " + product.getNaam() + " (" + product.getMerk() + ") succesvol verwijderd.");
        else
            System.out.println("Product niet verwijderd; Geen product gevonden.");
        scanner.nextLine();
        System.out.println("Druk enter als u terug wilt naar het menu.");
        scanner.nextLine();
    }

    public void removeProduct(int productCode) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getCode() == productCode) {
                alleProducten.remove(i);
                System.out.println("Product " +  + "succesvol verwijderd.");
                return;
            }
        }
    }
*/
    public Product getProductByCode(int productCode) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getCode() == productCode) {
                //alleProducten.get(i).print();
                //print(alleProducten.get(i));
                return alleProducten.get(i);
            }
        }
        return null;
    }
}