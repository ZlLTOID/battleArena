package battleArena

import java.lang.StringBuilder

open class Warrior(name: String, hp: Int, attack: Int, defend: Int, dice: Dice) {
    protected val name: String
    private var hp: Int
    protected var currentHp: Int = hp
    protected var attack: Int
    protected var defend: Int
    protected var dice: Dice
    protected var battleMessage: String = ""
    protected val alive: Boolean
        get() {
        return currentHp > 0
    }

    init {
        this.name = name
        this.hp = hp
        this.attack = attack
        this.defend = defend
        this.dice = dice
    }

    fun isAlive(): Boolean {
        if (alive) {
            battleMessage = "Warrior $name has died."
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

    open fun defend(incomingAttack: Int) {
        val damage = incomingAttack - (defend + dice.roll())

        if (damage > 0) {
            currentHp -= damage

            battleMessage = "$name has lost $damage hp!"
            if (currentHp < 1) {
                battleMessage += " And died..."
            }

            if (currentHp <= 0) {
                currentHp = 0
            }
        } else {
            battleMessage = "$name defended himself!"
        }
    }

    open fun attack(enemy: Warrior) {
        val attack: Int = attack + dice.roll()

        enemy.defend(attack)

        battleMessage = "$name attacks $enemy with $attack damage!"
        if (enemy.currentHp < 1) {
            battleMessage += " And killed Him!"
        }
    }

    @JvmName("getBattleMessage1")
    fun getBattleMessage(): String
    {
        return battleMessage
    }

    @JvmName("getCurrentHp1")
    fun getCurrentHp(): Int
    {
        return currentHp
    }

    override fun toString(): String {
        return name
    }
}