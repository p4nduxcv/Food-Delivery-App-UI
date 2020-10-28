package com.example.assignmentdmsl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;

    //This is Dummy Data Set for Each element I'm using Arrays to retrieve data to Title, Description and Images
    String[] TitleList = {"Pandula", "Dananjaya", "Mandawala","Amarabandu","Rupasinghe"};
    String[] TitleDescription = {"Description Pandula","Description Dananjaya","Description Mandawala","Description Amarabandu","Description Rupasinghe"};
    int[] ImageList = {R.drawable.picture1,R.drawable.picture2,R.drawable.picture3,R.drawable.picture4,R.drawable.picture5};

    //Dummy Data Set for Service Lists and Images
    //String[] ServiceList = {"Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List","Service List"};
    //int [] ServiceIconList = {R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds,R.drawable.rounds};
    //Bottom sheet
    private BottomAppBar mbottomAppBar;
    private ConstraintLayout mbottomSheet;
    private BottomSheetBehavior mbottomSheetBehavior;

    //Moving Second Page
    private ImageView move;

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



        //Bottom Sheet Configs
        mbottomSheet = findViewById(R.id.bottom_sheet);
        mbottomAppBar = findViewById(R.id.bottomAppBar);
        mbottomSheetBehavior = BottomSheetBehavior.from(mbottomSheet);

        mbottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mbottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }
}
