package com.dws.costumerservice.service;

import java.util.List;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;

public interface RegionService {
	
	public List<Region> getRegions();
	
	public Region getRegion(int id);
	
	public RespuestaApi createRegion(Region region);
	
	public RespuestaApi updateRegion(Region region, int id);
	
	public RespuestaApi deleteRegion(int id);
	
}
