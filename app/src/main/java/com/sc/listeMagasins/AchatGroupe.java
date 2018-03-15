package com.sc.listeMagasins;

/**
 * Created by nasredine on 26/02/2018.
 */

class AchatGroupe extends BaseWeBuy {


    private int duree;
    private int quantite_achat;
    private Promotion promotion;

    public int getDuree(){
        return duree;
    }

    public void setDuree(int duree){
        this.duree=duree;
    }

    public int getQuantite_achat(){
        return quantite_achat;
    }

    public void setQuantite_achat(int quantite_achat){
        this.quantite_achat=quantite_achat;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promotion getPromotion() {
        return this.promotion;
    }
}
