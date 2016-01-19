/*
 [The "BSD licence"]
 Copyright (c) 2013 Sam Harwell
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** C 2011 grammar built from the C11 Spec */
grammar ScapesShader;

@header {
package org.tobi29.scapes.engine.utils.shader;
}

primaryExpression
    :   Identifier
    |   Constant
    |   property
    |   '(' expression ')'
    ;

postfixExpression
    :   primaryExpression
    |   postfixExpression '[' expression ']'
    |   postfixExpression '(' argumentExpressionList? ')'
    |   postfixExpression '.' Identifier
    |   postfixExpression '++'
    |   postfixExpression '--'
    ;

argumentExpressionList
    :   assignmentExpression
    |   assignmentExpression ',' argumentExpressionList
    ;

unaryExpression
    :   postfixExpression
    |   '++' unaryExpression
    |   '--' unaryExpression
    |   unaryOperator castExpression
    ;

unaryOperator
    :   '+' | '-' | '~' | '!'
    ;

castExpression
    :   unaryExpression
    |   '(' typeSpecifier ')' castExpression
    ;

multiplicativeExpression
    :   castExpression
    |   multiplicativeExpression '*' castExpression
    |   multiplicativeExpression '/' castExpression
    |   multiplicativeExpression '%' castExpression
    ;

additiveExpression
    :   multiplicativeExpression
    |   additiveExpression '+' multiplicativeExpression
    |   additiveExpression '-' multiplicativeExpression
    ;

shiftExpression
    :   additiveExpression
    |   shiftExpression '<<' additiveExpression
    |   shiftExpression '>>' additiveExpression
    ;

relationalExpression
    :   shiftExpression
    |   relationalExpression '<' shiftExpression
    |   relationalExpression '>' shiftExpression
    |   relationalExpression '<=' shiftExpression
    |   relationalExpression '>=' shiftExpression
    ;

equalityExpression
    :   relationalExpression
    |   equalityExpression '==' relationalExpression
    |   equalityExpression '!=' relationalExpression
    ;

andExpression
    :   equalityExpression
    |   andExpression '&' equalityExpression
    ;

exclusiveOrExpression
    :   andExpression
    |   exclusiveOrExpression '^' andExpression
    ;

inclusiveOrExpression
    :   exclusiveOrExpression
    |   inclusiveOrExpression '|' exclusiveOrExpression
    ;

logicalAndExpression
    :   inclusiveOrExpression
    |   logicalAndExpression '&&' inclusiveOrExpression
    ;

logicalOrExpression
    :   logicalAndExpression
    |   logicalOrExpression '||' logicalAndExpression
    ;

conditionalExpression
    :   logicalOrExpression ('?' expression ':' conditionalExpression)?
    ;

assignmentExpression
    :   conditionalExpression
    |   unaryExpression assignmentOperator assignmentExpression
    ;

assignmentOperator
    :   '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '|=' | '^='
    ;

expression
    :   assignmentExpression
    ;

declaration
    :   declarationField
    |   declarationArray
    ;

declarationField
    :   declaratorField initDeclaratorFieldList ';'
    ;

declarationArray
    :   declaratorArray initDeclaratorArrayList ';'
    |   declaratorArrayUnsized Identifier '=' '{' initializerArrayList? '}'
    ;

uniformDeclaration
    :   'uniform' Constant declarator Identifier ';'
    ;

initDeclaratorFieldList
    :   initDeclaratorField ',' initDeclaratorFieldList
    |   initDeclaratorField
    ;

initDeclaratorArrayList
    :   Identifier
    |   Identifier ',' initDeclaratorArrayList
    ;

initDeclaratorField
    :   Identifier
    |   Identifier '=' initializerField
    ;

typeSpecifier
    :   'Void'
    |   'Float'
    |   'Int'
    |   'Vector2'
    |   'Vector2i'
    |   'Matrix2'
    |   'Vector3'
    |   'Vector3i'
    |   'Matrix3'
    |   'Vector4'
    |   'Vector4i'
    |   'Matrix4'
    |   'Texture2'
    ;

declarator
    :   declaratorField
    |   declaratorArray
    ;

declaratorField
    :   'const'? typeSpecifier
    ;

declaratorArray
    :   'const'? typeSpecifier '[' integerSize ']'
    ;

declaratorArrayUnsized
    :   'const'? typeSpecifier '[]'
    ;

parameterList
    :   parameterDeclaration
    |   parameterDeclaration ',' parameterList
    ;

parameterDeclaration
    :   declarator Identifier
    ;

shaderParameterList
    :   shaderParameterDeclaration
    |   shaderParameterDeclaration ',' shaderParameterList
    ;

shaderParameterDeclaration
    :   ('if' '(' property ')')? Constant? declarator Identifier
    ;

initializerField
    :   assignmentExpression
    ;

initializerArrayList
    :   assignmentExpression
    |   assignmentExpression ',' initializerArrayList
    ;

property
    :   '$' Identifier
    ;

statement
    :   declaration
    |   expressionStatement
    |   compoundStatement
    |   selectionStatement
    |   rangeLoopStatement
    ;

selectionStatement
    :   ifStatement statement elseStatement?
    ;

ifStatement
    :   'if' '(' expression ')'
    ;

elseStatement
    :   'else' statement
    ;

rangeLoopStatement
    :   'for' '(' Identifier 'in' integerSize '...' integerSize ')' statement
    ;

compoundStatement
    :   '{' blockItemList? '}'
    ;

blockItemList
    :   statement
    |   statement blockItemList
    ;

expressionStatement
    :   expression? ';'
    ;

compilationUnit
    :   translationUnit? EOF
    ;

translationUnit
    :   externalDeclaration
    |   externalDeclaration translationUnit
    ;

externalDeclaration
    :   shaderDefinition
    |   outputsDefinition
    |   functionDefinition
    |   declaration
    |   uniformDeclaration
    |   ';'
    ;

shaderDefinition
    :   'shader' shaderSignature compoundStatement
    ;

shaderSignature
    :   Identifier '(' shaderParameterList? ')'
    ;

outputsDefinition
    :   'outputs' '(' shaderParameterList? ')'
    ;

functionDefinition
    :   'fun' functionSignature compoundStatement
    ;

functionSignature
    :   typeSpecifier Identifier '(' parameterList? ')'
    ;

integerSize
    :   Constant
    |   property
    ;

Identifier
    :   IdentifierNondigit
        (   IdentifierNondigit
        |   Digit
        )*
    ;

fragment
IdentifierNondigit
    :   Nondigit
    ;

fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
Digit
    :   [0-9]
    ;

Constant
    :   IntegerConstant
    |   FloatingConstant
    |   CharacterConstant
    ;

IntegerConstant
    :   Digit+
    ;

fragment
FloatingConstant
    :   FractionalConstant ExponentPart?
    ;

fragment
FractionalConstant
    :   DigitSequence? '.' DigitSequence
    |   DigitSequence '.'
    ;

fragment
ExponentPart
    :   'e' Sign? DigitSequence
    |   'E' Sign? DigitSequence
    ;

fragment
Sign
    :   '+' | '-'
    ;

fragment
DigitSequence
    :   Digit+
    ;

fragment
CharacterConstant
    :   '\'' CCharSequence '\''
    |   'L\'' CCharSequence '\''
    |   'u\'' CCharSequence '\''
    |   'U\'' CCharSequence '\''
    ;

fragment
CCharSequence
    :   CChar+
    ;

fragment
CChar
    :   ~['\\\r\n]
    |   EscapeSequence
    ;

fragment
EscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

StringLiteral
    :   '"' SCharSequence? '"'
    ;

fragment
SCharSequence
    :   SChar+
    ;

fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;