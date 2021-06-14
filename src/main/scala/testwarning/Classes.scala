package testwarning

sealed trait Trait1
sealed trait Trait2
sealed trait Trait3

class Class1 extends Trait1
class Class2 extends Trait2
class Class3 extends Trait1 with Trait2
