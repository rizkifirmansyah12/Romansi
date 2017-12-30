package com.example.compaq.romansi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.compaq.romansi.app.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    ProgressDialog pDialog;
    Button btnRegister,btnlogin;
    EditText etNamauser, etpasswordreg,etconfirmpass;

    RadioButton radioadmin,radioclient,radioconsul;
Intent intent;
    int success;
    ConnectivityManager conMgr;

    private String url = Server.URL + "registeruser.php";

    private static final String TAG = Register.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnlogin=(Button) findViewById(R.id.btnlogin);
        etNamauser = (EditText) findViewById(R.id.etNamauser);
        etpasswordreg = (EditText) findViewById(R.id.etpasswordreg);
        etconfirmpass = (EditText) findViewById(R.id.etconfirmpass);

        radioadmin = (RadioButton) findViewById(R.id.radioadmin);
        radioclient = (RadioButton) findViewById(R.id.radioclient);
        radioconsul = (RadioButton) findViewById(R.id.radioconsul);

        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent = new Intent(Register.this, Login.class);
                finish();
                startActivity(intent);
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               // TODO Auto-generated method stub
                                               String username = etNamauser.getText().toString();
                                               String password = etpasswordreg.getText().toString();
                                               String confirm_password = etconfirmpass.getText().toString();
                                               String admin = radioadmin.getText().toString();
                                               String client = radioclient.getText().toString();
                                               String consultan = radioconsul.getText().toString();

                                               if (conMgr.getActiveNetworkInfo() != null
                                                       && conMgr.getActiveNetworkInfo().isAvailable()
                                                       && conMgr.getActiveNetworkInfo().isConnected()) {
                                                   checkRegister(username, password, confirm_password, admin, client, consultan);
                                               } else {
                                                   Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                                               }
                                           }
                                       });
    }
    private void checkRegister(final String username, final String password, final String confirm_password, final String admin ,final String client, final String consultan) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Register ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {

                        Log.e("Successfully Register!", jObj.toString());

                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        etNamauser.setText("");
                        etpasswordreg.setText("");
                        etconfirmpass.setText("");
                        radioadmin.setText("admin");
                        radioclient.setText("client");
                        radioconsul.setText("konsultan");

                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                params.put("confirm_password", confirm_password);
                params.put("admin",admin);
                params.put("client",client);
                params.put("konsultan",consultan);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}