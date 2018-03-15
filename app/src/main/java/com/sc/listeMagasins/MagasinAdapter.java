package com.sc.listeMagasins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nasredine on 25/02/2018.
 */

class MagasinAdapter extends BaseAdapter {

    //TODO: avoid to pass whole activity object, pass only context!
    //https://stackoverflow.com/questions/33162348/passing-activity-or-context-to-other-instance

    private final MagasinActivity mainActivityContext;
    private ArrayList<Magasin> magasins;

    public MagasinAdapter(MagasinActivity mainActivityContext, ArrayList<Magasin> magasins) {
        this.magasins = magasins;
        this.mainActivityContext = mainActivityContext;
    }



    @Override
    public int getCount() {
        return magasins.size();
    }

    @Override
    public Object getItem(int arg0) {
        return magasins.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // on crée l'élément graphique qui affiche les éléments de la liste
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.magasin_item, null);
        }
        // On fait un lien entre chaque composant d'un élément de la liste
        TextView nom = (TextView) itemView.findViewById(R.id.nom);
        TextView adresse = (TextView) itemView.findViewById(R.id.adresse);
        ImageView logo = (ImageView) itemView.findViewById(R.id.logo);

        // attribuer les valeurs de nom,adresse du magasin
        nom.setText(magasins.get(position).getNom());
        adresse.setText(magasins.get(position).getAdresse());

        // On utilise la bibliothèque Picasso pour pouvoir charger le logo du magasin à travers un lien URI
        Picasso.with(mainActivityContext).load(magasins.get(position).getLogo())
                .into(logo, new com.squareup.picasso.Callback(){
                    @Override
                    public void onSuccess(){
                        Toast.makeText(mainActivityContext, "success Loading img", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(){
                        Toast.makeText(mainActivityContext, "ERROR Loading img", Toast.LENGTH_SHORT).show();
                    }

                });



        return itemView;
    }
}



