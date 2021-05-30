package kodlamaio.hrms.business.concretes;

import antlr.CodeGenerator;
import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ActivationCodeManager implements ActivationCodeService {

    ActivationCodeDao activationCodeDao;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
    }


    @Override
    public DataResult<List<ActivationCode>> getAll() {
        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),"Listelendi");
    }

    @Override
    public DataResult<ActivationCode> getByUserId(int userId) {
        return new SuccessDataResult<ActivationCode>(this.activationCodeDao.getByUserId(userId));
    }

    @Override
    public Result add(ActivationCode activationCode) {
        activationCode.setExprationDate(LocalDateTime.now());
        activationCode.setUid(UUID.randomUUID().toString());
        activationCodeDao.save(activationCode);
        return new SuccessResult("Başarılı");
    }

    @Override
    public Result update(ActivationCode activationCode) {
        return null;
    }
}
