package imt.coo.beatthemall;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import imt.coo.beatthemall.Combat.Combat;
import imt.coo.beatthemall.Perso.Perso.Ennemi.Ennemi;
import imt.coo.beatthemall.Perso.Perso.Ennemi.Brigand.BrigandEnnemi;
import imt.coo.beatthemall.Perso.Perso.Hero.Hero;
import imt.coo.beatthemall.Perso.Perso.Hero.Warrior.WarriorHero;

class CombatTest {
    private Hero hero;
    private Ennemi ennemi;

    @BeforeEach
    void setUp() {
        // Initialisation des personnages
        hero = new WarriorHero();
        ennemi = new BrigandEnnemi();
    }

    @Test
    void testApplicationBonus() {
        // Ajout d'un bonus
        hero.useBonus("Bonus de soin"); 
        hero.useBonus("Bonus d'attaque");  
        
        // Vérifiez les statistiques après application
        assertEquals(135, hero.getAtt(), "Le bonus d'attaque n'est pas correctement appliqué.");
        assertEquals(100, hero.getPv(), "Le bonus de PV n'est pas correctement appliqué.");
    }

    @Test
    void testAttaqueQuiTue() {
        // Simuler une attaque qui tue l'ennemi
        int degats = 60; // Dégâts suffisants pour tuer
        ennemi.takeDamage(degats);

        // Vérifiez que l'ennemi est mort
        assertFalse(ennemi.isAlive(), "L'ennemi aurait dû être mort.");
    }

    @Test
    void testAttaqueQuiNeTuePas() {
        // Simuler une attaque qui ne tue pas l'ennemi
        int degats = 30; // Dégâts insuffisants pour tuer
        ennemi.takeDamage(degats);

        // Vérifiez que l'ennemi est toujours vivant
        assertTrue(ennemi.isAlive(), "L'ennemi aurait dû être encore vivant.");
        assertEquals(30, ennemi.getPv(), "Les PV de l'ennemi ne sont pas correctement réduits.");
    }

    @Test
    void testCombat() {
        // Simuler un combat entre le héros et l'ennemi
        Combat combat = new Combat(hero, ennemi);
        combat.lancerCombat(); // Le test de la fonction combat est impossible car il nécessite des actions de l'utilisateur

        // Vérifiez que l'un des deux est mort
        boolean unMort = !hero.isAlive() || !ennemi.isAlive();
        assertTrue(unMort, "Un des deux personnages aurait dû mourir.");
    }

    @Test
    void testHeroMeurtDansCombat() {
        // Modifiez les statistiques pour forcer la mort du héros
        hero.setPv(10); // Le héros est faible
        ennemi.setAtt(15); // L'ennemi a une attaque élevée

        // Simuler un combat
        Combat combat = new Combat(hero, ennemi);
        combat.lancerCombat(); // Le test de la fonction combat est impossible car il nécessite des actions de l'utilisateur

        // Vérifiez que le héros est mort
        assertFalse(hero.isAlive(), "Le héros aurait dû mourir.");
    }
}
