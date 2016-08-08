package com.nanodegree.builditbigger;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.nanodegree.builditbigger.backend.myApi.model.MyBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JokeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JokeFragment extends Fragment implements LoadingInterface {
    JokeInterface jokeInterface;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @OnClick(R.id.btnJoke)
    public void btnJokeClick()
    {
        JokeLoader loader = new JokeLoader();
        loader.setCallback(mCallback);
        loader.execute();

    }
    public JokeFragment() {
        // Required empty public constructor
    }


    public static JokeFragment newInstance() {
        JokeFragment fragment = new JokeFragment();
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_joke, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        jokeInterface = (JokeInterface)context;
    }


    @Override
    public void showLoading()
    {
        progressBar.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideLoading()
    {
        progressBar.setVisibility(View.GONE);
    }

    private String mJokeText;
    private JokeLoader.LoaderCallback mCallback = new JokeLoader.LoaderCallback() {
        @Override
        public void onPreExecute() {
            showLoading();
        }

        @Override
        public void onPostExecute(MyBean myBean) {
            progressBar.setVisibility(View.GONE);
            if (myBean == null) {
                jokeInterface.displayFailedMessage();
            } else {
                mJokeText = myBean.getData();
                displayJoke(mJokeText);
            }
        }
    };
    public void displayJoke(String joke)
    {
            hideLoading();
            jokeInterface.renderJoke(joke);

    }
}
