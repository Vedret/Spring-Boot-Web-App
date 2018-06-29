package licence.spin.ba.Licence.entity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
import javax.persistence.Transient;


import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity(name="Licence")
@Table(name="Licence")
@NamedQuery(name="updateLicence",query   =   "UPDATE Licence SET pocetakTrajanjaLicence = ?1, datumIsteka = ?2 ,instalirano=?3,brojFakture=?4,  brojPredracuna=?5,"
		+ "kolicinaLicenci=?6,opis=?7  WHERE id = ?8")
/*@SqlResultSetMapping(name="updateResult", columns = { @ColumnResult(name = "count")})
@NamedNativeQueries({
    @NamedNativeQuery(
            name    =   "updateLicence",
            query   =   "UPDATE licence SET pocetakTrajanjaLicence = ?, datumIsteka = ? ,instalirano=?,brojFakture=?,  brojPredracuna=?,"
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
	
	
	
	@Column
	@Type(type="date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datumPrijave;
	@Column
	@Type(type="date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date datumIsteka;
	@Column
	@Type(type="date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date instalirano;
	@Column
	@Type(type="date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fakturisano;
	
	
	String brojFakture;
	String  brojPredracuna;
	int kolicinaLicenci;
	
	String opis;
	
	@Transient
    private MultipartFile  productImage;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	
	
	public Licence() {
		
	}
	


	public Licence(int id, String tipLicence, Date datumPrijave, Date datumIsteka, Date instalirano, Date fakturisano,
			String brojFakture, String brojPredracuna, int kolicinaLicenci,  String opis,
			Customer customer) {
		super();
		this.id = id;
		this.tipLicence = tipLicence;
		this.datumPrijave = datumPrijave;
		this.datumIsteka = datumIsteka;
		this.instalirano = instalirano;
		this.fakturisano = fakturisano;
		this.brojFakture = brojFakture;
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


	public Date getDatumPrijave() {
		
		return datumPrijave;
	}

	public void setDatumPrijave(Date datumPrijave) throws ParseException {
		
		this.datumPrijave =datumPrijave ;
	}

	public Date getdatumIsteka() {
		return datumIsteka;
	}

	public void setdatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}

	public Date getinstalirano() {
		return instalirano;
	}

	public void setinstalirano(Date instalirano) {
		this.instalirano = instalirano;
	}

	public String getbrojFakture() {
		return brojFakture;
	}

	public void setbrojFakture(String brojFakture) {
		this.brojFakture = brojFakture;
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




	public  int getId() {
		return id;
	}

	public String getCustName() {
		return customer.getName();
	}
	
	public String getCustemail() {
		return customer.geteMail();
	}

	private Date parseDate(String date, String format) throws ParseException
	{
	    SimpleDateFormat formatter = new SimpleDateFormat(format);
	    System.out.println(formatter.parse(date));
	    return formatter.parse(date);
	}
	
	public Date getDatumIsteka() {

		return datumIsteka ;
	}

	public void setDatumIsteka(Date datumIsteka)  {
	
		this.datumIsteka = datumIsteka;
	}

	public Date getInstalirano() {
		return instalirano;
	}

	public void setInstalirano(Date instalirano) {
		this.instalirano = instalirano;
	}

	public Date getFakturisano() {
		return fakturisano;
	}

	public void setFakturisano(Date fakturisano) {
		this.fakturisano = fakturisano;
	}
	
	
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}



	
	
	


}
