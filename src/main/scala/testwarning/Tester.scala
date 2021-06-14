package testwarning

object Tester {
  def test(x: Trait1): String = x match {
    case y: Trait2 => "Also Trait2"
    case z: Trait3 => "Also Trait3"
    case _ => "Only Trait1"
  }
}
