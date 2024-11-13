import java.util.ArrayList;
import java.util.List;

public class Jeu {
    public static void main(String[] args) {
        // Cases prédéfinies
        ArrayList<Case> casesPredefinies = new ArrayList<>();
        casesPredefinies.add(new Case(1, "Bonus de soin", new ArrayList<>()));
        casesPredefinies.add(new Case(2, "Bonus d'attaque", new ArrayList<>()));
        casesPredefinies.add(new Case(3, "Pas de bonus", new ArrayList<>(List.of(new Ennemi("Gangster")))));
        casesPredefinies.add(new Case(4, "Pas de bonus", new ArrayList<>(List.of(new Ennemi("Brigand")))));
        casesPredefinies.add(new Case(5, "Pas de bonus", new ArrayList<>(List.of(new Ennemi("Catcheur")))));

        // Création des 3 plateaux
        Plateau plateau10 = new Plateau(1, "Petit plateau (10 cases)", 10);
        Plateau plateau15 = new Plateau(2, "Moyen plateau (15 cases)", 15);
        Plateau plateau20 = new Plateau(3, "Grand plateau (20 cases)", 20);

        // Met les cases aléatoirements sur les plateaux (@TODO: faire en sorte que la première case soit le départ et la dernière l'arrivée)
        plateau10.genererCasesAleatoires(casesPredefinies);
        plateau15.genererCasesAleatoires(casesPredefinies);
        plateau20.genererCasesAleatoires(casesPredefinies);

        // Affichage des plateaux
        System.out.println(plateau10);
        System.out.println(plateau15);
        System.out.println(plateau20);
    }
}