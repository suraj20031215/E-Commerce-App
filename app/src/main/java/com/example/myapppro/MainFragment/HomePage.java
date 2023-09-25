package com.example.myapppro.MainFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.example.myapppro.CostumeAdpter.BannerAdpter;
import com.example.myapppro.CostumeAdpter.ItemAdapter;
import com.example.myapppro.CostumeAdpter.ListAdpter;


import com.example.myapppro.CostumeAdpter.PosterAdapter;
import com.example.myapppro.CostumeAdpter.SpecialAdpter;
import com.example.myapppro.Interface.Click;
import com.example.myapppro.Model_Class.ModelClass;
import com.example.myapppro.R;
import com.example.myapppro.Fragment.SubCategoryPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomePage extends Fragment {
    private BottomNavigationView bottom;
    RequestQueue queue,  queue2, queue3,  queue4,queue5;
    ArrayList<ModelClass>  arrayList, arrayList1, arrayList4, arrayList7,arrayList9;
    BannerAdpter bannerAdpter;
    ItemAdapter itemAdapter;
    PosterAdapter posterAdapter;
    ImageCarousel r1,r5;
    SpecialAdpter specialAdpter;
    ListAdpter listAdpter;
    RecyclerView recyclerView,  recyclerView3,r4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        arrayList4 = new ArrayList<>();
        arrayList7=new ArrayList<>();
        arrayList9=new ArrayList<>();

        queue  = Volley.newRequestQueue(getContext());
        queue2 = Volley.newRequestQueue(getContext());
        queue3 = Volley.newRequestQueue(getContext());
        queue4 =Volley.newRequestQueue(getContext());
        queue5 =Volley.newRequestQueue(getContext());

        recyclerView  = view.findViewById(R.id.recyclerView1);
        r1            = view.findViewById(R.id.recyclerView2);
        recyclerView3 = view.findViewById(R.id.recyclerView3);
        r4            = view.findViewById(R.id.recyclerView4);
        r5            = view.findViewById(R.id.recyclerView5);


//        recyclerView.setAdapter(offerAdpter);

     //   recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //    recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        recyclerView3.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Catogray Page Fetch

    StringRequest   stringRequest = new StringRequest(Request.Method.GET, "https://www.digitechy.in.net/categorypageapi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       /// Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<= jsonArray.length(); i++) {
                                ModelClass modelClass = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int id = jsonObject.getInt("id");

                                String name = jsonObject.getString("name");
                                String img = "http://www.digitechy.in.net/img/" + jsonObject.getString("url");
                                modelClass.setName(name);
                                modelClass.setPic(img);
                                //modelClass.setId(id);

                                arrayList1.add(modelClass);
                                listAdpter = new ListAdpter(getContext(), arrayList1);
                                recyclerView.setAdapter(listAdpter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                               listAdpter.setOn(new Click() {
                                   @Override
                                   public void GetPos(int pos) {
                                    //   getFragmentManager().beginTransaction().replace(R.id.container2,new SubCategoryPage(arrayList1.get(pos).getId())).addToBackStack(null).commit();
                                   }
                               });

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


// Brand Name & logo Api
        StringRequest   stringRequest2 = new StringRequest(Request.Method.GET, "https://www.digitechy.in.net/categorypageapi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /// Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<= jsonArray.length(); i++) {
                                ModelClass modelClass2 = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name2 = jsonObject.getString("name");
                                String img2= "http://www.digitechy.in.net/img/" + jsonObject.getString("url");
                                modelClass2.setName(name2);
                                modelClass2.setPic(img2);
                                arrayList4.add(modelClass2);
                                specialAdpter = new SpecialAdpter(getContext(), arrayList4);
                                recyclerView3.setAdapter(specialAdpter);
                                recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//                                recyclerView3.setLayoutManager(new GridLayoutManager(getContext(),2));
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
        queue2.add(stringRequest2);


// Product Api Fetch

        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, "https://www.digitechy.in.net/PRODUCTApi.PHP",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getContext(), "" + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<= jsonArray.length(); i++) {
                                ModelClass modelClass3 = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String n1 = jsonObject.getString("pname");
                                String n2 = jsonObject.getString("pdetail");
                                String n3 = jsonObject.getString("pprice");
                                String img2= "https://www.digitechy.in.net/img/"+jsonObject.getString("pimg1");
                                modelClass3.setName(n1);
                                modelClass3.setDic(n2);
                                modelClass3.setPrice(n3);
                                modelClass3.setPic(img2);
                                arrayList7.add(modelClass3);
                                itemAdapter = new ItemAdapter(getContext(), arrayList7);
                                r4.setAdapter(itemAdapter);
                                r4.setLayoutManager(new GridLayoutManager(getContext(),2));
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
        queue3.add(stringRequest3);

        // Banner Api Fetch

        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, "https://www.digitechy.in.net/bannerapi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<= jsonArray.length(); i++) {
                                ModelClass modelClass4 = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String img1 = "https://www.digitechy.in.net/img/" + jsonObject.getString("url");
                                modelClass4.setPic(img1);
                                arrayList.add(modelClass4);
                               bannerAdpter = new BannerAdpter(getContext(), arrayList);
                               r1.addData(new CarouselItem(img1));
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
        queue4.add(stringRequest4);

      //  Poster Api Fetch

        StringRequest stringRequest5 = new StringRequest(Request.Method.GET, "https://www.digitechy.in.net/posterapi.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<= jsonArray.length(); i++) {
                                ModelClass modelClass5 = new ModelClass();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String img8 = "https://www.digitechy.in.net/img/" + jsonObject.getString("url");
                                modelClass5.setPic(img8);
                                arrayList9.add(modelClass5);
                                posterAdapter = new PosterAdapter(getContext(), arrayList9);
                               r5.addData(new CarouselItem(img8));
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
        queue5.add(stringRequest5);

            return view;
        }

}





