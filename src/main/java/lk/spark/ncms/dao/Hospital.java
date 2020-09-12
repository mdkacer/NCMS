package lk.spark.ncms.dao;

public class Hospital {
    private String name;
    private String district;
    private int xCoordinate;
    private int yCoordinate;

    public Hospital(String name, String district, int xCoordinate, int yCoordinate){
        this.name = name;
        this.district = district;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public String getName() {

        return name;
    }
    public String getDistrict(){

        return district;
    }
    public int getxCoordinate(){

        return xCoordinate;
    }
    public int getyCoordinate() {

        return yCoordinate;
    }
}
