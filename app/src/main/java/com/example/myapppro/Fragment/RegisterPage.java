package com.example.myapppro.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapppro.Fragment.LoginPage;
import com.example.myapppro.R;

import java.util.HashMap;
import java.util.Map;



public class RegisterPage extends Fragment {

    RequestQueue queue;
    String url = "http://www.digitechy.in.net/registerApi.php";
    EditText ed1, ed2, ed3;
    TextView log;
    ImageView imgbtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register_page, container, false);
        queue = Volley.newRequestQueue(getContext());
        ed1 = view.findViewById(R.id.editname);
        ed2 = view.findViewById(R.id.editemail);
        ed3 = view.findViewById(R.id.editpass);
        log=view.findViewById(R.id.login);
        imgbtn=view.findViewById(R.id.imageButton);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container, new LoginPage()).addToBackStack(null).commit();
            }
        });





        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = ed1.getText().toString();
                String email = ed2.getText().toString();
                String pass = ed3.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://www.digitechy.in.net/registerApi.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(fname.isEmpty()){
                                    Toast.makeText(getContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                                }
                               else if(email.isEmpty()){
                                    Toast.makeText(getContext(), "Enter Email", Toast.LENGTH_SHORT).show();
                                }
                             else   if(pass.isEmpty()){
                                    Toast.makeText(getContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                                }
                             else {

                                Toast.makeText(getContext(), "Register Success"+response, Toast.LENGTH_SHORT).show();
                            }}
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "User Alredy Register", Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> map = new HashMap<>();
                        map.put("name",fname);
                        map.put("email", email);
                        map.put("pass", pass);
                        return map;
                    }
                };

// Add the request to the RequestQueue.
                queue.add(stringRequest);



            }

});


        return view;
    }
}


