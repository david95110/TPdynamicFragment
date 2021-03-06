package com.example.tpdynamicfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction().add(R.id.frame,fragment1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fragment1:
                if (!fragment1.isVisible())
                    getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,fragment1)
                        .addToBackStack(null)
                        .commit();
                return true;
            case R.id.fragment2:
                if (!fragment2.isVisible())
                    getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame,fragment2)
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void create(MenuItem item) {
        Toast.makeText(this, "Bonjour drawer", Toast.LENGTH_SHORT).show();
    }
}












