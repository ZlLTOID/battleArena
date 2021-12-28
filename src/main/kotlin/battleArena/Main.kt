package battleArena

fun main(arg: Array<String>) {
    val cube1 = Cube(6)
    val cube2 = Cube(18)

    println(cube1)
    for (i in 0..100) {
        println(cube1.roll())
    }

    println(cube2)
    for (i in 0..100) {
        println(cube2.roll())
    }
}