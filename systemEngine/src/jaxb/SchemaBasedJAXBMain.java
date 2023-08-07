package jaxb;


import system.engine.world.WorldDefinition;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SchemaBasedJAXBMain {

    private final static String JAXB_XML_GAME_PACKAGE_NAME = "jaxb.generator";

    public WorldDefinition FromXmlToWorld() { //need to get XML file
        try {
            InputStream inputStream = new FileInputStream(new File("src/jaxb/resource/ex1-cigarets.xml"));
            WorldDefinition worldDefinition = deserializeFrom(inputStream);
            return worldDefinition;
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static WorldDefinition deserializeFrom(InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (WorldDefinition) u.unmarshal(in);
    }
}
