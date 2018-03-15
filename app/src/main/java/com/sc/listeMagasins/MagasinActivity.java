package com.sc.listeMagasins;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MagasinActivity extends AppCompatActivity {

    private ArrayList<Magasin> magasins;
    MagasinAdapter adapter;
    ListView listeMagasinView;
    int i = 0;

    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sc.listeMagasins.R.layout.activity_main);

        listeMagasinView = (ListView) findViewById(R.id.listView);

        Button btn_afficher_message = (Button) findViewById(R.id.btn_afficher_message);

        btn_afficher_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Toast.makeText(MagasinActivity.this, "message" + i, Toast.LENGTH_SHORT).show();
            }
        });


        Button btn_charger_sans = (Button) findViewById(R.id.btn_charger_sans);

        btn_charger_sans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                magasins = Magasin.getAllMagasins();
                adapter = new MagasinAdapter(MagasinActivity.this, magasins);
                listeMagasinView.setAdapter(adapter);
            }
        });

        Button btn_charger_async_task = (Button) findViewById(R.id.btn_charger_async_task);

        btn_charger_async_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetAllMagasinsTask task = new GetAllMagasinsTask(MagasinActivity.this);
                task.execute();
            }
        });

        Button btn_charger_async_thread = (Button) findViewById(R.id.btn_charger_thread);

        btn_charger_async_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {

                        magasins = Magasin.getAllMagasins();

                        listeMagasinView.post(new Runnable() {
                            public void run() {
                                adapter = new MagasinAdapter(MagasinActivity.this, magasins);
                                listeMagasinView.setAdapter(adapter);
                            }
                        });
                    }
                }).start();
            }
        });

    }

    /**
     * une tâche asynchrone pour obtenir des données json par des requêtes HTTP
     */
    private class GetAllMagasinsTask extends AsyncTask<Void, Void, Void> {

        private MagasinActivity activity;

        public GetAllMagasinsTask(MagasinActivity a) {
            this.activity = a;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MagasinActivity.this);
            pDialog.setMessage("Chargement des magasins...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {

            magasins = Magasin.getAllMagasins();
            Log.i("MagasinActivity", "magasins.size()" + magasins.size());
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... progress) {
            super.onProgressUpdate(progress);
            pDialog.setProgress(1);
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            adapter = new MagasinAdapter(activity, magasins);
            listeMagasinView.setAdapter(adapter);

            listeMagasinView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Magasin magasin_selectione = magasins.get(position);
                    Toast.makeText(MagasinActivity.this, "id_magasin:" + magasin_selectione.getId(), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }


}
