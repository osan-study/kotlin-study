fun main() {
    val items = mutableListOf("first", "second", "third", "XXX", "4th")

    val seq = generateSequence {
        items.removeAt(0).takeIf { it != "XXX" }
    }  // kotlin.sequences.ConstrainedOnceSequence@4f3f5b24

    println(seq.toList())
    println(seq.toList()) // 두번 사용 안된다.
//    Exception in thread "main" java.lang.IllegalStateException: This sequence can be consumed only once.
//    	at kotlin.sequences.ConstrainedOnceSequence.iterator(SequencesJVM.kt:23)
//    	at kotlin.sequences.SequencesKt___SequencesKt.toList(_Sequences.kt:812)
//    	at chapter4.HyunJunSon.Ch04Kt.main(ch04.kt:530)
//    	at chapter4.HyunJunSon.Ch04Kt.main(ch04.kt)

}