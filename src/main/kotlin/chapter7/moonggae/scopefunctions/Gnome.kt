package chapter7.moonggae.scopefunctions

class Gnome(val name: String) {
    fun who() = "Gnome: $name"
}

fun whatGnome(gnome: Gnome?) {
    gnome?.let { it.who() }
    gnome?.run { who() }
    gnome?.apply { who() }
    gnome?.also { it.who() }
    // null 인지 판단 할 수 없음
    with(gnome) { this?.who() }
}
