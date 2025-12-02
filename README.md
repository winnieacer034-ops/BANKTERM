# 🏦 BANKTERM - Système de Gestion Bancaire

Un système bancaire complet développé en **Java 17** avec **Maven**, permettant la gestion de comptes bancaires, la réalisation de transactions et la persistance des données.

## 📋 Table des matières

- [Vue d'ensemble](#vue-densemble)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Compilation et exécution](#compilation-et-exécution)
- [Architecture du projet](#architecture-du-projet)
- [Fonctionnalités](#fonctionnalités)
- [Guide d'utilisation](#guide-dutilisation)

---

## 🎯 Vue d'ensemble

**BANKTERM** est une application bancaire interactive qui offre :
- ✅ Création et gestion de comptes bancaires
- ✅ Gestion des transactions (dépôts, retraits, virements)
- ✅ Authentification des utilisateurs
- ✅ Interface utilisateur en ligne de commande
- ✅ Architecture modulaire et extensible

**Stack technique :**
- Langage : Java 17+
- Gestionnaire de dépendances : Maven 3.6+
- Architecture : MVC (Model-View-Controller)

---

## 🔧 Prérequis

Avant de commencer, assurez-vous que les éléments suivants sont installés sur votre système :

### Logiciels requis
- **Java Development Kit (JDK) 17 ou supérieur**
  ```bash
  java -version
  ```
  
- **Maven 3.6 ou supérieur**
  ```bash
  mvn -version
  ```

### Installation de Java et Maven
- **Java** : Téléchargez depuis [oracle.com](https://www.oracle.com/java/technologies/downloads/) ou utilisez votre gestionnaire de paquets
- **Maven** : Téléchargez depuis [maven.apache.org](https://maven.apache.org/download.cgi)

---

## 📥 Installation

### 1. Accéder au répertoire du projet

```bash
cd /home/nathan-pro/Documents/BANKTERM
```

### 2. Structure du projet

```
BANKTERM/
├── pom.xml                              # Configuration Maven
├── README.md                            # Documentation
├── src/
│   ├── main/
│   │   ├── java/com/bankingproject/
│   │   │   ├── Main.java               # Point d'entrée de l'application
│   │   │   ├── Account/
│   │   │   │   └── Compte.java         # Gestion des comptes bancaires
│   │   │   ├── auth/
│   │   │   │   └── Account.java        # Module d'authentification
│   │   │   ├── Dashboard/
│   │   │   │   └── screen.java         # Interface utilisateur principale
│   │   │   └── transactions/
│   │   │       └── Transaction.java    # Gestion des transactions
│   │   └── resources/                  # Ressources de configuration
│   └── test/
│       └── java/                       # Tests unitaires
└── target/                             # Répertoire de build (généré après compilation)
```

---

## 🔨 Compilation et exécution

### Option 1 : Compilation et exécution avec Maven

#### 1. Nettoyer et compiler le projet
```bash
mvn clean compile
```
Cette commande :
- Supprime les fichiers de build précédents (`target/`)
- Télécharge les dépendances requises
- Compile tous les fichiers `.java`
- Génère les fichiers `.class` dans `target/classes`

#### 2. Créer le fichier JAR
```bash
mvn package
```
Crée un JAR exécutable : `BankingApp.jar`

#### 3. Exécuter l'application
```bash
mvn exec:java -Dexec.mainClass="com.bankingproject.Main"
```

### Option 2 : Exécution du JAR compilé
```bash
java -jar target/BankingApp.jar
```

### Option 3 : Build complet (recommandé)
```bash
mvn clean package -DskipTests
mvn exec:java -Dexec.mainClass="com.bankingproject.Main"
```

---

## ✨ Fonctionnalités

### 1. 👤 Gestion des Comptes
- ✅ Création de nouveaux comptes avec informations personnelles
- ✅ Authentification par code PIN sécurisé
- ✅ Numéro de compte unique généré automatiquement
- ✅ Consultation du solde et des informations du compte

### 2. 💳 Transactions Bancaires
- ✅ **Dépôt** : Ajouter de l'argent à votre compte
- ✅ **Retrait** : Retirer de l'argent (avec vérification du solde)
- ✅ **Virement** : Transférer de l'argent à un autre compte
- ✅ Historique des transactions

### 3. 💾 Persistance des Données
- ✅ Sauvegarde automatique en fichier binaire (`comptes.dat`)
- ✅ Chargement des données au démarrage
- ✅ Synchronisation en temps réel des modifications

### 4. 🔐 Sécurité
- ✅ Authentification par code PIN
- ✅ Validation des montants
- ✅ Vérification du solde avant les retraits
- ✅ Confirmation des transactions sensibles

---

## 🏗️ Architecture du Projet

### Diagramme des classes

```
com.bankingproject
├── Main.java                  # Point d'entrée principal
├── Account
│   └── Compte.java           # Gestion des comptes
├── auth
│   └── Account.java          # Modèle de données compte
├── Dashboard
│   └── screen.java           # Interface utilisateur (CLI)
└── transactions
    └── Transaction.java      # Opérations bancaires
```

### Flux d'exécution

```
Main.java
   ↓
screen.java (Affichage du menu)
   ↓
Sélection utilisateur
   ├─→ Créer compte → Compte.java → Account.java
   ├─→ Consulter solde → Compte.java → Affichage
   ├─→ Transaction → Transaction.java → Compte.java
   └─→ Quitter → Sauvegarde → Fin
```

### Responsabilités des classes

| Classe | Responsabilité |
|--------|---------------|
| `Main.java` | Initialisation et boucle principale |
| `Compte.java` | CRUD des comptes, persistance |
| `Account.java` | Structure des données d'un compte |
| `screen.java` | Interface utilisateur, menu |
| `Transaction.java` | Opérations (dépôt, retrait, virement) |

---

## 📖 Guide d'Utilisation Détaillé

### Menu principal

```
╔═════════════════════════════════════════════╗
║   Bienvenue dans BANKTERM - Système Bancaire
╚═════════════════════════════════════════════╝

Quel opération souhaitez vous effectuer?

1. Créer un compte
2. Consulter votre solde
3. Effectuer un dépôt/retrait
4. Quitter

Veuillez choisir:
```

### Exemple 1 : Créer un compte

```
Choix: 1
→ Entrez votre nom: Jean Dupont
→ Entrez votre âge: 28
→ Entrez votre code PIN: 1234
→ Confirmez votre code PIN: 1234

✓ Votre compte a été créé !
  Nom: Jean Dupont
  Âge: 28
  Numéro de compte: 1001
  Solde initial: 0 €
```

### Exemple 2 : Consulter votre solde

```
Choix: 2
→ Veuillez entrer votre numéro de compte: 1001
→ Entrez votre code PIN: 1234

╔════════════════════════════════════════╗
║ Bienvenu Jean Dupont !
║ Numéro de compte: 1001
║ Solde: 500.00 €
╚════════════════════════════════════════╝
```

### Exemple 3 : Effectuer une transaction

```
Choix: 3
→ Veuillez entrer votre numéro de compte: 1001
→ Entrez votre code PIN: 1234

Bienvenu Jean Dupont !

Choisissez une opération:
1. Dépôt
2. Retrait
3. Virement vers un autre compte

Choix: 1
→ Entrer le montant: 200

✓ Dépôt de 200.00 € effectué !
  Nouveau solde: 700.00 €
```

---

## 📁 Fichiers et Dossiers

### Répertoire source

```
src/main/java/com/bankingproject/
├── Main.java                    # Point d'entrée (public static void main)
├── Account/
│   └── Compte.java             # Classe de gestion des comptes
├── auth/
│   └── Account.java            # Classe modèle (POJO)
├── Dashboard/
│   └── screen.java             # Interface en ligne de commande
└── transactions/
    └── Transaction.java        # Classe des opérations
```

### Fichier de persistence

**`comptes.dat`** 
- Fichier sérialisé contenant tous les comptes bancaires
- Créé automatiquement dans le répertoire courant
- Format : Binaire (sérialisation Java)
- Taille : Augmente avec le nombre de comptes

---

## 🚀 Commandes Essentielles

### Compilation et exécution rapides

```bash
# Build complet et exécution
mvn clean package -DskipTests && java -jar target/BankingApp.jar

# Seulement recompiler
mvn compile

# Nettoyer le projet
mvn clean

# Exécuter les tests
mvn test
```

### Résumé des commandes Maven

| Commande | Action |
|----------|--------|
| `mvn clean` | Supprime le dossier `target/` |
| `mvn compile` | Compile le code source |
| `mvn package` | Crée le JAR exécutable |
| `mvn clean compile package` | Build complet |
| `mvn clean package -DskipTests` | Build sans tests |
| `java -jar target/BankingApp.jar` | Lance l'application |

---

## 🔧 Configuration Technique

### Java et Maven

- **Java** : Version 17 ou supérieure
- **Maven** : Version 3.6 ou supérieure
- **Encoding** : UTF-8
- **Compilation cible** : Java 17

### Structure du pom.xml

```xml
<groupId>com.bankingproject</groupId>
<artifactId>demo</artifactId>
<version>1.0-SNAPSHOT</version>

<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
</properties>
```

### Plugins Maven utilisés

1. **maven-jar-plugin** : Empaquetage en JAR avec classe principale
2. **maven-assembly-plugin** : Création d'un JAR exécutable avec dépendances

---

## ⚠️ Dépannage

### Erreur : "Java 17 not found"

```bash
# Vérifier la version installée
java -version

# Si Java n'est pas installé, l'installer
sudo apt-get install default-jdk  # Linux/Debian
brew install java               # macOS
```

### Erreur : "mvn: command not found"

```bash
# Vérifier Maven
mvn -version

# Installer Maven
sudo apt-get install maven      # Linux/Debian
brew install maven              # macOS
```

### Erreur : "Cannot find symbol"

```bash
# Nettoyer et recompiler
mvn clean compile

# Ou avec build complet
mvn clean package
```

### Les données ne sont pas sauvegardées

1. Vérifier les permissions d'écriture du répertoire
2. Supprimer le fichier `comptes.dat` corrompu
3. Relancer l'application

### Erreur lors du chargement des comptes

```bash
# Si le fichier comptes.dat est corrompu
rm comptes.dat
# Relancer l'application pour recréer le fichier
```

---

## 📊 Informations de Build

### Structure du répertoire target/

```
target/
├── BankingApp.jar              # JAR exécutable (RECOMMANDÉ)
├── demo-1.0-SNAPSHOT.jar      # JAR standard
├── classes/                    # Fichiers .class compilés
│   └── com/bankingproject/
│       ├── Main.class
│       ├── Account/Compte.class
│       ├── auth/Account.class
│       ├── Dashboard/screen.class
│       └── transactions/Transaction.class
├── maven-archiver/
│   └── pom.properties
└── maven-status/
    └── maven-compiler-plugin/
        └── compile/
            └── default-compile/
                ├── createdFiles.lst
                └── inputFiles.lst
```

---

## 💡 Conseils et Bonnes Pratiques

### Avant de commencer

1. ✅ Vérifier que Java 17+ est installé
2. ✅ Vérifier que Maven 3.6+ est disponible
3. ✅ Cloner ou télécharger le projet
4. ✅ Accéder au répertoire du projet

### Pendant le développement

- Utiliser `mvn clean compile` régulièrement
- Tester avec `mvn package` avant de déployer
- Consulter les logs Maven pour les erreurs
- Vérifier les permissions d'accès aux fichiers

### Pour la production

- Utiliser `BankingApp.jar` (inclut toutes les dépendances)
- Tester complètement avant le déploiement
- Sauvegarder régulièrement les données (`comptes.dat`)
- Monitorer les logs d'erreur

---

## 📞 Support

Pour toute question ou problème :
1. Vérifier la section Dépannage
2. Consulter les logs Maven
3. Vérifier que votre environnement Java est configuré correctement
| `java -jar target/BankingApp.jar` | Exécute l'application |
| `mvn exec:java -Dexec.mainClass="com.bankingproject.Main"` | Exécute via Maven |

---

## 📞 Support

Pour toute question ou problème :
1. Vérifiez que Java 17+ et Maven 3.6+ sont installés
2. Essayez `mvn clean compile package`
3. Supprimez le répertoire `target` et recommencez

---

## 📄 Licence

Projet développé pour le cours INF151 - ICT4D

---

**Dernière mise à jour :** 2 décembre 2025
**Version :** 1.0-SNAPSHOT
