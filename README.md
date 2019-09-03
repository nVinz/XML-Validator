# XMLValidator
(Java)

## Checks is XML file is valid to XSD scheme.

### Project

This project contains sources and compiled .jar & .bat files with examples to usage for quick start and validation for your files.


-------------
### Usage

**From command line**: 

    java -jar Validator.jar PATH/files.txt

or

    java -jar Validator.jar PATH/XML_FILE.xml PATH/XSD_FILE.xsd

+ returns *true*/*false*.

**`Validate.bat`**: 

+ set up:

    PATH/XML_FILE.xml PATH/XSD_FILE.xsd
    
or
    PATH/files.txt
    
+ returns *true*/*false*.

### files.txt set up

    PATH/XML_FILE.xml PATH/XSD_FILE.xsd
    PATH/XML_FILE_2.xml PATH/XSD_FILE_2.xsd
    ...
    PATH/XML_FILE_n.xml PATH/XSD_FILE_n.xsd

-------------
### Outdated

**`ValidateAll.bat`**: used in previous version

+ set up **`files.txt`**:
+ returns *true*/*false* for each line.
