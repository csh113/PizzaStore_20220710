package com.cshka.pizzastore_20220710

import java.io.Serializable

class StoreData (
    val name : String,
    val score : Double,
    val phoneNum : String,
    val logoUrl : String
        ) : Serializable {
}