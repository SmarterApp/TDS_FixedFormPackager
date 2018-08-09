package tds.packager.model.gitlab;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
        final String v6expression = "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[contains(.,'-v6:')]";
        final String v1expression = "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[contains(.,'-v1:')]";
        try {
            NodeList nodeList = (NodeList) this.xPath.compile(v6expression).evaluate(this.xmlDocument, XPathConstants.NODESET);
            if(nodeList.getLength() == 1) {
                return nodeList.item(0).getTextContent();
            } else {
                return ((NodeList) this.xPath.compile(v1expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
            }

        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression failed. Could not retrieve PrimaryStandard. ", e);
        }
    }

    public String getIrtElement(String elementName) {
        final String expression = "metadata/smarterAppMetadata/IrtDimension/" + elementName;
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve IrtModelType. ", e);
        }
    }

    public NodeList getIrtParameters() {
        return this.xpathQuery("metadata/smarterAppMetadata/IrtDimension/IrtParameter");
    }

    public String getStatus() {
        final String expression = "metadata/smarterAppMetadata/Status";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve Status. ", e);
        }
    }

    public String getDepthOfKnowledge() {
        final String expression = "metadata/smarterAppMetadata/DepthOfKnowledge";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve Depth of Knowledge. ", e);
        }
    }

    public String getIntendedGrade() {
        final String expression = "metadata/smarterAppMetadata/IntendedGrade";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve IntendedGrade. ", e);
        }
    }

    public String getScoringEngine() {
        final String expression = "metadata/smarterAppMetadata/ScoringEngine";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve ScoringEngine. ", e);
        }
    }

    public String getASL() {
        final String expression = "metadata/smarterAppMetadata/AccessibilityTagsASLLanguage";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve AccessibilityTagsASLLanguage. ", e);
        }
    }

    public String getBraille() {
        final String expression = "metadata/smarterAppMetadata/BrailleType";
        try {
            final String brailleType = ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(0).getTextContent();
            return brailleType.split("_")[0];
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve AccessibilityTagsASLLanguage. ", e);
        }
    }
}
