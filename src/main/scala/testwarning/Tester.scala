package testwarning

object Tester {
  def test(x: Trait1): String = x match {
    case y: Trait2 => "Also Trait2"
    case _ => "Only Trait1"
  }
}

