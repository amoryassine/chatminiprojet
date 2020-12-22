package com.miniprojet.miniprojet;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        // action et its titre
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");
    }
}