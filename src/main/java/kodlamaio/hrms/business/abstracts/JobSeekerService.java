package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    List<JobSeeker> getAll();
    void add(JobSeeker jobSeeker);
    void delete(Integer id);
    void update(JobSeeker jobSeeker);
}
