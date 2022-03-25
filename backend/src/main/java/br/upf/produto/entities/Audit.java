package br.upf.produto.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Audit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "date_register", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataRegister;
	@Column(name = "date_last_edition",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dateLastEdition;
	
	public Audit() {
	}

	public Audit(Instant dataRegister, Instant dateLastEdition) {
		this.dataRegister = dataRegister;
		this.dateLastEdition = dateLastEdition;
	}

	public Instant getDataRegister() {
		return dataRegister;
	}

	public void setDataRegister(Instant dataRegister) {
		this.dataRegister = dataRegister;
	}

	public Instant getDateLastEdition() {
		return dateLastEdition;
	}

	public void setDateLastEdition(Instant dateLastEdition) {
		this.dateLastEdition = dateLastEdition;
	}
}
