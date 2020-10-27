package com.example.assignmentdmsl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;

    //This is Dummy Data Set for Each element I'm using Arrays to retrieve data to Title, Description and Images
    String[] TitleList = {"Pandula", "Dananjaya", "Mandawala","Amarabandu","Rupasinghe"};
    String[] TitleDescription = {"Description Pandula","Description Dananjaya","Description Mandawala","Description Amarabandu","Description Rupasinghe"};
    int[] ImageList = {R.drawable.picture1,R.drawable.picture2,R.drawable.picture3,R.drawable.picture4,R.drawable.picture5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvProgram);
        recyclerView.setHasFixedSize(true);
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        ProgramAdapter programAdapter = new ProgramAdapter(this, TitleList,TitleDescription,ImageList);
        recyclerView.setAdapter(programAdapter);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
    }
}
