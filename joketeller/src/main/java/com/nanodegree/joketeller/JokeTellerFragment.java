package com.nanodegree.joketeller;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JokeTellerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JokeTellerFragment extends Fragment {

    public static final String KEY_JOKE = "joke";
    public JokeTellerFragment() {
        // Required empty public constructor
    }

    public static JokeTellerFragment newInstance() {
        JokeTellerFragment fragment = new JokeTellerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_joke_teller, container, false);
        Intent i = getActivity().getIntent();
        if (i != null && i.hasExtra(KEY_JOKE)) {
            TextView tv = (TextView) rootView.findViewById(R.id.joke);
            tv.setText(i.getStringExtra(KEY_JOKE));
        }
        return rootView;
    }

}
