fun printInfo(name:String, age: Int, address: String) = "나는 ${name}입니다. ${age}살이며 ${address} 살아요 !";

fun main() {

    print(printInfo(name="최윤진", address="오산", age=32));
}