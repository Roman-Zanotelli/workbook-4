package com.pluralsight;

import java.time.LocalDate;

public class Reservation {
    Room room;
    int numberOfNights;
    boolean isWeekend;

    Reservation(Room room, int numberOfNights, boolean isWeekend){
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    //Gets
    public RoomType getRoomType(){
        return room.getType();
    }

    public float getPrice(){
        return room.getPrice();
    }

    public int getNumberOfNights(){
        return this.numberOfNights;
    }
    public float getReservationTotal(){
        return room.getPrice() * numberOfNights * (isWeekend ? 1.1f : 1f);
    }

    //Sets
    public boolean setNumberOfNights(int numberOfNights){
        if (numberOfNights <= 0) return false;
        this.numberOfNights = numberOfNights;
        return true;
    }

    public boolean setRoomType(String roomType){
        try {
            room.setType(RoomType.valueOf(roomType));
            return true;
        }catch (Exception ignored){
            return false;
        }
    }

    public void setIsWeekend(boolean isWeekend){
        this.isWeekend = isWeekend;
    }

    //Checks
    public boolean isWeekend(){
        return this.isWeekend;
    }

}
