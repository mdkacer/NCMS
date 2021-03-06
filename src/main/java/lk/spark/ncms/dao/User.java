package lk.spark.ncms.dao;

public class User {

    private String userName;
    private String password;
    private String name;
    private int moh;
    private int hospital;

    public User(String userName, String password, String name, int moh, int hospital) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.moh = moh;
        this.hospital = hospital;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getMoh() {
        return moh;
    }

    public int getHospital() {
        return hospital;
    }
}
