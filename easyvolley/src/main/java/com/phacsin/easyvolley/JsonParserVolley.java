package com.phacsin.easyvolley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class  JsonParserVolley {
        final String contentType = "application/json; charset=utf-8";
        String JsonURL = "http://www.gmeducom.com/api/login";
        Context context;
        RequestQueue requestQueue;
        String jsonresponse;
        static int METHOD;
        private Map<String, String> header;
        private Map<String, String> body;
        private String URL;
    public JsonParserVolley(Context context) {
            this.context = context;
            requestQueue = Volley.newRequestQueue(context);
            header = new HashMap<>();
            body = new HashMap<>();

        }
        public void addHeader(String key, String value) {
            header.put(key, value);
        }
        public void addBody(String key,String value){
            body.put(key,value);
        }
        public void addurl(String url){
            URL = url;
        }
        public void addmethod(int method){
            METHOD = method;
        }
        public void executeRequest( final VolleyCallback callback) {

            StringRequest stringRequest = new StringRequest(METHOD, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    jsonresponse = response;
                    callback.getResponse(jsonresponse);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String error_message = String.valueOf(error);
                    callback.failedresponse(error_message);
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {

                    return header;
                }
                @Override
                protected Map<String, String> getParams() {
                    return body;
                }
            };
            requestQueue.add(stringRequest);

        }
}
