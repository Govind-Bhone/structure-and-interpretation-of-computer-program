/*Exercise 1.43. If f is a numerical function and n is a positive integer, then we can form the nth
repeated
application of f, which is defined to be the function whose value at x is f(f(...(f(x))...)). For
example, if
f is the function x x + 1, then the nth repeated application of f is the function x x + n. If f is the
operation of squaring a number, then the nth repeated application of f is the function that raises
its
argument to the 2nth power. Write a procedure that takes as inputs a procedure that computes f
and a
positive integer n and returns the procedure that computes the nth repeated application of f. Your
procedure
should be able to be used as follows:
((repeated square 2) 5)
625
Hint: You may find it convenient to use compose from exercise 1.42.
Answer :
(define (repeated f n)
(define (loop acc g i )
( if (= i 1)
(* acc (g i))
(loop acc (compose f g) (- i 1))))
(loop 1 f n)
)
((repeated square 2) 5 )
We can Implement in scala it by two ways
3. writing our own compose method
4. using scala’s existing compose API
Below is the code containing both approaches */

object RepeatedComposingProcedures extends App {
// Exercise 1.43
//===============Using Customized compose method==================
def square(x: Int) = x * x
@annotation.unspecialized def compose[ A ](f: A => A )(g: A => A ): A => A = x => f(g(x))
def repeated(f: Int => Int, repeat: Int)(number: Int) = {
def loop(acc: Int, g: Int => Int, i: Int): Int = i match {
case 1 => acc * g(number)
case a@_ if a > 1 => loop(acc, compose(f)(g), i - 1 )
}
loop( 1 , f, repeat)
}
println( repeated( square, 1 )( 5 )) // 25
println( repeated( square, 2 )( 5 )) // 625
println( repeated( square, 2 )( 2 )) // 16
println( repeated( square, 2 )( 3 )) // 81
println( "=======================================" )
//===========Using Scala Compose Method====================
def repeated1(f: Int => Int, repeat: Int)(number: Int) = {
def loop(acc: Int, g: Int => Int, i: Int): Int = i match {
case 1 => acc * g(number)
case a@_ if a > 1 => loop(acc, f compose g, i - 1 )
}
loop( 1 , f, repeat)
}
println( repeated1( square, 1 )( 5 )) // 25
println( repeated1( square, 2 )( 5 )) // 625
println( repeated1( square, 2 )( 2 )) // 16
println( repeated1( square, 2 )( 3 )) // 81
}
