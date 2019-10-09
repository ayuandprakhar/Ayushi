package com.wp.services;

import java.util.List;
import java.util.Map;

import com.wp.entities.Vehicles;

public interface VehicleServiceInterface {
	
	public void addVehicle(Vehicles v);

	public void removeVehicle(String v_id);

	public void updateVehicle(Vehicles v);

	public Vehicles getVehicle(String v_id);

	public List<Vehicles> getAllVehicle(String email);
	
	Map<String, String> getId(String email);
	public List<Vehicles> getAllVehicles();

}
