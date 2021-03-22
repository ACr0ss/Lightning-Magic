package com.cross.magic;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;


public class ResultList extends Activity implements CardResult.OnFragmentInteractionListener {
    public ListView resListView;
    private RelativeLayout placeholder;
    FragmentTransaction fragmentTransaction;
    public Fragment result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_items);
        resListView = findViewById(R.id.res);
        placeholder = findViewById(R.id.result_fragment_placeholder);
        placeholder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        result = new CardResult();


        Bundle extras = getIntent().getExtras();
        String json = extras.getString("res");
        JsonArray results = new JsonParser().parse(json).getAsJsonArray();
        ArrayList<ResultItem> finalres = new ArrayList<>();
        placeholder.setVisibility(View.GONE);


        for (int i = 0; i < results.size(); i++) {
            JsonObject aux = results.get(i).getAsJsonObject();
            ResultItem resaux = new ResultItem(this);
            resaux.setName(aux.get("name").getAsString());
            if (aux.get("mana_cost") != null) {
                resaux.setMana(aux.get("mana_cost").getAsString());
                resaux.setRawMana(aux.get("mana_cost").getAsString());
            }
            resaux.setType(aux.get("type_line").getAsString());
            if (aux.get("colors") != null) {
                //Isolate value
                resaux.setColor(aux.get("colors").getAsJsonArray().toString());
            }
            if (aux.get("image_uris") != null) {
                JsonObject ob = aux.get("image_uris").getAsJsonObject();
                if (ob.get("art_crop") != null) {
                    resaux.setImgurl(ob.get("art_crop").getAsString());
                }
            }
            resaux.setRarity(aux.get("rarity").getAsString());
            resaux.setSet(aux.get("set").getAsString());
            if (aux.get("oracle_text") != null) {
                resaux.setOracle(aux.get("oracle_text").getAsString());
            }
            if (aux.get("flavor_text") != null) {
                resaux.setFlavor(aux.get("flavor_text").getAsString());
            }
            if (aux.get("power") != null) {
                resaux.setPow(aux.get("power").getAsString());
            }
            if (aux.get("toughness") != null) {
                resaux.setTou(aux.get("toughness").getAsString());
            }
            if (aux.get("loyalty") != null) {
                resaux.setLoy(aux.get("loyalty").getAsString());
            }
            finalres.add(resaux);
        }

//        Fragment result = new CardResult();
//        placeholder.setVisibility(View.VISIBLE);
//                    placeholder.setBackgroundColor(activity.getResources().getColor(R.Color.colorAccent));
//        fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.result_fragment_placeholder,result).addToBackStack(null);
//        final CustomListAdapter customListAdapter = new CustomListAdapter(this, finalres);
//        fragmentTransaction.commit();
        resListView.setAdapter(new CustomListAdapter(this, finalres));
//        resListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                customListAdapter.getView(position, view,parent);
//            }
//        });


//        arrayAdapter = new ArrayAdapter(this, R.layout.item_custom_suggestion, finalres);
//        resListView.setAdapter(arrayAdapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
