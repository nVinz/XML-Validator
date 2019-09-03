@echo off

REM USAGE

REM java -jar Validate.jar PATH/xml_file.xml PATH/xsd.file.xsd

REM OR

REM java -jar Validate.jar FILES.txt

REM | files.txt |
REM |------------------------------
REM | PATH/XML_FILE.xml PATH/XSD_FILE.xsd
REM | PATH/XML_FILE_2.xml PATH/XSD_FILE_2.xsd
REM | ...
REM | PATH/XML_FILE_n.xml PATH/XSD_FILE_n.xsd
REM |------------------------------

java -jar Validator.jar Examples/files.txt
PAUSE