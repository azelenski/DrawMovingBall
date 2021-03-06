package com.example.ealezel.drawmovingball.classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

import com.example.ealezel.drawmovingball.R;

/**
 * Created by ealezel on 28.10.2015.
 */
public class DrawScene extends View {


    private Paint canvasPaint;

    private int x;
    private int y;
    private int fixed_x;
    private int fixed_y;
    private int circleRadius;

    private int dx = 10;
    private int dy = 10;
    private final int FRAME_RATE = 30;

    private int scene_width;
    private int scene_height;

    Bitmap ballImage;
    Bitmap scaledBitmap;

    private Handler h;

    public DrawScene(Context context, int start_x, int start_y) {
        super(context);
        fixed_x = start_x;
        fixed_y = start_y;
        x = start_x;
        y = start_y;

        canvasPaint = new Paint();
        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.YELLOW);

        ballImage = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        scaledBitmap = Bitmap.createScaledBitmap(ballImage, 100, 100, false);

        h = new Handler();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas sceneCanvas) {
        super.onDraw(sceneCanvas);

        sceneCanvas.drawPaint(canvasPaint);
        scene_width = this.getWidth();
        scene_height = this.getHeight();

        //sceneCanvas.drawCircle(x, y, circleRadius, circlePaint);


        sceneCanvas.drawBitmap(scaledBitmap, x - fixed_x, y - fixed_y, null);
        circleRadius = scaledBitmap.getWidth() / 2;

        x += dx;
        y += dy;

        if ((x > scene_width - circleRadius) || (x < circleRadius)) {
            dx = dx * -1;
        }

        if ((y > scene_height - circleRadius) || (y < circleRadius)) {
            dy = dy * -1;
        }

        h.postDelayed(r, FRAME_RATE);
    }
}