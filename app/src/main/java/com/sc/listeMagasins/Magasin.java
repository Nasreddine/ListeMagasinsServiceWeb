package com.sc.listeMagasins;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nasredine on 25/02/2018.
 */

class Magasin extends BaseWeBuy {

    // Juste nom de la classe afin de l'afficher pendant le log.
    private static String TAG = MagasinActivity.class.getSimpleName();


    private String nom;
    private String adresse;
    private double latitude;
    private double longitude;
    private String logo;
    private ArrayList<Promotion> promotions;

    private static String api_url = BaseWeBuy.api_url + "/magasins";

    /**
     * renvoyer tous les magasins qui proposent des promos
     *
     * @return
     */

    public static ArrayList<Magasin> getAllMagasins() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Magasin> magasins = new ArrayList<>();

        HttpHandler sh = new HttpHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(api_url);

        Log.e(TAG, "Réponse Serveur: " + jsonStr);

        if (jsonStr != null) {
            try {new JSONArray(jsonStr);

                // Getting JSON Array node
                JSONArray magasins_json = new JSONArray(jsonStr);

                // looping through All Contacts

                for (int i = 0; i < magasins_json.length(); i++) {


                    JSONObject magasin_json = magasins_json.getJSONObject(i);

                    int id_magasin = magasin_json.getInt("id_magasin");
                    String nom = magasin_json.getString("nom");
                    String adresse = magasin_json.getString("adresse");

                    double latitude = magasin_json.getDouble("latitude");
                    double longitude = magasin_json.getDouble("longitude");

                    String logo = magasin_json.getString("logo");

                    Magasin magasin = new Magasin();
                    magasin.setId(id_magasin);
                    magasin.setNom(nom);
                    magasin.setLongitude(latitude);
                    magasin.setLatitude(longitude);
                    magasin.setAdresse(adresse);

                    magasins.add(magasin);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Erreur de parsing JSON : " + e.getMessage());

            }
        } else {
            Log.e(TAG, "Réponse vide !, pas de JSON");
        }

        return magasins;





    }

    /**
     * renvoyer toutes les achat en groupe  d'un magasin
     * chat achat concerne une promo qui elle même concerne un produit
     *
     * @param id_magasin
     * @return
     */

    public static ArrayList<AchatGroupe> getAllAchatGroupe(int id_magasin) {

        ArrayList<AchatGroupe> achatGroupes = new ArrayList<>();
        AchatGroupe achatGroupe1 = new AchatGroupe();


        return achatGroupes;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


}