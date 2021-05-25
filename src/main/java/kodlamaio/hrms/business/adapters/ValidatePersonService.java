package kodlamaio.hrms.business.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface ValidatePersonService {
    boolean validate(JobSeeker person);
}
