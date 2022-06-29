import java.util.ArrayList;
import java.util.Scanner;

public class Medewerker {
    private int code;
    private String voornaam;
    private String achternaam;
    private String password;
    private String bedrijfsrol;

    public Medewerker(int code, String voornaam, String achternaam, String password, String bedrijfsrol) {
        this.code = code;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.password = password;
        this.bedrijfsrol = bedrijfsrol;
    }

    public int getCode() {return code;}

    public String getVoornaam() {return voornaam;}

    public String getAchternaam() {return achternaam;}

    public String getPassword() {return password;}

    public String getBedrijfsrol() {return bedrijfsrol;}

    public boolean authenticate(String meegegeven_password) {
        if (password.equals(meegegeven_password)) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.println("Voornaam: " + voornaam +
                "\nAchternaam: " + achternaam +
                "\nMedewerkercode: " + code +
                "\nPassword: " + password +
                "\nBedrijfsrol: " + bedrijfsrol);
    }
}


class MedewerkersPool {
    private ArrayList<Medewerker> medewerkerGegevens = new ArrayList<>();

    public void bootstrap() {
        addMedewerker("Jan", "Kabel", "123", "Eigenaar");
        addMedewerker("Karel", "van der Plank", "321", "Werknemer");
        addMedewerker("Piet", "Stoel", "101", "Administratief Medewerker");
    }

    public void printWithWerknemersCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de werknemercode: ");
        int OpzoekenWerknemerCode = scanner.nextInt() - 1;
        if (medewerkerGegevens.get(OpzoekenWerknemerCode) == null) {
            System.out.println("Deze werknemer staat niet in het systeem");
        }
        Medewerker medewerker = getWerknemerByCode(OpzoekenWerknemerCode);
        medewerker.print();
    }

    public Medewerker getWerknemerByCode(int gegevenWerknemersCode) {
        return medewerkerGegevens.get(gegevenWerknemersCode - 1);
    }

    public void addMedewerker(String voornaam, String achternaam, String password, String bedrijfsrol) {
        int medewerkersCode = medewerkerGegevens.size() + 1;
        medewerkerGegevens.add(new Medewerker(medewerkersCode, voornaam, achternaam, password, bedrijfsrol));
        System.out.println("Medewerker succesvol toegevoegd.\nDe medewerkerscode is: " + medewerkersCode + "\n");
    }

    public void getInformatieToAddMedewerker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de voornaam van de medewerker die u wilt toevoegen:");
        String voornaam = scanner.nextLine();
        System.out.println("Geef de achternaam van de medewerker die u wilt toevoegen:");
        String achternaam = scanner.nextLine();
        System.out.println("Geef het password van de medewerker die u wilt toevoegen:");
        String password = scanner.nextLine();
        System.out.println("Geef de bedrijfsrol van de medewerker die u wilt toevoegen:");
        String bedrijfsrol = scanner.nextLine();
        addMedewerker(voornaam, achternaam, password, bedrijfsrol);
    }

    public void removeMedewerker(int medewerkersCode) {
        try {
            medewerkerGegevens.remove(medewerkersCode - 1);
            System.out.println("Medewerker succesvol verwijderd.");
        }
        catch (Exception E) {
            System.out.println("Een medewerker met die medewerkerscode bestaat niet.");
        }
    }

    public void getInformatieToRemoveMedewerker() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef de medewerkercode van de medewerker die u wilt verwijderen:");
        int medewerkercodeSelected = scanner.nextInt();
        removeMedewerker(medewerkercodeSelected);
    }
}