package com.example.ealezel.drawmovingball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ealezel.drawmovingball.classes.DrawScene;

public class StartUpWindow extends AppCompatActivity {

    private int start_x =50;
    private int start_y =50;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_window);
        DrawScene scene = new DrawScene(this, start_x, start_y);
        setContentView(scene);
    }
}
