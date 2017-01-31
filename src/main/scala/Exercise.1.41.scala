/*Exercise 1.41. Define a procedure double that takes a procedure of one argument as argument
and
returns a procedure that applies the original procedure twice. For example, if inc is a procedure
that adds
1 to its argument, then (double inc) should be a procedure that adds 2. What value is
returned by
(((double (double double)) inc) 5)
Answer :
(define (double f)
(lambda (x) (f (f x))))
Let’s use some sample test cases ,
Where ,
(define (inc n) (+ n 1))
((double inc) 3)
⇨ (inc ( inc ( 3))) => 5
apply the substitution for below test
(((double (double double)) inc) 5)
⇨ (((double (double double)) inc) 5)
⇨ (((double (lambda (x) (double (double x)))) inc) 5)
⇨ .......
⇨ .........
⇨ (double(double(double(double(inc(5))))))
⇨ (double(double(double(inc(inc(5))))))
⇨ (double(double(inc(inc(inc(inc(5))))))))
⇨ (double(inc(inc(inc(inc(inc(inc(inc(inc(5))))))))))
⇨ (inc(inc(inc(inc(inc(inc(inc(inc(5)))))))))
⇨ (inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(inc(5)))))))))))))
))))
⇨ (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc (inc
5))))))))))))))))
⇨ 21
We can demonstrate this using scala program as */

object RepeatedIncrement extends App{
// Exercise 1.41
def inc(x: Int) = x + 1
def double[ Int ](f: Int => Int )(x: Int ) = f(f(x))
println(double (inc) ( 6 ) ) // inc execute twice so 8
println(double(double(double[Int]))(inc)( 5 )) //21
}
