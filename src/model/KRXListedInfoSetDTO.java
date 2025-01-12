package model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class KRXListedInfoSetDTO {

    private List<String> isinCdList;
    private Map<String, KRXListedInfoDTO> dtoMap;
    
}
