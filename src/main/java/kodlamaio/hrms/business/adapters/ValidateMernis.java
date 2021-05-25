package kodlamaio.hrms.business.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.services.UTOKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class ValidateMernis implements ValidatePersonService{

  private  UTOKPSPublicSoap mernis = new UTOKPSPublicSoap();
    @Override
    public boolean validate(JobSeeker person) {
        try {
            return mernis.TCKimlikNoDogrula(
                    Long.parseLong(person.getNationalIdentity()),
                    person.getName(),
                    person.getSurname(),
                    Integer.parseInt(person.getDateOfBirth()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
