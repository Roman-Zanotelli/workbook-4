package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private boolean isOccupied, isDirty;
    private RoomType type;

    public Room(int numberOfBeds, RoomType type) {
        this.numberOfBeds = numberOfBeds;
        this.type = type;
    }

    //Gets
    public int getNumberOfBeds(){
        return numberOfBeds;
    }
    public float getPrice(){
        return type.getPricePerNight();
    }
    public RoomType getType(){
        return type;
    }

    //Sets
    public void setType(RoomType type){
        this.type = type;
    }

    //Checks
    public boolean isOccupied(){
        return this.isOccupied;
    }
    public boolean isDirty(){
        return this.isDirty;
    }
    public boolean isAvailable(){
        return !(isDirty || isOccupied);
    }

    //Methods
    public boolean checkIn(){ //false if already occupied
        if(isOccupied) return false;
        isOccupied = true;
        isDirty = true;
        return true;
    }
    public boolean checkout(){ //false if already not occupied
        if(!isOccupied) return false;
        isOccupied = false;
        return true;
    }
    public boolean cleanroom(){ //false if already clean
        if(!isDirty) return false;
        isDirty = false;
        return true;
    }
}
