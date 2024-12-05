package Perso.Hero;

import java.util.logging.Logger;
import Perso.Perso;

/**
 * Classe abstraite représentant un héros dans le jeu.
 */
public abstract class Hero extends Perso{

    private static final Logger logger = Logger.getLogger(Hero.class.getName());

    protected boolean isPlayable; // Attribut pour savoir si c'est un héros jouable
    protected boolean ulti;

    /**
     * Constructeur pour initialiser un héros.
     *
     * @param name nom du héros
     * @param pv   points de vie du héros
     * @param att  points d'attaque du héros
     * @param def  points de défense du héros
     * @param spe  points de spécialité du héros
     */
    public Hero(String name, int pv, int att, int def, int spe) {
        super(name, pv, att, def, spe);
        this.isPlayable = true;
        this.ulti = true;
        logger.info("Héro initialisé avec succès.");
    }

    /**
     * Vérifie si le héros est jouable.
     *
     * @return true si le héros est jouable, false sinon.
     */
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

    public abstract void useUltimate();

    /**
     * Applique un bonus au héros.
     *
     * @param bonus
     */
    public void useBonus(String bonus){
        if (bonus == "Bonus de soin") {
            this.att = this.pv + 25;
            logger.info("Bonus de soin attribué");
        }if (bonus == "Bonus d'attaque") {
            this.att = this.att + 10;
            logger.info("Bonus de d'attaque attribué");
        }
    }
}
