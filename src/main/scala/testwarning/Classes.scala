package testwarning

sealed trait Trait1
sealed trait Trait2

class Class1 extends Trait1
// No class extends Trait1 with Trait2
