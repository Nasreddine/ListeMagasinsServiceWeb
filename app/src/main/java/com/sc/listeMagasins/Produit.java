package com.sc.listeMagasins;

/**
 * Created by nasredine on 26/02/2018.
 */

class Produit extends BaseWeBuy {


    private String libelle;
    private String description;
    private String image;

    public String getLibelle(){
        return libelle;
    }



    public void setLibelle(String libelle){
        this.libelle=libelle;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image=image;
    }
}
