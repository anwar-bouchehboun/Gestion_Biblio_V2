package org.example.CoucheMetier.Interface.Implemnation;


import org.example.CoucheMetier.Entites.Livre;
import org.example.CoucheMetier.Entites.Magasin;
import org.example.CoucheMetier.Interface.Bebliothique;
import org.example.CouchePresentation.CostumColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class LivreImp implements Bebliothique<Livre> {

    private static List<Livre> livres = new ArrayList<>();
    private static HashMap<Integer, Livre> listeMapping = new HashMap<>();


    public void add(Livre document) {
        livres.add(document);
        System.out.println(CostumColor.WHITE_BOLD_BRIGHT+livres+ CostumColor.RESET);
        listeMapping.put(document.getId(),document);
    }

    @Override
    public void emprunt(String titre) {
        Optional<Livre> doc=   getDoc(titre);
        doc.ifPresentOrElse(Livre::emprunter, () -> System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Livre introuvable."+ CostumColor.RESET));
    }

    @Override
    public void retourner(String titre) {
        Optional<Livre> doc=   getDoc(titre);
        doc.ifPresentOrElse(Livre::retourner, () -> System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Livre introuvable."+ CostumColor.RESET));
    }

    @Override
    public Optional<Livre> getDoc(String titre) {
    return listeMapping.values().stream()
                .filter(livre -> livre.getTitre().equalsIgnoreCase(titre))
                .findFirst();


    }
    public Optional<Livre> RechDoc(String titre) {
        Optional<Livre> doc=   getDoc(titre);
        doc.ifPresentOrElse(Livre::afficherDetailslivre, () -> System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Livre introuvable."+ CostumColor.RESET));
        return doc;
    }



    @Override
    public void afficherDetails() {

        if (livres.isEmpty()) {

            System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"| Aucun lIVRE n'est disponible dans la bibliothèque. "+ CostumColor.RESET);

        } else {
            System.out.printf(CostumColor.WHITE_BOLD_BRIGHT+"%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s | %-15s %n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "ISBN"+ CostumColor.RESET);
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

           livres.forEach(Livre::afficherDetails);
        }

    }

    @Override
    public void getIdRech(int id){
         // return Optional.ofNullable(listeMapping.get(id));

    }
}
