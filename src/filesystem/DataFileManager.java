package filesystem;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DataFileManager {

    protected static final String corpcodeFilePath = "documents/CORPCODE.xml";
    protected static final String dataDir = "data/";
    protected static final String dartDir = dataDir + "dart/";
    protected static final String fnlttSinglAcntAllDir = dartDir + "fnlttSinglAcntAll/";

    protected static final String stockDir = dataDir + "stock/";
    protected static final String krxDir = dataDir + "krx/";

    // 경로 지정 오류 시 no_use 폴더에 모음
    protected String directory = dataDir + "no_use/";



    
protected String getTagValue(Element element, String tagName) {
    NodeList nodeList = element.getElementsByTagName(tagName);
    if (nodeList != null && nodeList.getLength() > 0) {
        Node node = nodeList.item(0);
        if (node != null && node.getTextContent() != null) {
            return node.getTextContent().trim();
        }
    }
    return "";
}


}
