fun main(args: Array<String>) {

    val gameHost = GameHost()
    gameHost.welcome()

    val yahtzeeRoll = YahtzeeRoll()
    val strategy = Strategy()
    val player = Player()

   do{
       gameHost.startRolling()
        for (i in 1..3){
            if (i == 1){
                yahtzeeRoll.rollDices()
            }
            else{
                gameHost.writeLockDiceInfo()
                val rollingOrder = player.readRollingOrder()
                if (rollingOrder.equals("00000")){
                    break
                }
                else{
                    yahtzeeRoll.rollDices(rollingOrder)
                }
            }
            println(strategy.checkExtraCategory(yahtzeeRoll.getDices(), yahtzeeRoll.getSum()))
        }

    }while (true)

}

