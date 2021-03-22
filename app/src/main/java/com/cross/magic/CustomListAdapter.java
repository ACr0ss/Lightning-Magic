package com.cross.magic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ResultItem> listData;
    private LayoutInflater layoutInflater;
    FragmentTransaction fragmentTransaction;
    private Context context;

    public CustomListAdapter(Context aContext, ArrayList<ResultItem> listData) {
        this.listData = listData;
        this.context = aContext;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_custom_suggestion, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.types = (TextView) convertView.findViewById(R.id.types);
            holder.mana = (TextView) convertView.findViewById(R.id.mana);
            final View finalConvertView = convertView;
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle infobundle = new Bundle();
                    infobundle.putString("name", listData.get(position).getName());
                    if (listData.get(position).getMana() != null) {
                        infobundle.putString("mana", listData.get(position).getRawMana());
                    }
                    infobundle.putString("type", listData.get(position).getType());
                    String colorfix = listData.get(position).getColor();
                    infobundle.putString("color", listData.get(position).getColor());
                    if (listData.get(position).getImgurl() != null) {
                        infobundle.putString("imgurl", listData.get(position).getImgurl());
                    }
                    infobundle.putString("rarity", listData.get(position).getRarity());
                    infobundle.putString("set", listData.get(position).getSet());
                    if (listData.get(position).getOracle() != null) {
                        infobundle.putString("oracle", listData.get(position).getOracle().toString());
                    }
                    if (listData.get(position).getFlavor() != null) {
                        infobundle.putString("flavor", listData.get(position).getFlavor());
                    }
                    if (listData.get(position).getPow() != null) {
                        infobundle.putString("pow", listData.get(position).getPow());
                    }
                    if (listData.get(position).getTou() != null) {
                        infobundle.putString("tou", listData.get(position).getTou());
                    }
                    if (listData.get(position).getLoy() != null) {
                        infobundle.putString("loy", listData.get(position).getLoy());
                    }
                    Activity activity = (Activity) finalConvertView.getContext();
                    RelativeLayout placeholder = activity.findViewById(R.id.result_fragment_placeholder);
                    Fragment result = new CardResult();
                    placeholder.setVisibility(View.VISIBLE);
//                    placeholder.setBackgroundColor(activity.getResources().getColor(R.color.colorAccent));
                    result.setArguments(infobundle);
                    activity.getFragmentManager().beginTransaction().replace(R.id.result_fragment_placeholder, result).addToBackStack(null).commit();
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(listData.get(position).getName());
        holder.types.setText(listData.get(position).getType());
        holder.mana.setText(listData.get(position).getMana());
        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView types;
        TextView mana;
    }
}
