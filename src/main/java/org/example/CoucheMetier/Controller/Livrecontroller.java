package org.example.CoucheMetier.Controller;

import org.example.CoucheMetier.Entites.Livre;
import org.example.CoucheMetier.Interface.Bebliothique;
import org.example.CoucheMetier.Interface.Implemnation.LivreImp;
import org.example.CouchePresentation.CostumColor;
import org.example.CoucheUntaire.DateUtil.DateUtils;
import org.example.CoucheUntaire.Pattren.PattrenUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Livrecontroller {


    private static final Bebliothique livreImp = new LivreImp();

    public void MenuLivre() {

        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"|                  Welcome to Gestion Livre :     "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (Livre)"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunter un document (Livre)"  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retourner un document (Livre)"+ CostumColor.RESET);
            System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Afficher tous les documents (Livre) "+ CostumColor.RESET);
            System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Rechercher un document (Livre) "+ CostumColor.RESET);
            System.out.println("|Press 6 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT(Livre)__________"+ CostumColor.RESET);
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
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"-----_____Exit (Livre)_______------"+ CostumColor.RESET);

                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice Menu Livre");
                    break;
            }
        }while (true);

    }

    public  void afficheDetailsLivre() {
        livreImp.afficherDetails();
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


            String isbn = PattrenUtils.getStringInputType("Entrez l'ISBN du livre :");
            // Set

            livreImp.add(new Livre(id, titre, auteur, datePublication, nombreDePages, isbn));

            System.out.println("Livre ajouté avec succès!");


        } catch (Exception e) {
            System.err.println("Une erreur s'est produite lors de l'ajout du livre: " + e.getMessage());
        }
    }
    public void emprunterLivre(){
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        livreImp.emprunt(titre);
    }
    public void retournerLivre(){
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        livreImp.retourner(titre);
    }
    public void RechDocLivre(){
        String titre = PattrenUtils.getStringInput("Entrez le titre du document :");
        livreImp.RechDoc(titre);
    }
}
