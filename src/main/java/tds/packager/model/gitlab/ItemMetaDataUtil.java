package tds.packager.model.gitlab;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import tds.packager.mapper.ContentSpecFormatConverter;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ItemMetaDataUtil {

    private final Document xmlDocument;
    private final XPath xPath;

    private final List<XPathExpression> searchExpressions;

    private final Logger log = LoggerFactory.getLogger(ItemMetaDataUtil.class);

    public ItemMetaDataUtil(String itemMeta) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            this.xmlDocument = builder.parse(new InputSource(new StringReader(itemMeta)));
            this.xPath = XPathFactory.newInstance().newXPath();
            this.searchExpressions = new ArrayList<>();
            initSearchExpressions();
        } catch (Exception e) {
            throw new RuntimeException("Could not parse item metadata XML.", e);
        }
    }

    // Sets up the XPath expressions in the order of precedence. First looks for enhanced, then legacy.
    private void initSearchExpressions() {
        String [] searchStrings = {
                "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[starts-with(.,'M.')]",
                "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[starts-with(.,'E.')]",
                "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[contains(.,'-v6:')]",
                "metadata/smarterAppMetadata/StandardPublication/PrimaryStandard[contains(.,'-v1:')]"
        };

        searchExpressions.addAll(Arrays.stream(searchStrings)
                .map(this::compileXpath)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }

    private XPathExpression compileXpath(String expression) {
        try {
            return this.xPath.compile(expression);
        } catch (XPathExpressionException e) {
            log.error("Cannot compile XPath expression: " + expression, e);
        }

        return null;
    }

    public NodeList xpathQuery(String expression) {
        try {
            return (NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed.", e);
        }
    }

    /**
     * Retrieves primary standard from standard publication in enhanced format if available, or legacy if not.
     * @return content spec ID in legacy or enhanced format
     *
     * @throws RuntimeException if no primary standard ID exists in either format.
     */
    public String getRawPrimaryStandard() {
        return searchExpressions.stream()
                .map(this::evaluate)
                .filter(nodeList -> nodeList.getLength() != 0)
                .map(nodeList -> nodeList.item(0).getTextContent())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No PrimaryStandard found in metadata"));
    }

    /**
     * Retrieves primary standard from standard publication in legacy format for usage in downstream processing
     * that relies on the legacy format. The returned value is either converted from the enhanced primary standard
     * ID if it exists, or just taken from the legacy format primary standard in there is no enhanced standard
     * publication.
     *
     * @return content spec ID in legacy format
     *
     * @throws RuntimeException if no primary standard ID exists in the metadata.
     */
    public String getPrimaryStandard() {
        return ContentSpecFormatConverter
                .convertEnhancedToLegacy(getRawPrimaryStandard())
                .orElse(null);
    }

    private NodeList evaluate(XPathExpression expression) {
        try {
            return (NodeList)expression.evaluate(this.xmlDocument, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression failed. Could not retrieve PrimaryStandard. ", e);
        }
    }

    public String getIrtElement(final String elementName, final int index) {
        final String expression = "metadata/smarterAppMetadata/IrtDimension/" + elementName;
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).item(index).getTextContent();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve IrtModelType. ", e);
        }
    }

    public int getIrtDimensionCount() {
        final String expression = "metadata/smarterAppMetadata/IrtDimension";
        try {
            return ((NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET)).getLength();
        } catch (XPathExpressionException e) {
            throw new RuntimeException("XPath expression " + expression + " failed. Could not retrieve IrtDimension count. ", e);
        }
    }

    public NodeList getIrtParameters(final int dimensionIndex) {
        return this.xpathQuery("metadata/smarterAppMetadata/IrtDimension[" + dimensionIndex + "]/IrtParameter");
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
            NodeList nl = (NodeList) this.xPath.compile(expression).evaluate(this.xmlDocument, XPathConstants.NODESET);
            if(nl.getLength() == 0) {
                return "N";
            }
            return nl.item(0).getTextContent();
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
