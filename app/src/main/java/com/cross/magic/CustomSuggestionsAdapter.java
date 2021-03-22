package com.cross.magic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.mancj.materialsearchbar.adapter.SuggestionsAdapter;

import java.util.ArrayList;

import com.cross.magic.pojos.Card;

public class CustomSuggestionsAdapter extends SuggestionsAdapter<Card, CustomSuggestionsAdapter.SuggestionHolder> {


    public CustomSuggestionsAdapter(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public int getSingleViewHeight() {
        return 80;
    }

    @Override
    public SuggestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.item_custom_suggestion, parent, false);
        return new SuggestionHolder(view);
    }

    @Override
    public void onBindSuggestionHolder(Card suggestion, SuggestionHolder holder, int position) {
        holder.name.setText(suggestion.getName());
        holder.types.setText(suggestion.getType_line());
        holder.cost.setText(suggestion.getMana_cost());
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                String term = constraint.toString();
                if(term.isEmpty())
                    suggestions = suggestions_clone;
                else {
                    suggestions = new ArrayList<>();
                    for (Card c: suggestions_clone)
                        if(c.getName().contains(term.toLowerCase()))
                            suggestions.add(c);
                }
                results.values = suggestions;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                suggestions = (ArrayList<Card>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    static class SuggestionHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView types;
        protected TextView cost;

        public SuggestionHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            types = (TextView) itemView.findViewById(R.id.types);
            cost = (TextView) itemView.findViewById(R.id.mana);
        }
    }
}
