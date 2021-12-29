package battleArena

import java.lang.StringBuilder
import java.math.*

class Warrior(name: String, hp: Int, attack: Int, defend: Int, cube: Cube) {
    private val name: String
    private var hp: Int
    private var currentHp: Int = hp
    private var attack: Int
    private var defend: Int
    private var cube: Cube
    private var message: String = ""

    init {
        this.name = name
        this.hp = hp
        this.attack = attack
        this.defend = defend
        this.cube = cube
    }

    fun isAlive(): Boolean {
        if (this.currentHp == 0) {
            this.message = "Warrior $name has died."
        }

        return this.currentHp > 0
    }

    fun graphicHp(): String {
        val builder = StringBuilder()
        var healthBarParts: Int = 10
        var currentHpPercentage: Int = ((this.currentHp.toDouble() / this.hp) * 100).toInt()

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
        val damage = incomingAttack - (this.defend + this.cube.roll())

        this.message = "$name has lost $damage hp!"

        if (damage > 0) {
            this.currentHp -= incomingAttack

            if (this.currentHp <= 0) {
                this.currentHp = 0
            }
        } else {
            this.message = "$name defend himself!"
        }
    }

    fun attack(enemy: Warrior) {
        val attack: Int = this.attack + this.cube.roll()

        this.message = "$name attacks on $enemy with $attack damage!"

        enemy.defend(attack)
    }

    fun getMessage(): String
    {
        return this.message
    }

    override fun toString(): String {
        return "$name"
    }
}