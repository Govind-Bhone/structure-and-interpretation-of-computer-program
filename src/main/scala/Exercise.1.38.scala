/*Exercise 1.38. In 1737, the Swiss mathematician Leonhard Euler published a memoir De Fractionibus
Continuis, which included a continued fraction expansion for e - 2, where e is the base of the natural
logarithms. In this fraction, the Ni are all 1, and the Di are successively 1, 2, 1, 1, 4, 1, 1, 6, 1, 1, 8, ....
Write a program that uses your cont-frac procedure from exercise 1.37 to approximate e, based on
Euler's expansion.
Answer :
In Lisp , We can implement this as follows .
(define (cont-frac n d k)
(define (iter k acc)
(if (= 0 k)
acc
(iter (- k 1) (/ (n k)
(+ (d k) acc)))))
(iter k (/ (n k) (d k)))
(define (e limit)
(+ 2
(cont-frac (lambda (i) 1.0)
(lambda (i) (/(* (+ i 1) 2) 3))
limit)))
(e 9)
and In scala , we can implement this as follows .*/

object EulerExpansionPrinciple extends App {
//Exercise 1.38
def contFract(n: (Int) => Double, d: (Int) => Double, k: Int): Double = {
def iter(acc: Double, k: Int): Double = {
if (k == 0 )
acc
else
iter(n(k) / (acc + d(k)), k - 1 )
}
iter(n(k) / d(k), k)
}
def e(limit: Int) = 2 + contFract((n: Int) => 1.0 , (i: Int) => ( 2 * (i + 1 )) / 3 ,
limit)
println( "value of e for n=9 is " + e( 9 )) // 2.708715596330275
}
