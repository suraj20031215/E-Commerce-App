package com.example.myapppro.Fragment;


import  android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.myapppro.Activity.MainActivity2;
import com.example.myapppro.R;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


    public class LoginPage extends Fragment {
    TextView txt;
    ImageView img;


    RequestQueue queue;
 String url= "http://www.digitechy.in.net/log.php";
    EditText ed4, ed5;
    SharedPreferences sharedPreferences;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login_page, container, false);

        queue = Volley.newRequestQueue(getContext());
        ed4=view.findViewById(R.id.editText);
        ed5=view.findViewById(R.id.editText2);
         txt=view.findViewById(R.id.signup);
        img=view.findViewById(R.id.imageButton);

        sharedPreferences=getContext().getSharedPreferences("message", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("key","0");

        if (name!="0")
        {
            Intent in=new Intent(getContext(), MainActivity2.class);
            startActivity(in);
            getActivity().finish();
        }

txt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        getFragmentManager().beginTransaction().replace(R.id.container, new RegisterPage()).addToBackStack(null).commit();

    }
});


  img.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
          String email = ed4.getText().toString();
          String password = ed5.getText().toString();

              StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://www.digitechy.in.net/log.php?email="+email+"password="+password,
                  new Response.Listener<String>() {
                      @Override
                      public void onResponse(String response) {

                          try {
                              JSONObject jsonObject=new JSONObject(response);
                               String mass=jsonObject.getString("message");
//                              JSONObject jsonObject1 = jsonObject.getJSONObject(0);

                              if(email.isEmpty()){
                                  Toast.makeText(getContext(),"Enter Email",Toast.LENGTH_SHORT).show();
                              }
                              else if(password.isEmpty()){
                                  Toast.makeText(getContext(),"Enter Password",Toast.LENGTH_SHORT).show();
                              }
                         else if(mass.equals("Login successful.")) {
                                  SharedPreferences.Editor sh=sharedPreferences.edit();
                                  sh.putString("key",email);
                                  //sh.apply();
                                  sh.commit();
                              Intent in=new Intent(getContext(), MainActivity2.class);
                            startActivity(in);
                                  getActivity().finish();
                  }
                          else{

                              Toast.makeText(getContext(),"Enter Correct Password",Toast.LENGTH_SHORT).show();
//
                          }

                          } catch (JSONException e) {
                              throw new RuntimeException(e);
                          }

                      }
                  }, new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
                  Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();

              }
          }) {
              @Nullable
              @Override
              protected Map<String, String> getParams() throws AuthFailureError {
                  HashMap<String, String> map = new HashMap<>();

                  map.put("email", email);
                  map.put("password", password);
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
