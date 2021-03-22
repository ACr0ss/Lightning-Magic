package com.cross.magic.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public abstract class CardList {


    @Expose
    @SerializedName("data")
    private List<DataEntity> data;
    @Expose
    @SerializedName("has_more")
    private boolean has_more;
    @Expose
    @SerializedName("total_cards")
    private int total_cards;
    @Expose
    @SerializedName("object")
    private String object;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public int getTotal_cards() {
        return total_cards;
    }

    public void setTotal_cards(int total_cards) {
        this.total_cards = total_cards;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public static class DataEntity {
        @Expose
        @SerializedName("name")
        private String name;
        @Expose
        @SerializedName("oracle_id")
        private String oracle_id;
        @Expose
        @SerializedName("id")
        private String id;
        @Expose
        @SerializedName("object")
        private String object;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOracle_id() {
            return oracle_id;
        }

        public void setOracle_id(String oracle_id) {
            this.oracle_id = oracle_id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }
    }
}
