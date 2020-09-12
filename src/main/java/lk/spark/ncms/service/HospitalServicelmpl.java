package lk.spark.ncms.service;

import lk.spark.ncms.dao.Hospital;
import lk.spark.ncms.repository.HospitalRepository;

public class HospitalServicelmpl implements HospitalService {
    @Override
    public String registerHospital(Hospital hospitalInformation) {
        HospitalRepository hospitalRepository = new HospitalRepository();
        String result = hospitalRepository.registerHospital(hospitalInformation);
        return result;
    }
}
