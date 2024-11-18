package com.example.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.navigation.databinding.FragmentTabbed1Binding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Tabbed1Fragment extends Fragment {
    private FragmentTabbed1Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTabbed1Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            // retorna el fragment que se debe mostrar en función de la posición de la página.
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0:
                        return new Tabbed1AFragment();
                    case 1:
                        return new Tabbed1BFragment();
                    case 2:
                        return new Tabbed1CFragment();
                    default:
                        return new Tabbed1AFragment();
                }
            }

            @Override
            public int getItemCount() {
                // retorna el número de páginas que debe tener el viewPager.
                return 3;
            }
        });

        // vinculamos el TabLayout con el ViewPager2
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("TAB A");
                        break;
                    case 1:
                        tab.setText("TAB B");
                        break;
                    case 2:
                        tab.setText("TAB C");
                        break;
                    default:
                        tab.setText("TAB A");
                        break;
                }
            }
        }).attach();
    }
}