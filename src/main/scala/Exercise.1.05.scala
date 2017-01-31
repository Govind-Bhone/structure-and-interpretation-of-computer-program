/*Exercise 1.5. ​Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is

using applicative-order evaluation or normal-order evaluation. He defines the following two procedures:

(define (p) (p))

(define (test x y)

(if (= x 0)

0

y))

Then he evaluates the expression

(test 0 (p))

What behavior will Ben observed with an interpreter that uses applicative-order evaluation? What

behavior

will he observe with an interpreter that uses normal-order evaluation? Explain your answer. (Assume that

the evaluation rule for the special form if is the same whether the interpreter is using normal or

applicative order: The predicate expression is evaluated first, and the result determines whether to

evaluate

the consequent or the alternative expression.)

Answer : For applicative order evaluation , all expressions/arguments get evaluated first irrespective of its call
during program run or evaluation of procedure body .
so , (test 0 (p)) result into infinite loop for applicative order evaluation as (p) is calling itself indefinitely
.In scala ,we can use this approach of order evaluation for argument with syntax as p: Int ,this is the
default approach of evaluation of arguments called as call by value .
for normal-order evaluation , the expressions/arguments get evaluated only when they get used within
procedure body .
So , ( test 0 (p)) result into 0 for normal-order evaluation as value of first parameter is 0 and alternative
expression never get called /used .
In scala ,we can use this approach of order evaluation for procedure arguments with syntax as p: =>Int
called as call by Name
we can describe above behavior using below scala code . */



object InterpreterOrderEvaluation extends App {
// Exercise 1.5
//=====================Applicative order evaluation scenario using call by value
parameter=======================
def p : Int = { printl n( "p calling repeatively" ); p}
def testforApplicativeOrder(x : Int, y : Int) = { println( "Infinite Loop for any
case" ); if (x == 0 ) 0 else y }
testforApplicativeOrder( 0 , p)
// ======================Normal order evaluation scenario using call by name
parameter=====================
def testforNormalOrder(x : Int, y : => Int) = { println( "Finite execution steps for
current case" ); if (x == 0 ) 0 else y }
testforNormalOrder( 0 , p)
}
