package com.example.erigom.dibujoscanvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private  BitmapDrawable miImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
            Resources res = contexto.getResources();
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.logo);
            miImagen.setBounds(new Rect(790, 500, 290, 1100));
        }
        @Override
        protected void onDraw(Canvas canvas) {

            Paint pincel = new Paint();
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(20);
            pincel.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(1000, 1500, 80, 40,pincel);
            pincel.setColor(Color.WHITE);
            canvas.drawCircle(540, 800, 380, pincel);
            miImagen.draw(canvas);
            pincel.setColor(Color.RED);
            pincel.setStrokeWidth(10);
            canvas.drawCircle(540, 800, 15, pincel);
            canvas.drawLine(150, 800, 930, 800, pincel);
            canvas.drawLine(540, 1190, 540, 410, pincel);
        }
    }
}
