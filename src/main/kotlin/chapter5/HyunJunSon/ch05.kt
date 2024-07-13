package chapter5.HyunJunSon


//interface Player{
//    val symbol: Char
//}
//
//class Food : Player{
//    override val symbol = '.'
//}
//
//class Robot : Player {
//    override val symbol get() = 'R'  // 리턴타입은 적어도 되고 안적어도 됨 , get()
//}
//
//class Wall(override val symbol: Char) : Player
//
//fun main(){
//    println(listOf(Food(), Robot(), Wall('|')).map{ it.symbol})
//}


//interface Hotness{
//    fun feedback(): String
//}

//fun interface ZeroArg{
//    fun f() : Int
//}
//
//fun interface OneArg{
//    fun g(n: Int) : Int
//}
//
//fun interface TwoArg{
//    fun h(i:Int, j:Int) : Int
//}
//
//class VerboseZero : ZeroArg {
//    override fun f() = 11
//}
//
//val verboseZero = VerboseZero()
//
//val samZero = ZeroArg{ 11 }
//
//class VerboseOne : OneArg {
//    override fun g(n: Int) = n+ 47
//}
//
//val verboseOne = VerboseOne()
//
//val samOne = OneArg{ it + 47}
//
//class VerboseTwo : TwoArg{
//    override fun h(i:Int, j:Int) = i+j
//}
//
//val verboseTwo = VerboseTwo()
//
//val samTwo = TwoArg{ i,j -> i+j}
//
//fun main() {
//    println(verboseZero.f())//11
//    println(samZero.f()) //11
//    println(verboseOne.g(92))    //139
//    println(samOne.g(92))    //139
//    println(verboseTwo.h(11,47))  //58
//    println(samTwo.h(11,47)) //58
//}

//class WithSecondary(i: Int) {
//    init{
//        println("Primary: $i")
//    }
//    constructor(c: Char) : this(c - 'A'){
//        println("Secondary: '$c'")
//    }
//    constructor(s: String) : this(s.first()){
//        println("Secondary: \"$s\"")
//    }
//}
//
//
//fun main() {
//    fun sep() = println("-".repeat(10))
////    WithSecondary(1)
////    sep()
////    WithSecondary('D')
//    sep()
//    WithSecondary("Last Constructor")
//}

//enum class Material{
//    Ceramic, Metal, Plastic
//}
//
//class GardenIem(val name: String){
//    var material: Material = Plastic
//    constructor(
//        name: String, material:Material
//    ) : this(name){
//        this.material = material
//    }
//
//    constructor(
//        material: Material
//    ) : this("Strange Thing", material)
//
//    override fun toString(): String = "$material $name"
//}
//
//fun main() {
//    println(GardenIem("Elf")) // Plastic Elf
//    println(GardenIem("Snowman").name) // Snowman
//    println(GardenIem("Grazing Ball", Metal)) //Metal Grazing Ball
//    println(GardenIem(material = Ceramic)) //Ceramic Strange Thing
//
//}

//open class Parent
//
//class Child : Parent()
//
//class GrandChild : Child() // error

//open class GreatApe{
//    protected var energy = 0
//    open fun call() = "Hoo!"
//    open fun eat() {
//        energy += 10
//    }
//    fun climb(x: Int){
//        energy -= x
//    }
//    fun energyLevel() = "Energy: $energy"
//}
//
//class Bonobo : GreatApe() {
//    override fun call() = "Eep!"
//    override fun eat(){
//        energy += 10
//        super.eat()
//    }
//
//    fun run() = "Bonobo run"
//}
//
//class Chimpanzee : GreatApe() {
//    val additionalEnergy = 20
//    override fun call() = "Yawp!"
//    override fun eat() {
//        energy += additionalEnergy
//        super.eat()
//    }
//    fun jump() = "Chimp jump"
//}
//fun talk(ape: GreatApe): String{
//    ape.eat()
//    ape.climb(10)
//    return "${ape.call()} ${ape.energyLevel()}"
//}
//
//fun main() {
//    println(talk(GreatApe()))
//    println(talk(Bonobo()))
//    println(talk(Chimpanzee()))
//}

//class IntList(val name: String){
//    val list = mutableListOf<Int>()
//}
//
//fun main(){
//    val ints = IntList("numbers")
//    println(ints.name)
//
//    ints.list += 7
//    println(ints.list)
//}


//interface Parent{
//    val ch: Char
//    fun f(): Int
//    fun g() = "ch = $ch; f() = ${f()}"
//}
//
//class Actual(
//    override val ch: Char
//) : Parent {
//    override fun f() = 17
//}
//
//class Other : Parent {
//    override val ch: Char
//        get() = 'B'
//    override fun f() = 34
//}
//
//fun main() {
//    println(Actual('A').g()) //ch = A; f() = 17
//    println(Other().g()) //ch = B; f() = 34
//
//}


//interface A {
//    fun f() = 1
//    fun g() = "A.g"
//    val n: Double
//        get() = 1.1
//}
//
//interface B {
//    fun f() = 2
//    fun g() = "B.g"
//    val n: Double
//        get() = 2.2
//}
//
//class C : A,B {
//    override fun f() = 0
//    override fun g() = super<A>.g()
//    override val n: Double
//        get() = super<A>.n + super<B>.n
//}
//
//fun main(){
//    val c = C()
//    println(c.f())
//    println(c.g())
//    println(c.n)
//}

//open class Base{
//    open fun f() = "Base.f()"
//}
//
//class Derived : Base() {
//    override fun f() = "Derived.f()"
//}
//
//fun Base.g() = "Base.g()"
//fun Derived.g() = "Derived.g()"
//
//fun useBase(b: Base){
//    println("Received ${b::class.simpleName}")
//    println(b.f()) // 멤버함수
//    println(b.g()) // 확장함수
//}
//
//fun main() {
//    println(useBase(Base()))
//    println(useBase(Derived()))
//}

//interface Controls{
//    fun up(velocity: Int): String
//    fun down(velocity: Int): String
//    fun left(velocity: Int): String
//    fun right(velocity: Int): String
//    fun forward(velocity: Int): String
//    fun back(velocity: Int): String
//    fun turboBoost(): String
//}
//
//class SpaceShipControls : Controls {
//
//    override fun up(velocity: Int) = "up $velocity";
//    override fun down(velocity: Int) = "down $velocity";
//    override fun left(velocity: Int) = "left $velocity";
//    override fun right(velocity: Int) = "right $velocity";
//    override fun forward(velocity: Int) = "forward $velocity";
//    override fun back(velocity: Int) = "back $velocity";
//    override fun turboBoost() = "turbo Boost";
//}
//
//class ExplicitSpaceShipControls : Controls {
//    private val controls = SpaceShipControls()
//    override fun up(velocity: Int) = "controls.up $velocity";
//    override fun down(velocity: Int) = "controls.down $velocity";
//    override fun left(velocity: Int) = "controls.left $velocity";
//    override fun right(velocity: Int) = "controls.right $velocity";
//    override fun forward(velocity: Int) = "controls.forward $velocity";
//    override fun back(velocity: Int) = "controls.back $velocity";
//    override fun turboBoost() = "controls.turbo Boost";
//}
//fun main() {
//    val controls = ExplicitSpaceShipControls()
//    println(controls.forward(10))
//    println(controls.turboBoost())
//}

//interface Rectangle {
//    fun paint(): String
//}
//
//class ButtonImage(
//    private val width: Int,
//    private val height: Int
//) : Rectangle {
//    override fun paint() = "painting ButtonImage($width, $height)"
//}
//
//interface MouseManager {
//    fun clicked(): Boolean
//    fun hovering(): Boolean
//}
//
//class UserInput : MouseManager {
//    override fun clicked() = true
//    override fun hovering() = true
//}
//
//class Button(
//    private val width: Int,
//    private val height: Int
//) : Rectangle by ButtonImage(width, height), MouseManager by UserInput()
//
//fun main() {
//    val button = Button(10, 5)
//    println(button.paint())
//    println(button.clicked())
//    println(button.hovering())
//}

//interface Creature
//
//class Human : Creature {
//    fun greeting() = "I'am Human"
//}
//class Dog : Creature {
//    fun bark() = "Yip"
//}
//class Alien : Creature {
//    fun mobility() = "Three legs"
//}
//
//fun what(c: Creature): String =
//    when(c){
//        is Human -> c.greeting()
//        is Dog -> c.bark()
//        is Alien -> c.mobility()
//        else -> "Something else"
//    }
//
//fun dobBarkUnsafe(c: Creature)= (c as Dog).bark()
//fun dogBarkUnsafe2(c: Creature) : String {
//    c as Dog
//    c.bark()
//    return c.bark() + c.bark()
//}
//
//fun main() {
//    println(dobBarkUnsafe(Dog()))
//    println(dogBarkUnsafe2(Dog()))
//}


//interface Creature
//
//class Human : Creature {
//    fun greeting() = "I'am Human"
//}
//class Dog : Creature {
//    fun bark() = "Yip"
//}
//class Alien : Creature {
//    fun mobility() = "Three legs"
//}
//
//fun what(c: Creature): String =
//    when(c){
//        is Human -> c.greeting()
//        is Dog -> c.bark()
//        is Alien -> c.mobility()
//        else -> "Something else"
//    }
//fun dogBarkSafe(c: Creature) =
//    (c as? Dog)?.bark() ?: "Not a Dog"

//fun main(){
//    println(dogBarkSafe(Dog()))
//    println(dogBarkSafe(Human()))
//}
//
//val group: List<Creature> = listOf(
//    Human(), Human(), Dog(), Alien(), Dog()
//)
//
//fun main() {
////    val dog = group.find{it is Dog} as Dog?
////    println(dog?.bark())
//    val filterIsInstance = group.filterIsInstance<Human>()
//    println(filterIsInstance)
//}

//open class Transport
//data class Train(
//    val line: String
//) : Transport()
//
//data class Bus(
//    val number: String,
//    val capacity: Int
//) : Transport()
//
//fun travel(transport : Transport) =
//    when(transport) {
//        is Train -> "Train ${transport.line}"
//        is Bus -> "Bus ${transport.number}: "+ "size ${transport.capacity}"
//        else -> "$transport is in limbo!"
//    }
//
//fun main() {
//    val map = listOf(Train("S1"), Bus("11", 90)).map(::travel)
//    println(map)
//}

//sealed class Transport
//
//data class Train(
//    val line: String
//) : Transport()
//
//data class Bus(
//    val number: String,
//    val capacity: Int
//) : Transport()
//
//fun travel(transport : Transport) =
//    when(transport) {
//        is Train -> "Train ${transport.line}"
//        is Bus -> "Bus ${transport.number}: "+ "size ${transport.capacity}"
//        else -> "$transport is in limbo!"
//    }
//
//fun main() {
//    val map = listOf(Train("S1"), Bus("11", 90)).map(::travel)
//    println(map)
//}

sealed class Top
class Middle1 : Top()
class Middle2 : Top()

open class Middle3 : Top()

class Bottom3 : Middle3()

fun main() {
    println(Top::class.sealedSubclasses.map{ it.simpleName}) //[Middle1, Middle2, Middle3]

}