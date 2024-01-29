package make.money.stock1.service;

import make.money.stock1.dao.CodeDao;
import make.money.stock1.model.CorpCode;
import org.springframework.stereotype.Service;

@Service
public class CodeService {

    private final CodeDao codeDao;

    public CodeService(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public void insertCode(CorpCode corpCode) {
        codeDao.insertCode(corpCode);
    }

}
