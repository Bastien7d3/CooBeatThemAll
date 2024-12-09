# **CooBeatThemAll**

CooBeatThemAll est un jeu de combat textuel en Java, dans lequel un héros progresse sur un plateau, rencontre des ennemis et doit les vaincre pour atteindre la ligne d'arrivée. Le projet met en œuvre une architecture orientée objet, exploitant des concepts tels que l'héritage, les interfaces et le polymorphisme.

## **Description**

Dans ce jeu, le joueur incarne un héros et choisit une carte pour commencer une aventure. Le héros peut affronter divers types d'ennemis (brigands, gangsters, boss, etc.) et utiliser des compétences spéciales pour les vaincre. Les ennemis attaquent de différentes manières, et le héros doit survivre jusqu'à la fin de la carte pour gagner.

---

## **Fonctionnalités principales**

1. **Système de combat :**
   - Les combats suivent un système de tours où le héros attaque en premier.
   - Les héros peuvent attaquer plusieurs fois par tour (entre 1 et 5 fois de manière aléatoire).
   - Les ennemis attaquent une fois par tour.
   - Chaque personnage possède des statistiques de base : Points de vie (PV), Attaque (Att), Défense (Def), et Vitesse (Vit).

2. **Capacités spéciales :**
   - Chaque héros dispose d'une compétence spéciale unique, utilisable une fois par niveau (exemple : se soigner, attaquer en zone, esquiver).

3. **Progression sur un plateau :**
   - Le héros avance sur un plateau composé de cases.
   - Chaque case peut contenir un combat, un événement, ou être vide.

4. **Gestion des logs :**
   - Les actions importantes (mouvements, combats, utilisation des capacités, etc.) sont tracées dans des fichiers de log pour faciliter le suivi des parties.

5. **Personnalisation des cartes et des personnages :**
   - Les cartes ont un nom, une longueur et une série d’événements aléatoires.
   - Les héros et ennemis ont des classes spécifiques avec des compétences et des statistiques uniques.

---

## **Structure du projet**

Voici l’arborescence des fichiers :

```
CooBeatThemAll/
├── Carte/
│   ├── Case.java            # Représente une case du plateau
│   └── Plateau.java         # Gère l'ensemble des cases
├── Jeu/
│   └── Jeu.java             # Logique principale du jeu
├── Perso/
│   ├── Perso.java           # Classe abstraite pour les personnages
│   ├── Hero/
│   │   ├── Hero.java        # Classe abstraite pour les héros
│   │   ├── MageHero.java    # Classe pour un héros de type Mage
│   │   └── WarriorHero.java # Classe pour un héros de type Guerrier
│   ├── Ennemi/
│   │   ├── Ennemi.java      # Classe abstraite pour les ennemis
│   │   ├── BossEnnemi.java  # Classe pour un ennemi de type Boss
│   │   └── BrigandEnnemi.java # Classe pour un ennemi de type Brigand
├── Combat/
│   └── Combat.java          # Gestion des combats entre personnages
├── Main.java                # Point d’entrée principal
├── resources/               # Contient les fichiers de configuration et les logs
│   └── logging.properties   # Configuration des logs
├── test/
│   ├── CombatTest.java      # Tests unitaires JUnit
├── pom.xml                  # Configuration Maven
└── README.md                # Ce fichier
```

### **Classes principaux :**

1. **Carte :**
   - Gère le plateau de jeu et les cases où se déroulent les événements.
2. **Jeu :**
   - Point central du déroulement de la partie.
3. **Perso :**
   - Contient tous les personnages du jeu, séparés en héros et ennemis.
4. **Combat :**
   - Logique des combats entre héros et ennemis.
5. **Tests :**
   - Fichier contenant des tests unitaires pour vérifier les fonctionnalités clés du projet.

---

## **Installation et exécution**

### **Pré-requis :**
- Java 17 ou une version plus récente.
- Maven pour gérer les dépendances et compiler le projet.

### **Étapes :**

1. **Cloner le projet :**
   ```bash
   git clone https://github.com/votre-utilisateur/CooBeatThemAll.git
   ```
2. **Naviguer dans le dossier :**
   ```bash
   cd CooBeatThemAll
   ```
3. **Compiler le projet avec Maven :**
   ```bash
   mvn clean install
   ```
4. **Lancer le jeu :**
   - Exécutez la classe `Main.java` depuis votre IDE Java (IntelliJ, Eclipse, etc.) :
---

## **Exemples d'utilisation**

1. **Démarrage :**
   - Le jeu demande de choisir une carte et un héros.
   - Les caractéristiques du héros s’affichent.

2. **Déroulement :**
   - Le héros avance sur le plateau, rencontre des ennemis ou des cases vides.
   - Pendant les combats, le joueur peut choisir d'utiliser une compétence spéciale ou d'attaquer normalement.

3. **Fin de la partie :**
   - La partie se termine si le héros atteint la fin du plateau ou si ses points de vie tombent à 0.


---

## **Tests unitaires**

Des tests ont été implémentés avec JUnit pour vérifier les fonctionnalités critiques :
1. **Application des bonus :**
   - Vérifie que les statistiques du héros sont correctement mises à jour.
2. **Application des dégâts :**
   - Simule les dégâts reçu par un personnage pour controler la méthode de calcul des dégâts.

Pour exécuter les tests :
```bash
mvn test
```

---

## **Contributeurs**

Créé par :
- **Bastien BRUNEL**
- **Paul BEAUREPAIRE**
