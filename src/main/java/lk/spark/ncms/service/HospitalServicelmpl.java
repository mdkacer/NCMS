package lk.spark.ncms.service;

import lk.spark.ncms.dao.Hospital;
import lk.spark.ncms.repository.HospitalRepository;

public class HospitalServicelmpl implements HospitalService {
    @Override
    public String registerHospital(Hospital hospitalInformation) {
//        InputValidation inputValidation = new InputValidationlmpl();
//        String validationResult = (String) inputValidation.validationHospitalRegister(hospitalInformation);
        HospitalRepository hospitalRepository = new HospitalRepository();
        String result;
//        if (validationResult != null) {
//            return validationResult;
//        } else{
            result = hospitalRepository.registerHospital(hospitalInformation);
            return result;
//        }

    }
}
