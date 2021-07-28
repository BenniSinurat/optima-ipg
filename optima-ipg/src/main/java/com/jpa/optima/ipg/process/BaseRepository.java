package com.jpa.optima.ipg.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseRepository {

	@Autowired
	private IPGRepository ipgRepository;

	public IPGRepository getIpgRepository() {
		return ipgRepository;
	}

	public void setIpgRepository(IPGRepository ipgRepository) {
		this.ipgRepository = ipgRepository;
	}
	
	
}
