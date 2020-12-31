package com.example.jagan.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jagan.bean.Sample;
import com.example.jagan.service.SampleService;


@RestController
public class SampleController {

	@Autowired
	private SampleService service;
	
	@GetMapping(path = "/")
	public HashMap<String, String> imUpAndRunning(HttpServletRequest request) {
		if(service.count()==null) {
			HashMap<String, String> returnMap = new HashMap<>();
			returnMap.put("healthy", "false");
			returnMap.put("IP", getClientIp(request));
			return returnMap;
		}else
		{
			HashMap<String, String> returnMap = new HashMap<>();
			returnMap.put("healthy", "true");
			returnMap.put("Count", service.count().size()+"");
			returnMap.put("IP", getClientIp(request));
			return returnMap;
		}
	}

	@GetMapping(path = "/hit")
	public HashMap<String, String> hitDb(HttpServletRequest request) {
		
		Sample insert = new Sample();
		insert.setInformation("Data");
		service.save(insert);
		HashMap<String, String> returnMap = new HashMap<>();
		returnMap.put("status", "Success");
		returnMap.put("Count", service.count().size()+"");
		return returnMap;
	}
	
	private static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
}
