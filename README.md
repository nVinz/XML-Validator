# XMLValidator
(Java)

## Checks is XML file is valid to XSD scheme.

### Usage

**From command line**: 

    java -jar Validator.jar PATH/XML_FILE.xml PATH/XSD_FILE.xsd

+ returns *true*/*false*.

**`Validate.bat`**: 

+ set up:

    PATH/XML_FILE.xml PATH/XSD_FILE.xsd
    
+ returns *true*/*false*.

**`ValidateAll.bat`**:

set up **`files.txt`**:

    PATH/XML_FILE.xml PATH/XSD_FILE.xsd
    PATH/XML_FILE_2.xml PATH/XSD_FILE_2.xsd
    ...
    PATH/XML_FILE_n.xml PATH/XSD_FILE_n.xsd
    
+ returns *true*/*false* for each line.
