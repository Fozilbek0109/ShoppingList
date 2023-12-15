package uz.coder.shoppinglist.presentation.vm

import androidx.lifecycle.ViewModel
import uz.coder.shoppinglist.domain.use_case.DeleteShopItemUseCase
import uz.coder.shoppinglist.domain.use_case.EditShopItemUseCase
import uz.coder.shoppinglist.domain.use_case.GetShopItemListUseCase
import uz.coder.shoppinglist.domain.entity.ShopItem
import javax.inject.Inject


class MyViewModel @Inject constructor(
    private val getShopItemListUseCase: GetShopItemListUseCase,
    private val editShopItemUseCase: EditShopItemUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase
): ViewModel() {

    val shopList = getShopItemListUseCase()
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase(shopItem)

    }
    fun enabled(shopItem: ShopItem){
        val newValue = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase(newValue)
    }



}