package org.example.CoucheMetier.Interface.Implemnation;

import org.example.CoucheMetier.Entites.Magasin;
import org.example.CoucheMetier.Interface.Bebliothique;

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
        System.out.println(Magasins);
        listeMapping.put(document.getId(), document);
    }

    @Override
    public void emprunt(String titre) {
        Optional<Magasin> doc = getDoc(titre);
        doc.ifPresentOrElse(Magasin::emprunter, () -> System.out.println("Magasin introuvable."));
    }

    @Override
    public void retourner(String titre) {
        Optional<Magasin> doc = getDoc(titre);
        doc.ifPresentOrElse(Magasin::retourner, () -> System.out.println("Magasin introuvable."));
    }

    @Override
    public Optional<Magasin> getDoc(String titre) {
        return Magasins.stream()
                .filter(magasin -> magasin.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }

    public Optional<Magasin> RechDoc(String titre) {
        Optional<Magasin> doc = getDoc(titre);
        doc.ifPresentOrElse(Magasin::afficherDetailsMagsin, () -> System.out.println("Magasin introuvable."));
        return doc;
    }

    @Override
    public void afficherDetails() {
        if (Magasins.isEmpty()) {
            System.out.println("Aucun magasin n'est disponible dans la bibliothèque.");
        } else {
            System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s | %-15s %n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "Numero");

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

            Magasins.forEach(Magasin::afficherDetails);
        }
    }
}
