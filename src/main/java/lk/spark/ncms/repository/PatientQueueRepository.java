package lk.spark.ncms.repository;

import lk.spark.ncms.db.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientQueueRepository {

    public String addToQueue(String patientId){

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String result = null;
        int rows = 0;
//        UUID uID = UUID.randomUUID();
//        String uId = uID.toString();
        try {

            con = DBConnectionPool.getInstance().getConnection();
            stmt = con.prepareStatement("INSERT INTO patient_queue (patient_id) VALUES ('"+ patientId +"')");
//            stmt.setInt(1, Integer.parseInt(uId));
//            stmt.setString(2,patientId);
            rows = stmt.executeUpdate();
//            if (rows > 0){


//            }else {
//                result = patientId + " Could not Added to The Queue";
//            }
        }catch (SQLException e){

            e.printStackTrace();
        }finally {

            DBConnectionPool.getInstance().close(rs);
            DBConnectionPool.getInstance().close(stmt);
            DBConnectionPool.getInstance().close(con);
        }

        return  (rows > 0 ? "Patient Successfully Added to The Queue" : "Patient Could not Added to The Queue");
//        return result;
    }
}
