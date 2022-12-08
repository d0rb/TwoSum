package com.example.twosum;

public class BagObj {
    private double BagSizeInKG  = 0.0;
    public int BagID  = 0;

    public void setBagSizeInKG(double size){
        this.BagSizeInKG = size;
    }
    public void setBagID(int id){
        this.BagID = id;
    }

    public double getBagSizeInKG(){
        return this.BagSizeInKG;
    }
    public int getBagID(){
        return this.BagID;
    }
}
