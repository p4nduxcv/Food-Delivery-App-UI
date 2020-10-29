package com.example.assignmentdmsl;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

class ProgressButton {
    private CardView cardView;
    private ProgressBar progressBar;
    private ConstraintLayout constraintLayout;
    Animation fade_in;
    ProgressButton(Context ct, View view) {
    cardView = view.findViewById(R.id.cardView);
    progressBar = view.findViewById(R.id.progressBar2);
    constraintLayout = view.findViewById(R.id.constraint_layout);
    }
    void ButtonActivated () {
        progressBar.setVisibility(View.VISIBLE);
    }
    void ButtonFinished () {
        constraintLayout.setBackgroundColor(cardView.getResources().getColor(R.color.design_default_color_error));
        progressBar.setVisibility(View.GONE);
    }
}
