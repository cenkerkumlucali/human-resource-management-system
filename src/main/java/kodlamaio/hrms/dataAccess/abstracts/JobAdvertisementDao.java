package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    List<JobAdvertisement> getByEmployerIdAndIsActiveTrue(int employerId);
    List<JobAdvertisement> getByIsActiveTrue();
    List<JobAdvertisement> getByDeadlineLessThanEqual(LocalDate date);
}
