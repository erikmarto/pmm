package com.example.erigom.examenev2;

import android.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public  class SimpleFragment extends Fragment {
    private static final java.lang.String ARG_PARAM = "";
    TextView item = null;
    TextView place = null;
    TextView description = null;
    TextView importance = null;
    TextView id = null;
    int mParam1_num;

    static SimpleFragment newInstance(int param1) {
        SimpleFragment f = new SimpleFragment();
        // Mantenemos el nÃºmero para usarlo en cualquier momento.
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, param1);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParam1_num = getArguments().getInt(ARG_PARAM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v  = null;
        View tv  = null;
        // dependiendo de si es par o impar mostramos distintos layouts
        v = inflater.inflate(R.layout.fragment_simple, container, false);
        tv = v.findViewById(R.id.text);

        ((TextView)tv).setText("Fragmento nº" + mParam1_num);
        item = (TextView)v.findViewById(R.id.item);
        place = (TextView)v.findViewById(R.id.place);
        description  = (TextView)v.findViewById(R.id.description);
        importance  = (TextView)v.findViewById(R.id.importance);
        id = (TextView)v.findViewById(R.id.identificator);
        populateFieldsFromDB(mParam1_num);

        return v;
    }
    private void populateFieldsFromDB(int numTarea) {
        try {
            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(numTarea);
            if (c.moveToFirst()) {
                item.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_ITEM)));
                place.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_PLACE)));
                description.setText(c.getString(2));
            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
