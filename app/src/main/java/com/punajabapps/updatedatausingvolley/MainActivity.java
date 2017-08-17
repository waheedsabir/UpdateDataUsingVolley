package com.punajabapps.updatedatausingvolley;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
            EditText edit_title , edit_detail ,id;
            Button get , update ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        id = (EditText) findViewById(R.id.id);
        edit_title = (EditText) findViewById(R.id.edit_title);
        edit_detail= (EditText) findViewById(R.id.edit_detail);
    }

    public void get(View view) {
        //here is code for data using ID
       String get_ID = id.getText().toString();
        //TODO UPDATE THE URL
        String URL = "http://android.apnitaleem.com/concepts/showdata.php?id=" ;

        //Here attach the ID from edit text ;

        String NEW_URL =URL+get_ID;
        StringRequest stringRequest = new StringRequest(NEW_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

               Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();


                try {
                    JSONArray jsonArray = new JSONArray(response);


                    for (int i= 0 ; i <response.length(); i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//// TODO: 17/08/2017  update
                        String title_put = jsonObject.getString("title");
                        String detail_put = jsonObject.getString("detail");
                        Toast.makeText(MainActivity.this, ""+title_put, Toast.LENGTH_SHORT).show();
                        edit_title.setText(""+title_put);
                       edit_detail.setText(""+detail_put);




                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "Some Thing Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

RequestQueue re = Volley.newRequestQueue(this);
        re.add(stringRequest);







    }

    public void update(View view) {

        String get_ID = id.getText().toString();
        String URL = "http://android.apnitaleem.com/concepts/update_data.php?id=" ;

        //Here attach the ID from edit text ;

        String NEW_URL =URL+get_ID;


        StringRequest str = new StringRequest(Request.Method.POST, NEW_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("title",edit_title.getText().toString().trim());
                params.put("detail",edit_detail.getText().toString().trim());





                return params;
            }
        };



RequestQueue re = Volley.newRequestQueue(this);
        re.add(str);


    }

    public void delete(View view) {

        String get_ID = id.getText().toString();
        //// TODO:
        String URL = "http://android.apnitaleem.com/concepts/delete_data.php?id=" ;

        //Here attach the ID from edit text ;

        String NEW_URL =URL+get_ID;

        StringRequest str = new StringRequest(Request.Method.POST, NEW_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        });




        RequestQueue re = Volley.newRequestQueue(this);
        re.add(str);





    }
}
