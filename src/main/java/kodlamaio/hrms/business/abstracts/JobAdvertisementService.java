package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByEmployerIdAndIsActiveTrue(int employerId);
    DataResult<List<JobAdvertisement>> getByIsActiveTrue();
    DataResult<List<JobAdvertisement>> getByDeadlineLessThanEqual(LocalDate date);
    Result add(JobAdvertisement jobAdvertisement);
}
