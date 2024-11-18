package com.example.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.navigation.databinding.ActivityTabbedBinding;

public class TabbedActivity extends AppCompatActivity {

    private ActivityTabbedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Infla el diseño usando View Binding
        binding = ActivityTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura la Toolbar como ActionBar
        setSupportActionBar(binding.toolbar);

        // Obtiene el NavController del NavHostFragment
        NavController navController = ((NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment)).getNavController();

        // Vincula la Toolbar al NavController
        NavigationUI.setupWithNavController(binding.toolbar, navController);
    }
}