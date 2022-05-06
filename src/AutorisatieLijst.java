/*import java.util.ArrayList;

public class AutorisatieLijst {
    private static ArrayList<AutorisatieLijst> medewerkerGegevens = new ArrayList<>(2);
    private int medewerkersCode;
    private String voornaam;
    private String achternaam;
    private String password;
    private String bedrijfsRol;

    public AutorisatieLijst(int medewerkersCode, String voornaam, String achternaam, String password, String bedrijfsRol) {
        this.medewerkersCode = medewerkersCode;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.password = password;
        this.bedrijfsRol = bedrijfsRol;
        addToAutorisatieLijst(0, "nullspace", "nullspace", "0","nullspace");
        addToAutorisatieLijst(1,"Jan","Kabel","123", "eigenaar");
        AutorisatieLijst nieuw = new AutorisatieLijst(2,"nullspace","nullspace","nullspace","nullspace");
        medewerkerGegevens.add(nieuw);
    }

    public void addToAutorisatieLijst(int code, String voornaam1, String achternaam1, String password1, String bedrijfsRol) {
        AutorisatieLijst nieuw = new AutorisatieLijst(code,voornaam1,achternaam1,password1,bedrijfsRol);
        medewerkerGegevens.add(nieuw);
    }

    public static ArrayList getMedewerkerGegevens() {
        return medewerkerGegevens;
    }
}
*/