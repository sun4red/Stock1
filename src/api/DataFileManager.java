package api;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DataFileManager {

    protected final String corpcodeFilePath = "documents/CORPCODE.xml";
    protected final String dataDir = "data/";
    protected final String dartDir = dataDir + "dart/";
    protected final String fnlttSinglAcntAllDir = dartDir + "fnlttSinglAcntAll/";

    protected final String stockDir = dataDir + "stock/";

    protected String directory = dataDir + "bin/";



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
