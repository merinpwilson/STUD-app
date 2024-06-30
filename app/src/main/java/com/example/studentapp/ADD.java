package com.example.studentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ADD extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    AppCompatButton b1;
    String apiUrl="https://courseapplogix.onrender.com/addstudents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        e1=(EditText) findViewById(R.id.fname);
        e2=(EditText) findViewById(R.id.lname);
        e3=(EditText) findViewById(R.id.cname);
        e4=(EditText) findViewById(R.id.dob);
        e5=(EditText) findViewById(R.id.course);
        e6=(EditText) findViewById(R.id.mno);
        e7=(EditText) findViewById(R.id.email);
        e8=(EditText) findViewById(R.id.address);
        b1=(AppCompatButton) findViewById(R.id.addbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getFname=e1.getText().toString();
                String getLname=e2.getText().toString();
                String getCname=e3.getText().toString();
                String getDob=e4.getText().toString();
                String getCourse=e5.getText().toString();
                String getMno=e6.getText().toString();
                String getEmail=e7.getText().toString();
                String getAddress=e8.getText().toString();
                JSONObject stud=new JSONObject();
                try {
                    stud.put("firstname",getFname);
                    stud.put("lastname",getLname);
                    stud.put("college",getCname);
                    stud.put("dob",getDob);
                    stud.put("course",getCourse);
                    stud.put("mobile",getMno);
                    stud.put("email",getEmail);
                    stud.put("address",getAddress);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        stud,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_LONG).show();
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                            }
                        }
                );

                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);
            }
        });

    }
}