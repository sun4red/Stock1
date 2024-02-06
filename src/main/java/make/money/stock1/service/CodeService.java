package make.money.stock1.service;

import make.money.stock1.dao.CodeDao;
import make.money.stock1.model.CorpCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeService {

    private final CodeDao codeDao;

    public CodeService(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public void insertCode(CorpCode corpCode) {
        codeDao.insertCode(corpCode);
    }


    public List<CorpCode> searchStock(CorpCode corpCode){

        if(corpCode.getStock_code() != 0){
            return codeDao.searchByStockCode(corpCode);
        }else if(corpCode.getCorp_code() != 0){
            return codeDao.searchByCorpCode(corpCode);
        }else{
            return codeDao.searchByCorpName(corpCode);
        }

    }

}
