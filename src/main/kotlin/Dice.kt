class Dice {
    private var number : Int = 0;

    fun roll(){
        val randomDiceNumber = (1..6).random()
        number = randomDiceNumber
    }

    fun getNumber():Int{
        return number
    }
}