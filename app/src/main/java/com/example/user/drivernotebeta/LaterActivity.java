package com.example.user.drivernotebeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import android.os.Environment;
import android.util.Log;
import android.view.View;

public class LaterActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    final String FILENAME = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_later );
    }
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                writeFile();
                break;
            case R.id.btnRead:
                readFile();
                break;
        }
    }

    void writeFile() {
        try {
            // отрываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(FILENAME, MODE_PRIVATE)));
            // пишем данные
            bw.write("Тут рыбы нет");
            // закрываем поток
            bw.close();
            Log.d(LOG_TAG, "Файл записан");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFile() {
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput(FILENAME)));
            String str = "";
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
