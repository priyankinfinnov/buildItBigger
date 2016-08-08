package com.nanodegree.builditbigger;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.nanodegree.builditbigger.backend.myApi.MyApi;
import com.nanodegree.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

/**
 * Created by yogeshmadaan on 21/02/16.
 */
public class JokeEndpointManager {

    private static JokeEndpointManager sEndpoint;

    public static JokeEndpointManager getInstance() {
        if (sEndpoint == null) {
            sEndpoint = new JokeEndpointManager();
        }

        return sEndpoint;
    }

    private MyApi mService;

    public JokeEndpointManager() {

        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        if (Constants.isProduction()){
            builder.setRootUrl(Constants.ENDPOINT_PRODUCTION_ROOT_URL);
        }else{
            builder.setRootUrl(Constants.ENDPOINT_ROOT_URL);
        }

        mService = builder.build();
    }

    public MyBean getJoke() throws IOException {
        return mService.getJoke().execute();
    }



}