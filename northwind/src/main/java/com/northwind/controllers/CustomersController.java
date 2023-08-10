package com.northwind.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entities.Customers;


@RestController
@RequestMapping("/customers")
public class CustomersController {

	@GetMapping
	public synchronized static List<JsonObject> getAllCustomers(){
		
		
		JsonObjectBuilder customersJsonBuilder = Json.createObjectBuilder();
		List<JsonObject> allCustomers = new ArrayList<>();
		
		
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT * FROM customers");
			ConnectionFactory.getConnection();
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sb.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String comapany = rs.getString("company");
				String last_name = rs.getString("last_name");
				String first_name = rs.getString("first_name");
				String job_title = rs.getString("job_title");
				//String business_phone = rs.getString("business_phone");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state_province = rs.getString("state_province");
				Long zip_postal_code = rs.getLong("zip_postal_code");
				
				customersJsonBuilder.add("company", comapany);
				customersJsonBuilder.add("state_province", state_province);
				customersJsonBuilder.add("zip_postal_code", zip_postal_code);
				customersJsonBuilder.add("first_name", first_name);
				customersJsonBuilder.add("last_name", last_name);
				customersJsonBuilder.add("job_title", job_title);
				customersJsonBuilder.add("id", id);
				customersJsonBuilder.add("address",address);
				customersJsonBuilder.add("city", city);
				
				JsonObject customersJsonObject = customersJsonBuilder.build();
				
				allCustomers.add(customersJsonObject);
				
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(ConnectionFactory.getConnection() != null) {
					ConnectionFactory.getConnection().close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return allCustomers;
		
		
	}
	
}
