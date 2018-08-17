package tds.packager.model.gitlab;

import tds.itemrenderer.data.xml.itemrelease.Itemrelease;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ItemreleaseUnmarshaller {
    private final JAXBContext jaxbContext;

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
        if (itemXml.startsWith(UTF8_BOM)) {
            return new StringReader(itemXml.substring(1));
        }
        return new StringReader(itemXml);
    }

}
