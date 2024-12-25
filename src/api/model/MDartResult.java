package api.model;

import lombok.Data;
import java.util.List;

@Data
public class MDartResult {

    private List<MDartCorpcode> corpcodeList;
    private List<MDartFnlttSinglAcntAll> fnlttSinglAcntAllList;

}
