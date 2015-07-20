package com.appnucleus.volleylibraryillustrativeexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_Main extends Activity implements OnClickListener
{
    private Button btnJson, btnString, btnImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnString = (Button) findViewById(R.id.btnStringRequest);
        btnJson = (Button) findViewById(R.id.btnJsonRequest);
        btnImage = (Button) findViewById(R.id.btnImageRequest);

        // button click listeners
        btnString.  setOnClickListener(this);
        btnJson.    setOnClickListener(this);
        btnImage.   setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnStringRequest:
                startActivity(new Intent(Activity_Main.this,
                        Activity_StringRequest.class));
                break;
            case R.id.btnJsonRequest:
                startActivity(new Intent(Activity_Main.this,
                        Activity_JsonRequest.class));
                break;
            case R.id.btnImageRequest:
                startActivity(new Intent(Activity_Main.this,
                        Activity_ImageRequest.class));
                break;
            default:
                break;
        }
    }
}
