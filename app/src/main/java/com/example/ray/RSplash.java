package com.example.ray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class RSplash extends AppCompatActivity {

    ImageView fondo;
    ImageView logo;
    TextView tvRay;
    TextView tvEslogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsplash);

        logo = findViewById(R.id.ivLogo);
        tvRay = findViewById(R.id.tvTitulo);
        tvEslogan = findViewById(R.id.tvEslogan);
        fondo = findViewById(R.id.ivPinkclouds);

        Glide.with(this)
                .load(R.drawable.pinkclouds)
                .apply(new RequestOptions()
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(fondo);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);

        tvRay.startAnimation(myanim);
        AbrirAnim(true);

    }

    private void AbrirAnim(boolean b) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(RSplash.this, RLogin.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
