package licence.spin.ba.Licence.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import licence.spin.ba.Licence.entity.Customer;
import licence.spin.ba.Licence.entity.Licence;

@Repository
@Transactional
public class LicenceRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public Licence saveLicence(Licence licence) {
		System.out.println("------>"+licence);
		
		
		if(licence==null) {
			em.persist(licence);
		}else {
			em.merge(licence);
		}
		return licence;
		
	}
	
   public Licence findLicenceById(int id) {
		
		
		return em.find(Licence.class,id);
	}
	
	//Update Licence
	public boolean  updateLicence(Licence licence , int id) {
		System.out.println("licence opis jeee===="+licence.getOpis());
		
		try
	    {
			
			Query query = em.createNativeQuery("UPDATE LICENCE SET datum_Isteka=?,instalirano=?,fakturisano=?,broj_Fakture=?,Kolicina_Licenci=?,opis=?,Tip_Licence=?  WHERE ID=?",Licence.class);
			query.setParameter(1, licence.getdatumIsteka());
			query.setParameter(2, licence.getInstalirano());
			query.setParameter(3, licence.getFakturisano());
			query.setParameter(4, licence.getbrojFakture());
			query.setParameter(5, licence.getKolicinaLicenci());			
			query.setParameter(6, licence.getOpis());
			query.setParameter(7, licence.getTipLicence());
			query.setParameter(8, id);
			
			query.executeUpdate();
			
	        return true;
	    }
	    catch (Exception e)
	    {
	        return false;
	    }
		
			
	
	}
	
	//Find all by id (to generate PDF)
		public List<Licence> getAllByIdForPDF(int id) {
			
			Query query = em.createNativeQuery("SELECT * FROM licence WHERE ID=?",Licence.class);
			query.setParameter(1, id);
			List<Licence> theLicence=query.getResultList();
			
			return theLicence;
			
			
		}

}
