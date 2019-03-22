package com.example.sasiroot.talde_proyect;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

    private Spinner selector;
    private Spinner select;
    private String[] locales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.setTitle("Ajustes");
        this.selector = this.findViewById(R.id.spinner);
        this.select = this.findViewById(R.id.spinner2);

        Configuration config = this.getResources().getConfiguration();

        int pos = 0;
        this.locales = new String[]{"eu", "es", "en"};

        String[] names = new String[3];
        for (int i = 0; i < locales.length; i++) {
            Locale locale = new Locale(locales[i]);
            names[i] = locale.getDisplayLanguage(config.locale);
            if (locales[i].equals(config.locale.getLanguage())) {
                pos = i;
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        this.selector.setAdapter(adapter);
        this.selector.setSelection(pos);
    }

    public void cancel(View view) {
        finish();
    }


    public void save(View view) {
        Intent i = this.getIntent();
        int pos = this.selector.getSelectedItemPosition();
        i.putExtra("LANG", this.locales[pos]);

        i.putExtra("theme", this.select.getSelectedItem().toString());


        this.setResult(RESULT_OK, i);



        finish();


    }
}
