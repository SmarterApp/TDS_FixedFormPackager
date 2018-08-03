package tds.packager.model.gitlab;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;


public class ItemMetaDataUtil {

    private final DocumentBuilderFactory builderFactory;
    private final DocumentBuilder builder;
    private final Document xmlDocument;
    private final XPath xPath;

    public ItemMetaDataUtil(String itemMeta) {

        try {
            this.builderFactory = DocumentBuilderFactory.newInstance();
            this.builder = this.builderFactory.newDocumentBuilder();
            this.xmlDocument = builder.parse(new InputSource(new StringReader(itemMeta)));
            this.xPath = XPathFactory.newInstance().newXPath();
        } catch (Exception e) {
            throw new RuntimeException("Could not parse item metadata XML.", e);
        }
    }

    public NodeList xpathQuery(String expression) {
        try {
            return (NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed.", e);
        }
    }

    public String getPrimaryStandard() {
        final String expression = "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[contains(.,'-v6:')]";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve PrimaryStandard. ", e);
        }
    }
}
