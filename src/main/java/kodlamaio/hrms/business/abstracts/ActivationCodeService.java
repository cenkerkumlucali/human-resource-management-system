package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;

import java.util.List;

public interface ActivationCodeService {
    DataResult<List<ActivationCode>> getAll();
    DataResult<ActivationCode> getByUserId(int userId);
    Result add(ActivationCode activationCode);
    Result update(ActivationCode activationCode);

}
