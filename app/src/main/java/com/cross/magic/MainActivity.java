package com.cross.magic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.design.widget.CoordinatorLayout;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.cross.magic.db.DBHelper;
import com.cross.magic.pojos.Card;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.mancj.slideup.SlideUp;
import com.mancj.slideup.SlideUpBuilder;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CardSearch.OnFragmentInteractionListener {


    private MaterialSearchBar searchBar;
    public FloatingActionsMenu floatingActionButton;
    private RelativeLayout ll;
    private ImageView logo;
    private AppCompatTextView quoteText;
    private AppCompatTextView quoteName;
    private Float sbz;
    private int padsb, padsbaux;
    private Card card;
    private List<Card> cards;
    private RecyclerView recView;
    private String prueba;
    private Gson gson;
    private SlideUp slideUp;
    private String flnam, flcos, fltyp, flora, fltxt, flpow, fltou, flpho;
    private TextView fcnam, fccos, fctyp, fcora, fctxt, fcpow, fctou, uwu;
    private LinearLayout quoteContainer;
    private RelativeLayout placeholder;
    private ImageLoader imageLoader;
    private NetworkImageView nv;
    private FloatingActionButton adv_search;
    private Fragment search, result;
    FragmentTransaction fragmentTransaction;
    //private List<Card> suggestions = getResults();
    private final String[] cardsug = {

    };
    String urlfast;
    Intent i;
    String ob;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.bolt2);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ll = findViewById(R.id.bluraso);
        logo = findViewById(R.id.logo1);
        quoteText = findViewById(R.id.fltext);
        quoteName = findViewById(R.id.flname);
        quoteContainer = findViewById(R.id.flavorcontainer);
        searchBar = findViewById(R.id.searchBar);
        floatingActionButton = findViewById(R.id.fab);
        sbz = searchBar.getZ();
        padsb = searchBar.getPaddingStart();
        padsbaux = padsb;
        adv_search = findViewById(R.id.fab_action2);
        adv_search.setOnClickListener(this);
        nv = findViewById(R.id.photo);
        placeholder = findViewById(R.id.fragment_placeholder);
        placeholder.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        fltxt = getString(R.string.cf);
        flnam = getString(R.string.cn);
        flcos = getString(R.string.cc);
        fltyp = getString(R.string.ct);
        flora = getString(R.string.co);
        flpow = "";
        fltou = "";

        try {

            Bundle extras = getIntent().getExtras();
            fltxt = extras.getString("text");
            flnam = extras.getString("name");
            flcos = extras.getString("cost");
            fltyp = extras.getString("types");
            flora = extras.getString("oracle");
            flpow = extras.getString("power");
            fltou = extras.getString("toughness");
            flpho = extras.getString("url");


        } catch (Exception e) {
            e.getMessage();
        }
        if (flpho != null) {
            nv.setImageUrl(flpho, VolleySingleton.getInstance(this.getApplicationContext()).getImageLoader());
        } else {

            nv.setDefaultImageResId(R.drawable.defaultbolt);
        }

        quoteText.setText(fltxt);
        quoteName.setText("— " + flnam);
        fcnam = findViewById(R.id.cname);
        fcnam.setText(flnam);
        fccos = findViewById(R.id.ccost);
        fccos.setText(manamorphose(flcos));
        fctyp = findViewById(R.id.ctypes);
        fctyp.setText(fltyp);
        fcora = findViewById(R.id.coracle);
        fcora.setText(manamorphose(flora));
        fctxt = findViewById(R.id.cflavor);
        fctxt.setText(fltxt);
        fcpow = findViewById(R.id.cpower);
        fcpow.setText(flpow);
        fctou = findViewById(R.id.ctoughness);
        fctou.setText(fltou);
        uwu = findViewById(R.id.barritauwu);
        if (flpow.equals("") && fltou.equals("")) {
            uwu.setText("");
        }

        placeholder.setVisibility(View.GONE);

        search = new CardSearch();


        floatingActionButton.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {
                try {
                    floatingActionButton.bringToFront();
                    //leblur code was here!!!
                    leblur();
                    ll.setVisibility(View.VISIBLE);
                    quoteText.setVisibility(View.INVISIBLE);
                    quoteName.setVisibility(View.INVISIBLE);
                    quoteContainer.setVisibility(View.INVISIBLE);
                    searchBar.setVisibility(View.INVISIBLE);
                    logo.setVisibility(View.INVISIBLE);
                    searchBar.disableSearch();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMenuCollapsed() {
                ll.setVisibility(View.GONE);
                quoteText.setVisibility(View.VISIBLE);
                quoteName.setVisibility(View.VISIBLE);
                searchBar.setVisibility(View.VISIBLE);
                quoteContainer.setVisibility(View.VISIBLE);
                logo.setVisibility(View.VISIBLE);


            }
        });

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        final CustomSuggestionsAdapter customSuggestionsAdapter = new CustomSuggestionsAdapter(inflater);
//
//        searchBar.setMaxSuggestionCount(3);
//
//        for (int i = 1; i < 11; i++) {
//           suggestions.add(new Card());
//        }
//
//
//        customSuggestionsAdapter.setSuggestions(suggestions);
//        searchBar.setCustomSuggestionAdapter(customSuggestionsAdapter);
//
//        searchBar.addTextChangeListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Log.d("LOG_TAG", getClass().getSimpleName() + " text changed " + searchBar.getText());
//                // send the entered text to our filter and let it manage everything
//                customSuggestionsAdapter.getFilter().filter(searchBar.getText());
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//
//        });

        searchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {
                urlfast = "https://api.scryfall.com/cards/search?order=name&q=name%3A"+ TextUtils.htmlEncode(searchBar.getText());
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                gson = gsonBuilder.create();
                i = new Intent(MainActivity.this, ResultList.class);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, urlfast, null, new Response.Listener<JSONObject>() {

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
                                boolean errorrrrrrrrrrrrrrrrrrrr = true;
                                Log.d("rawJSON", "FAIL");
                                Toast.makeText(getApplicationContext(), "Something has countered that...",Toast.LENGTH_SHORT).show();
                                //TO DO add offline features
//                                startActivity(i);
//                                finish();
                            }
                        });
                VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
                searchBar.disableSearch();
            }

            @Override
            public void onButtonClicked(int buttonCode) {
            }
        });

        KeyboardUtils.addKeyboardToggleListener(this, new KeyboardUtils.SoftKeyboardToggleListener() {
            @Override
            public void onToggleSoftKeyboard(boolean isVisible) {

                if (placeholder.getVisibility() != View.VISIBLE) {

                    if (!isVisible) {

                        floatingActionButton.setVisibility(View.VISIBLE);
                        quoteText.setVisibility(View.VISIBLE);
                        quoteName.setVisibility(View.VISIBLE);
                        quoteContainer.setVisibility(View.VISIBLE);
                        logo.setVisibility(View.VISIBLE);
                        //searchBar.setZ(sbz);
                        //searchBar.setVisibility(View.VISIBLE);
                        //ll.setVisibility(View.GONE);
                        searchBar.disableSearch();


                    } else {

                        floatingActionButton.setVisibility(View.INVISIBLE);
                        quoteText.setVisibility(View.INVISIBLE);
                        quoteName.setVisibility(View.INVISIBLE);
                        logo.setVisibility(View.INVISIBLE);
                        quoteContainer.setVisibility(View.INVISIBLE);
                        //searchBar.setPadding(padsb+1000,0,0,0);
                        //leblur();
                        //ll.setVisibility(View.VISIBLE);
                        //searchBar.setPadding(padsbaux,0,0,0);

                        searchBar.setZ(ll.getZ() + 1);
                        //searchBar.bringToFront();
                        //searchBar.setVisibility(View.VISIBLE);


                    }
                }
            }
        });



        View slideView = findViewById(R.id.slideView);
        slideUp = new SlideUpBuilder(slideView)
                .withListeners(new SlideUp.Listener.Events() {
                    @Override
                    public void onSlide(float percent) {

                    }

                    @Override
                    public void onVisibilityChanged(int visibility) {
                        if (visibility == View.GONE) {
                            ll.setVisibility(View.GONE);
                            floatingActionButton.setVisibility(View.VISIBLE);
                            searchBar.setVisibility(View.VISIBLE);
                            quoteText.setVisibility(View.VISIBLE);
                            quoteName.setVisibility(View.VISIBLE);
                            quoteContainer.setVisibility(View.VISIBLE);
                            logo.setVisibility(View.VISIBLE);

                        } else {
                            ll.setVisibility(View.VISIBLE);
                            floatingActionButton.setVisibility(View.INVISIBLE);
                            searchBar.setVisibility(View.INVISIBLE);
                            quoteText.setVisibility(View.INVISIBLE);
                            quoteName.setVisibility(View.INVISIBLE);
                            quoteContainer.setVisibility(View.INVISIBLE);
                            logo.setVisibility(View.INVISIBLE);

                        }
                    }
                })
                .withStartState(SlideUp.State.HIDDEN)
                .withStartGravity(Gravity.BOTTOM)
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (slideUp.isVisible()) {
            slideUp.hide();
        }

        if (floatingActionButton.isExpanded()) {
            floatingActionButton.collapse();
        }

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
/*if (!slideUp.isVisible() && !floatingActionButton.isExpanded() && doubleBackToExitPressedOnce) {
    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
}*/

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1000);

        if(search.isVisible())
        getFragmentManager().beginTransaction().remove(search).commit();
        placeholder.setVisibility(View.GONE);
        quoteText.setVisibility(View.VISIBLE);
        quoteName.setVisibility(View.VISIBLE);
        searchBar.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);
        logo.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                floatingActionButton.collapse();
            }
        }, 1000);


    }


    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case (R.id.fab):

                break;
            case (R.id.searchBar):
                //searchBar.onClick(searchBar,quoteText,quoteName,floatingActionButton);
                break;

            case (R.id.content_l):
                KeyboardUtils.forceCloseKeyboard(view);
                floatingActionButton.collapse();
                slideUp.hide();
                break;

            case (R.id.bluraso):
                floatingActionButton.collapse();
                //searchBar.disableSearch();
                break;

            case (R.id.flname):
                leblur();
                /*floatingActionButton.setVisibility(View.INVISIBLE);
                quoteText.setVisibility(View.INVISIBLE);
                quoteName.setVisibility(View.INVISIBLE);
                searchBar.setVisibility(View.INVISIBLE);
                logo.setVisibility(View.INVISIBLE);*/
                slideUp.show();
                break;

            case (R.id.fltext):
                leblur();
                /*floatingActionButton.setVisibility(View.INVISIBLE);
                quoteText.setVisibility(View.INVISIBLE);
                quoteName.setVisibility(View.INVISIBLE);
                searchBar.setVisibility(View.INVISIBLE);
                logo.setVisibility(View.INVISIBLE);*/
                slideUp.show();
                break;

            case (R.id.fab_action2):
                placeholder.setVisibility(View.VISIBLE);
                quoteText.setVisibility(View.GONE);
                quoteName.setVisibility(View.GONE);
                searchBar.setVisibility(View.GONE);
                floatingActionButton.setVisibility(View.GONE);
                logo.setVisibility(View.GONE);
                createSearchFragment();

                break;

            case (R.id.fragment_placeholder):
                //getFragmentManager().popBackStack();
                break;




        }

    }

    public void createSearchFragment(){
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder,search);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void createResultFragment(){
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_placeholder,result);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }





    public Bitmap blurBitmap(Bitmap bitmap) {
        Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        RenderScript rs = RenderScript.create(getApplicationContext());
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
        Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);
        blurScript.setRadius(25.f);
        blurScript.setInput(allIn);
        blurScript.forEach(allOut);
        allOut.copyTo(outBitmap);
        rs.destroy();
        return outBitmap;
    }

    public void leblur() {
        CoordinatorLayout v = (CoordinatorLayout) floatingActionButton.getParent();
        v.buildDrawingCache();
        Bitmap bm = v.getDrawingCache();
        BitmapDrawable background = new BitmapDrawable(blurBitmap(bm));
        ll.setBackground(background);
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
            Drawable mana = ContextCompat.getDrawable(this, R.drawable.ic_w);

            switch (m) {
                case "W":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_w);
                    break;

                case "U":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_u);
                    break;

                case "R":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_r);
                    break;

                case "B":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_b);
                    break;

                case "G":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_g);
                    break;

                case "T":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_t);
                    break;

                case "Q":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_q);
                    break;

                case "E":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_e);
                    break;

                case "X":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_x);
                    break;

                case "Y":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_y);
                    break;

                case "Z":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_z);
                    break;

                case "0":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_0);
                    break;

                case "1":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_1);
                    break;

                case "2":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_2);
                    break;

                case "3":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_3);
                    break;

                case "4":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_4);
                    break;

                case "5":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_5);
                    break;

                case "6":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_6);
                    break;

                case "7":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_7);
                    break;

                case "8":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_8);
                    break;

                case "9":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_9);
                    break;

                case "10":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_10);
                    break;

                case "11":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_11);
                    break;

                case "12":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_12);
                    break;

                case "13":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_13);
                    break;

                case "14":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_14);
                    break;

                case "15":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_15);
                    break;

                case "16":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_16);
                    break;

                case "17":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_17);
                    break;

                case "18":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_18);
                    break;

                case "19":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_19);
                    break;

                case "20":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_20);
                    break;

                case "100":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_100);
                    break;

                case "1000000":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_1000000);
                    break;

                case "∞":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_inf);
                    break;

                case "W/U":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_wu);
                    break;

                case "W/B":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_wb);
                    break;

                case "B/R":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_br);
                    break;

                case "B/G":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_bg);
                    break;

                case "U/B":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_ub);
                    break;

                case "U/R":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_ur);
                    break;

                case "R/G":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_rg);
                    break;

                case "R/W":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_rw);
                    break;

                case "G/W":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_gw);
                    break;

                case "G/U":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_gu);
                    break;

                case "2/W":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_2w);
                    break;

                case "2/U":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_2u);
                    break;

                case "2/B":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_2b);
                    break;

                case "2/G":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_2g);
                    break;

                case "2/R":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_2r);
                    break;

                case "W/P":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_wp);
                    break;

                case "U/P":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_up);
                    break;

                case "B/P":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_bp);
                    break;

                case "R/P":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_rp);
                    break;

                case "G/P":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_gp);
                    break;

                case "C":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_c);
                    break;

                case "S":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_s);
                    break;

                case "CHAOS":
                    mana = ContextCompat.getDrawable(this, R.drawable.ic_chaos);
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

    private ArrayList<Card> getResults() {

        DBHelper db = new DBHelper(this.getApplicationContext()); //my database helper file
        db.open();

        ArrayList<Card> resultList = new ArrayList<>();


        Cursor c = (Cursor) db.getAllValues(); //function to retrieve all values from a table- written in MyDb.java file
        while (c.moveToNext())
        {
            String name = c.getString(c.getColumnIndex("name"));

            try
            {
                Card card = new Card(name);
                resultList.add(card);
            }
            catch (Exception e) {
                Log.e("ERROR", "Error " + e.toString());
            }

        }

        c.close();

        db.close();
        return resultList;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
