class YahtzeeRoll {
    private var dices = mutableListOf<Dice>();

    init {
        for(i in 0..4){
            val dice =  Dice()
            dices.add(dice)
        }
    }

    fun rollDices(rollingOrder : String? ="11111"){
        print("You rolled:")
        for(i in 0..4){
            if (rollingOrder!![i]=='1'){
                dices[i].roll()
            }
            print(" ${dices[i].getNumber()}")
        }
        println()
    }

    fun getSum():Int{
        var sum = 0
        for (dice in dices){
            sum+=dice.getNumber()
        }
        return sum
    }

    fun getDices( ):MutableList<Dice>{
        return dices
    }
}