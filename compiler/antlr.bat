cls
java -jar "antlr\antlr-4.7.1-complete.jar" -no-listener -package parser src\parser\Grammar.g4

@echo off
del src\parser\*.tokens
del src\parser\*.interp
