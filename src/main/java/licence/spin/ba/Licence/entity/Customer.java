package licence.spin.ba.Licence.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;





@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue
	int id;
	
	@Column(nullable = false,unique=true)
	@NotEmpty(message="Polje ne smije biti prazno")
	String name;
	
	
	@Column(nullable = false)
	@NotEmpty(message="Polje ne smije biti prazno")
	String eMail;
	
	String phone;
	
	String addressa;
	
	String grad;
	
	String opis;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.EAGER)	
	private List<Licence> licence = new ArrayList<>();
	
	public Customer() {
	}
	
	

	public Customer(String name, String eMail, String phone, String addressa, String grad) {
		super();
		this.name = name;
		this.eMail = eMail;
		this.phone = phone;
		this.addressa = addressa;
		this.grad = grad;
	}
	



	

	public Customer( String name,
			String eMail, String phone, String addressa, String grad,
			String opis, List<Licence> licence) {
		super();
		this.name = name;
		this.eMail = eMail;
		this.phone = phone;
		this.addressa = addressa;
		this.grad = grad;
		this.opis = opis;
		this.licence = licence;
	}



	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressa() {
		return addressa;
	}

	public void setAddressa(String addressa) {
		this.addressa = addressa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}



	public String getOpis() {
		return opis;
	}



	public void setOpis(String opis) {
		this.opis = opis;
	}


	//Mappin relation
	public List<Licence> getLicence() {
		return licence;
	}


	//Mappin relation
	public void addLicence(Licence licence) {
		this.licence.add(licence);
	}
	//Mappin relation
	public void removeLicence(Licence licence) {
		this.licence.remove(licence);
	}
	
	



	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", eMail=" + eMail + ", phone=" + phone + ", addressa="
				+ addressa + ", grad=" + grad + ", opis=" + opis + ", licence=" + licence + "]";
	}






	

	
	
	
	
	
	
	
	
	
	

}
