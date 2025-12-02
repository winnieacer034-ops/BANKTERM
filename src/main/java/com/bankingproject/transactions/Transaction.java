package com.bankingproject.tranaction;
import java.util.Scanner;

import com.bankingproject.objets.Account;
import com.bankingproject.compte.Compte;


public class Transaction {

    Scanner scan = new Scanner(System.in);
    Compte gestionComptes;
    
    String name;
    int age;
    int pin;
    int solde;

    public Transaction(Compte gestionComptes) {
        this.gestionComptes = gestionComptes;
    }

    public void depot(Account compte){
        System.out.println("Vous avez choisi Depôt...");
        System.out.print("Entrer le montant que vous souhaitez déposer: ");
        int depot = scan.nextInt();
        scan.nextLine();
        compte.solde += depot;
        gestionComptes.mettreAJourCompte(compte);
        System.out.println("Votre nouveau solde est de: " + compte.solde);
    }

    // Les autres méthodes de transaction (retrait, virement) seront implémentées ici de manière similaire.
}