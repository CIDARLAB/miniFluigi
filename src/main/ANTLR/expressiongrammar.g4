grammar expressiongrammar;

atom
    :   number_atom
    |   parameter_atom
    ;

parameter_atom : ID ;

number_atom
    :   FLOAT
    |   INT
    ;

signed_atom
    :   '-' atom
    ;

function_expression
    :   function=ID LPAREN bracket_expression (',' bracket_expression)*  RPAREN
    ;

primary_expression
    :   bracket_expression
    |   function_expression
    |   additive_expression
    |   signed_atom
    |   atom
    ;

bracket_expression
    :   LPAREN additive_expression RPAREN
    |   function_expression
    |   signed_atom
    |   atom
    ;

multiplicative_expression
    :   bracket_expression
    |   multiplicative_expression operator=MUL bracket_expression
    |   multiplicative_expression operator=DIV bracket_expression
    ;

additive_expression
    :   multiplicative_expression
    |   additive_expression operator=ADD multiplicative_expression
    |   additive_expression operator=SUB multiplicative_expression
    ;


//Common Lexical Rules

LPAREN :    '(';

RPAREN :    ')';

ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';

ID :    ('a'..'z'|'_'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

FLOAT : [0-9]+'.'[0-9]+;

INT :   [0-9]+ ; // Define token INT as one or more digits

WS  :   [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out

COMMENT :    '#' ~[\r\n]* -> skip ;
