package com.ensa.marhbabik;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ImageView profilePicture = findViewById(R.id.profile_picture);
        profilePicture.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
            startActivity(intent);
        });

        LinearLayout guideLayout = findViewById(R.id.guide);
        guideLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GuideActivity.class);
            startActivity(intent);
        });

        LinearLayout chooseOptionLayout = findViewById(R.id.chooseOption);
        chooseOptionLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChoixfiliereActivity.class);
            startActivity(intent);
        });

        LinearLayout OptionListLayout = findViewById(R.id.option_list);
        OptionListLayout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OptionListActivity.class);
            startActivity(intent);
        });
    }
}
