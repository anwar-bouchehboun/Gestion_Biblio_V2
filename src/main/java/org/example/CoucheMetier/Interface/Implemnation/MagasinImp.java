package org.example.CoucheMetier.Interface.Implemnation;

import org.example.CoucheMetier.Entites.Magasin;
import org.example.CoucheMetier.Interface.Bebliothique;
import org.example.CouchePresentation.CostumColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MagasinImp implements Bebliothique<Magasin> {

    private static List<Magasin> Magasins = new ArrayList<>();
    private static HashMap<Integer, Magasin> listeMapping = new HashMap<>();

    @Override
    public void add(Magasin document) {
        Magasins.add(document);
        System.out.println(CostumColor.WHITE_BOLD_BRIGHT+Magasins+ CostumColor.RESET);
        listeMapping.put(document.getId(), document);
    }

    @Override
    public void emprunt(String titre) {
        Optional<Magasin> doc = getDoc(titre);
        doc.ifPresentOrElse(Magasin::emprunter, () -> System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Magasin introuvable."+ CostumColor.RESET));
    }

    @Override
    public void retourner(String titre) {
        Optional<Magasin> doc = getDoc(titre);
        doc.ifPresentOrElse(Magasin::retourner, () -> System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Magasin introuvable."+ CostumColor.RESET));
    }

    @Override
    public Optional<Magasin> getDoc(String titre) {
        return Magasins.stream()
                .filter(magasin -> magasin.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }

    public Optional<Magasin> RechDoc(String titre) {
        Optional<Magasin> doc = getDoc(titre);
        doc.ifPresentOrElse(Magasin::afficherDetailsMagsin, () -> System.out.println(CostumColor.WHITE_BOLD_BRIGHT+"Magasin introuvable."+ CostumColor.RESET));
        return doc;
    }

    @Override
    public void afficherDetails() {
        if (Magasins.isEmpty()) {
            System.out.println("Aucun magasin n'est disponible dans la bibliothèque.");
        } else {
            System.out.printf(CostumColor.WHITE_BOLD_BRIGHT+"%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s | %-15s %n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "Numero"+ CostumColor.RESET);
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

            Magasins.forEach(Magasin::afficherDetails);
        }
    }

    public void getIdRech(int id){
        Optional<Magasin> result = Optional.ofNullable(listeMapping.get(id));
        result.ifPresentOrElse(
                Magasin::afficherDetailsMagsin,
                () -> System.out.println("No Magasin found for the given ID")
        );
    }
}
