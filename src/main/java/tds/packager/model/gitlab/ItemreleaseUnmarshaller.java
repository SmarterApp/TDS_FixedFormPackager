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

        // This character sometimes appears as the first character in an XML file that was created/saved in a Windows
        // text editor (e.g. Notepad++).  This character is the first of three characters in a sequence that occurs
        // before the first character of the itemXml.  This character sequence could not be detected during debugging in
        // IntelliJ on Windows - it was only found by building this jar on a Windows machine and running the jar on
        // Windows.
        final String INITIAL_SPECIAL_CHARACTER = "\u00EF";
        for (int i = 0; i < 10; i++) {
            log.trace("hex code of first character in itemXml: " + itemXml.codePointAt(i));
        }

        if (itemXml.startsWith(UTF8_BOM)) {
            log.debug("STARTS WITH SPECIAL CHAR: itemXml starts with the UTF8_BOM ({}) pattern.", UTF8_BOM);
            return new StringReader(itemXml.substring(1));
        } else if (itemXml.startsWith(INITIAL_SPECIAL_CHARACTER)) {
            // If the itemXml starts with the INITIAL_SPECIAL_CHARACTER, skip the first three characters in the string
            // to get at the actual XML.
            log.debug("STARTS WITH SPECIAL CHAR: itemXml starts with a special character: ({}).  Will skip the first three characters in the string.", INITIAL_SPECIAL_CHARACTER);
            return new StringReader(itemXml.substring(3));
        }

        log.debug("OUTSIDE IF: did not find UTF8_BOM ({}) or INITIAL_SPECIAL_CHARACTER ({}) pattern at start of itemXml.", UTF8_BOM, INITIAL_SPECIAL_CHARACTER);
        return new StringReader(itemXml);
    }

}
