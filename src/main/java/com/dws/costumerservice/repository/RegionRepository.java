package com.dws.costumerservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dws.costumerservice.dto.Region;
import com.dws.costumerservice.dto.RespuestaApi;

@Repository
public class RegionRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Region> getRegions(){
		List<Region> regions = new ArrayList<>();
		regions = jdbcTemplate.query("SELECT * FROM region;", new BeanPropertyRowMapper<Region>(Region.class));
		
		return regions;
	}
	
	public Region getRegion(int id){
		Region region = new Region();
		
		String query = "SELECT * FROM region WHERE id = " + id + ";";
		region = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Region>(Region.class));
		
		return region;
	}
	
	public RespuestaApi createRegion(Region region){
		RespuestaApi msg = new RespuestaApi();
		
		String query = "INSERT INTO region (region) VALUES('" + region.getRegion() + "');";
		jdbcTemplate.update(query);
		
		msg.setMessage("La region ha sido registrada");
		
		return msg;
	}
	
	public RespuestaApi updateRegion(Region region, int id){
		RespuestaApi msg = new RespuestaApi();
		
		String query = "UPDATE region SET region = '" + region.getRegion() + "' WHERE id = " + id +";";
		jdbcTemplate.update(query);
		
		msg.setMessage("La region ha sido actualizada");
		
		return msg;
	}
	

	public RespuestaApi deleteRegion(int id){
		RespuestaApi msg = new RespuestaApi();
		
		String query = "DELETE FROM region WHERE id = " + id +";";
		jdbcTemplate.update(query);
		
		msg.setMessage("La region ha sido eliminada");
		
		return msg;
	}
}
