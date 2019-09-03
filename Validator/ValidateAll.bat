REM | USAGE

REM | files.txt |
REM |------------------------------
REM | PATH/XML_FILE.xml PATH/XSD_FILE.xsd
REM | PATH/XML_FILE_2.xml PATH/XSD_FILE_2.xsd
REM | ...
REM | PATH/XML_FILE_n.xml PATH/XSD_FILE_n.xsd
REM |------------------------------

@echo off
for /F "tokens=*" %%A in (files.txt) do (
	echo # %%A 
	java -jar Validator.jar %%A
)
PAUSE