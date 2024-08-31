package org.example.CouchePresentation;

import org.example.CoucheMetier.Controller.Livrecontroller;
import org.example.CoucheMetier.Controller.Magasincontroller;

import java.util.Scanner;


public class ConsolUi {


    private static final Livrecontroller livre = new Livrecontroller();
    private static final Magasincontroller Magsin = new Magasincontroller();

    public ConsolUi() {

        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"|                  Welcome to Bibliotheque :     "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Gestion  Livre "      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Gestion Magazine"  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);

            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
          Scanner choix= new Scanner(System.in);
            String ch = choix.nextLine();

            switch (ch) {
                case "1":
                    livre.MenuLivre();
                    break;
                case "2":
                    Magsin.MenuMagasin();
                    break;

                case "3" :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"-----_____Exit Application_______------"+ CostumColor.RESET);
                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT+"Invalid choice");
                    break;
            }
        }while (true);

    }


}
