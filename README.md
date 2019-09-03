# XMLValidator
(Java)

## Checks is XML file is valid to XSD scheme.

### Project

This project contains sources and compiled .jar & .bat files with examples to usage for quick start and validation for your files.
It returns true/false for single xml-xsd bunch and true/false with file names for multimple xml-xsd bunches.

-------------
### Usage

**From command line**: 

    java -jar Validator.jar PATH/files.txt

or

    java -jar Validator.jar PATH/XML_FILE.xml PATH/XSD_FILE.xsd

**`Validate.bat`**: 

set up:

    PATH/XML_FILE.xml PATH/XSD_FILE.xsd
    
or

    PATH/files.txt
    
### files.txt set up

Write here paths to all xml and xsd files separated by spaces:

    PATH/XML_FILE.xml PATH/XSD_FILE.xsd
    PATH/XML_FILE_2.xml PATH/XSD_FILE_2.xsd
    ...
    PATH/XML_FILE_n.xml PATH/XSD_FILE_n.xsd

-------------
### Outdated

**`ValidateAll.bat`**: used in previous version

+ set up **`files.txt`**:
+ returns *true*/*false* for each line.
