package battleArena

class Dice(numberOfSides: Int) {
    val numberOfSides: Int

    init {
        this.numberOfSides = numberOfSides
    }

    constructor(): this(6)

    public fun roll(): Int
    {
        return (1..this.numberOfSides).random()
    }

    override fun toString(): String {
        return "Cube with $numberOfSides sides"
    }
}

//class Cube(val numberOfSides: Int) {
//
//    constructor(): this(6)
//}

