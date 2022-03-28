package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    // declare and initialize views top class level
    private val rollButton: Button by lazy { findViewById(R.id.button) }
    private val diceImage: ImageView by lazy { findViewById(R.id.imageView) }
    private val diceImage2: ImageView by lazy { findViewById(R.id.imageView2) }

    // declare and initialize model top class level to reuse entire activity
    private val die1 = Dice(6)
    private val die2 = Dice(6)

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        updateDie(diceImage, die1.roll())
        updateDie(diceImage2, die2.roll())
    }

    // reusable function to apply to each die
    private fun updateDie(die: ImageView, dieRoll: Int) {
        val drawable = when(dieRoll) {
            1 ->R.drawable.dice_1
            2 ->R.drawable.dice_2
            3 ->R.drawable.dice_3
            4 ->R.drawable.dice_4
            5 ->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        die.setImageResource(drawable)
        die.contentDescription = dieRoll.toString()
    }
}
/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}