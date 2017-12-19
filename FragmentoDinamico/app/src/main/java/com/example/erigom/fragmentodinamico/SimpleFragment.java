package com.example.erigom.fragmentodinamico;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SimpleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SimpleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {
    int mNum;
    static SimpleFragment newInstance(int number) {
        SimpleFragment f = new SimpleFragment();
        Bundle args = new Bundle();
        args.putInt("num", number);
        f.setArguments(args);
        return f;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments().getInt("num");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = null;
        View tv = null;
        if (mNum % 2 == 0){
            v = inflater.inflate(R.layout.fragment_simple, container, false);
            tv = v.findViewById(R.id.text);            }
        else{
            v = inflater.inflate(R.layout.fragment_simple2 , container, false);
            tv = v.findViewById(R.id.text2);            }

        ((TextView)tv).setText("Fragmento nÃºmero #" + mNum);
        return v;
    }
}
