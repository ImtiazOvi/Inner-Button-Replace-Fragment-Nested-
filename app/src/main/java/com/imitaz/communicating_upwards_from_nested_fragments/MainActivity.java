package com.imitaz.communicating_upwards_from_nested_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewReplaceInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repliseFragment(new Fragment_A());

    }

    @Override
    public void currentView(String string) {
        repliseFragment(new Fragment_B());

        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }


    public void repliseFragment(Fragment fragment) {

        FragmentTransaction transaction = ((MainActivity) this).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_id, fragment).commit();

    }
}
