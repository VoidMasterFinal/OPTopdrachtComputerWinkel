import java.util.ArrayList;
import java.util.Scanner;

public class InformatieOverzicht {
    private ArrayList<String> gegevensVoorOverzicht = new ArrayList<>();

    public void ophalenGegevens() {
        Scanner scanner = new Scanner(System.in);
        String doorgaan = "";
        String soortGegeven;
        System.out.println("Wat voor gegevens gaat u geven (in het enkelvoud)?");
        soortGegeven = scanner.nextLine();
        System.out.println("Type ~ om te stoppen.");
        while (!(doorgaan.equals("~"))) {
            System.out.print("Toevoegen gegeven: ");
            doorgaan = scanner.nextLine();
            if (!(doorgaan.equals("~")))
                gegevensVoorOverzicht.add(doorgaan);
        }
        System.out.println();
        printOverzicht(gegevensVoorOverzicht, soortGegeven);
    }

    public void printOverzicht(ArrayList printAllGegevens, String soortGegeven) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < printAllGegevens.size(); i++) {
            System.out.println(soortGegeven + " " + (i + 1) + ": " + printAllGegevens.get(i));
        }
        System.out.println();
    }
}