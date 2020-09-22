package lk.spark.ncms.service;

import lk.spark.ncms.dao.HospitalsWithBed;
import lk.spark.ncms.dao.Patient;
import lk.spark.ncms.repository.HospitalBedRepository;
import lk.spark.ncms.repository.HospitalRepository;
import lk.spark.ncms.repository.PatientQueueRepository;
import lk.spark.ncms.repository.PatientRepository;

import java.util.ArrayList;

public class PatientServicelmpl implements PatientService {

    @Override
    public String registerPatient(Patient patientInformation) {
        PatientRepository patientRepository = new PatientRepository();
        String patientId = patientRepository.addPatient(patientInformation);

        if (!patientId.equals(null)) {
            HospitalRepository hospitalRepository = new HospitalRepository();
            ArrayList<HospitalsWithBed> hospitalsWithBedArrayList;
            hospitalsWithBedArrayList = hospitalRepository.getHospitalsWithBeds();

            if (hospitalsWithBedArrayList.isEmpty()) {
                PatientQueueRepository patientQueueRepository = new PatientQueueRepository();
                return patientQueueRepository.addToQueue(patientId);
//                return hospitalsWithBedArrayList.get();

            } else {

                double distance = 0.0;
                String hospitalId = "Hospital ID Servlet";
                String test = "testPatientServlet";
//                int i = 0;
                for (HospitalsWithBed hospitalsWithBed : hospitalsWithBedArrayList) {
//                    i++;
                    double xDistance = (double) Math.pow(patientInformation.getxCoordinate() - hospitalsWithBed.getxCoordinate(), 2);
                    double yDistance = (double) Math.pow(patientInformation.getyCoordinate() - hospitalsWithBed.getyCoordinate(), 2);
                    double calculatedDistence = (double) Math.sqrt(xDistance + yDistance);
                    test = "For Loop ";
                    if (distance == 0.0 || distance > calculatedDistence) {

                        hospitalId = hospitalsWithBed.getHospitalId();
                        distance = calculatedDistence;
                        test = (hospitalId + " sfsafgrg fdvbdfg rgerg " + distance);
                    }
                }

                HospitalBedRepository hospitalBedRepository = new HospitalBedRepository();
                return hospitalBedRepository.admitPatient(hospitalId, patientId);
//                return String.valueOf(hospitalsWithBedArrayList);
            }


        } else {

            return "Patient Registration Failed..!!";
        }

//        return null;
    }
}
