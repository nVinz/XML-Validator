package my.nvinz;

public class Threading extends Thread {

    private String XML_FILE, SCHEMA_FILE;

    public Threading(String xml, String xsd){
        this.XML_FILE = xml;
        this.SCHEMA_FILE = xsd;
    }

    public void run(){
        try{
            Validator valid = new Validator(XML_FILE, SCHEMA_FILE);
            System.out.println (valid.isValid + " | " + XML_FILE + ", " + SCHEMA_FILE);
        }
        catch (Exception e) {
            System.out.println ("Exception is caught");
        }
    }
}
