package com.example.user.afinal;

public class Save {
    public String Mapname;
    public String Xcoor;
    public String Ycoor;

    public Save(String mapname, String xcoor, String ycoor) {
        Mapname = mapname;
        Xcoor = xcoor;
        Ycoor = ycoor;
    }

    @Override
    public String toString() {
        return "Saves{" +
                "Mapname='" + Mapname + '\'' +
                ", Xcoor='" + Xcoor + '\'' +
                ", Ycoor='" + Ycoor + '\'' +
                '}';
    }

    public String getMapname() {
        return Mapname;
    }

    public void setMapname(String mapname) {
        Mapname = mapname;
    }

    public String getXcoor() {
        return Xcoor;
    }

    public void setXcoor(String xcoor) {
        Xcoor = xcoor;
    }

    public String getYcoor() {
        return Ycoor;
    }

    public void setYcoor(String ycoor) {
        Ycoor = ycoor;

    }

}
