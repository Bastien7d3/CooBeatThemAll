package Perso.Ennemi;

import Perso.Perso;

public abstract class Ennemi extends Perso {
    protected boolean isBoss; // Pour savoir si c'est un boss

    public Ennemi(String name, int pv, int att, int def, boolean isBoss) {
        super(name, pv, att, def);
        this.isBoss = isBoss;
    }

    public String GetNom(){
        return this.name;
    }

    public boolean isBoss() {
        return isBoss;
    }
}