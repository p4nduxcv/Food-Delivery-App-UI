package com.example.assignmentdmsl;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

class ProgressButton {
    private CardView cardView;
    private ProgressBar progressBar;
    private ConstraintLayout constraintLayout;
    Animation fade_in;
    private TextView textView;
    ProgressButton(Context ct, View view) {
        fade_in = AnimationUtils.loadAnimation(ct, R.anim.fade_in);
    cardView = view.findViewById(R.id.cardView);
    progressBar = view.findViewById(R.id.progressBar2);
    constraintLayout = view.findViewById(R.id.constraint_layout);
    textView = view.findViewById(R.id.textView_button);
    }
    void ButtonActivated () {
        progressBar.setAnimation(fade_in);
        progressBar.setVisibility(View.VISIBLE);
        constraintLayout.setBackgroundColor(cardView.getResources().getColor(R.color.material_on_primary_disabled));
        textView.setAnimation(fade_in);
        textView.setText("");

    }
    void ButtonFinished () {
        constraintLayout.setAnimation(fade_in);
        constraintLayout.setBackgroundColor(cardView.getResources().getColor(R.color.colorPrimary));
        progressBar.setVisibility(View.GONE);
        textView.setAnimation(fade_in);
        textView.setText("Done");
    }
}
