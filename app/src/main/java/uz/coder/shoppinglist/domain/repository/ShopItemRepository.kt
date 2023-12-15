package uz.coder.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import uz.coder.shoppinglist.domain.entity.ShopItem

interface ShopItemRepository {
     fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun getShopItemList():LiveData<List<ShopItem>>
    fun getShopItemById(id:Int): ShopItem?
}