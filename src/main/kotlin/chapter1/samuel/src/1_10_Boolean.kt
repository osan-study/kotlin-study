fun main() {
    isOpen24hh(6)
    println()
    isClose24hh(6)
}

fun isOpen24hh(hour: Int) {
    val open = 9
    val close = 20
    println("Operating hours: $open - $close")
    val status =
//        if(hour >= open && hour <= close) {
        if(hour in open..close) {
            true
        } else {
             false
        }

//    val status2 = hour >= open && hour <= close
    val status2 = hour in open..close

    println("isOpen: $status")
    println("isOpen2 (hour in open..close): $status2")

}

fun isClose24hh(hour: Int) {
    val open = 9
    val close = 20
    println("Operating hours: $open - $close")

    var status =
        if(hour < open || hour > close) {
            true
        } else {
            false
        }

    var status2 = hour < open || hour > close

    println("isClose: $status")
    println("isClose2: $status2")

}

