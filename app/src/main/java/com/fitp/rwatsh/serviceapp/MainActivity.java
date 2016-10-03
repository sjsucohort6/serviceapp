package com.fitp.rwatsh.serviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.downloadButton);


        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PDFDownloadService.class);
                try {
                    final String pdf1Text = ((EditText) findViewById(R.id.pdf1EditText)).getText().toString();
                    final String pdf2Text = ((EditText) findViewById(R.id.pdf2EditText)).getText().toString();
                    final String pdf3Text = ((EditText) findViewById(R.id.pdf3EditText)).getText().toString();
                    final String pdf4Text = ((EditText) findViewById(R.id.pdf4EditText)).getText().toString();
                    final String pdf5Text = ((EditText) findViewById(R.id.pdf5EditText)).getText().toString();

                    URL[] urls = new URL[]{
                            new URL(pdf1Text),
                            new URL(pdf2Text),
                            new URL(pdf3Text),
                            new URL(pdf4Text),
                            new URL(pdf5Text)};
                    intent.putExtra("URLs", urls);
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                startService(intent);
            }
        });
    }
}
