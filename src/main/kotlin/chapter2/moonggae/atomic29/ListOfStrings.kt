package chapter2.moonggae.atomic29

import atomictest.*

fun main() {
    val wocky = """
    Twas brillig, and the slithy toves
      Did gyre and gimble in the wabe:
    All mimsy were the borogoves,
      And the mome raths outgrabe.
  """.trim().split(Regex("\\W+")) // regex \W+ : 한개 이상의 알파벳 또는 숫자
    trace(wocky.take(5))
    trace(wocky.slice(6..12))
    trace(wocky.slice(6..18 step 2))
    trace(wocky.sorted().takeLast(5))
    trace(wocky.sorted().distinct().takeLast(5))
    trace eq """
    [Twas, brillig, and, the, slithy]
    [Did, gyre, and, gimble, in, the, wabe]
    [Did, and, in, wabe, mimsy, the, And]
    [the, the, toves, wabe, were]
    [slithy, the, toves, wabe, were]
  """
}