class Player {

    fun readRollingOrder() : String?{
        var isSuccess : Boolean
        var rollingOrder : String?
        do{
            rollingOrder = readLine()
            isSuccess = checkRollingOrder(rollingOrder)
        }while(!isSuccess)
        return rollingOrder
    }

    private fun checkRollingOrder(rollingOrder:String?):Boolean{
        if(rollingOrder?.length!=5){
            println("Length not correct, enter again correctly! Example of correct entry 10011")
            return false
        }
        else{
            for (i in 0..4) {
                if (rollingOrder[i] != '1' && rollingOrder[i] != '0') {
                    println("Wrong entry, enter again correctly! Example of correct entry 10011")
                    return false
                }
            }
            return true
        }
    }


}