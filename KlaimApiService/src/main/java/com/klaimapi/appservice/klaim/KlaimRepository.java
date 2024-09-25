package com.klaimapi.appservice.klaim;

import com.klaimapi.common.Klaim;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlaimRepository extends CrudRepository<Klaim, Long> {}
