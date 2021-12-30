package battleArena

fun main(arg: Array<String>) {
    val dice = Dice(12)

    println("Enter name for Warrior #1")
    val warrior1Name: String = (readLine()?.ifBlank { null } ?: "Conan").toString()
    println("Enter health points for Warrior #1")
    val warrior1Hp: Int = readLine()?.toIntOrNull() ?: 80
    println("Enter attack for Warrior #1")
    val warrior1Attack: Int = readLine()?.toIntOrNull() ?: (dice.roll() * 2)
    println("Enter defend for Warrior #1")
    val warrior1Defend: Int = readLine()?.toIntOrNull() ?: dice.roll()

    println("Enter name for Warrior #2")
    val warrior2Name: String = (readLine()?.ifBlank { null } ?: "Ziltoid").toString()
    println("Enter health points for Warrior #2")
    val warrior2Hp: Int = readLine()?.toIntOrNull() ?: 80
    println("Enter attack for Warrior #2")
    val warrior2Attack: Int = readLine()?.toIntOrNull() ?: (dice.roll() * 2)
    println("Enter defend for Warrior #2")
    val warrior2Defend: Int = readLine()?.toIntOrNull() ?: dice.roll()

    val warrior1: Warrior = Warrior(warrior1Name, warrior1Hp, warrior1Attack, warrior1Defend, dice)
//    val warrior2: Warrior = Warrior(warrior2Name, warrior2Hp, warrior2Attack, warrior2Defend, dice)
    val warrior2: Mage = Mage(warrior2Name, warrior2Hp, warrior2Attack, warrior2Defend, dice, 100, 30)
    val arena: Arena = Arena(warrior1, warrior2, dice)

    arena.fight()
}