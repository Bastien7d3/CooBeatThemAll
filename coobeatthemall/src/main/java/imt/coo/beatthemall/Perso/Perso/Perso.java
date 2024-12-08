package imt.coo.beatthemall.Perso.Perso;

/* Classe abstraite qui defini les points commun entre tous les personnages */
public abstract class Perso {
    protected String name;
    protected int pv; // Points de vie
    protected int att; // Points d'attaque
    protected int def; // Points de défense
    protected int vitesse; // Points de Vitesse

    /**
     * Constructeur pour initialiser un Perso.
     *
     * @param name nom du héros
     * @param pv   points de vie du héPersoros
     * @param att  points d'attaque du Perso
     * @param def  points de défense du Perso
     * @param spe  points de spécialité du Perso
     */
    public Perso(String name, int pv, int att, int def, int spe) {
        this.name = name;
        this.pv = pv;
        this.att = att;
        this.def = def;
        this.vitesse = spe;
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = Math.max(0, pv); // Assure que PV ne soit pas négatif
    }

    public int getAtt() {
        return att;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    // Getters et setters
    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    // Méthodes supplémentaires
    public void takeDamage(int damage) {
        setPv(pv - damage);
    }

    public boolean isAlive() {
        return pv > 0;
    }

    /**
     * Affichage console d'un personnage.
     *
     * @return Une chaîne décrivant la case.
     */
    @Override
    public String toString() {
        return name + " - PV: " + pv + ", ATT: " + att + ", DEF: " + def;
    }
}
