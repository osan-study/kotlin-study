package chapter5.moonggae

import atomictest.eq

class Hotel(private val reception: String) {
    open inner class Room(val id: Int = 0) {
        fun callReception() = "Room $id Calling $reception" // reception 접근
    }
    private inner class Closet : Room()
    fun closet(): Room = Closet()
}

fun main() {
    val nycHotel = Hotel("311")
    val room = nycHotel.Room(319) // 내부 클래스의 인스턴스를 생성하려면 그 내부 클래스를 둘러싼 클래스의 인스턴스가 필요하다
    room.callReception() eq "Room 319 Calling 311"
    val sfHotel = Hotel("0")
    val closet = sfHotel.closet() // Hotel.Room으로 업캐스팅 된다.
    closet.callReception() eq "Room 0 Calling 0"
}