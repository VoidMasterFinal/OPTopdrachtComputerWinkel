import java.util.ArrayList;
import java.util.Scanner;

public class BaseProduct {
    private String naam;
    private String merk;
    private int code;
    private double inkoopPrijs;
    private double verkoopPrijs;
    private int voorraad;
    private String extraInfo;
    protected String product_type;

    public BaseProduct(String naam, String merk, int code, double inkoopPrijs, double verkoopPrijs, int voorraad) {
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

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void print() {
        System.out.println("Naam: " + naam + "" +
                "\nMerk: " + merk + "" +
                "\nProductcode: " + code +
                "\nType: " + product_type +
                "\nInkoopprijs: " + inkoopPrijs + " euro" +
                "\nVerkoopprijs: " + verkoopPrijs + " euro" +
                "\nIn voorraad: " + voorraad +
                "\nExtra info: " + extraInfo);
    }
}

class LaptopProduct extends BaseProduct {
    private double screen_inch;
    private boolean has_fingerprint_reader;

    public LaptopProduct(String naam, String merk, int code, double inkoopPrijs, double verkoopPrijs, int voorraad, double screen_inch, boolean has_fingerprint_reader) {
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

class PrinterProduct extends BaseProduct {
    private double weightKG;
    private boolean has_display;

    public PrinterProduct(String naam, String merk, int code, double inkoopPrijs, double verkoopPrijs, int voorraad, double weightKG, boolean has_display) {
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

abstract class ProductAdditionBuilder {
    public final void setupDevice(ArrayList<BaseProduct> alleProducten, int code) {
        String firstInfo = addComponents(alleProducten, code);
        addOperatingSystem(alleProducten, code, firstInfo);
    }
    public abstract String addComponents(ArrayList<BaseProduct> alleProducten, int code);
    public abstract void addOperatingSystem(ArrayList<BaseProduct> alleProducten, int code, String firstInfo);
}

class ApplyBuilder extends ProductAdditionBuilder {
    @Override
    public String addComponents(ArrayList<BaseProduct> alleProducten, int code) {
        String extraInfo = "RTX 3080";
        alleProducten.get(code).setExtraInfo(extraInfo);
        return extraInfo;
    }

    @Override
    public void addOperatingSystem(ArrayList<BaseProduct> alleProducten, int code, String extraInfo) {
        extraInfo += "\tWindows 10";
        alleProducten.get(code).setExtraInfo(extraInfo);
    }
}

class ProductManager {
    private ArrayList<BaseProduct> alleProducten = new ArrayList<>();

    public void bootstrap() {
        alleProducten.add(new LaptopProduct("Intel9C","Intel", alleProducten.size() + 1,300,450, 3, 15, true));
        alleProducten.add(new PrinterProduct("Colorer10","COLOR", alleProducten.size() + 1,100,250, 5, 8, true));
        alleProducten.add(new BaseProduct("Intel5D","Intel",500,600,5,1));
        alleProducten.add(new BaseProduct("DELLG2","DELL",580,680,3,1));
    }

    public ArrayList<BaseProduct> getProductList() {
        return alleProducten;
    }

    public BaseProduct informationToAddProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de naam van het product dat u wilt toevoegen:");
        String productNaamSelected = scanner.nextLine();
        System.out.println("Geef het soort product dat u wilt toevoegen:");
        String productType = scanner.nextLine();
        System.out.println("Geef het merk van het product dat u wilt toevoegen:");
        String productMerkSelected = scanner.nextLine();
        System.out.println("Geef de inkoopprijs van het product dat u wilt toevoegen:");
        Double inkoopPrijsSelected = scanner.nextDouble();
        System.out.println("Geef de verkoopprijs van het product dat u wilt toevoegen:");
        Double verkoopPrijsSelected = scanner.nextDouble();
        System.out.println("Geef de voorraad van het product dat u wilt toevoegen:");
        int voorraadProduct = scanner.nextInt();
        return addProduct(productNaamSelected, productMerkSelected, inkoopPrijsSelected, verkoopPrijsSelected, voorraadProduct,"", productType);
    }

    public BaseProduct addProduct(String naam, String merk, double inkoopPrijs, double verkoopPrijs, int voorraad, String extraInfo,String productType) {
        Scanner scanner = new Scanner(System.in);

        int code = alleProducten.size() + 1;
        int productPos = alleProducten.size();
        if (productType.equals("Laptop")) {
            System.out.println("Geef hoeveel inches het scherm van de laptop is:");
            double screenInches = scanner.nextDouble();
            System.out.println("Geef of de laptop een fingerprint reader heeft: (true/false)");
            boolean hasFingerprintReader = scanner.nextBoolean();
            LaptopProduct laptopProduct = new LaptopProduct(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad, screenInches, hasFingerprintReader);
            ProductAdditionBuilder applyBuilder = new ApplyBuilder();
            alleProducten.add(laptopProduct);
            applyBuilder.setupDevice(alleProducten, productPos);
            return laptopProduct;
        }
        if (productType.equals("Printer")) {
            System.out.println("Geef hoeveel de printer weegt in KG:");
            double weightKG = scanner.nextDouble();
            System.out.println("Geef of de printer een display heeft: (true/false)");
            boolean hasDisplay = scanner.nextBoolean();
            LaptopProduct laptopProduct = new LaptopProduct(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad, weightKG, hasDisplay);
            ProductAdditionBuilder applyBuilder = new ApplyBuilder();
            alleProducten.add(laptopProduct);
            applyBuilder.setupDevice(alleProducten, productPos);
            return laptopProduct;
        }
        BaseProduct product = new BaseProduct(naam, merk, code, inkoopPrijs, verkoopPrijs, voorraad);
        ProductAdditionBuilder applyBuilder = new ApplyBuilder();
        alleProducten.add(product);
        applyBuilder.setupDevice(alleProducten, productPos);
        return product;
    }

    public boolean removeProduct(BaseProduct product) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getCode() == product.getCode()) {
                alleProducten.remove(i);
                return true;
            }
        }
        return false;
    }

    public BaseProduct getProductByCode(int productCode) {
        for (int i = 0; i < alleProducten.size(); i++) {
            if (alleProducten.get(i).getCode() == productCode) {
                return alleProducten.get(i);
            }
        }
        return null;
    }
}