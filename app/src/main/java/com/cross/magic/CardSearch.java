package com.cross.magic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardSearch.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardSearch extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText name, cost, color, type, subtype, rarity, set, oracle, flavor, power, toughness;
    private FloatingActionButton confirm;
    private String url, aux;
    private Gson gson;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Intent i;
    String ob;

    private OnFragmentInteractionListener mListener;

    public CardSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardSearch.
     */
    // TODO: Rename and change types and number of parameters
    public static CardSearch newInstance(String param1, String param2) {
        CardSearch fragment = new CardSearch();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_card_search, container, false);
        name = mView.findViewById(R.id.as_name);
        cost = mView.findViewById(R.id.as_cost);
        color = mView.findViewById(R.id.as_color);
        type = mView.findViewById(R.id.as_type);
        subtype = mView.findViewById(R.id.as_subtype);
        rarity = mView.findViewById(R.id.as_rarity);
        set = mView.findViewById(R.id.as_set);
        oracle = mView.findViewById(R.id.as_oracle);
        flavor = mView.findViewById(R.id.as_flavor);
        power = mView.findViewById(R.id.as_power);
        toughness = mView.findViewById(R.id.as_toughness);
        confirm = mView.findViewById(R.id.confirm);
        confirm.setOnClickListener(this);


        return mView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                url = "https://api.scryfall.com/cards/search?order=name&q=";
                if (!name.getText().toString().equals("")) {
                    aux = name.getText().toString();
                    aux = aux.replace(" ","+name%3A");
                    url = url + "name%3A" + aux + "+";
                }

                if (!cost.getText().toString().equals("")) {
                    aux = cost.getText().toString();
                    aux = aux.replace(" ","+mana%3A");
                    url = url + "mana%3A" + aux + "+";
                }

                if (!color.getText().toString().equals("")) {
                    aux = color.getText().toString();
                    aux = aux.replace(" ","+color%3D");
                    url = url + "color%3D" + aux + "+";
                }

                if (!type.getText().toString().equals("")) {
                    aux = type.getText().toString();
                    aux = aux.replace(" ","+type%3A");
                    url = url + "type%3A" + aux + "+";
                }

                if (!subtype.getText().toString().equals("")) {
                    aux = subtype.getText().toString();
                    aux = aux.replace(" ","+type%3A");
                    url = url + "type%3A" + aux + "+";
                }

                if (!rarity.getText().toString().equals("")) {
                    aux = rarity.getText().toString();
                    aux = aux.replace(" ","+rarity%3A");
                    //c
                    url = url + "rarity%3A" + aux + "+";
                }

                if (!set.getText().toString().equals("")) {
                    aux = set.getText().toString();
                    aux = aux.replace(" ","+set%3A");
                    //isd
                    url = url + "set%3A" + aux + "+";
                }
                if (!oracle.getText().toString().equals("")) {
                    //aux = TextUtils.htmlEncode(oracle.getText().toString());
                    aux = oracle.getText().toString();
                    aux = aux.replace(" ","+oracle%3A");
                    url = url + "oracle%3A" + aux + "+";
                }
                if (!flavor.getText().toString().equals("")) {
                    aux = flavor.getText().toString();
                    aux = aux.replace(" ","+flavor%3A");
                    url = url + "flavor%3A" + aux + "+";
                }
                if (!power.getText().toString().equals("")) {
                    aux = power.getText().toString();
                    aux = aux.replace(" ","+pow%3D");
                    url = url + "pow%3D" + aux + "+";
                }
                if (!toughness.getText().toString().equals("")) {
                    aux = toughness.getText().toString();
                    aux = aux.replace(" ","+tou%3D");
                    url = url + "tou%3D" + aux + "+";
                }

                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                gson = gsonBuilder.create();
                i = new Intent(getContext(), ResultList.class);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    ob = response.getString("data");
                                    Log.d("rawJSON", response.toString());
                                    i.putExtra("res", ob);
                                    startActivity(i);



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("rawJSON", "FAIL");
                                Toast.makeText(getContext(), "Something has countered that...",Toast.LENGTH_SHORT).show();
                            }
                        });
                VolleySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

        }

    }
}
