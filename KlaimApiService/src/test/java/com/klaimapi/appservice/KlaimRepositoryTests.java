package com.klaimapi.appservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import com.klaimapi.appservice.klaim.KlaimRepository;
import com.klaimapi.common.Klaim;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class KlaimRepositoryTests {

	@Autowired
	private KlaimRepository klaimRepository;
	
	@Test
	public void testAddSuccess() {
		
		Klaim klaim = new Klaim();
		
		klaim.setLob("test");
		klaim.setPenyebabKlaim("macet");
		klaim.setPeriode(new Date());
		klaim.setNilaiBebanKlaim(1.00);
		
		Klaim savedKlaim = klaimRepository.save(klaim);
		
		assertThat(savedKlaim).isNotNull();
		
		assertThat(savedKlaim.getLob()).isEqualTo("test");
	}
}
