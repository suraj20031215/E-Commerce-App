package com.example.myapppro.Fragment;

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
import com.example.myapppro.CostumeAdpter.ListAdpter;
import com.example.myapppro.CostumeAdpter.SubAdapter;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SubCategoryPage extends Fragment {
    RequestQueue queue;
    ArrayList<ModelClass> arrayList;
    ListAdpter listAdpter;
    RecyclerView recyclerView;
    SubAdapter subAdapter;
//    public SubCat(int pos){
//     this.pos=pos;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sub_category_page, container, false);
        arrayList = new ArrayList<>();
        queue  = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.digitechy.in.net/subcategoryApi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /// Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<= jsonArray.length(); i++) {
                                ModelClass modelClass = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String name = jsonObject.getString("name");
                                String img = "http://www.digitechy.in.net/img/" + jsonObject.getString("img");
                                modelClass.setName(name);
                                modelClass.setPic(img);
                                arrayList.add(modelClass);
                                listAdpter = new ListAdpter(getContext(), arrayList);
                                recyclerView.setAdapter(listAdpter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


                            }


                        } catch (JSONException e) {
//                            throw new RuntimeException(e);
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