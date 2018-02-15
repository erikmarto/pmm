package com.example.erik.proyectofinal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Coordenadas extends AppCompatActivity {

    private static final String TAG = "Http Connection";
    private String direccion;
    private EditText longitud;
    private EditText latitud;
    private Button boton;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordenadas);
        longitud = (EditText) findViewById(R.id.longitud);
        latitud = (EditText) findViewById(R.id.latitud);
        boton = (Button) findViewById(R.id.boton);
        resultado = (TextView) findViewById(R.id.resultado);
//

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String url = ("http://maps.googleapis.com/maps/api/geocode/json?"
                        + "latlng=" + longitud.getText().toString() + " ,"
                        + latitud.getText().toString() + "&sensor=false");
                new AsyncHttpTask().execute(url);
            }
        });
    }

    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            Integer result = 0;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setRequestMethod("GET");
                int statusCode = urlConnection.getResponseCode();

                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                String response = convertInputStreamToString(inputStream);
                parseResult(response);
                result = 1;


            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            resultado.setText(direccion);
        }
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";

        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        if (null != inputStream) {
            inputStream.close();
        }
        return result;
    }

    private void parseResult(String result) {

        try {
            JSONObject response = new JSONObject(result);
            JSONArray results = response.optJSONArray("results");
            JSONObject ubicacion = results.getJSONObject(0);
            direccion = ubicacion.getString("formatted_address");
            Toast.makeText(this, direccion, Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
