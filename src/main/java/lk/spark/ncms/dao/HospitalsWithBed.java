package lk.spark.ncms.dao;

public class HospitalsWithBed {

    private String hospitalId;
    private int xCoordinate;
    private int yCoordinate;
//    private int bedNo;

    public HospitalsWithBed(String hospitalId, int location_x, int location_y) {

        this.hospitalId = hospitalId;
        this.xCoordinate = location_x;
        this.yCoordinate = location_y;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}
