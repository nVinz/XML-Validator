@echo off
for /F "tokens=*" %%A in (files.txt) do (
	echo # %%A 
	java -jar Validator.jar %%A
)
PAUSE