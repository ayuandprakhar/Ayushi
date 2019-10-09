package com.wp.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.VehicleDAOInterface;
import com.wp.DAO.VehicleImplementation;
import com.wp.entities.Vehicles;
@Service
public class VehicleServiceImplementation  implements VehicleServiceInterface{

	@Autowired
	 private VehicleDAOInterface vehicle;
	public void addVehicle(Vehicles v) {
		vehicle.addVehicle(v);
		
	}

	public void removeVehicle(String v_id) {
		vehicle.removeVehicle(v_id);
		
	}

	public void updateVehicle(Vehicles v) {
		vehicle.updateVehicle(v);
		
	}

	public Vehicles getVehicle(String v_id) {
		
		return vehicle.getVehicle(v_id);
	}

	public List<Vehicles> getAllVehicle(String email) {
		
		return vehicle.getAllVehicle(email);
	}

	public Map<String, String> getId(String email) {
		return vehicle.getId(email);
	}

}
