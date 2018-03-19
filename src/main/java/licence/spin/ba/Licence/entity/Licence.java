package licence.spin.ba.Licence.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="Licence")
@Table(name="Licence")
@NamedQuery(name="updateLicence",query   =   "UPDATE Licence SET pocetakTrajanjaLicence = ?1, istekLicence = ?2 ,isporuceno=?3,katBroj=?4,  brojPredracuna=?5,"
		+ "kolicinaLicenci=?6,opis=?7  WHERE id = ?8")
/*@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})
@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "updateLicence",
            query   =   "UPDATE licence SET pocetakTrajanjaLicence = ?, istekLicence = ? ,isporuceno=?,katBroj=?,  brojPredracuna=?,"
            		+ "kolicinaLicenci=?,opis=?  WHERE id = ?"
            ,resultSetMapping = "updateResult"
    )
    
})
*/
public class Licence {
	
	@Id
	@GeneratedValue
	int id ;
	
	
	
	String tipLicence;
	
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date pocetakTrajanjaLicence;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date istekLicence;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date isporuceno;
	
	String katBroj;
	String  brojPredracuna;
	int kolicinaLicenci;
	String opis;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	
	
	public Licence() {
		
	}
	
	
	

	public Licence(int id, String tipLicence, Date pocetakTrajanjaLicence, Date istekLicence, Date isporuceno,
			String katBroj, String brojPredracuna, int kolicinaLicenci, String opis) {
		super();
		this.id = id;
		this.tipLicence = tipLicence;
		this.pocetakTrajanjaLicence = pocetakTrajanjaLicence;
		this.istekLicence = istekLicence;
		this.isporuceno = isporuceno;
		this.katBroj = katBroj;
		this.brojPredracuna = brojPredracuna;
		this.kolicinaLicenci = kolicinaLicenci;
		this.opis = opis;
		
	}









	public Licence(int id, String tipLicence, Date pocetakTrajanjaLicence, Date istekLicence, Date isporuceno,
			String katBroj, String brojPredracuna, int kolicinaLicenci, String opis, Customer customer) {
		super();
		this.id = id;
		this.tipLicence = tipLicence;
		this.pocetakTrajanjaLicence = pocetakTrajanjaLicence;
		this.istekLicence = istekLicence;
		this.isporuceno = isporuceno;
		this.katBroj = katBroj;
		this.brojPredracuna = brojPredracuna;
		this.kolicinaLicenci = kolicinaLicenci;
		this.opis = opis;
		this.customer = customer;
		
	}


    

	public void setId(int id) {
		this.id = id;
	}




	public String getTipLicence() {
		return tipLicence;
	}

	public void setTipLicence(String tipLicence) {
		this.tipLicence = tipLicence;
	}


	public Date getPocetakTrajanjaLicence() {
		return pocetakTrajanjaLicence;
	}

	public void setPocetakTrajanjaLicence(Date pocetakTrajanjaLicence) {
		this.pocetakTrajanjaLicence = pocetakTrajanjaLicence;
	}

	public Date getIstekLicence() {
		return istekLicence;
	}

	public void setIstekLicence(Date istekLicence) {
		this.istekLicence = istekLicence;
	}

	public Date getIsporuceno() {
		return isporuceno;
	}

	public void setIsporuceno(Date isporuceno) {
		this.isporuceno = isporuceno;
	}

	public String getKatBroj() {
		return katBroj;
	}

	public void setKatBroj(String katBroj) {
		this.katBroj = katBroj;
	}

	public String getBrojPredracuna() {
		return brojPredracuna;
	}

	public void setBrojPredracuna(String brojPredracuna) {
		this.brojPredracuna = brojPredracuna;
	}

	public int getKolicinaLicenci() {
		return kolicinaLicenci;
	}

	public void setKolicinaLicenci(int kolicinaLicenci) {
		this.kolicinaLicenci = kolicinaLicenci;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	public String getOpis() {
		return opis;
	}




	public void setOpis(String opis) {
		this.opis = opis;
	}




	public int getId() {
		return id;
	}

	public String getCustName() {
		return customer.getName();
	}
	
	public String getCustemail() {
		return customer.geteMail();
	}



	@Override
	public String toString() {
		return "Licence [id=" + id + ", tipLicence=" + tipLicence + ", pocetakTrajanjaLicence=" + pocetakTrajanjaLicence
				+ ", istekLicence=" + istekLicence + ", isporuceno=" + isporuceno + ", katBroj=" + katBroj
				+ ", brojPredracuna=" + brojPredracuna + ", kolicinaLicenci=" + kolicinaLicenci + ", opis=" + opis
				+ "]";
	}










	
	
	
	
	
}
