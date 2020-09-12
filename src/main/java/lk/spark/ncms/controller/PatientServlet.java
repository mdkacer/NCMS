package lk.spark.ncms.controller;

import com.google.gson.JsonObject;
import lk.spark.ncms.dao.Patient;
import lk.spark.ncms.service.PatientService;
import lk.spark.ncms.service.PatientServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PatientServlet")
public class PatientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Patient patientInformation = new Patient(req.getParameter("firstName"),req.getParameter("lastName"), req.getParameter("district"), Integer.parseInt(req.getParameter("locationX")), Integer.parseInt(req.getParameter("locationY")), req.getParameter("gender"), req.getParameter("contact"), req.getParameter("email"), Integer.parseInt(req.getParameter("age")));
        PatientService patientService = new PatientServicelmpl();
        String result = patientService.registerPatient(patientInformation);
        this.sendResponse(result, resp);
    }

    private void sendResponse(String data, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        JsonObject json = new JsonObject();
        json.addProperty("Response", data);
        writer.print(json.toString());
        writer.flush();
    }
}
