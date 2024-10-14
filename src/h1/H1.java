/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author DELL
 */
public class H1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        // Création d'une instance de ProduitService
        ProduitService ps = new ProduitService();

        // 1. Créer cinq produits
        Produit p1 = new Produit("HP", "Laptop", new Date(), 8500, "Ordinateur portable");
        Produit p2 = new Produit("Dell", "Desktop", new Date(), 6500, "Ordinateur de bureau");
        Produit p3 = new Produit("Lenovo", "Tablet", new Date(), 3000, "Tablette");
        Produit p4 = new Produit("Apple", "Cable", new Date(), 99, "chargeur");
        Produit p5 = new Produit("Samsung", "Ecouteurs", new Date(), 55, "ecouteurs");

        ps.create(p1);
        ps.create(p2);
        ps.create(p3);
        ps.create(p4);
        ps.create(p5);

        // 2. Afficher la liste des produits
        System.out.println("Liste de tous les produits :");
        for (Produit p : ps.findAll()) {
            System.out.println("Marque:" + p.getMarque() + " , Reference:" + p.getReference() + 
                    " , Prix:" + p.getPrix() + " ,Designation:" + p.getDesignation());
        }

        // 3. Afficher les informations du produit dont id = 2
        System.out.println("\nInformations du produit avec id = 2 :");
        Produit pp = ps.findById(2);
        System.out.println("Marque:" + pp.getMarque() + " , Reference:" + pp.getReference() +
                " , Prix:" + pp.getPrix() + " ,Designation:" + pp.getDesignation());

        // 4. Supprimer le produit dont id = 3
        System.out.println("\nSuppression du produit avec id = 3");
        Produit produitASupprimer = ps.findById(3);
         ps.delete(produitASupprimer);

        // 5. Modifier les informations du produit dont id = 1
        Produit produitAModifier = ps.findById(1);

        // Modifier l'objet récupéré
        produitAModifier.setPrix(9000);
        produitAModifier.setDesignation("Ordinateur portable mis à jour");

        // Mettre à jour dans la base de données
        ps.update(produitAModifier);

        // Vérifier la mise à jour
        Produit produitModifie = ps.findById(1);
        System.out.println("\nProduit mis à jour :");
        System.out.println("Marque: " + produitModifie.getMarque() + ", Reference: " + produitModifie.getReference() + 
                ", Prix: " + produitModifie.getPrix() + ", Designation: " + produitModifie.getDesignation());

        // 6. Afficher la liste des produits dont le prix est supérieur à 100 DH
        System.out.println("\nProduits avec prix > 100 DH :");

        for (Produit pn : ps.findAll()) {
            if (pn.getPrix() > 100) {
                System.out.println("Marque:" + pn.getMarque() + " , Reference:" + pn.getReference() +
                        " , Prix:" + pn.getPrix() + " ,Designation:" + pn.getDesignation());
            }
        }

        // 7. Afficher la liste des produits commandés entre deux dates
        System.out.println("\nProduits achetés entre deux dates :");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date startDate = sdf.parse("2024-10-10 16:10:10");
        Date endDate = sdf.parse("2024-10-14 19:00:00");

        List<Produit> produitsEntreDeuxDates = ps.findBetweenDates(startDate, endDate);

        for (Produit p : produitsEntreDeuxDates) {
            System.out.println("Marque: " + p.getMarque()
                    + ", Reference: " + p.getReference()
                    + ", Prix: " + p.getPrix()
                    + ", Date d'achat: " + sdf.format(p.getDateAchat()));
        }

    }
}
