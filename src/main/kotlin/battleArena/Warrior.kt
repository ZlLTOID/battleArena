package battleArena

import java.lang.StringBuilder

class Warrior(name: String, hp: Int, attack: Int, defend: Int, dice: Dice) {
    private val name: String
    private var hp: Int
    private var currentHp: Int = hp
    private var attack: Int
    private var defend: Int
    private var dice: Dice
    private var message: String = ""

    init {
        this.name = name
        this.hp = hp
        this.attack = attack
        this.defend = defend
        this.dice = dice
    }

    fun isAlive(): Boolean {
        if (currentHp == 0) {
            message = "Warrior $name has died."
        }

        return currentHp > 0
    }

    fun graphicHp(): String {
        val builder = StringBuilder()
        var healthBarParts: Int = 10
        var currentHpPercentage: Int = ((currentHp.toDouble() / hp) * 100).toInt()

        builder.append("[")
        for (i in 1..Math.round(currentHpPercentage/10.0) * 10 / healthBarParts) {
            builder.append("#")
        }
        for (i in 1..healthBarParts - (Math.round(currentHpPercentage/10.0) * 10 / healthBarParts)) {
            builder.append("_")
        }
        builder.append("]")

        var healthBar = builder.toString()

        return healthBar
    }

    fun defend(incomingAttack: Int) {
        val damage = incomingAttack - (defend + dice.roll())

        if (damage > 0) {
            currentHp -= incomingAttack

            message = "$name has lost $damage hp!"
            if (currentHp < 1) {
                message += " And died..."
            }

            if (currentHp <= 0) {
                currentHp = 0
            }
        } else {
            message = "$name defended himself!"
        }
    }

    fun attack(enemy: Warrior) {
        val attack: Int = attack + dice.roll()

        enemy.defend(attack)

        message = "$name attacks $enemy with $attack damage!"
        if (enemy.currentHp < 1) {
            message += " And killed Him!"
        }
    }

    fun getMessage(): String
    {
        return message
    }

    fun getCurrentHp(): Int
    {
        return currentHp
    }

    override fun toString(): String {
        return name
    }
}