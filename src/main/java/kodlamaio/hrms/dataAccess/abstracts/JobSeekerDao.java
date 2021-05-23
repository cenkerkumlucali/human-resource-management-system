package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {

    @Query("SELECT s FROM JobSeeker s WHERE s.email=?1")
    Optional<JobSeeker> findEmail(String email);

    @Query("SELECT s FROM JobSeeker s WHERE s.nationalIdentity=?1")
    Optional<JobSeeker> findNationalIdentity(String nationalIdentity);
}
