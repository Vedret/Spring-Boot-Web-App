package licence.spin.ba.Licence.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="licence")
public class Licence {
	
	@Id
	@GeneratedValue
	int id ;
	
	@Column(unique=true)
	String tipLicence;
	
	@Column(unique=true)
	String imeLicence;
	
	LocalDateTime pocetakTrajanjaLicence;
	LocalDateTime istekLicence;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public String getTipLicence() {
		return tipLicence;
	}

	public void setTipLicence(String tipLicence) {
		this.tipLicence = tipLicence;
	}

	public String getImeLicence() {
		return imeLicence;
	}

	public void setImeLicence(String imeLicence) {
		this.imeLicence = imeLicence;
	}

	public LocalDateTime getPocetakTrajanjaLicence() {
		return pocetakTrajanjaLicence;
	}

	public void setPocetakTrajanjaLicence(LocalDateTime pocetakTrajanjaLicence) {
		this.pocetakTrajanjaLicence = pocetakTrajanjaLicence;
	}

	public LocalDateTime getIstekLicence() {
		return istekLicence;
	}

	public void setIstekLicence(LocalDateTime istekLicence) {
		this.istekLicence = istekLicence;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
