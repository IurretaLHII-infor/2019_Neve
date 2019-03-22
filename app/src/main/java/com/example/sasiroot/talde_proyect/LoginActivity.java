package com.example.sasiroot.talde_proyect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Date;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    private final static int REQUEST_SETTINGS = 0;
    private final static int REQUEST_THEMES = 1;
    private final static int REQUEST_LANGUAGES = 2;
    private EditText password;
    private EditText username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.password = this.findViewById(R.id.password);
        this.username = this.findViewById(R.id.username);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.settingsMenuOption:
                Intent i = new Intent(this, SettingsActivity.class);

                this.startActivityForResult(i, LoginActivity.REQUEST_SETTINGS);
                break;


            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_CANCELED) return;

        switch (requestCode) {

            case LoginActivity.REQUEST_THEMES:
                Bundle extras = data.getExtras();
                String theme = extras.get("theme").toString();

                SharedPreferences prefered = this.getSharedPreferences("PREFERED", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefered.edit();
                editor.putString("THEME",theme);
                editor.commit();
                this.recreate();
                break;
            case LoginActivity.REQUEST_LANGUAGES:
                extras = data.getExtras();
                Resources res = this.getResources();
                Configuration config = res.getConfiguration();
                config.locale = new Locale(extras.get("LANG").toString());
                res.updateConfiguration(config, res.getDisplayMetrics());
                this.recreate();
                break;





            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }


    }

