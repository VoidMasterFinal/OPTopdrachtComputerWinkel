import java.util.ArrayList;
import java.util.Scanner;

public class Autorisatie {
    private static ArrayList<Autorisatie> medewerkerGegevens = new ArrayList<>();
    private int medewerkersCode;
    private String voornaam;
    private String achternaam;
    private String password;
    private String bedrijfsrol;
    private boolean goedgekeurd = false;

    public Autorisatie(int medewerkersCode, String voornaam, String achternaam, String password, String bedrijfsrol) {
        this.medewerkersCode = medewerkersCode;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.password = password;
        this.bedrijfsrol = bedrijfsrol;
    }

    public static Autorisatie getWerknemer(int medewerkersCode) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < medewerkerGegevens.size(); i++) {
            if (medewerkerGegevens.get(i).medewerkersCode == medewerkersCode) {
                System.out.println("Voornaam: " + medewerkerGegevens.get(i).voornaam + "\nAchternaam: " + medewerkerGegevens.get(i).achternaam + "\nMedewerkercode: " + medewerkerGegevens.get(i).medewerkersCode + "\nPassword: " + medewerkerGegevens.get(i).password + "\nBedrijfsrol: " + medewerkerGegevens.get(i).bedrijfsrol);
                return medewerkerGegevens.get(i);
            }
        }
        System.out.println("Deze werknemer staat niet in het systeem");
        return null;
    }

    public static ArrayList GetMedewerkersList() {
        return medewerkerGegevens;
    }

    public static int getMedewerkerCode(String password) {
        int pos = medewerkerGegevens.indexOf(password);
        return medewerkerGegevens.get(pos).medewerkersCode;
    }

    public static String getPassword(int medewerkersCode) {
        return medewerkerGegevens.get(medewerkerGegevens.indexOf(medewerkersCode)).password;
    }

    public static String getNaam(String password) {
        return medewerkerGegevens.get(medewerkerGegevens.indexOf(password)).voornaam + " " + medewerkerGegevens.get(medewerkerGegevens.indexOf(password)).achternaam;
    }

    public static void addMedewerker(String voornaam, String achternaam, String password, String bedrijfsrol) {
        int medewerkersCode = medewerkerGegevens.size() + 1;
        medewerkerGegevens.add(new Autorisatie(medewerkersCode, voornaam, achternaam, password, bedrijfsrol));
        System.out.println("Medewerker succesvol toegevoegd.\nDe medewerkerscode is: " + medewerkersCode + "\n");
    }

    public static void removeMedewerker(int posToRemove) {
        try {
            medewerkerGegevens.remove(posToRemove - 1);
            System.out.println("Medewerker succesvol verwijderd.");
        }
        catch (Exception E) {
            System.out.println("Een medewerker met die medewerkerscode bestaat niet.");
        }
    }


    public static boolean startAutorisatie() {
        Scanner scanner = new Scanner(System.in);
        int gegevenAntwoordCode = -1;
        String gegevenAntwoordPassoword;
        int pos = -1;
        for (int x = 1; x <= 3; x++) {
            System.out.print("Poging " + x + "/3,\nGeef uw medewerkercode: ");
            gegevenAntwoordCode = scanner.nextInt();
            for (int y = 0; y < medewerkerGegevens.size(); y++) {
                if (medewerkerGegevens.get(y).medewerkersCode == gegevenAntwoordCode) {
                    pos = medewerkerGegevens.get(y).medewerkersCode - 1;
                }
            }
            if (pos >= 0) {
                System.out.print("Geef uw password: ");
                scanner.nextLine();
                gegevenAntwoordPassoword = scanner.nextLine();
                if (medewerkerGegevens.get(pos).password.equals(gegevenAntwoordPassoword)) {
                    System.out.println("\nWelkom " + medewerkerGegevens.get(pos).voornaam + " " + medewerkerGegevens.get(pos).achternaam + "!\n");
                    return true;
                }
            }
            System.out.println("Gebruikerscode of password is niet correct");
        }
        return false;
    }

    public static boolean inloggen(boolean inlogCodeGelukt, boolean passwordGelukt) {
        if (inlogCodeGelukt == true && passwordGelukt == true) {
            return true;
        }
        return false;
    }

}