package uz.coder.shoppinglist.domain.entity

import javax.inject.Inject

data class ShopItem @Inject constructor(
    val id:Int= 0,
    val name:String,
    val count:Int,
    val enabled:Boolean,
)

