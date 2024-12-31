package api.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import api.model.MDartCorpcode;
import api.model.MDartFnlttSinglAcntAll;

public class ReadData {

    private final String corpcodeFilePath = "documents/CORPCODE.xml";
    // private final String corpcodeFilePath = "data/testdata4.xml";
    private final String dataFilePath = "data/";
    private final String dartDir = "dart/";

    public List<MDartCorpcode> XmlCorpcodeList() {
        List<MDartCorpcode> list = new ArrayList<>();

        File file = new File(corpcodeFilePath);

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML 파일을 파싱하여 Document 객체 생성
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            // System.out.println("Root element: " +
            // document.getDocumentElement().getNodeName());

            // result 태그 안의 하위 요소들을 가져오기
            NodeList nodeList = document.getElementsByTagName("list");

            System.out.println(nodeList.getLength());

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                MDartCorpcode mDartCorpcode = new MDartCorpcode();

                String corp_code = "";
                String corp_name = "";
                String stock_code = "";
                String modify_date = "";

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // name, age, city 값 출력
                    corp_code = element.getElementsByTagName("corp_code").item(0).getTextContent();
                    corp_name = element.getElementsByTagName("corp_name").item(0).getTextContent();
                    stock_code = element.getElementsByTagName("stock_code").item(0).getTextContent();
                    modify_date = element.getElementsByTagName("modify_date").item(0).getTextContent();

                }

                if (stock_code == null || stock_code.trim().isEmpty()) {
                    continue;
                }

                mDartCorpcode.setCorp_code(corp_code);
                mDartCorpcode.setCorp_name(corp_name);
                mDartCorpcode.setStock_code(stock_code);
                mDartCorpcode.setModify_date(modify_date);

                list.add(mDartCorpcode);

                // System.out.println("corp_code: " + corp_code);
                // System.out.println("corp_name: " + corp_name);
                // System.out.println("stock_code: " + stock_code);
                // System.out.println("modify_date: " + modify_date);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    };

    // public List<MDartFnlttSinglAcntAll> XmlDartFnlttSinglAcntAll(String
    // corp_code, String bsns_year, String reprt_code,
    // String fs_div) {
    // List<MDartFnlttSinglAcntAll> list = new ArrayList<>();

    // String subDir = "fnlttSinglAcntAll";
    // String corpDir = corp_code;
    // String filePath = dataFilePath + subDir + "/" + corpDir + "/" + corp_code +
    // "_" + bsns_year + "_" + reprt_code
    // + "_" + fs_div
    // + ".xml";

    // File file = new File(filePath);

    // if (file.exists()) {

    // try {

    // DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // DocumentBuilder builder = factory.newDocumentBuilder();

    // Document document = builder.parse(filePath);
    // document.getDocumentElement().normalize();

    // NodeList nodeList = document.getElementsByTagName("list");

    // for (int i = 0; i < nodeList.getLength(); i++) {
    // Node node = nodeList.item(i);
    // MDartFnlttSinglAcntAll mDartFnlttSinglAcntAll = new MDartFnlttSinglAcntAll();

    // String rcept_no = "";
    // // String
    // reprt_code = "";
    // // String
    // bsns_year = "";
    // // String
    // corp_code = "";
    // String sj_div = "";
    // String sj_nm = "";
    // String account_id = "";
    // String account_nm = "";
    // String account_detail = "";
    // String thstrm_nm = "";
    // String thstrm_amount = "";
    // String frmtrm_nm = "";
    // String frmtrm_amount = "";
    // String bfefrmtrm_nm = "";
    // String bfefrmtrm_amount = "";
    // String ord = "";
    // String currency = "";

    // if (node.getNodeType() == Node.ELEMENT_NODE) {
    // Element element = (Element) node;

    // // name, age, city 값 출력
    // rcept_no = element.getElementsByTagName("rcept_no").item(0).getTextContent();
    // reprt_code =
    // element.getElementsByTagName("reprt_code").item(0).getTextContent();
    // bsns_year =
    // element.getElementsByTagName("bsns_year").item(0).getTextContent();
    // corp_code =
    // element.getElementsByTagName("corp_code").item(0).getTextContent();
    // sj_div = element.getElementsByTagName("sj_div").item(0).getTextContent();
    // sj_nm = element.getElementsByTagName("sj_nm").item(0).getTextContent();
    // account_id =
    // element.getElementsByTagName("account_id").item(0).getTextContent();
    // account_nm =
    // element.getElementsByTagName("account_nm").item(0).getTextContent();
    // account_detail =
    // element.getElementsByTagName("account_detail").item(0).getTextContent();
    // thstrm_nm =
    // element.getElementsByTagName("thstrm_nm").item(0).getTextContent();
    // thstrm_amount =
    // element.getElementsByTagName("thstrm_amount").item(0).getTextContent();
    // frmtrm_nm =
    // element.getElementsByTagName("frmtrm_nm").item(0).getTextContent();
    // frmtrm_amount =
    // element.getElementsByTagName("frmtrm_amount").item(0).getTextContent();
    // bfefrmtrm_nm =
    // element.getElementsByTagName("bfefrmtrm_nm").item(0).getTextContent();
    // bfefrmtrm_amount =
    // element.getElementsByTagName("bfefrmtrm_amount").item(0).getTextContent();
    // ord = element.getElementsByTagName("ord").item(0).getTextContent();
    // currency = element.getElementsByTagName("currency").item(0).getTextContent();

    // mDartFnlttSinglAcntAll.setRcept_no(rcept_no);
    // mDartFnlttSinglAcntAll.setReprt_code(reprt_code);
    // mDartFnlttSinglAcntAll.setBsns_year(bsns_year);
    // mDartFnlttSinglAcntAll.setCorp_code(corp_code);
    // mDartFnlttSinglAcntAll.setSj_div(sj_div);
    // mDartFnlttSinglAcntAll.setSj_nm(sj_nm);
    // mDartFnlttSinglAcntAll.setAccount_id(account_id);
    // mDartFnlttSinglAcntAll.setAccount_nm(account_nm);
    // mDartFnlttSinglAcntAll.setAccount_detail(account_detail);
    // mDartFnlttSinglAcntAll.setThstrm_nm(thstrm_nm);
    // mDartFnlttSinglAcntAll.setThstrm_amount(thstrm_amount);
    // mDartFnlttSinglAcntAll.setFrmtrm_nm(frmtrm_nm);
    // mDartFnlttSinglAcntAll.setFrmtrm_amount(frmtrm_amount);
    // mDartFnlttSinglAcntAll.setBfefrmtrm_nm(bfefrmtrm_nm);
    // mDartFnlttSinglAcntAll.setBfefrmtrm_amount(bfefrmtrm_amount);
    // mDartFnlttSinglAcntAll.setOrd(ord);
    // mDartFnlttSinglAcntAll.setCurrency(currency);

    // list.add(mDartFnlttSinglAcntAll);
    // }
    // }

    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // } else {
    // System.out.println("존재하지않음: " + filePath);
    // }

    // return list;
    // }

    // #메소드 오버로딩
    public List<MDartFnlttSinglAcntAll> dartFnlttSinglAcntAll(String corp_code, String bsns_year, String reprt_code,
            String fs_div, String extension) {
        List<MDartFnlttSinglAcntAll> list = new ArrayList<>();

        String subDir = "fnlttSinglAcntAll";
        String corpDir = corp_code;
        String filePath = dataFilePath + dartDir + subDir + "/" + corpDir + "/" + corp_code + "_" + bsns_year + "_"
                + reprt_code
                + "_" + fs_div
                + "."
                + extension;

        list = dartFnlttSinglAcntAll(filePath);

        return list;
    }

    // #Base Method
    public List<MDartFnlttSinglAcntAll> dartFnlttSinglAcntAll(String filePath) {
        List<MDartFnlttSinglAcntAll> list = new ArrayList<>();

        File file = new File(filePath);

        if (file.exists()) {

            try {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(filePath);
                document.getDocumentElement().normalize();

                NodeList statusNodeList = document.getElementsByTagName("status");
                String statusValue = "";
                if (statusNodeList.getLength() > 0) {
                    Node statusNode = statusNodeList.item(0);
                    statusValue = statusNode.getTextContent();
                    System.out.println("Status: " + statusValue);
                }

                if (statusValue.equals("000")) {

                    NodeList nodeList = document.getElementsByTagName("list");

                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        MDartFnlttSinglAcntAll mDartFnlttSinglAcntAll = new MDartFnlttSinglAcntAll();

                        String rcept_no = "";
                        String reprt_code = "";
                        String bsns_year = "";
                        String corp_code = "";
                        String sj_div = "";
                        String sj_nm = "";
                        String account_id = "";
                        String account_nm = "";
                        String account_detail = "";
                        String thstrm_nm = "";
                        String thstrm_amount = "";
                        String frmtrm_nm = "";
                        String frmtrm_amount = "";
                        String bfefrmtrm_nm = "";
                        String bfefrmtrm_amount = "";
                        String ord = "";
                        String currency = "";

                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;

                            // name, age, city 값 출력
                            rcept_no = element.getElementsByTagName("rcept_no").item(0).getTextContent();
                            reprt_code = element.getElementsByTagName("reprt_code").item(0).getTextContent();
                            bsns_year = element.getElementsByTagName("bsns_year").item(0).getTextContent();
                            corp_code = element.getElementsByTagName("corp_code").item(0).getTextContent();
                            sj_div = element.getElementsByTagName("sj_div").item(0).getTextContent();
                            sj_nm = element.getElementsByTagName("sj_nm").item(0).getTextContent();
                            account_id = element.getElementsByTagName("account_id").item(0).getTextContent();
                            account_nm = element.getElementsByTagName("account_nm").item(0).getTextContent();
                            account_detail = element.getElementsByTagName("account_detail").item(0).getTextContent();
                            thstrm_nm = element.getElementsByTagName("thstrm_nm").item(0).getTextContent();
                            thstrm_amount = element.getElementsByTagName("thstrm_amount").item(0).getTextContent();
                            // frmtrm_nm =
                            // element.getElementsByTagName("frmtrm_nm").item(0).getTextContent();
                            // frmtrm_amount =
                            // element.getElementsByTagName("frmtrm_amount").item(0).getTextContent();
                            // bfefrmtrm_nm =
                            // element.getElementsByTagName("bfefrmtrm_nm").item(0).getTextContent();
                            // bfefrmtrm_amount =
                            // element.getElementsByTagName("bfefrmtrm_amount").item(0).getTextContent();
                            ord = element.getElementsByTagName("ord").item(0).getTextContent();
                            currency = element.getElementsByTagName("currency").item(0).getTextContent();

                            mDartFnlttSinglAcntAll.setRcept_no(rcept_no);
                            mDartFnlttSinglAcntAll.setReprt_code(reprt_code);
                            mDartFnlttSinglAcntAll.setBsns_year(bsns_year);
                            mDartFnlttSinglAcntAll.setCorp_code(corp_code);
                            mDartFnlttSinglAcntAll.setSj_div(sj_div);
                            mDartFnlttSinglAcntAll.setSj_nm(sj_nm);
                            mDartFnlttSinglAcntAll.setAccount_id(account_id);
                            mDartFnlttSinglAcntAll.setAccount_nm(account_nm);
                            mDartFnlttSinglAcntAll.setAccount_detail(account_detail);
                            mDartFnlttSinglAcntAll.setThstrm_nm(thstrm_nm);
                            mDartFnlttSinglAcntAll.setThstrm_amount(thstrm_amount);
                            mDartFnlttSinglAcntAll.setFrmtrm_nm(frmtrm_nm);
                            mDartFnlttSinglAcntAll.setFrmtrm_amount(frmtrm_amount);
                            mDartFnlttSinglAcntAll.setBfefrmtrm_nm(bfefrmtrm_nm);
                            mDartFnlttSinglAcntAll.setBfefrmtrm_amount(bfefrmtrm_amount);
                            mDartFnlttSinglAcntAll.setOrd(ord);
                            mDartFnlttSinglAcntAll.setCurrency(currency);

                            list.add(mDartFnlttSinglAcntAll);
                        }
                    }
                } else {
                    System.out.println("xml 데이터 비정상: " + filePath);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("존재하지않음: " + filePath);
        }

        return list;
    }

    public String dartFnlttSinglAcntAllStatus(String filePath) {
        String status = "";

        File file = new File(filePath);

        if (file.exists()) {

            try {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(filePath);
                document.getDocumentElement().normalize();

                NodeList statusNodeList = document.getElementsByTagName("status");

                if (statusNodeList.getLength() > 0) {
                    Node statusNode = statusNodeList.item(0);
                    status = statusNode.getTextContent();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }

}