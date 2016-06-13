package com.inspired.manically.a2dplatformer;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.inspired.manically.a2dplatformer.IntroLogos.GameLogoScreenView;
import com.inspired.manically.a2dplatformer.IntroLogos.LogoScreenView;

/**
 * Created by Tim on 05/05/2016.
 */
public class MainActivity extends Activity {

    View currentView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        LogoScreenView lsv = new LogoScreenView(this,this);
        setContentView(lsv);
        currentView = lsv;
    }

    public void changeToGameLogo(){
        Log.v("test", "testing shit");

        GameLogoScreenView glsv = new GameLogoScreenView(this);
        setContentView(glsv);
        currentView = glsv;
    }
}
