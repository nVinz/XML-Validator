package my.nvinz;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.*;

public class XMLValidator {
    private static String XML_FILE = "";
    private static String SCHEMA_FILE = "";
    private static String ALL_FILES = "";
    private static Map<String, String> FILE_LINES = new HashMap<>();

    public static void main (String[] args) {
        if (getProperties(args)) {
            XMLValidator XMLValidator = new XMLValidator();
            if (ALL_FILES.equals("")){
                boolean valid = XMLValidator.validate(XML_FILE, SCHEMA_FILE);
                System.out.println(valid);
                return;
            }
            else{
                FILE_LINES.forEach((xml, xsd) -> {
                    boolean valid = XMLValidator.validate(xml, xsd);
                    System.out.println("# " + xml + ", " + xsd);
                    System.out.println(valid);
                });
                return;
            }
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
        } catch (FileNotFoundException e){
            System.out.println("File(s) not found");
            return false;
        } catch (IOException e) {
            System.out.println("File(s) not found");
            return false;
        }catch (SAXException e) {
            System.out.println("# Validation failure: " + e.getMessage());
            return false;
        }
    }

    private static boolean getProperties(String[] args){
        if (args.length == 1 &&
            args[0].contains(".txt")){
            ALL_FILES = args[0];
            parseFile(ALL_FILES);
            return true;
        }
        else if (args.length == 2 &&
                args[0].contains(".xml") &&
                args[1].contains(".xsd")){
            XML_FILE = args[0];
            SCHEMA_FILE = args[1];
            return true;
        }
        else{
            return false;
        }
    }

    private static void parseFile(String file){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                while (tokenizer.hasMoreElements()) {
                    FILE_LINES.put(tokenizer.nextToken(), tokenizer.nextToken());
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File(s) not found");
            return;
        }catch(IOException e) {
            System.out.println("File(s) not found");
            return;
        }
    }
}
