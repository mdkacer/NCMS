package lk.spark.ncms.controller;

import com.google.gson.JsonObject;
import lk.spark.ncms.dao.Hospital;
import lk.spark.ncms.service.HospitalService;
import lk.spark.ncms.service.HospitalServicelmpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HospitalServlet")

public class HospitalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Hospital hospitalInformation = new Hospital(req.getParameter("name"),req.getParameter("district"), Integer.parseInt(req.getParameter("xCoordinate")), Integer.parseInt(req.getParameter("yCoordinate")));
        HospitalService hospitalService = new HospitalServicelmpl();
        String result = hospitalService.registerHospital(hospitalInformation);
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
