package fablab.devinci.myfabconnect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by Ken on 20/07/2017.
 */

public class Menu2 extends Fragment {

    ListView listview;
    Project responseObj;
    CustomAdapterProject adapter;
    Gson gson;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_2, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Mes Projets");
        MainActivity activity = (MainActivity) getActivity();
        String myDataFromActivity = activity.getMyString();
        String myIdFromActivity = activity.getMyId();
        Log.d("FragAct",myDataFromActivity);
        listview = (ListView)getView().findViewById(R.id.listView);

        url(myIdFromActivity);




    }


    public String url(String userId) {

        final String apikey = "GEPRSokac9uKRb00G0X5RXt9OWxj66cN";
        String url="http://myfab.pe.hu/api/v1/project/list.php?userid="+userId+"&key="+apikey+"";


        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Results", response);
                response = "{\"items\": " + response + "}";
                Log.d("Results", response);
                gson = new Gson();
                responseObj = gson.fromJson(response, Project.class);
                adapter = new CustomAdapterProject(getActivity().getApplicationContext(), responseObj.getItems());
                listview.setAdapter(adapter);
                //listview.setOnItemClickListener(onItemClickListener);
                //  mytxtvw = (TextView) findViewById(R.id.txtview);
                //  mytxtvw.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError response) {
//                Log.e("Results",response.getMessage());
            }
        });
        Volley.newRequestQueue(getActivity().getApplicationContext()).add(request);


        return userId;
    }
}