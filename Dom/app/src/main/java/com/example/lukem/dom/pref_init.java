package com.example.lukem.dom;

/**
 * Created by jacob on 3/25/2017.
 */

public class pref_init {
    private int zip_code;
    private int num_beds;

    public pref_init(int zip_code, int num_beds) {
        this.zip_code = zip_code;
        this.num_beds = num_beds;
    }

    public int getZip_code() {
        return zip_code;
    }

    public int getNum_beds() {
        return num_beds;
    }
}
