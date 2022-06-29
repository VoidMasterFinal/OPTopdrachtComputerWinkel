import java.util.ArrayList;
import java.util.Scanner;

public class FinancieelWeekInformatie {
    private int currentWeek;
    private double verdiend;
    private double uitgegeven;

    public FinancieelWeekInformatie(int currentWeek, double verdiend, double uitgegeven) {
        this.currentWeek = currentWeek;
        this.verdiend = verdiend;
        this.uitgegeven = uitgegeven;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }

    public double getVerdiend() {
        return verdiend;
    }

    public  double getUitgegeven() {
        return uitgegeven;
    }
}

class FinancieelOverzichtManager {

    private ArrayList<FinancieelWeekInformatie> financieleGegevens = new ArrayList<>();

    public void bootstrap() {
        toevoegenFinancieleGegevens(1, 1000, 600);
        toevoegenFinancieleGegevens(2, 1200, 800);
        toevoegenFinancieleGegevens(3, 1600, 850);
        toevoegenFinancieleGegevens(4, 2200, 2000);
    }

    public void opstellenFinancieelOverzicht() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Van welke week wilt u de financiële informatie bekijken?");
        System.out.print("Week: ");
        int week = scanner.nextInt();
        System.out.print("Geef het aantal weken terug vanaf de gegeven week dat u wilt zien: ");
        int aantalWeken = scanner.nextInt();
        printOverzicht(week, aantalWeken);
    }

    public double getWinstByWeek(int week) {
        return financieleGegevens.get(week).getVerdiend() - financieleGegevens.get(week).getUitgegeven();
    }

    public void printOverzicht(int currentWeek, int aantalWekenTerug) {
        int thisweek;
        for (int i = 0; i <= aantalWekenTerug; i++) {
            thisweek = currentWeek - aantalWekenTerug + i;
            System.out.println("\nWeek " + thisweek + ": ");
            try {
                for (int j = 0; j < financieleGegevens.size(); j++) {
                    if (financieleGegevens.get(j).getCurrentWeek() == thisweek) {
                        System.out.println("Verdiend: " + financieleGegevens.get(j).getVerdiend() + " euro" +
                                            "\nUitgegeven: " + financieleGegevens.get(j).getUitgegeven() + " euro" +
                                            "\nWinst: " + (financieleGegevens.get(j).getVerdiend() - financieleGegevens.get(j).getUitgegeven()) + " euro");
                        try {
                            System.out.println("Winstverschil t.o.v. vorige week: " + ((financieleGegevens.get(j).getVerdiend() - financieleGegevens.get(j).getUitgegeven()) - (financieleGegevens.get(j - 1).getVerdiend() - financieleGegevens.get(j - 1).getUitgegeven())) + " euro");
                        }
                        catch (Exception e) {
                            System.out.println("Kon bepaalde gegevens van week " + thisweek + " niet ophalen");
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Er zijn van week " + thisweek + " geen gegevens bekend.");
            }
            System.out.println();
        }
    }

    public void toevoegenFinancieleGegevens(int week, double verdiend, double uitgaven) {
        if (financieleGegevens.add(new FinancieelWeekInformatie(week, verdiend, uitgaven))) {
            System.out.println("Gegevens succesvol toegevoegd");
        } else {
            System.out.println("Gegevens niet toegevoegd, kon gegevens niet aan de ArrayList toevoegen");
        }
    }

    public void ophalenGegevens() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geef de week: ");
        int week = scanner.nextInt();
        System.out.print("Geef het verdiende bedrag: ");
        double verdiend = scanner.nextDouble();
        System.out.print("Geef het uitgegeven bedrag: ");
        double uitgegeven = scanner.nextDouble();
        toevoegenFinancieleGegevens(week, verdiend, uitgegeven);
    }
}