package com.example.firsttry.view;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.firsttry.R;

public class AnimationActivity extends AppCompatActivity {

    Animation anim=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        Button alpha=findViewById(R.id.alpha);
        Button scale=findViewById(R.id.scale);
        Button rotate=findViewById(R.id.rotate);
        Button translate=findViewById(R.id.translate);
        Button allAnimation=findViewById(R.id.all);
        Button allAnimationFifo=findViewById(R.id.allFifo);

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlphaAnimation();
            }
        });
        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScaleAnimation();
            }
        });
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRotateAnimation();
            }
        });
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTranslateAnimation();
            }
        });
        allAnimationFifo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllFifoAnimation();
            }
        });
        allAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAllAnimation();
            }
        });
    }

    private  void startAlphaAnimation(){

        anim= AnimationUtils.loadAnimation(this,R.anim.alpha);
        LinearLayout animationTarget=findViewById(R.id.animationTarget);
        animationTarget.startAnimation(anim);
    }

    private  void startScaleAnimation(){
        anim= AnimationUtils.loadAnimation(this,R.anim.scale);
        LinearLayout animationTarget=findViewById(R.id.animationTarget);
        animationTarget.startAnimation(anim);
    }
    private  void startRotateAnimation(){
        anim= AnimationUtils.loadAnimation(this,R.anim.rotate);
        LinearLayout animationTarget=findViewById(R.id.animationTarget);
        animationTarget.startAnimation(anim);
    }
    private  void startTranslateAnimation(){
        anim= AnimationUtils.loadAnimation(this,R.anim.translate);
        LinearLayout animationTarget=findViewById(R.id.animationTarget);
        animationTarget.startAnimation(anim);

    }
    private  void startAllAnimation(){
        LinearLayout animationTarget=findViewById(R.id.animationTarget);
        ObjectAnimator animation = ObjectAnimator.ofFloat(animationTarget, "translationX", 100f);
        ObjectAnimator animation5 = ObjectAnimator.ofFloat(animationTarget, "translationY", 100f);
        ObjectAnimator animation1= ObjectAnimator.ofFloat( animationTarget,"alpha", 1f, 0.5f);
        ObjectAnimator animation2= ObjectAnimator.ofFloat( animationTarget,"rotation", 0,360);
        ObjectAnimator animation3= ObjectAnimator.ofFloat( animationTarget,"scaleX", 0,1);
        ObjectAnimator animation4= ObjectAnimator.ofFloat( animationTarget,"scaleY", 0,1);
        AnimatorSet bouncer = new AnimatorSet();
        bouncer.play(animation).with(animation1);
        bouncer.play(animation1).with(animation2);
        bouncer.play(animation2).with(animation3);
        bouncer.play(animation3).with(animation4);
        bouncer.play(animation4).with(animation5);
        bouncer.setDuration(2000);
        bouncer.start();

    }

 private   void startAllFifoAnimation(){
        LinearLayout animationTarget=findViewById(R.id.animationTarget);
     ObjectAnimator animation = ObjectAnimator.ofFloat(animationTarget, "translationX", 100f);
     ObjectAnimator animation5 = ObjectAnimator.ofFloat(animationTarget, "translationY", 100f);
     ObjectAnimator animation1= ObjectAnimator.ofFloat( animationTarget,"alpha", 1f, 0f);
     ObjectAnimator animation2= ObjectAnimator.ofFloat( animationTarget,"rotation", 0,360);
     ObjectAnimator animation3= ObjectAnimator.ofFloat( animationTarget,"scaleX", 0,1);
     ObjectAnimator animation4= ObjectAnimator.ofFloat( animationTarget,"scaleY", 0,1);
     AnimatorSet bouncer = new AnimatorSet();
     bouncer.play(animation).before(animation1);
     bouncer.play(animation5).before(animation2);
     bouncer.play(animation2).before(animation3);
     bouncer.play(animation3).before(animation4);
     bouncer.play(animation4).before(animation1);
     bouncer.setDuration(2000);
     bouncer.start();
    };
}