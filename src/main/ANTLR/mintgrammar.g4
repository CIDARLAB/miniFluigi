/*
 * krishna
 */

grammar mintgrammar;

netlist
    :   importBlock?
        header
        ufmoduleBlock?
        layerBlocks
        EOF
    ;

importBlock
    :   importStat+
    ;

importStat
    :   'IMPORT' ufmodulename
    ;

header
    :   (tag='3D')? 'DEVICE' ID_SMALL
    ;

ufmoduleBlock
    :   ufmoduleStat+
    ;

ufmoduleStat
    :   ufmodulename ufnames ';'
    ;

layerBlocks
    :   layerBlock+
    ;

layerBlock
    :   flowBlock
        controlBlock?
    ;


flowBlock
    :   'LAYER FLOW'
        (flowStat)*
        'END LAYER'
    ;

controlBlock
    :   'LAYER CONTROL'
        (controlStat)*
        'END LAYER'
    ;

flowStat
    :   primitiveStat
    |   compositeStat
    |   channelStat
    |   netStat
    |   valveStat
    |   bankStat
    |   gridStat
    |   spanStat
    ;

controlStat
    :   valveStat
    |   channelStat
    |   netStat
    |   bankStat
    |   primitiveStat
    ;

//Flow and Control Statements

primitiveStat
    :   entity ufnames paramsStat ';'
    ;

compositeStat
    :   ('V'|'H')? entity ufnames paramsStat ';'
    ;

bankStat
    :   ('V'|'H')? 'BANK' ufname 'of' INT entity paramsStat ';'
    ;

gridStat
    :   'GRID' ufname 'of' INT ',' INT entity paramsStat ';'
    ;

spanStat
    :   ('V'|'H')? entity ufname  INT 'to' INT paramsStat ';'
    ;

valveStat
    :   ('VALVE'|'3DVALVE') ufname 'on' ufname paramsStat ';'
    ;


channelStat
    :   'CHANNEL' ufname 'from' uftarget 'to' uftarget widthParam ';'
    ;

netStat
    :   'NET' ufname 'from' source_name=ID_SMALL source_terminal=INT 'to' uftargets widthParam ';'
    ;

//Common Parser Rules

entity
    :   entity_element+
    ;

entity_element
    :   ID_BIG
    ;

paramsStat
    :   paramStat*
    ;

paramStat
    :   param_element '=' value
    |   verticalDirectionParam
    |   horizontalDirectionParam
    |   verticalConnectionParam
    |   horizontalConnectParam
    |   widthParam
    ;

param_element
    :   ID_SMALL
    ;

widthParam
    :   'width' '=' value
    |   'w' '=' value
    |   'channelWidth' '=' value
    ;

verticalDirectionParam
    :   'dir''='dir=('RIGHT'|'LEFT')
    ;

horizontalDirectionParam
    :   'dir''='dir=('UP'|'DOWN')
    ;

horizontalConnectParam
    :   'horizontalConnect' '=' boolvalue
    ;

verticalConnectionParam
    :   'verticalConnect' '=' boolvalue
    ;

ufmodulename
    :   ID_BIG
    ;

ufterminal
    :   INT
    ;

uftargets
    :    uftarget (',' uftarget)+
    ;

uftarget
    :   target_name=ID_SMALL (target_terminal=INT)?
    ;

ufname
    :   ID_SMALL
    ;

ufnames
    :   ufname (',' ufname)*
    ;

value
    :   INT
    ;

boolvalue
    :   'YES'
    |   'NO'
    ;

//Common Lexical Rules

ID_BIG  :  ('A'..'Z'|'_') ('A'..'Z'|'_')*  ;

ID_SMALL    :  ('a'..'z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

INT :   [0-9]+ ; // Define token INT as one or more digits
WS  :   [ \t\r\n]+ -> skip ; // Define whitespace rule, toss it out

COMMENT :    '#' ~[\r\n]* -> skip ;