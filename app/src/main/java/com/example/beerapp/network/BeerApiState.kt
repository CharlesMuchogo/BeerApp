package com.example.beerapp.network


data class BeerApiState<out T>(val status: Status, val data: List<T>?, val message: String?){

    companion object{
        // in case of success
        fun <T> success(data: List<T>?):BeerApiState<T>{
            return  BeerApiState(Status.SUCCESS, data,null)
        }

        //in case of failure
        fun <T>error(msg: String): BeerApiState<T>{
            return BeerApiState(Status.ERROR, null, msg)
        }
        //loading
        fun <T>loading(): BeerApiState<T>{
            return BeerApiState(Status.LOADING, null, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
