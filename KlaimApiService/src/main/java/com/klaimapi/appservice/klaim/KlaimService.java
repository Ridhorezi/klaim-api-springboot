package com.klaimapi.appservice.klaim;

import com.klaimapi.common.Klaim;

import org.springframework.stereotype.Service;

@Service
public class KlaimService {

	private KlaimRepository klaimRepository;

	public KlaimService(KlaimRepository klaimRepository) {
		super();
		this.klaimRepository = klaimRepository;
	}
	
	public Klaim add(Klaim klaim) {
		
		return klaimRepository.save(klaim);
	}
}
