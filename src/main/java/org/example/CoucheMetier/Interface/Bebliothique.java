package org.example.CoucheMetier.Interface;

import org.example.CoucheMetier.Entites.Abstractions.Document;

import java.util.Optional;

public interface Bebliothique <Doc extends  Document> {
    void add(Doc Document);
    void emprunt(String titre);
    void retourner(String titre);
    Optional<Doc> getDoc(String titre);
    void afficherDetails();
   Optional<Doc> RechDoc(String titre);
}
