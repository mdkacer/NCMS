package lk.spark.ncms.service;

public interface InputValidation {
    public Object validationHospitalRegister(String name, String district, String xCoordinate, String yCoordinate);
    public Object validationPatientRegister(String firstName, String lastName, String district, String locationX, String locationY, String gender, String contact, String email, String age);
    public Object validationSignUpUser(String username, String password, String name, String moh, String hospital);
    public Object validationSignInUser(String username, String password);
}
