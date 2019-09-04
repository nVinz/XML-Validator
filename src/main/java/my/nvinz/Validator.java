package my.nvinz;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Validator {
    public boolean isValid;

    public Validator(String XML_FILE, String SCHEMA_FILE){
        validate(XML_FILE, SCHEMA_FILE);
    }

    private void validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(schemaFile));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            isValid = true;
        } catch (FileNotFoundException e){
            System.out.println("File(s) not found");
            isValid = false;
        } catch (IOException e) {
            System.out.println("File(s) not found");
            isValid = false;
        }catch (SAXException e) {
            System.out.println("(!) " + e.getMessage());
            isValid = false;
        }
    }
}
