# 🏦 Système de Gestion Bancaire

Un système bancaire complet développé en Java avec Maven, permettant la création de comptes, la gestion des transactions et la persistance des données.

## 📋 Table des matières

- [Prérequis](#prérequis)
- [Installation](#installation)
- [Compilation](#compilation)
- [Exécution](#exécution)
- [Fonctionnalités](#fonctionnalités)
- [Architecture](#architecture)
- [Guide d'utilisation](#guide-dutilisation)

---

## 🔧 Prérequis

Avant de commencer, assurez-vous que les éléments suivants sont installés sur votre système :

### Logiciels requis
- **Java 17+** (JDK)
  ```bash
  java -version
  ```
  
- **Maven 3.6+**
  ```bash
  mvn -version
  ```

Si Maven n'est pas installé, téléchargez-le depuis [maven.apache.org](https://maven.apache.org/download.cgi)

---

## 📥 Installation

### 1. Cloner ou télécharger le projet

```bash
# Accéder au répertoire du projet
cd /home/ty/Bureau/ICT4D/INF151/demo
```

### 2. Vérifier la structure du projet

```
demo/
├── pom.xml                          # Configuration Maven
├── README.md                        # Ce fichier
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bankingproject/
│   │   │       ├── Main.java                    # Point d'entrée
│   │   │       ├── compte/
│   │   │       │   └── Compte.java              # Gestion des comptes
│   │   │       ├── objets/
│   │   │       │   └── Account.java             # Modèle de compte
│   │   │       ├── screen/
│   │   │       │   └── screen.java              # Interface utilisateur
│   │   │       └── tranaction/
│   │   │           └── Transaction.java         # Gestion des transactions
│   │   └── resources/
│   └── test/
│       └── java/
└── target/                          # Répertoire de build (généré après compilation)
```

---

## 🔨 Compilation

### Étape 1 : Nettoyer et préparer le projet

```bash
cd /home/ty/Bureau/ICT4D/INF151/demo
mvn clean
```

**Explication :** La commande `mvn clean` supprime le répertoire `target` et tous les fichiers compilés précédents, garantissant une compilation propre.

### Étape 2 : Compiler le code source

```bash
mvn compile
```

**Explication :** 
- Maven analyse le `pom.xml`
- Télécharge les dépendances (si nécessaire)
- Compile tous les fichiers `.java` du répertoire `src/main/java`
- Génère les fichiers `.class` dans `target/classes`

### Étape 3 : Packager le projet en JAR

```bash
mvn package
```

**Explication :**
- Compile le projet
- Exécute les tests (s'il y en a)
- Crée deux fichiers JAR :
  - `target/demo-1.0-SNAPSHOT.jar` - JAR standard
  - `target/BankingApp.jar` - JAR exécutable avec classe principale

### Étape 4 (Optionnel) : Compiler en une seule commande

```bash
mvn clean compile package -DskipTests
```

**Paramètres :**
- `clean` : Nettoie les fichiers précédents
- `compile` : Compile le code
- `package` : Crée le JAR
- `-DskipTests` : Ignore les tests unitaires

---

## 🚀 Exécution

### Option 1 : Exécuter le JAR exécutable (Recommandé)

```bash
java -jar /home/ty/Bureau/ICT4D/INF151/demo/target/BankingApp.jar
```

ou depuis le répertoire du projet :

```bash
cd /home/ty/Bureau/ICT4D/INF151/demo
java -jar target/BankingApp.jar
```

### Option 2 : Exécuter directement avec Maven

```bash
mvn exec:java -Dexec.mainClass="com.bankingproject.Main"
```

### Option 3 : Exécuter depuis l'IDE

Si vous utilisez IntelliJ IDEA ou Eclipse :
1. Clic droit sur `Main.java`
2. Sélectionner "Run"

---

## ✨ Fonctionnalités

### 1. **Créer un compte**
   - Saisir votre nom
   - Saisir votre âge
   - Définir un code PIN avec confirmation
   - Un numéro de compte unique est généré automatiquement

### 2. **Consulter votre solde**
   - Entrer votre numéro de compte
   - Affichage de votre nom et solde actuel

### 3. **Effectuer des transactions**
   - **Dépôt** : Ajouter de l'argent à votre compte
   - **Retrait** : Retirer de l'argent (avec vérification du solde)
   - **Virement** : Transférer de l'argent à un autre compte

### 4. **Persistance des données**
   - Tous les comptes sont sauvegardés automatiquement dans `comptes.dat`
   - Les données sont récupérées au démarrage suivant

### 5. **Boucle d'exécution continue**
   - Le programme continue de s'exécuter jusqu'à ce que l'utilisateur choisisse "Quitter"

---

## 🏗️ Architecture

### Structure des classes

```
┌─────────────────────────────────────────────────────────────┐
│                         Main.java                           │
│                    (Point d'entrée)                         │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│                      screen.java                            │
│                 (Interface utilisateur)                     │
└─────────────────────────────────────────────────────────────┘
            │                           │
            ▼                           ▼
    ┌───────────────┐          ┌──────────────────┐
    │  Compte.java  │          │ Transaction.java │
    │(Gestion des   │          │(Opérations       │
    │  comptes)     │          │ bancaires)       │
    └───────────────┘          └──────────────────┘
            │                           │
            └───────────────┬───────────┘
                            ▼
                   ┌──────────────────┐
                   │  Account.java    │
                   │(Modèle de compte)│
                   └──────────────────┘
```

### Flux de données

1. **Main.java** : Lance l'application et gère la boucle principale
2. **screen.java** : Affiche le menu et collecte les données utilisateur
3. **Compte.java** : Gère la création, le stockage et la récupération des comptes
4. **Transaction.java** : Effectue les opérations bancaires (dépôt, retrait, virement)
5. **Account.java** : Représente les données d'un compte

---

## 📖 Guide d'utilisation

### Démarrage du programme

```
Bienvenue Dans notre systeme banquaire !

Quel operation souhaitez vous effectuer?

1. Créer un compte
2. Consulter votre solde
3. Effectuer un depôt/retrait
4. Quitter

Veillez choisir:
```

### Scénario d'utilisation : Créer un compte

```
Choix : 1
→ Entrez votre nom : Jean Dupont
→ Entrez votre âge : 25
→ Entrez votre code pin : 1234
→ Confirmez votre code pin : 1234

✓ Votre compte a été créer !
  Nom: Jean Dupont
  Âge: 25
  Numéro de compte: 742
  Solde initial: 0
```

### Scénario d'utilisation : Effectuer un virement

```
Choix : 3
→ Veuillez entrer votre numéro de compte : 742
Bienvenu Jean Dupont!

Choisissez une opération: 
1. Dépôt
2. Retrait
3. Virement vers un autre compte

Choix : 3
→ Entrer le numéro de compte destinataire : 123
→ Entrer le montant à transférer : 50

✓ Virement de 50 effectué avec succès vers le compte n°123 (Marie Martin)
  Votre nouveau solde est de: 0
```

---

## 📁 Fichiers générés

Après la compilation, les fichiers suivants sont créés dans le répertoire `target/` :

```
target/
├── BankingApp.jar                  # JAR exécutable (RECOMMANDÉ)
├── demo-1.0-SNAPSHOT.jar          # JAR standard
├── classes/                        # Fichiers .class compilés
│   └── com/bankingproject/
│       ├── Main.class
│       ├── compte/Compte.class
│       ├── objets/Account.class
│       ├── screen/screen.class
│       └── tranaction/Transaction.class
└── maven-archiver/
```

### Fichier de persistance

**`comptes.dat`** : Fichier binaire contenant tous les comptes sauvegardés
- Créé automatiquement lors du premier enregistrement
- Chargé au démarrage du programme
- Mis à jour après chaque transaction

---

## 🔍 Dépannage

### Le projet ne compile pas

**Problème :** `Java 17 not found`

**Solution :**
```bash
# Vérifier la version de Java
java -version

# Définir JAVA_HOME si nécessaire
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

### Maven ne trouve pas le compilateur

**Problème :** `Cannot find symbol`

**Solution :**
```bash
# Nettoyer et recompiler
mvn clean compile
```

### L'application ne sauvegarde pas les données

**Problème :** Les comptes ne sont pas persistés

**Solution :**
- Vérifier que vous avez les permissions d'écriture dans le répertoire courant
- Vérifier que le fichier `comptes.dat` n'est pas corrompu
- Supprimer `comptes.dat` et relancer l'application

---

## 📝 Détails techniques

### Configuration Maven (pom.xml)

Le fichier `pom.xml` contient :

- **modelVersion** : Version du modèle POM (4.0.0)
- **groupId** : Identifiant du groupe (com.bankingproject)
- **artifactId** : Identifiant du projet (demo)
- **version** : Version du projet (1.0-SNAPSHOT)
- **properties** : Java 17 comme source et cible de compilation
- **build** : Configuration des plugins Maven
  - `maven-jar-plugin` : Crée le JAR avec manifest
  - `maven-assembly-plugin` : Crée le JAR exécutable

### Classe principale

Le point d'entrée du programme est défini dans :
```java
<mainClass>com.bankingproject.Main</mainClass>
```

---

## 🎯 Commandes rapides

| Commande | Description |
|----------|-------------|
| `mvn clean` | Nettoie les fichiers compilés |
| `mvn compile` | Compile le code source |
| `mvn package` | Crée le JAR exécutable |
| `mvn clean package` | Nettoie et compile |
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
