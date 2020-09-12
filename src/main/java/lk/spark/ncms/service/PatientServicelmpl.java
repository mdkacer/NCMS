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
        String patientId = patientRepository.newPatient(patientInformation);

        if (!patientId.equals("Patient Registration Failed..!!")){
            HospitalRepository hospitalRepository = new HospitalRepository();
            ArrayList<HospitalsWithBed> hospitalsWithBedArrayList = hospitalRepository.getHospitalsWithBeds();

            if (hospitalsWithBedArrayList.isEmpty()){

                PatientQueueRepository patientQueueRepository = new PatientQueueRepository();
                return patientQueueRepository.addToQueue(patientId);

            }else {

                double distance = 0.0;
                String hospitalId = null;

                for (HospitalsWithBed hospitalsWithBed : hospitalsWithBedArrayList){

                    double xDistance = (double)Math.pow(patientInformation.getxCoordinate() - hospitalsWithBed.getxCoordinate(),2);
                    double yDistance = (double)Math.pow(patientInformation.getyCoordinate() - hospitalsWithBed.getyCoordinate(),2);
                    double calculatedDistence = (double)Math.sqrt(xDistance + yDistance);

                    if (distance == 0.0 || distance > calculatedDistence){

                        hospitalId = hospitalsWithBed.getHospitalId();
                        distance = calculatedDistence;
                    }
                }

                HospitalBedRepository hospitalBedRepository = new HospitalBedRepository();
                hospitalBedRepository.admitPatient(hospitalId, patientId);
            }

            return "Patient Registration Successful";

        }else {

            return patientId;
        }

//        return null;
    }
}
