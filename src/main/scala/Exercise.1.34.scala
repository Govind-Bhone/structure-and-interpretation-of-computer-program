/*Exercise 1.34. Suppose we define the procedure
(define (f g)
(g 2))
Then we have
(f square)
4
(f (lambda (z) (* z (+ z 1))))
6
What happens if we (perversely) ask the interpreter to evaluate the combination (f f)? Explain.
Answer :
When we try to execute /evaluate (f f ) then using substitution principle
(f f ) => (f 2 ) => ( 2 2) => Error as no method/procedure found
we can describe this behavior using scala code as follows .*/

object LamdaMethodInvocation extends App {
// Exercise 1.34
def f(g: Int => Int):Int = g( 2 )
def square: Int => Int = (x: Int) => x * x
println(f(square)) // 4
val lambda: Int => Int = (x: Int) => x * (x + 1 )
println(f(lambda)) // 6
println(f(f))
/*
compile time error
Error:(13, 13) type mismatch;
found : (Int => Int) => Int
required: Int => Int
println(f(f)) // compile time error*/
}
