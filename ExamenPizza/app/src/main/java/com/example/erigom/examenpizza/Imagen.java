package com.example.erigom.examenpizza;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Imagen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujo(this));

    }

    public class Dibujo extends View {
        public Dibujo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {


            Paint curva = new Paint();
            Paint circulo = new Paint();


            curva.setColor(Color.BLACK);
            curva.setStrokeWidth(15);
            curva.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(500,400,50,circulo);
            canvas.drawCircle(800,400,50,circulo);
            canvas.drawCircle(200,400,50,circulo);
            canvas.drawRoundRect(1000,500,0,300,800,800,curva);

            Paint tactil = new Paint();

            tactil.setColor(Color.RED);
            tactil.setStrokeWidth(15);
            tactil.setStyle(Paint.Style.STROKE);

        }
    }
}
