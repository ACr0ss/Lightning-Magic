package com.cross.magic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;

import java.util.ArrayList;

public class ResultItem {
    private String name;
    private SpannableString mana;
    private String type;
    private String color;
    private String imgurl;
    private String rarity;
    private String set;
    private String oracle;
    private String flavor;
    private String pow;
    private String tou;
    private String loy;
    private String rawMana;

    private static Context con;

    public ResultItem(Context con) {
        this.con = con;
    }

    public Context getCon() {
        return con;
    }

    public void setCon(Context con) {
        this.con = con;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpannableString getMana() {
        return mana;
    }
    public String getRawMana() {
        return rawMana;
    }

    public void setMana(String mana) {
        this.mana = manamorphose(mana);
    }

    public void setRawMana(String rawMana) {
        this.rawMana = rawMana;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getOracle() {
        return oracle;
    }

    public void setOracle(String oracle) {
        this.oracle = oracle;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getPow() {
        return pow;
    }

    public void setPow(String pow) {
        this.pow = pow;
    }

    public String getTou() {
        return tou;
    }

    public void setTou(String tou) {
        this.tou = tou;
    }

    public String getLoy() {
        return loy;
    }

    public void setLoy(String loy) {
        this.loy = loy;
    }

    public static SpannableString manamorphose(String o) {
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
            Drawable mana = ContextCompat.getDrawable(con, R.drawable.ic_w);

            switch (m) {
                case "W":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_w);
                    break;

                case "U":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_u);
                    break;

                case "R":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_r);
                    break;

                case "B":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_b);
                    break;

                case "G":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_g);
                    break;

                case "T":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_t);
                    break;

                case "Q":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_q);
                    break;

                case "E":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_e);
                    break;

                case "X":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_x);
                    break;

                case "Y":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_y);
                    break;

                case "Z":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_z);
                    break;

                case "0":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_0);
                    break;

                case "1":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_1);
                    break;

                case "2":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_2);
                    break;

                case "3":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_3);
                    break;

                case "4":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_4);
                    break;

                case "5":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_5);
                    break;

                case "6":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_6);
                    break;

                case "7":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_7);
                    break;

                case "8":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_8);
                    break;

                case "9":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_9);
                    break;

                case "10":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_10);
                    break;

                case "11":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_11);
                    break;

                case "12":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_12);
                    break;

                case "13":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_13);
                    break;

                case "14":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_14);
                    break;

                case "15":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_15);
                    break;

                case "16":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_16);
                    break;

                case "17":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_17);
                    break;

                case "18":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_18);
                    break;

                case "19":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_19);
                    break;

                case "20":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_20);
                    break;

                case "100":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_100);
                    break;

                case "1000000":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_1000000);
                    break;

                case "∞":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_inf);
                    break;

                case "W/U":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_wu);
                    break;

                case "W/B":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_wb);
                    break;

                case "B/R":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_br);
                    break;

                case "B/G":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_bg);
                    break;

                case "U/B":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_ub);
                    break;

                case "U/R":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_ur);
                    break;

                case "R/G":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_rg);
                    break;

                case "R/W":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_rw);
                    break;

                case "G/W":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_gw);
                    break;

                case "G/U":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_gu);
                    break;

                case "2/W":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_2w);
                    break;

                case "2/U":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_2u);
                    break;

                case "2/B":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_2b);
                    break;

                case "2/G":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_2g);
                    break;

                case "2/R":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_2r);
                    break;

                case "W/P":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_wp);
                    break;

                case "U/P":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_up);
                    break;

                case "B/P":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_bp);
                    break;

                case "R/P":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_rp);
                    break;

                case "G/P":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_gp);
                    break;

                case "C":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_c);
                    break;

                case "S":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_s);
                    break;

                case "CHAOS":
                    mana = ContextCompat.getDrawable(con, R.drawable.ic_chaos);
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
