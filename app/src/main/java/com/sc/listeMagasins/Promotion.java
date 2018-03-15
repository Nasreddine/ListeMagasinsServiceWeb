package com.sc.listeMagasins;

/**
 * Created by nasredine on 26/02/2018.
 */

class Promotion extends BaseWeBuy {

    private double prix_hors_promo;
    private double prix_promo;
    private int quantite_min;
    private Magasin magasin;
    private Produit produit;


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }



    public double getPrix_hors_promo() {
        return prix_hors_promo;
    }

    public void setPrix_hors_promo(double prix_hors_promo) {
        this.prix_hors_promo = prix_hors_promo;
    }

    public double getPrix_promo() {
        return prix_promo;
    }

    public void setPrix_promo(double prix_promo) {
        this.prix_promo = prix_promo;
    }

    public int getQuantite_min() {
        return quantite_min;
    }

    public void setQuantite_min(int quantite_min) {
        this.quantite_min = quantite_min;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }


}
