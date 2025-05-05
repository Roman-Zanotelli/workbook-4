package com.pluralsight;

public enum RoomType {
    King(139.00f), Double(124.00f);


    final float pricePerNight;

    RoomType(float pricePerNight){
        this.pricePerNight = pricePerNight;
    }

    public float getPricePerNight(){
        return pricePerNight;
    }

}
