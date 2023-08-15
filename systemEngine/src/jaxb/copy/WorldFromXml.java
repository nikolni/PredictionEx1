package jaxb.copy;


import jaxb.error.handling.validator.FileValidator;
import jaxb.error.handling.validator.PRDWorldValidator;
import jaxb.generator.PRDWorld;
import system.engine.world.api.WorldDefinition;
import system.engine.world.impl.WorldDefinitionImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class WorldFromXml {

    private final static String JAXB_XML_GAME_PACKAGE_NAME = "jaxb.generator";


    public WorldDefinition FromXmlToPRDWorld(String xmlPathName) throws JAXBException,FileNotFoundException{
        //check XML path
        FileValidator fileValidator = new FileValidator();
        fileValidator.validateXmlFile(xmlPathName);
        //here the file is ok
        InputStream inputStream = new FileInputStream(new File(xmlPathName));
        PRDWorld PrdWorld = deserializeFrom(inputStream);
        //validation of PrdWorld
        PRDWorldValidator prdWorldValidator=new PRDWorldValidator();
        prdWorldValidator.validatePRDWorld(PrdWorld);
        return createWorldDefinitionFromPRDWorld(PrdWorld);
    }


    private static PRDWorld deserializeFrom(InputStream in) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(JAXB_XML_GAME_PACKAGE_NAME);
        Unmarshaller u = jc.createUnmarshaller();
        return (PRDWorld) u.unmarshal(in);
    }

    //validation of PRDWorld

    WorldDefinition createWorldDefinitionFromPRDWorld(PRDWorld PrdWorld){
        EnvironmentVariableFromXML environmentVariableFromXML=new EnvironmentVariableFromXML(PrdWorld.getPRDEvironment());
        EntityFromXML entityFromXML=new EntityFromXML(PrdWorld.getPRDEntities());
        RuleFromXML ruleFromXML=new RuleFromXML(PrdWorld.getPRDRules());

        WorldDefinition worldDefinition=new WorldDefinitionImpl(entityFromXML.getEntityDefinitionManager(),environmentVariableFromXML.getEnvVariablesDefinitionManager(),ruleFromXML.getRuleDefinitionManager());
        return worldDefinition;
    }



}
