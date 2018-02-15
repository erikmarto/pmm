package com.example.erik.proyectofinal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Dibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Dibujar(this));
    }
    //permite dibujar cualquier cosa
    public class Dibujar extends View {
        public Dibujar(Context context) {
            super(context);
        }

        float x=50;
        float y=50;
        String accion = "accion";
        Path path=new Path();

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        protected void onDraw(Canvas canvas) {

            Paint tactil= new Paint();

            tactil.setColor(Color.BLACK);
            tactil.setStrokeWidth(15);
            tactil.setStyle(Paint.Style.STROKE);

            if(accion=="down"){
                path.moveTo(x,y);
            }

            if(accion=="move"){
                path.lineTo(x,y);

            }
            canvas.drawPath(path,tactil);

        }

        public boolean onTouchEvent(MotionEvent e){
            x=e.getX();
            y=e.getY();

            if (e.getAction()==MotionEvent.ACTION_DOWN){
                accion="down";
            }
            if (e.getAction()==MotionEvent.ACTION_MOVE){
                accion="move";
            }
            invalidate();
            return true;
        }
    }
}
