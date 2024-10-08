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
                    emprunterMagasin();
                    break;
                case "3":
                    retournerMagasin();
                    break;
                case "4":

                    afficheDetailsMagasin();
                    break;
                case "5":
                    Menumagasin();
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

    public  void afficheDetailsMagasin() {

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
    public void emprunterMagasin(){
        System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunter un document (Magazine)"  + CostumColor.RESET);
        String titre = PattrenUtils.getStringInput("Entrez le titre du document emprunter :");
        MagasinImp.emprunt(titre);
    }
    public void retournerMagasin(){
        System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"|• Retourner un document (Magazine)"  + CostumColor.RESET);

        String titre = PattrenUtils.getStringInput("Entrez le titre du document retourner :");
        MagasinImp.retourner(titre);
    }
    public void RechDocMagasin(){
        System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un document (Magazine)"  + CostumColor.RESET);

        String titre = PattrenUtils.getStringInput("Entrez le titre du document Recherche :");
        MagasinImp.RechDoc(titre);
    }

    //Get ID Recherche ID
    public  void getIdMagasin(){
        int id = PattrenUtils.getIntInput("Entrez l'ID du document (numérique) :");
        MagasinImp.getIdRech(id);
    }

    public void Menumagasin(){
        do {
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche titre "      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche ID"  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT (Recherche) __________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);

            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            Scanner choix= new Scanner(System.in);
            String ch = choix.nextLine();
            switch (ch){
                case "1":
                    RechDocMagasin();
                    break;
                case "2":
                    getIdMagasin();
                    break;

                case "3" :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"-----_____Exit Recherche ------"+ CostumColor.RESET);
                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice");
                    break;
            }
        }while (true);
    }
}
