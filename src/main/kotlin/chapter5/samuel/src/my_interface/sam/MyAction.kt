package chapter5.samuel.src.my_interface.sam

fun interface MyAction {
    fun act()
}

fun delayAction(action: MyAction) {
    print("in delayAction ... ")
    action.act()
}