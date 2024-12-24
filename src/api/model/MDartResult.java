package api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import java.util.List;

@JacksonXmlRootElement(localName = "result")
@Data
public class MDartResult {

    @JacksonXmlProperty(localName = "list")
    private List<MDartCorpcode> corpcodeList;

}
