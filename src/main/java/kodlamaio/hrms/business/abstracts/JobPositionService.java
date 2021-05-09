package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getAll();
    void add(JobPosition jobPosition);
    void delete(Integer id);
}
