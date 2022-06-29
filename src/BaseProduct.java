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

    public BaseProduct(String naam, String merk, int code) {
        this.naam = naam;
        this.merk = merk;
        this.code = code;
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

    public void setInkoopPrijs(double newInkoopPrijs) {
        inkoopPrijs = newInkoopPrijs;
    }

    public void setVerkoopPrijs(double newVerkoopPrijs) {
        verkoopPrijs = newVerkoopPrijs;
    }

    public void setVoorraad(int newVoorraad) {
        voorraad = newVoorraad;
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

    public LaptopProduct(String naam, String merk, int code, double screen_inch, boolean has_fingerprint_reader) {
        super(naam, merk, code);
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

    public PrinterProduct(String naam, String merk, int code, double weightKG, boolean has_display) {
        super(naam, merk, code);
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
        alleProducten.add(new LaptopProduct("Intel9C","Intel", alleProducten.size() + 1, 15, true));
        alleProducten.get(alleProducten.size() - 1).setInkoopPrijs(300);
        alleProducten.get(alleProducten.size() - 1).setVerkoopPrijs(450);
        alleProducten.get(alleProducten.size() - 1).setVoorraad(3);

        alleProducten.add(new PrinterProduct("Colorer10","COLOR", alleProducten.size() + 1, 8, true));
        alleProducten.get(alleProducten.size() - 1).setInkoopPrijs(100);
        alleProducten.get(alleProducten.size() - 1).setVerkoopPrijs(250);
        alleProducten.get(alleProducten.size() - 1).setVoorraad(5);

        alleProducten.add(new BaseProduct("Intel5D","Intel", alleProducten.size() + 1));
        alleProducten.get(alleProducten.size() - 1).setInkoopPrijs(500);
        alleProducten.get(alleProducten.size() - 1).setVerkoopPrijs(600);
        alleProducten.get(alleProducten.size() - 1).setVoorraad(1);

        alleProducten.add(new BaseProduct("DELLG2","DELL", alleProducten.size() + 1));
        alleProducten.get(alleProducten.size() - 1).setInkoopPrijs(580);
        alleProducten.get(alleProducten.size() - 1).setVerkoopPrijs(680);
        alleProducten.get(alleProducten.size() - 1).setVoorraad(3);
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
        return addProduct(productNaamSelected, productMerkSelected, inkoopPrijsSelected, verkoopPrijsSelected, voorraadProduct, productType);
    }

    public BaseProduct addProduct(String naam, String merk, double inkoopPrijs, double verkoopPrijs, int voorraad, String productType) {
        Scanner scanner = new Scanner(System.in);

        int code = alleProducten.size() + 1;
        int productPos = alleProducten.size();
        if (productType.equals("Laptop")) {
            System.out.println("Geef hoeveel inches het scherm van de laptop is:");
            double screenInches = scanner.nextDouble();
            System.out.println("Geef of de laptop een fingerprint reader heeft: (true/false)");
            boolean hasFingerprintReader = scanner.nextBoolean();
            LaptopProduct laptopProduct = new LaptopProduct(naam, merk, code, screenInches, hasFingerprintReader);
            laptopProduct.setInkoopPrijs(inkoopPrijs);
            laptopProduct.setVerkoopPrijs(verkoopPrijs);
            laptopProduct.setVoorraad(voorraad);
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
            PrinterProduct printerProduct = new PrinterProduct(naam, merk, code, weightKG, hasDisplay);
            printerProduct.setInkoopPrijs(inkoopPrijs);
            printerProduct.setVerkoopPrijs(verkoopPrijs);
            printerProduct.setVoorraad(voorraad);
            ProductAdditionBuilder applyBuilder = new ApplyBuilder();
            alleProducten.add(printerProduct);
            applyBuilder.setupDevice(alleProducten, productPos);
            return printerProduct;
        }
        BaseProduct product = new BaseProduct(naam, merk, code);
        product.setInkoopPrijs(inkoopPrijs);
        product.setVerkoopPrijs(verkoopPrijs);
        product.setVoorraad(voorraad);
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