package com.example.assignmentdmsl;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity<firstVisibleInListview> extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;

    //This is Dummy Data Set for Each element I'm using Arrays to retrieve data to Title, Description and Images
    String[] TitleList = {"Pandula", "Dananjaya", "Mandawala","Amarabandu","Rupasinghe"};
    String[] TitleDescription = {"Lorem Ipsum is simply dummy text of the printing and typesetting industry.","Description Dananjaya","Description Mandawala","Description Amarabandu","Description Rupasinghe"};
    int[] ImageList = {R.drawable.picture1,R.drawable.picture2,R.drawable.picture3,R.drawable.picture4,R.drawable.picture5};

    private BottomAppBar mbottomAppBar;
    private ConstraintLayout mbottomSheet;
    private BottomSheetBehavior mbottomSheetBehavior;
    //Moving Second Page
    private ImageView move;

    private View bsview;
    Animation slide_down;




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Moving Second Page
        move = findViewById(R.id.imageView1);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second.class);
                startActivity(intent);
            }
        });

        //Recycle View Config
        recyclerView = findViewById(R.id.rvProgram);
        recyclerView.setHasFixedSize(true);
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        ProgramAdapter programAdapter = new ProgramAdapter(this, TitleList,TitleDescription,ImageList);
        recyclerView.setAdapter(programAdapter);

        //Config step down when scrolling inthe recycler view
        final ConstraintLayout constraintLayout;
        constraintLayout = findViewById(R.id.bottom_sheet);


        final View bottomSheet = findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);



        //Bottom Sheet Configs
        bsview = findViewById(R.id.bottom_sheet);
        mbottomSheet = findViewById(R.id.bottom_sheet);
        mbottomAppBar = findViewById(R.id.bottomAppBar);
        mbottomSheetBehavior = BottomSheetBehavior.from(mbottomSheet);
        mbottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });



        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if(oldScrollX != 0 || oldScrollY !=0) {

                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bsview);
//                  TransitionManager.beginDelayedTransition(mbottomSheet);
                    bottomSheetBehavior.setPeekHeight(1050);

                }
                Log.d("X", "onScrollChange: "+oldScrollX);
                Log.d("Y", "onScrollChange: "+oldScrollY);
            }

        });
    }
}
