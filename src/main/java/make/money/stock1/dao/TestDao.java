package make.money.stock1.dao;


import make.money.stock1.model.Test;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

        private final SqlSession session;

    public TestDao(SqlSession session) {
        this.session = session;
    }



    public int inserttest(Test test){
        return session.insert("test.inserttest", test);
    }
    //    public CorpCode getCorpCodeByStockCode(CorpCode corpCode) {
//        return session.selectOne("corpCode.getcorpcodebystockcode", corpCode);
//    }

}
