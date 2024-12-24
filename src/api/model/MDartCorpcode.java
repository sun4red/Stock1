package api.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "list")
public class MDartCorpcode {

    @JacksonXmlProperty(localName = "corp_code")
    private String corp_code;
    @JacksonXmlProperty(localName = "corp_name")
    private String corp_name;
    @JacksonXmlProperty(localName = "stock_code")
    private String stock_code;
    @JacksonXmlProperty(localName = "modify_date")
    private String modify_date;

    @Override
    public String toString() {
        return "Company{" +
                "corp_code='" + corp_code + '\'' +
                ", corp_name='" + corp_name + '\'' +
                ", stock_code='" + stock_code + '\'' +
                ", modify_date='" + modify_date + '\'' +
                '}';
    }

}
