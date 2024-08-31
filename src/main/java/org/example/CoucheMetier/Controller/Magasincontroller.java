package org.example.CoucheMetier.Controller;

import org.example.CoucheMetier.Entites.Magasin;
import org.example.CoucheMetier.Interface.Bebliothique;
import org.example.CoucheMetier.Interface.Implemnation.MagasinImp;
import org.example.CouchePresentation.CostumColor;
import org.example.CoucheUntaire.DateUtil.DateUtils;
import org.example.CoucheUntaire.Pattren.PattrenUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Magasincontroller {

    private static final Bebliothique MagasinImp = new MagasinImp();

    public void MenuMagasin() {

        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"|                  Welcome to Gestion Magazine :     "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (Magazine)"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunter un document (Magazine)"  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retourner un document (Magazine)"+ CostumColor.RESET);
            System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Afficher tous les documents (Magazine) "+ CostumColor.RESET);
            System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Rechercher un document (Magazine) "+ CostumColor.RESET);
            System.out.println("|Press 6 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT (Magazine)__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);

            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            Scanner choix= new Scanner(System.in);
            String ch = choix.nextLine();

            switch (ch) {
                case "1":
                    AddOoc();
                    break;
                case "2":
                    emprunterLivre();
                    break;
                case "3":
                    retournerLivre();
                    break;
                case "4":

                    afficheDetailsLivre();
                    break;
                case "5":
                    RechDocLivre();
                    break;
                case "6" :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"-----_____Exit (Magazine)_______------"+ CostumColor.RESET);
                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice Menu Magasin");
                    break;
            }
        }while (true);

    }

    public  void afficheDetailsLivre() {
        MagasinImp.afficherDetails();
    }

    public void AddOoc(){
        try  {
            int id = PattrenUtils.getIntInput("Entrez l'ID du document (numérique) :");
            String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
            String auteur = PattrenUtils.getStringInput("Entrez l'auteur du document :");
            int nombreDePages = PattrenUtils.getIntInput("Entrez le nombre de pages :");

            Scanner choix = new Scanner(System.in);
            LocalDate datePublication,currentDate;
            currentDate  = LocalDate.now();
            do {
                System.out.println("Entrez la date de publication (AAAA-MM-JJ) :");
                datePublication = DateUtils.parseDate(choix.nextLine());

                if (datePublication == null || datePublication.isAfter(currentDate)) {
                    System.out.println("Date de publication invalide, opération annulée.");

                }
            } while (datePublication == null || datePublication.isAfter(currentDate));


                int numero = PattrenUtils.getIntInput("Entrez le numéro du magazine :");
                MagasinImp.add(new Magasin(id, titre, auteur, datePublication, nombreDePages, numero));
                System.out.println("Magasin ajouté avec succès!");



        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de l'ajout du Doc: " + e.getMessage());
        }
    }
    public void emprunterLivre(){
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        MagasinImp.emprunt(titre);
    }
    public void retournerLivre(){
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        MagasinImp.retourner(titre);
    }
    public void RechDocLivre(){
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        MagasinImp.RechDoc(titre);
    }
}
