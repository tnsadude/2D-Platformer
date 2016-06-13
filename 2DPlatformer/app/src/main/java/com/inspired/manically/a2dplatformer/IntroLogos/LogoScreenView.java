package com.inspired.manically.a2dplatformer.IntroLogos;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import com.inspired.manically.a2dplatformer.MainActivity;
import com.inspired.manically.a2dplatformer.R;

import java.sql.Time;

/**
 * Created by Tim on 05/05/2016.
 */
public class LogoScreenView extends View {

    private Context mycontext;
    private MainActivity main;

    private Bitmap logo;
    private long current = 0;

    public LogoScreenView(Context context, MainActivity main) {
        super(context);
        mycontext = context;
        this.main = main;

        //Get logos from assets
        logo = BitmapFactory.decodeResource(mycontext.getResources(), R.drawable.manically_inspired_logo);
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        long start = System.currentTimeMillis();

        //animation stuff
        canvas.drawBitmap(logo,null,new Rect(canvas.getWidth()/4,canvas.getHeight()/4,canvas.getWidth()-canvas.getWidth()/4,canvas.getHeight()-canvas.getHeight()/4),null);

        long end = System.currentTimeMillis();
        long duration = end - start;
        //keep to 60fps
        if (duration < 16){
            try {
                Thread.sleep(16-duration);
            } catch (InterruptedException e){}
        }
        current += 16;

        //once complete change view
        if (current >= 5000){
            main.changeToGameLogo();
        }

        invalidate();
    }
}
