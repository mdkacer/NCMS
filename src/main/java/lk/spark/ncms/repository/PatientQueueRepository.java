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

        try {

            con = DBConnectionPool.getInstance().getConnection();
            stmt = con.prepareStatement("INSERT INTO patient_queue patient_id VALUES (+ patientId +)");

        }catch (SQLException e){

            e.printStackTrace();
        }finally {

            DBConnectionPool.getInstance().close(rs);
            DBConnectionPool.getInstance().close(stmt);
            DBConnectionPool.getInstance().close(con);
        }

        return "Patient Successfully Added to The Queue";
    }
}
