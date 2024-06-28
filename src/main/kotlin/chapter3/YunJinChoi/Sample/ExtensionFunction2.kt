class ExtensionFunction {

    private val MAX = 10;
    val MIN = 1;
}

// Cannot access 'val MAX: Int': it is private in '/ExtensionFunction'. 발생
//fun ExtensionFunction.max() = this.MAX;
fun ExtensionFunction.min() = this.MIN;
fun main() {


    val sample = ExtensionFunction();
    print(sample.min())
}