package com.android.newseh.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.PopupMenu;

import com.android.newseh.R;
import com.android.newseh.interfaces.FragmentActionListener;
import com.android.newseh.modules.Login.view.LoginActivity;
import com.android.newseh.modules.News.view.NewsFragment;
import com.android.newseh.modules.Saved.view.SavedFragment;
import com.android.newseh.modules.Search.view.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements FragmentActionListener, BottomNavigationView.OnNavigationItemSelectedListener, PopupMenu.OnMenuItemClickListener {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        changesFragment(new NewsFragment());

        bottomNavigationView = findViewById(R.id.home_bottom_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void changesFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.home_container_id, fragment);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.home_bottom_id){
            changesFragment(new NewsFragment());
        } else if (id == R.id.saved_bottom_id){
            changesFragment(new SavedFragment());
        } else if (id == R.id.search_bottom_id){
            changesFragment(new SearchFragment());
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item){
        if (item.getItemId() == R.id.item_log_out) {
            signOut();
        }
        return super.onOptionsItemSelected(item);
    }

    private void signOut() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}