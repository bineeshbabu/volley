package com.phacsin.volleylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.phacsin.easyvolley.JsonParserVolley;
import com.phacsin.easyvolley.VolleyCallback;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonParserVolley jsonParserVolley = new JsonParserVolley(this);
        jsonParserVolley.addurl("http://www.gmeducom.com/api/login");
        jsonParserVolley.addmethod(Request.Method.POST);
        // jsonParserVolley.addHeader("Authorization", "re123");
        jsonParserVolley.addBody("username","bineesh");
        jsonParserVolley.addBody("password","123456789");
        jsonParserVolley.executeRequest( new VolleyCallback() {
                    @Override
                    public void getResponse(String response) {
                        String jObject = response;
                        Toast.makeText(getApplicationContext(), jObject, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failedresponse(String message) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}
