package lk.spark.ncms.service;

import lk.spark.ncms.dao.Hospital;

public class InputValidationlmpl implements InputValidation{

//    private String name;
//    private String district;
//    private int xCoordinate;
//    private int yCoordinate;

    @Override
    public String validationHospitalRegister(Hospital hospitalInformation){

//        name = hospitalInformation.getName();
//        district = hospitalInformation.getDistrict();
//        xCoordinate = hospitalInformation.getxCoordinate();
//        yCoordinate = hospitalInformation.getyCoordinate();

        if(hospitalInformation.getName().equals(null) || hospitalInformation.getName().isEmpty() || hospitalInformation.getDistrict().equals(null)){
            return "Please Fill the All Fields";
        }else {
            return null;
        }
    }
}
