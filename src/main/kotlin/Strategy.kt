class Strategy {
    private val bonusYahtzeePoints = 50
    private val bonusPokerPoints = 40
    private val bonusFullHousePoints = 30
    private val bonusSmallStraightPoints = 35
    private val bonusBigStraightPoints = 45
    private val bonusTwoPairsPoints = 10


    fun checkExtraCategory(dices: MutableList<Dice>, sum: Int):String{
        if (isYahtzee(dices)){
            return "Yahtzee, points: ${sum+bonusYahtzeePoints}"
        }
        else if(isPoker(dices)){
            return "Poker, points: ${sum-getNotPokerNumber(dices)+bonusPokerPoints}"
        }
        else if(isFullHouse(dices)){
            return "Full House, points: ${sum+bonusFullHousePoints}"
        }
        else if(isSmallStraight(dices)){
            return "Small Straight, points: ${sum+bonusSmallStraightPoints}"
        }
        else if(isBigStraight(dices)){
            return "Big Straight, points: ${sum+bonusBigStraightPoints}"
        }
        else if(isTwoPairs(dices)){
            return "Two Pairs, points: ${sum-getNotTwoPairsNumber(dices)+bonusTwoPairsPoints}"
        }
        return "points: $sum"

    }

    private fun isYahtzee(dices : MutableList<Dice>):Boolean{
        for(i in  1..4){
            if (dices[0].getNumber()!=dices[i].getNumber()){
                return false
            }
        }
        return true
    }

    private fun isPoker(dices: MutableList<Dice>):Boolean{
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})
        //checking if first 4 numbers are equal
        for (i in 1..3){
            if (sortedDices[0].getNumber()!=sortedDices[i].getNumber()){
                break;
            }
            if(i==3){
                return true
            }
        }
        //checking if last 4 numbers are equal
        for (i in 2..4){
            if (sortedDices[1].getNumber()!=sortedDices[i].getNumber()){
                break;
            }
            if(i==4){
                return true
            }
        }
        return false
    }

    private fun isFullHouse(dices: MutableList<Dice>):Boolean{
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})

        //checking combination 3+2
        if (sortedDices[0].getNumber()==sortedDices[1].getNumber() && sortedDices[0].getNumber()==sortedDices[2].getNumber()){
            if (sortedDices[3].getNumber()==sortedDices[4].getNumber()){
                return true
            }
        }
        //checking combination 2+3
        else if (sortedDices[0].getNumber()==sortedDices[1].getNumber()){
            if (sortedDices[2].getNumber()==sortedDices[3].getNumber() && sortedDices[2].getNumber()==sortedDices[4].getNumber()){
                return true
            }
        }
        return false
    }
    private fun isBigStraight(dices: MutableList<Dice>):Boolean{
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})
        //checking if numbers are 2,3,4,5,6
        for (i in 0..4){
            if (sortedDices[i].getNumber()!=i+2){
                return false
            }
        }
        return true
    }

    private fun isSmallStraight(dices: MutableList<Dice>):Boolean{
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})
        //checking if numbers are 1,2,3,4,5
        for (i in 0..4){
            if (sortedDices[i].getNumber()!=i+1){
                return false
            }
        }
        return true
    }

    private fun isTwoPairs(dices: MutableList<Dice>):Boolean{
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})

        if (sortedDices[0].getNumber()==sortedDices[1].getNumber()){
            if (sortedDices[2].getNumber()==sortedDices[3].getNumber() || sortedDices[3].getNumber()==sortedDices[4].getNumber()){
                return true
            }
        }
        else if (sortedDices[1].getNumber()==sortedDices[2].getNumber() && sortedDices[3].getNumber()==sortedDices[4].getNumber()){
            return true
        }
        return false
    }

    private fun getNotPokerNumber(dices: MutableList<Dice>): Int {
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})
        return if (sortedDices[0].getNumber()==sortedDices[1].getNumber()){
            sortedDices[4].getNumber()
        } else{
            sortedDices[0].getNumber()
        }
    }

    private fun getNotTwoPairsNumber(dices: MutableList<Dice>): Int{
        val sortedDices = dices.sortedWith(compareBy { it.getNumber()})
        return if (sortedDices[0].getNumber()!=sortedDices[1].getNumber()){
            sortedDices[0].getNumber()
        } else if(sortedDices[3].getNumber()!=sortedDices[4].getNumber()){
            sortedDices[4].getNumber()
        } else{
            sortedDices[2].getNumber()
        }
    }
}