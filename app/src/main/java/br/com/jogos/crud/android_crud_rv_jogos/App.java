package br.com.jogos.crud.android_crud_rv_jogos;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Mescla on 14/03/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

    }
}
