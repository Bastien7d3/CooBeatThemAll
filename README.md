# CooBeatThemAll

CooBeatThemAll est un mini-jeu de combat en Java, dans lequel des héros affrontent divers ennemis. Ce projet illustre une architecture orientée objet avec des concepts tels que l'héritage, les classes abstraites et le polymorphisme. Chaque personnage possède ses propres attributs et compétences spécifiques, ce qui permet d'expérimenter différentes stratégies de combat.

## Structure du projet

L'arborescence du projet est la suivante :

    CooBeatThemAll/
    ├── Carte/
    │   ├── Case.java
    │   └── Plateau.java
    ├── Jeu/
    │   └── Jeu.java
    ├── Perso/
    │   ├── Perso.java
    │   ├── Hero/
    │   │   ├── Hero.java
    │   │   ├── Mage/
    │   │   │   └── MageHero.java
    │   │   └── Warrior/
    │   │       └── WarriorHero.java
    │   └── Ennemi/
    │       ├── Ennemi.java
    │       ├── Boss/
    │       │   └── BossEnnemi.java
    │       └── Brigand/
    │           └── BrigandEnnemi.java
    ├── Main.java
    └── README.md

- Carte : Contient les classes pour le plateau de jeu (Case, Plateau).
- Jeu : Contient la logique de jeu principale (Jeu.java).
- Perso : Contient les classes des personnages, divisées en Héros et Ennemis.
  - Hero : Sous-dossier pour les classes de héros.
  - Ennemi : Sous-dossier pour les classes d'ennemis.
- Main.java : Le fichier principal pour lancer et tester le jeu.

## Installation

  Clonez ce dépôt sur votre machine locale.

    git clone https://github.com/votre-utilisateur/CooBeatThemAll.git

  Ouvrez le projet dans votre IDE Java préféré (par exemple IntelliJ, Eclipse).
  Assurez-vous que la structure des packages est correctement configurée pour que chaque fichier soit reconnu par le projet.

## Utilisation

Pour lancer le projet, exécutez la classe Main.java, qui contient des exemples de création de personnages et de tests de leurs compétences.

## Fonctionnalités
### 1. Combat entre personnages
Les héros et les ennemis peuvent s'attaquer en utilisant leurs points d'attaque. La défense de chaque personnage réduit les dégâts subis. Les héros peuvent utiliser leurs compétences spéciales (ultimes) pour infliger des dégâts supplémentaires.

### 2. Points de vie et état de vie
Chaque personnage dispose de points de vie (pv). Lorsqu'un personnage subit des dégâts, ses points de vie sont réduits. La méthode isAlive() permet de vérifier si un personnage est encore en vie.

### 3. Système de compétences spéciales (Ultimate)
Les héros et les ennemis disposent de compétences spéciales uniques, définies dans la méthode useUltimate(). Ces compétences permettent d'attaquer avec des effets ou des dégâts spéciaux.

### 4. Plateau de jeu (en développement)
Les classes dans le dossier Carte (Case et Plateau) permettent de gérer le plateau de jeu sur lequel les personnages peuvent se déplacer et interagir.

## Contributeurs

Créé par Bastien BRUNEL et BEAUREPAIRE Paul.
