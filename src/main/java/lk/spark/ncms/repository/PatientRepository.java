package lk.spark.ncms.repository;

import lk.spark.ncms.dao.Patient;
import lk.spark.ncms.db.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PatientRepository {

    public String newPatient(Patient patientInformation){

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;

        int resultPatient = 0;
        UUID uId = UUID.randomUUID();

        try {

//            uId = UUID.randomUUID();

            con = DBConnectionPool.getInstance().getConnection();
            stmt = con.prepareStatement("INSERT INTO patient (id, first_name, last_name, district, location_x, location_y, gender, contact, email, age) VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,uId.toString());
            stmt.setString(2,patientInformation.getFirstName());
            stmt.setString(3, patientInformation.getLastName());
            stmt.setString(4, patientInformation.getDistrict());
            stmt.setInt(5, patientInformation.getxCoordinate());
            stmt.setInt(6, patientInformation.getyCoordinate());
            stmt.setString(7,patientInformation.getGender());
            stmt.setString(8,patientInformation.getContact());
            stmt.setString(9,patientInformation.getEmail());
            stmt.setInt(10,patientInformation.getAge());

            resultPatient = stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();

        }finally {

            DBConnectionPool.getInstance().close(rs);
            DBConnectionPool.getInstance().close(stmt);
            DBConnectionPool.getInstance().close(con);
        }
        return resultPatient == 1 ? uId.toString() : "Patient Registration Failed..!!";
    }
}
