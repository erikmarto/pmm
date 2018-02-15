package com.example.erik.proyectofinal;

/**
 * Created by erik on 15/02/2018.
 */

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoDinamico.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentoDinamico extends Fragment {

    Integer[] id;
    Button aceptar, cancelar, comprar;
    Activity activity;
    RelativeLayout layout;
    TextView nombre, estilo, clase, precio, caja, radio;
    DataBaseHelper acce_DB;
    private OnFragmentInteractionListener mListener;


    public FragmentoDinamico() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragmento_dinamico, container, false);

        aceptar = (Button) view.findViewById(R.id.confirmar_compra);
        cancelar = (Button) view.findViewById(R.id.cancelar_compra);
        comprar = (Button) view.findViewById(R.id.boton_comprar);
        layout = (RelativeLayout) view.findViewById(R.id.layout_fragment);

        nombre = (TextView) view.findViewById(R.id.accesorio_nombre);
        estilo = (TextView) view.findViewById(R.id.accesorio_estilo);
        clase = (TextView) view.findViewById(R.id.accesorio_clase);
        precio = (TextView) view.findViewById(R.id.accesorio_precio);
        caja = (TextView) view.findViewById(R.id.resultado_caja);
        radio = (TextView) view.findViewById(R.id.resultado_pago);

        final EditText usuario = (EditText) view.findViewById(R.id.verificar_usuario);

        final Bundle mibundle = this.getArguments();
        final Accesorios accesorio = (Accesorios) mibundle.getSerializable("informacion");

        nombre.setText("Nombre: " + accesorio.getNombre());
        estilo.setText("Estilo: " + accesorio.getEstilo());
        clase.setText("Clase: " + accesorio.getClase());
        precio.setText("Precio: " + accesorio.getPrecio() + " €/Unidad");
        caja.setText("Plataformas: ");

        if (this.getArguments().getBoolean("boolean1") == true) {
            caja.setText(caja.getText() + this.getArguments().getString("caja_regalo"));
        }
        if (this.getArguments().getBoolean("boolean2") == true) {
            caja.setText(caja.getText() + "  " + this.getArguments().getString("caja_internet"));
        }
        if (this.getArguments().getBoolean("boolean3") == true) {
            caja.setText(caja.getText() + "  " + this.getArguments().getString("caja_recoger"));
        }

        radio.setText(this.getArguments().getString("grupo"));


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity = getActivity();
                Toast.makeText(activity, "GRACIAS POR LA COMPRA", Toast.LENGTH_LONG).show();


                layout.setVisibility(View.INVISIBLE);

                acce_DB = new DataBaseHelper(getActivity().getApplicationContext(), "Usuarios", null, 1);

                SQLiteDatabase bd = acce_DB.getWritableDatabase();


                //PROBAR EN VEZ DE ESCRIBIR, PRIMERO LEER EL ID, Y DESPUES ESCRIBIRLO

                Cursor cursor = bd.rawQuery("SELECT id FROM Usuarios where usuario= '" + mibundle.getString("usuario") + "';", null);

                id = new Integer[cursor.getCount()];
                //  empieza el recorrido desde el principio
                if (cursor.moveToFirst()) {
                    do {
                        String ids = cursor.getString(0);
                        id[0] = Integer.parseInt(ids);
                    } while (cursor.moveToNext());
                    try {
                        bd.execSQL("INSERT INTO Ventas (usuarios,Nombre,Estilo,Clase,Precio,Plataforma,Forma_pago) VALUES" +
                                " ('" + id[0] + "','" + accesorio.getNombre() + "','" + accesorio.getEstilo() + "','" + accesorio.getClase() + "','" + accesorio.getPrecio() + "','" + caja.getText() + "','" + radio.getText() + "')");

                        Toast.makeText(getActivity().getApplicationContext(), "REGISTRO COMPLETADO", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.getMessage();

                    }
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.setVisibility(View.INVISIBLE);

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
