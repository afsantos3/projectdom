package com.example.lukem.dom;

/**
 * Created by jacob on 3/25/2017.
 */

public class pref_init {
    public int zip_code;
    public int num_beds;

    public pref_init(int zip_code, int num_beds) {
        this.zip_code = zip_code;
        this.num_beds = num_beds;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public int getNum_beds() {
        return num_beds;
    }

    public void setNum_beds(int num_beds) {
        this.num_beds = num_beds;
    }
}
