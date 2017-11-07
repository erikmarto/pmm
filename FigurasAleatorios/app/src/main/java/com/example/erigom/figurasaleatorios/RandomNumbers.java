package com.example.erigom.figurasaleatorios;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RandomNumbers extends View {
    private Paint[] mForegrounds =
            { makePaint(Color.BLACK), makePaint(Color.BLUE),makePaint(Color.GREEN), makePaint(Color.RED)};
    private int mNumbers;
    private Bitmap[] mPics =
            { makeBitmap(R.drawable.fotograma1),
                    makeBitmap(R.drawable.fotograma2),
                    makeBitmap(R.drawable.fotograma3)};

    public RandomNumbers (Context context) {
        super(context);
    }
    public RandomNumbers (Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int avgShapeWidth = viewWidth/5;
        for(int i=0; i<20; i++) {
            drawRandomNumbers(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawRandomBitmap(canvas, viewWidth, viewHeight);
        }
    }
    private Paint makePaint(int color) {
        Paint p = new Paint();
        p.setColor(color);
        return(p);
    }

    private Bitmap makeBitmap(int bitmapId) {
        return(BitmapFactory.decodeResource(getResources(), bitmapId));
    }
    private void drawRandomBitmap(Canvas canvas, int viewWidth,
                                  int viewHeight) {
        float left = RandomUtils.randomFloat(viewWidth);
        float top = RandomUtils.randomFloat(viewHeight);
        Bitmap pic = RandomUtils.randomElement(mPics);
        canvas.drawBitmap(pic, left, top, null);
    }
    private void drawRandomNumbers(Canvas canvas, int viewWidth,
                                int viewHeight, int avgShapeWidth) {
        float x = RandomUtils.randomFloat(viewWidth);
        float y = RandomUtils.randomFloat(viewHeight);
        float numberSize = RandomUtils.randomFloat(avgShapeWidth);
        Paint numberPaint = RandomUtils.randomElement(mForegrounds);
        numberPaint.setTextSize(numberSize);
        mNumbers = (int)(Math.random() *10) + 1;
        canvas.drawText(String.valueOf(mNumbers), x, y, numberPaint);
    }
}
