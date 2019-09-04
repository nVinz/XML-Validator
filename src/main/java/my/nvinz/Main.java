package my.nvinz;

import java.io.*;
import java.util.*;

public class Main {
    private static String XML_FILE = "";
    private static String SCHEMA_FILE = "";
    private static String ALL_FILES = "";
    private static Map<String, String> FILE_LINES = new HashMap<>();

    public static void main (String[] args) {
        if (getProperties(args)) {
            if (ALL_FILES.equals("")){
                Threading thread = new Threading(XML_FILE, SCHEMA_FILE);
                thread.start();
                return;
            }
            else{
                FILE_LINES.forEach((xml, xsd) -> {
                    Threading thread = new Threading(xml, xsd);
                    thread.start();
                });
                return;
            }
        }
        else{
            System.out.println("Invalid arguments");
            return;
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
                    try {
                        FILE_LINES.put(tokenizer.nextToken(), tokenizer.nextToken());
                    } catch (NoSuchElementException e) {
                        System.out.println("(!) " + e);
                    }
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
