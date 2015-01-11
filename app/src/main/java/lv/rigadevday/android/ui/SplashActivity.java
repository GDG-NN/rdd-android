package lv.rigadevday.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;

import java.io.IOException;

import lv.rigadevday.android.R;
import lv.rigadevday.android.infrastructure.db.DataImportHelper;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new DatabaseImportOperation().execute();
    }

    private class DatabaseImportOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
            if (!preferences.getBoolean("importDone", false)) {
                try {
                    DataImportHelper.importFromAsset(SplashActivity.this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                preferences.edit().putBoolean("importDone", true).commit();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }
    }
}