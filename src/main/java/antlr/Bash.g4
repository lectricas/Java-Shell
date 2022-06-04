grammar Bash;

start : pipeline EOF                                        #pipe
      | assignment EOF                                      #assign
      ;

pipeline : command                                          #singleCommand
         | left=pipeline (' '*) '|' (' '*) right=command    #multipleCommands
         ;

command : (part(' '*))+
        ;

part : WORD                                                 #partWord
     | SQSTR                                                #sqstr
     | DQSTR                                                #dqstr
     | '$' WORD                                             #partVariable
     ;

assignment : name=WORD '=' value=WORD                       #wordAssignment
           | name=WORD '=' '$' value=WORD                   #variableAssignment
           ;


SQSTR: '\'' .*? '\'';
DQSTR: '"' .*? '"';

WORD : [a-zA-Z0-9-]+;
