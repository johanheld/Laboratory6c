package com.example.johan.laboratory6c;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by johan on 2017-10-17.
 */

public class ColorTextView extends android.support.v7.widget.AppCompatTextView
{
    public ColorTextView(Context context)
    {
        super(context);
    }

    public ColorTextView (Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void colorize()
    {
        new Task().execute();
    }

    private class Task extends AsyncTask<Void, Integer, Void>
    {
        int n = 0;
        Random rand = new Random();

        @Override
        protected Void doInBackground(Void... params)
        {
            while (n < 10)
            {
                int r = rand.nextInt();
                int g = rand.nextInt();
                int b = rand.nextInt();
                int color = Color.argb(255, r, g, b);
                Log.d("COLOR", " " + color);
                publishProgress(color);
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                n++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            int color = values[0];
            setBackgroundColor(color);
        }
    }
}
