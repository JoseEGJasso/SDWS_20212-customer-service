package com.dws.costumerservice.service;

import java.util.List;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;
import com.dws.costumerservice.repository.RegionRepository;

@Service
public class RegionServiceImp implements RegionService {

	@Autowired
	RegionRepository regionRepository;
	
	@Override
	public List<Region> getRegions() {
		// TODO Auto-generated method stub
		return regionRepository.getRegions();
	}

	@Override
	public Region getRegion(int id) {
		// TODO Auto-generated method stub
		return regionRepository.getRegion(id);
	}

	@Override
	public RespuestaApi createRegion(Region region) {
		// TODO Auto-generated method stub
		return regionRepository.createRegion(region);
	}

	@Override
	public RespuestaApi updateRegion(Region region, int id) {
		// TODO Auto-generated method stub
		return regionRepository.updateRegion(region,id);
	}

	@Override
	public RespuestaApi deleteRegion(int id) {
		// TODO Auto-generated method stub
		return regionRepository.deleteRegion(id);
	}

}
