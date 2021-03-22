package com.cross.magic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardResult.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardResult#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardResult extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CardResult() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardResult.
     */
    // TODO: Rename and change types and number of parameters
    public static CardResult newInstance(String param1, String param2) {
        CardResult fragment = new CardResult();
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
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_card_result, container, false);

        String dname = getArguments().getString("name");
        TextView name = mView.findViewById(R.id.res_name);
        name.setText(dname);

        if (getArguments().getString("mana") != null) {
            String dcost = getArguments().getString("mana");
            TextView mana = mView.findViewById(R.id.res_cost);
            mana.setText(manamorphose(dcost));
        }

        String dtype = getArguments().getString("type");
        TextView type = mView.findViewById(R.id.res_type);
        type.setText(dtype);

        NetworkImageView img = mView.findViewById(R.id.res_pic);
        if (getArguments().getString("imgurl") != null) {
            String dimg = getArguments().getString("imgurl");
            img.setImageUrl(dimg, VolleySingleton.getInstance(getActivity().getApplicationContext()).getImageLoader());
        } else {
            img.setDefaultImageResId(R.drawable.ic_lightning);
        }

        String drarity = getArguments().getString("rarity");
        //TextView rarity = mView.findViewById(R.id.res_rarity);
        //rarity.setText(drarity);

        String dset = getArguments().getString("set");
        //Switch w image
        //TextView set = mView.findViewById(R.id.res_set);
        //set.setText(dset);

        if (getArguments().getString("oracle") != null) {
            String doracle = getArguments().getString("oracle");
            TextView oracle = mView.findViewById(R.id.res_oracle);
            oracle.setText(manamorphose(doracle));
        }

        if (getArguments().getString("flavor") != null) {
            String dflavor = getArguments().getString("flavor");
            TextView flavor = mView.findViewById(R.id.res_flavor);
            flavor.setText(dflavor);
        }

        if (getArguments().getString("pow") != null) {
            String dpow = getArguments().getString("pow");
            TextView pow = mView.findViewById(R.id.res_power);
            pow.setText(dpow);
        }

        if (getArguments().getString("tou") != null) {
            String dtou = getArguments().getString("tou");
            TextView tou = mView.findViewById(R.id.res_toughness);
            tou.setText(dtou);
        }

        LinearLayout llpt = mView.findViewById(R.id.linearLayout4);
        LinearLayout llptborder = mView.findViewById(R.id.linearLayout5);
        if (getArguments().getString("pow") == null && getArguments().getString("tou") == null) {
            llpt.setVisibility(View.GONE);
            llptborder.setVisibility(View.GONE);
        }


//if (getArguments().getString("pow") != null) {
//            String dpow = getArguments().getString("pow");
//            TextView pow = mView.findViewById(R.id.res_power);
//            pow.setText(dpow);
//        }

        String color = getArguments().getString("color");
        ImageView coloredframe = mView.findViewById(R.id.imageView2);
        switch(color) {
            case "[\"C\"]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_c);
                break;
            case "[]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_c);
                break;

            case "[\"W\"]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_w);
                break;
            case "[\"B\"]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_b);
                break;
            case "[\"G\"]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_g);
                break;
            case "[\"R\"]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_r);
                break;
            case "[\"U\"]":
                coloredframe.setImageResource(R.drawable.ic_color_frame_u);
                break;
            default:
                coloredframe.setImageResource(R.drawable.ic_color_frame_gold);
                break;

        }
        ImageView setsymbol = mView.findViewById(R.id.set_img);

        switch (dset){
            case "m19":
                switch (drarity){
                    case "common":
                        setsymbol.setImageResource(R.drawable.ic_c_m19);
                        break;
                    case "uncommon":
                        break;
                    case "rare":
                        break;
                    case "mythic":
                        break;
                }
                break;
            default:
                    Toast.makeText(getActivity().getApplicationContext(), "no set found yet", Toast.LENGTH_SHORT);
        }


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

    @Override
    public void onClick(View v) {
        Toast.makeText(this.getContext(), "buuuuarns", Toast.LENGTH_LONG).show();
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

    public SpannableString manamorphose(String o) {
        String origin = o;
        origin = origin.replaceAll("\\{", "·");
        origin = origin.replaceAll("\\}", "·");
        int r = 0;
        for (int i = 0; i < o.length(); i++) {
            if (o.charAt(i) == '{')
                r++;
        }

        String m = null;


        int c = 0;
        ArrayList<Drawable> d = new ArrayList<Drawable>();
        int pos[] = new int[r];
        String symbol[] = new String[r];
        while (c < r) {
            m = o.substring(o.indexOf('{') + 1, o.indexOf('}'));
            pos[c] = o.indexOf('{');
            symbol[c] = "·" + m + "·";
            o = o.substring(o.indexOf("}") + 1);
            Drawable mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_w);

            switch (m) {
                case "W":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_w);
                    break;

                case "U":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_u);
                    break;

                case "R":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_r);
                    break;

                case "B":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_b);
                    break;

                case "G":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_g);
                    break;

                case "T":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_t);
                    break;

                case "Q":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_q);
                    break;

                case "E":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_e);
                    break;

                case "X":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_x);
                    break;

                case "Y":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_y);
                    break;

                case "Z":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_z);
                    break;

                case "0":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_0);
                    break;

                case "1":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_1);
                    break;

                case "2":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_2);
                    break;

                case "3":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_3);
                    break;

                case "4":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_4);
                    break;

                case "5":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_5);
                    break;

                case "6":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_6);
                    break;

                case "7":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_7);
                    break;

                case "8":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_8);
                    break;

                case "9":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_9);
                    break;

                case "10":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_10);
                    break;

                case "11":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_11);
                    break;

                case "12":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_12);
                    break;

                case "13":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_13);
                    break;

                case "14":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_14);
                    break;

                case "15":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_15);
                    break;

                case "16":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_16);
                    break;

                case "17":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_17);
                    break;

                case "18":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_18);
                    break;

                case "19":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_19);
                    break;

                case "20":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_20);
                    break;

                case "100":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_100);
                    break;

                case "1000000":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_1000000);
                    break;

                case "∞":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_inf);
                    break;

                case "W/U":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_wu);
                    break;

                case "W/B":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_wb);
                    break;

                case "B/R":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_br);
                    break;

                case "B/G":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_bg);
                    break;

                case "U/B":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_ub);
                    break;

                case "U/R":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_ur);
                    break;

                case "R/G":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_rg);
                    break;

                case "R/W":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_rw);
                    break;

                case "G/W":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_gw);
                    break;

                case "G/U":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_gu);
                    break;

                case "2/W":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_2w);
                    break;

                case "2/U":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_2u);
                    break;

                case "2/B":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_2b);
                    break;

                case "2/G":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_2g);
                    break;

                case "2/R":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_2r);
                    break;

                case "W/P":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_wp);
                    break;

                case "U/P":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_up);
                    break;

                case "B/P":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_bp);
                    break;

                case "R/P":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_rp);
                    break;

                case "G/P":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_gp);
                    break;

                case "C":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_c);
                    break;

                case "S":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_s);
                    break;

                case "CHAOS":
                    mana = ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.ic_chaos);
                    break;
            }
            d.add(mana);

            c++;
        }
        Log.d("prueba", String.valueOf(pos.length));
        Log.d("prueba", String.valueOf(d.size()));
        Log.d("prueba", String.valueOf(symbol.length));
        SpannableString res = new SpannableString(origin);


        for (int i = 0; i < d.size(); i++) {
            Drawable currDrw = d.get(i);
            currDrw.setBounds(0, 0, currDrw.getIntrinsicWidth() - 30, currDrw.getIntrinsicHeight() - 30);
            ImageSpan currImgSpan = new ImageSpan(currDrw, ImageSpan.ALIGN_BASELINE);
            Log.d("RES", res.length() + "");
            int indexofimg = origin.indexOf(symbol[i]);
            String auxstr = "";
            for (int j = 0; j < symbol[i].length(); j++) {
                auxstr += " ";
            }
            origin = origin.replaceFirst(symbol[i], auxstr);

            res.setSpan(currImgSpan, indexofimg, indexofimg + symbol[i].length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

        }
        return res;
    }

}
