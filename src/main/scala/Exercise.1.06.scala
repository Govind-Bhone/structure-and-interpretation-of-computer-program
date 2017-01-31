/*Exercise 1.6. Alyssa P. Hacker doesn't see why if needs to be provided as a special form. ``Why can't I
just define it as an ordinary procedure in terms of cond ?'' she asks. Alyssa's friend Eva Lu Ator claims
this can indeed be done, and she defines a new version of if :
(define (new-if predicate then-clause else-clause)
(cond (predicate then-clause)
(else else-clause)))
Eva demonstrates the program for Alyssa:
(new-if (= 2 3) 0 5)
5
(new-if (= 1 1) 0 5)
0
Delighted, Alyssa uses new-if to rewrite the square-root program:
(define (sqrt-iter guess x)
(new-if (good-enough? guess x)
guess
(sqrt-iter (improve guess x)
x)))
What happens when Alyssa attempts to use this to compute square roots? Explain.
Answer :
The if condition expression in LISP is a special form having special rules for execution irrespective of
interpreter order . it is called as flow of control special form .we can express it as follows
(IF antecedent consequent alternative) with meaning
(COND (antecedent consequent)
(T alternative))
In this example, we can see that not only must one of the arguments (the antecedent) be evaluated before
the other arguments, but one of the two other arguments will not be evaluated at all.
But when we rewrite the new version of if statement as follows
(define (new-if predicate then-clause else-clause)
(cond (predicate then-clause)
(else else-clause)))
then we will use applicative order evaluation and so it will evaluate (sqrt-iter (improve guess
x)x) argument resulting in the following behaviour which won’t terminate .
sqrt-iter
new-if
sqrt-iter
new-if
……………
we can describe above behavior using below scala code .*/


object EvasNewIfDefinition extends App{
// Exercise 1.6
import scala.math._
private def isGoodEnough(guess: Double, x: Double) =
abs(guess * guess - x) < 0.001
private def improve(guess: Double, x: Double) =
(guess + x / guess) / 2
// ======================== Special If =========================
private def squareRootLogicSpecialIf(guess: Double, x: Double): Double = {
if (isGoodEnough(guess, x)) guess
else squareRootLogicSpecialIf(improve(guess, x), x)
}
def sqrtWithSpecialIf(x: Double) = squareRootLogicSpecialIf( 1.0 , x)
// ========================Evas New If definition=========================
def sqrtWithNewIf(x : Double) = squareRootLogicWithNewIf( 1.0 , x)
private def newIf(predicate : Boolean, ifPart : Double, elsePart : Double) = { if
(predicate) ifPart else elsePart }
private def squareRootLogicWithNewIf(guess : Double, x : Double) : Double = {
newIf(isGoodEnough(guess, x), guess, squareRootLogicWithNewIf(improve(guess, x),
x))
}
println(sqrtWithSpecialIf( 2 )) // 1.4142156862745097
println(sqrtWithNewIf( 2 )) // fail with Exception in thread "main"
java.lang.StackOverflowError
}
