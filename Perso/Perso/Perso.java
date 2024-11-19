package Perso;

public abstract class Perso {
    protected String name;
    protected int pv;  // Points de vie
    protected int att; // Points d'attaque
    protected int def; // Points de défense

    public Perso(String name, int pv, int att, int def) {
        this.name = name;
        this.pv = pv;
        this.att = att;
        this.def = def;
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

    // Méthodes supplémentaires
    public void takeDamage(int damage) {
        int actualDamage = Math.max(damage - def, 0); // Réduction par la défense
        setPv(pv - actualDamage); // Met à jour les PV
    }

    public boolean isAlive() {
        return pv > 0;
    }

    @Override
    public String toString() {
        return name + " - PV: " + pv + ", ATT: " + att + ", DEF: " + def;
    }
}
