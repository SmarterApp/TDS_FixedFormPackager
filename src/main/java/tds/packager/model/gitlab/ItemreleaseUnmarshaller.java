package tds.packager.model.gitlab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tds.itemrenderer.data.xml.itemrelease.Itemrelease;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ItemreleaseUnmarshaller {
    private final JAXBContext jaxbContext;
    private final Logger log = LoggerFactory.getLogger(ItemreleaseUnmarshaller.class);

    public ItemreleaseUnmarshaller() {

        try {
            this.jaxbContext = JAXBContext.newInstance(Itemrelease.class);
        } catch (JAXBException e) {
            throw new RuntimeException("ItemUnmarshaller could not initialize JAXBContext.", e);
        }
    }

    public Itemrelease unmarshallItem(String itemXml, String itemId) {
        try {
            Unmarshaller jaxbUnmarshaller = this.jaxbContext.createUnmarshaller();
            StringReader reader = removeBomIfPresent(itemXml);
            return (Itemrelease) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException("Could not unmarshall item " + itemId, e);
        }
    }
    /*
     Data returned from S3 seems to include a BOM (Byte-Order-Mark) that will need to be removed before it can
     be unmarshalled.
  */
    private StringReader removeBomIfPresent(final String itemXml) {
        final String UTF8_BOM = "\uFEFF";
        final String UTF8_BOM_FIRST_HEX_CHAR = "\u00EF";

        // Look for the UTF8_BOM as the first character in the itemXml string.  In the event the UTF8_BOM is not
        // detected, look for the first character of the UTF-8 hex representation.  This issue was only exposed by
        // building the jar and running it in a Windows command prompt.
        if (itemXml.startsWith(UTF8_BOM)) {
            log.debug("STARTS WITH SPECIAL CHAR: itemXml starts with the UTF8_BOM ({}) pattern.", UTF8_BOM);
            return new StringReader(itemXml.substring(1));
        } else if (itemXml.startsWith(UTF8_BOM_FIRST_HEX_CHAR)) {
            // If the itemXml starts with the UTF8_BOM_FIRST_HEX_CHAR, skip the first three characters in the string
            // to get at the actual XML.  The first three characters should be 0xEF, 0xBB and 0xBEF (decimal
            // representation is 239, 187, 191).  From here:
            // https://en.wikipedia.org/wiki/Byte_order_mark#Byte_order_marks_by_encoding
            log.debug("STARTS WITH SPECIAL CHAR: itemXml starts with 0xEF: ({}).  Will skip the first three characters in the string.", UTF8_BOM_FIRST_HEX_CHAR);
            return new StringReader(itemXml.substring(3));
        }

        log.debug("OUTSIDE IF: did not find UTF8_BOM ({}) or UTF8_BOM_FIRST_HEX_CHAR ({}) pattern at start of itemXml.", UTF8_BOM, UTF8_BOM_FIRST_HEX_CHAR);
        return new StringReader(itemXml);
    }

}
