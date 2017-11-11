grammar Calc;

code
	: mExpression EOF;
	
mExpression : left=mExpression op=('*'|'/'|'%') right=mExpression 	#operationExpr
      | left=mExpression op=('+'|'-') right=mExpression 		#operationExpr
      | '(' solvableExpr=mExpression ')'                      				#parExpr
      | value													#val
      ;
      
value
	:  '-'? DIGIT+ ('.' DIGIT*)?
	;

DIGIT:  '0'..'9' ; 

WS  :  [ \t\r\n\u000C]+ -> skip
    ;
	
//par_math_expression
//	: 	'(' math_expression WS? ')'
//	|	math_expression
//	;
//	
//math_expression
//	:	left=math_expression op=('+'|'-') right=math_expression
//	|	'(' math_expression ')'
//	|	term
//	;
//
//term
//	:	value
//	| 	left=term WS? op=('*'|'/'|'%') WS? right=term
//	|	'(' term ')'
//	;	
//	
//	:	inputVal=value 
//	|	'(' WS? math_expression WS? ')' (op=('*'|'/'|'%') WS? right=math_expression_lower)? 
//	|   left=math_expression WS? op=('+'|'-') WS? right=math_expression
//	|	math_expression_lower  
//	;
//	
//math_expression_lower
//	:	inputValue=value
//	|	left=math_expression_lower WS? op=('*'|'/'|'%') WS? right=math_expression_lower
//	;
