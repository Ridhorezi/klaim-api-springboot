package com.klaimapi.appservice.klaim;

import java.net.URI;

import com.klaimapi.common.Klaim;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/klaims")
public class KlaimApiController {

	private KlaimService klaimService;

	public KlaimApiController(KlaimService klaimService) {
		super();
		this.klaimService = klaimService;
	}	
	
	@PostMapping
	public ResponseEntity<Klaim> add(@RequestBody @Valid Klaim klaim) {
		
		Klaim addedKlaim = klaimService.add(klaim);
		
		URI uri = URI.create("/v1/klaims/" + klaim.getLob()); 
				
		return ResponseEntity.created(uri).body(addedKlaim);
	}
}
