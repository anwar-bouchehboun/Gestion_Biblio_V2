package org.example.CoucheMetier.Interface.Implemnation;


import org.example.CoucheMetier.Entites.Livre;
import org.example.CoucheMetier.Interface.Bebliothique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class LivreImp implements Bebliothique<Livre> {

    private static List<Livre> livres = new ArrayList<>();
    private static HashMap<Integer, Livre> listeMapping = new HashMap<>();


    public void add(Livre document) {
        livres.add(document);
        System.out.println(livres);
        listeMapping.put(document.getId(),document);
    }

    @Override
    public void emprunt(String titre) {
        Optional<Livre> doc=   getDoc(titre);
        doc.ifPresentOrElse(Livre::emprunter, () -> System.out.println("Livre introuvable."));
    }

    @Override
    public void retourner(String titre) {
        Optional<Livre> doc=   getDoc(titre);
        doc.ifPresentOrElse(Livre::retourner, () -> System.out.println("Livre introuvable."));
    }

    @Override
    public Optional<Livre> getDoc(String titre) {
    return listeMapping.values().stream()
                .filter(livre -> livre.getTitre().equalsIgnoreCase(titre))
                .findFirst();


    }
    public Optional<Livre> RechDoc(String titre) {
        Optional<Livre> doc=   getDoc(titre);
        doc.ifPresentOrElse(Livre::afficherDetailslivre, () -> System.out.println("Livre introuvable."));
        return doc;
    }


    @Override
    public void afficherDetails() {

        if (livres.isEmpty()) {
            System.out.println("Aucun lIVRE n'est disponible dans la bibliothèque.");
        } else {
            System.out.printf("%-10s | %-20s | %-30s | %-15s | %-10s  | %-12s | %-15s %n",
                    "ID", "Titre", "Auteur", "Date Pub.", "Pages", "Statut", "ISBN");

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

           livres.forEach(Livre::afficherDetails);
        }

    }
}
