package com.nanodegree.builditbigger;

import android.test.AndroidTestCase;

import com.nanodegree.builditbigger.backend.myApi.model.MyBean;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yogeshmadaan on 21/02/16.
 */
public class TestAsyncTask extends AndroidTestCase {

    public void testAsyncTask() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        JokeLoader loader = new JokeLoader();
        loader.setCallback(new JokeLoader.LoaderCallback() {
            @Override
            public void onPreExecute() {}

            @Override
            public void onPostExecute(MyBean myBean) {
                assertNotNull(myBean.getData());
                latch.countDown();
            }
        });

        loader.execute();
        latch.await();
    }
}
