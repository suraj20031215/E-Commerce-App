package com.example.myapppro.MainFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapppro.CostumeAdpter.SpecialAdpter;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class OfferPage extends Fragment {
    private BottomNavigationView bottom2;
    RequestQueue queue;
    SpecialAdpter specialAdpter;
    ArrayList<ModelClass> arrayList4;
    RecyclerView recyclerView4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_offer_page, container, false);
        arrayList4=new ArrayList<>();

        queue = Volley.newRequestQueue(getContext());
       recyclerView4=view.findViewById(R.id.Recyclerview4);
       specialAdpter=new SpecialAdpter(getContext(),arrayList4);
       recyclerView4.setAdapter(specialAdpter);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));





       StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.digitechy.in.net/categorypageapi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                ModelClass modelClass = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String img = "http://www.digitechy.in.net/img/" + jsonObject.getString("url");
//                                modelClass.setName1(name);
//                               modelClass.setImg1(img);
                                arrayList4.add(modelClass);
                                specialAdpter = new SpecialAdpter(getContext(), arrayList4);
                                recyclerView4.setAdapter(specialAdpter);
                                //   recyclerView3.setAdapter(bannerAdpter);
                                recyclerView4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));



                            }


                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "" + error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);




















       return view;
    }
}