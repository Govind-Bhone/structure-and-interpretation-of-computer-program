/*Bonus Set Problem
For bonus point, tackle this - “you'll need to find out what language this is, first”. Let's model a set of
integers to be a function Int -> Bool; applying that function to some integer tells us whether the integer is
in the set or not.
type Set = Int -> Bool
I would like to you implement function forall, which takes some predicate p, the set to be checked and
computes whether all elements in the set satisfy the predicate p. Dueto the way the set is modelled, and Int
represents *a lot* of numbers, and because we want the answer 'quickly', you will need to restrict the
possible range, for example from -1000 to 1000.
Thus, the final exercise to implement the function
forall :: (Int -> Bool) -> Set -> Bool
Feel free to parametrise the type Set with a type variable, if you like; and explore the implication of such
type polymorphism.
Answer :
This is scala language construct and we can easily implement in scala using scala Typing as follows .
type is set to Int for this current implementation .*/

object SetExample extends App {
type T = Int
type Set [ T ] = T => Boolean
def contains(s: Set [ T ], elem: T ): Boolean = s(elem)
def filter(s: Set [ T ], p: T => Boolean): Set [ T ] = { elem: T => contains(s, elem) &&
contains(p, elem) }
val limit = 1000
def forall(s: Set [ T ], p: T => Boolean): Boolean = {
def loop(a: Int): Boolean = {
a match {
case a if (a == - limit) => true
case a if (( contains(s, a)) && (! contains( filter(s, p), a))) => false
case _ => loop(a - 1 )
}
}
loop( limit)
}
//=============Set(25)===============
val s1 = (ele: Int) ⇒ ele == 25
val p1 = (ele: Int) ⇒ ele > 11
println( forall( s1, p1))
//=============Set(25)====================
val s2 = (ele: Int) ⇒ ele == 25
val p2 = (ele: Int) ⇒ ele == 25
println( forall( s2, p2))
//=============Set(11,12,13,14,15,16,17,18)===============
val s3 = (ele: Int) ⇒ 11 <= ele && ele <= 18
val p3 = (ele: Int) ⇒ ele >= 12
println( forall( s3, p3))
//=============Set(11,12,13,14,15,16,17,18)===============
val s4 = (ele: Int) ⇒ 11 <= ele && ele <= 18
val p4 = (ele: Int) ⇒ ele >= 11
println( forall( s4, p4))
// =================Set(5000,6000)===================
val s5 = (ele: Int) ⇒ 5000 <= ele && ele <= 6000
val p5 = (ele: Int) ⇒ ele >= 1
println( forall( s5, p5))
}
