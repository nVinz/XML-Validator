package my.nvinz;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static String XML_FILE = "";
    public static String SCHEMA_FILE = "";

    public static void main (String[] args) {
        if (getProperties(args)) {
            XMLValidator XMLValidator = new XMLValidator();
            boolean valid = XMLValidator.validate(XML_FILE, SCHEMA_FILE);
            System.out.println(valid);
            return;
        }
        else{
            System.out.println("Invalid arguments");
            return;
        }
    }

    private boolean validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(schemaFile));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (SAXException | IOException e) {
            return false;
        }
    }

    private static boolean getProperties(String[] args){
        if (args.length == 2 &&
                args[0].contains(".xml") &&
                args[1].contains(".xsd")){
                XML_FILE = args[0];
                SCHEMA_FILE = args[1];
                return true;
        }
        else{
            return false;
        }
        /*XML_FILE = args.length > 0 ? args[0] : XML_FILE;
        try {
            SCHEMA_FILE = args.length > 1 ? args[1] : SCHEMA_FILE;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
    }
}
