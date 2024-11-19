package Perso.Hero;

import Perso.Perso;

public abstract class Hero extends Perso{
    protected boolean isPlayable; // Attribut pour savoir si c'est un héros jouable

    public Hero(String name, int pv, int att, int def) {
        super(name, pv, att, def);
        this.isPlayable = true;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    // Méthode spéciale pour les héros
    public void heal(int healAmount) {
        setPv(pv + healAmount); // Guérit les PV
    }
}
