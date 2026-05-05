object TestRunner {
  def main(args: Array[String]): Unit = {
    val signalcase_1 = Signal(81, 85, 26, 8, 5)
    assert(Policy.score(signalcase_1) == 133)
    assert(Policy.classify(signalcase_1) == "review")
    val signalcase_2 = Signal(75, 72, 21, 12, 11)
    assert(Policy.score(signalcase_2) == 119)
    assert(Policy.classify(signalcase_2) == "review")
    val signalcase_3 = Signal(89, 95, 22, 11, 8)
    assert(Policy.score(signalcase_3) == 162)
    assert(Policy.classify(signalcase_3) == "accept")
  }
}
