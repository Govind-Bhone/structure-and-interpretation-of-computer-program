/*Exercise 1.42. Let f and g be two one-argument functions. The composition f after g is defined
to be the
function x => f(g(x)). Define a procedure compose that implements composition. For example, if
inc is a
procedure that adds 1 to its argument,
((compose square inc) 6)
49
Answer :
(define (compose f g)
(lambda (x)
(f (g x))))
((compose square inc) 6)
49
We can Implement in scala it by two ways
1. writing our own compose method
2. using scala’s existing compose API
Below is the code containing both approaches */

object ComposingProcedures extends App{
// Exercise 1.42
// =================Customized compose use=======================
def square(x: Int): Int = x * x
def inc(x: Int): Int = x + 1
@annotation.unspecialized def compose[A](f: A => A)(g: A => A): A => A = x => f(g(x))
println(compose(square)(inc) ( 6 )) //49
// ===============Scala compose Use=======================
val scalaComposeFun = square _ compose inc _
println(scalaComposeFun( 6 )) //49
}
