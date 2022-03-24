class GameHost {
    private val welcomeText = "Welcome to Yahtzee game!"
    private val startingGameText = "New round, press ENTER to roll the dice"
    private val lockDiceInfoText = "Write string with 5 numbers without any space (1 you WILL roll that dice again | 0 you WILL NOT roll that dice again)"

    fun welcome(){
        println(welcomeText)
    }

    fun startRolling(){
        println(startingGameText)
        readLine()
    }

    fun writeLockDiceInfo(){
        println(lockDiceInfoText)
    }
}