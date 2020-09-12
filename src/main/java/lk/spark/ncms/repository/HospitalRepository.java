package lk.spark.ncms.repository;

import lk.spark.ncms.dao.Hospital;
import lk.spark.ncms.dao.HospitalsWithBed;
import lk.spark.ncms.db.DBConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class HospitalRepository {
    public String registerHospital(Hospital hospitalInformation){
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;

        ResultSet rs2 = null;
        Connection con2 = null;
        PreparedStatement stmt2 = null;

        int resultHospital = 0;
        int resultBed = 0;

        try{
            UUID uID = UUID.randomUUID();
            String uId = uID.toString();

            con = DBConnectionPool.getInstance().getConnection();
            stmt = con.prepareStatement("INSERT INTO hospital (id, name, district, location_x, location_y, build_date) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, uId);
            stmt.setString(2, hospitalInformation.getName());
            stmt.setString(3, hospitalInformation.getDistrict());
            stmt.setInt(4, hospitalInformation.getxCoordinate());
            stmt.setInt(5, hospitalInformation.getyCoordinate());
            stmt.setDate(6, new Date(new java.util.Date().getTime()));
            resultHospital = stmt.executeUpdate();

            con2 = DBConnectionPool.getInstance().getConnection();
            stmt2 = con2.prepareStatement("INSERT INTO hospital_bed (id, hospital_id) VALUES (1,'" + uId + "'),(2,'" + uId + "'),(3,'" + uId + "'),(4,'" + uId + "'),(5,'" + uId + "'),(6,'" + uId + "'),(7,'" + uId + "'),(8,'" + uId + "'),(9,'" + uId + "'),(10,'" + uId + "')");
//            stmt2.setInt(1, Integer.parseInt(uId));
//            stmt2.setString(1, uId);

            resultBed = stmt2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBConnectionPool.getInstance().close(rs);
            DBConnectionPool.getInstance().close(stmt);
            DBConnectionPool.getInstance().close(con);

            DBConnectionPool.getInstance().close(rs2);
            DBConnectionPool.getInstance().close(stmt2);
            DBConnectionPool.getInstance().close(con2);

        }
        return (resultHospital > 0 && resultBed > 0 ? "Hospital Registration Success" : "Hospital Registration Failed \n" +
                " Maximum Number of Hospitals Reached Already..!! ");

    }

    public ArrayList<HospitalsWithBed> getHospitalsWithBeds(){

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
//        int test = 0;

        ArrayList<HospitalsWithBed> hospitalWithBedDetails = new ArrayList<>();
        try {

            con = DBConnectionPool.getInstance().getConnection();
            stmt = con.prepareStatement("SELECT DISTINCT (id, location_x, location_y) FROM hospital INNER JOIN hospital_bed ON hospital.id = hospital_bed.hospital_id AND hospital_bed.patient_id IS NULL ");
            rs = stmt.executeQuery();
//            test = stmt.getFetchSize();
            while(rs.next()){

                HospitalsWithBed hospitalsWithBed = new HospitalsWithBed(rs.getString("id"), rs.getInt("location_x"), rs.getInt("location_y"));
                hospitalWithBedDetails.add(hospitalsWithBed);

            }

        }catch (SQLException e){

            e.printStackTrace();
        }finally {

            DBConnectionPool.getInstance().close(rs);
            DBConnectionPool.getInstance().close(stmt);
            DBConnectionPool.getInstance().close(con);
        }
        return hospitalWithBedDetails;

    }
}
