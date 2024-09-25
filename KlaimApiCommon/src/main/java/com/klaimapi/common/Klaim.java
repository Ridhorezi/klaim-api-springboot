package com.klaimapi.common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "klaim")
public class Klaim {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	@JsonProperty("id")
    private Long id;
    
	@Column(length = 255, nullable = false)
	@JsonProperty("lob")
	@NotBlank
    private String lob;
	
	@Column(length = 255, nullable = false)
	@JsonProperty("penyebab_klaim")
	@NotBlank
    private String penyebabKlaim;
	
	@Column(nullable = false)
	@JsonProperty("periode")
	@NotNull
    private Date periode;
    
	@Column(nullable = false)
	@JsonProperty("nilai_beban_klaim")
	@NotNull
    private Double nilaiBebanKlaim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getPenyebabKlaim() {
		return penyebabKlaim;
	}

	public void setPenyebabKlaim(String penyebabKlaim) {
		this.penyebabKlaim = penyebabKlaim;
	}

	public Date getPeriode() {
		return periode;
	}

	public void setPeriode(Date periode) {
		this.periode = periode;
	}

	public Double getNilaiBebanKlaim() {
		return nilaiBebanKlaim;
	}

	public void setNilaiBebanKlaim(Double nilaiBebanKlaim) {
		this.nilaiBebanKlaim = nilaiBebanKlaim;
	}
	
}
