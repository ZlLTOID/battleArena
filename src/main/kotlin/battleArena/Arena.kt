package battleArena

class Arena(warrior1: Warrior, warrior2: Warrior, dice: Dice) {
    private val warrior1: Warrior
    private val warrior2: Warrior
    private val dice: Dice

    init {
        this.warrior1 = warrior1
        this.warrior2 = warrior2
        this.dice = dice
    }

    fun printArena() {
        println("-------------- Arena --------------\n")
        println("Warrior\'s health: \n")
        println("$warrior1 \u001B[32m ${warrior1.graphicHp()} \u001b[0m")
        println("$warrior2 \u001B[32m ${warrior2.graphicHp()} \u001B[0m")
    }

    fun printMessage(message: String) {
        println(message)
        Thread.sleep(200)
    }

    fun fight() {
        println("Welcome to Arena")
        println("Today will fight warriors \u001b[31m $warrior1 \u001b[0m and \u001b[31m $warrior2 \u001b[0m")
        println("Let the fight begin...")

        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.attack(warrior2)
            printArena()
            printMessage(warrior1.getMessage())
            printMessage(warrior2.getMessage())
            println(warrior2.getCurrentHp())

            if (!warrior1.isAlive()) {
                println(warrior1.getMessage())
                break
            } else if (!warrior2.isAlive()) {
                println(warrior2.getMessage())
                break
            }

            warrior2.attack(warrior1)
            printArena()
            printMessage(warrior2.getMessage())
            printMessage(warrior1.getMessage())
            println(warrior1.getCurrentHp())
        }
    }
}