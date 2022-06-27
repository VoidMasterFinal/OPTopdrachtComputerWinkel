import java.util.ArrayList;
import java.util.Scanner;

interface CollectInfo {
    public String update(ArrayList a);
}

class CollectInformatieVoorOverzicht implements CollectInfo {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String update(ArrayList gegevensVoorOverzicht) {
        String soortGegevens = vraagSoortGegevens();
        vraagMainGegevens(gegevensVoorOverzicht);
        return soortGegevens;
    }

    public String vraagSoortGegevens() {
        System.out.println("Wat voor gegevens gaat u noteren? (in het enkelvoud)");
        return scanner.nextLine();
    }

    public void vraagMainGegevens(ArrayList gegevensVoorOverzicht) {
        String doorgaan = "";
        System.out.println("Type ~ om te stoppen.");
        while (!(doorgaan.equals("~"))) {
            System.out.print("Toevoegen gegeven: ");
            doorgaan = scanner.nextLine();
            if (!(doorgaan.equals("~"))) {
                gegevensVoorOverzicht.add(doorgaan);}
        }
        System.out.println();
    }
}

public class InformatieOverzicht {
    private ArrayList<String> gegevensVoorOverzicht = new ArrayList<>();

    public void setupGegevens() {
        CollectInformatieVoorOverzicht collectInformatieVoorOverzicht = new CollectInformatieVoorOverzicht();
        printOverzicht(gegevensVoorOverzicht, collectInformatieVoorOverzicht.update(gegevensVoorOverzicht));
    }

    public void printOverzicht(ArrayList printAllGegevens, String soortGegeven) {
        for (int i = 0; i < printAllGegevens.size(); i++) {
            System.out.println(soortGegeven + " " + (i + 1) + ": " + printAllGegevens.get(i));
        }
        System.out.println();
    }
}