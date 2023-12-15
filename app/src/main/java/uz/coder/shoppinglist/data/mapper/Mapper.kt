package uz.coder.shoppinglist.data.mapper


import uz.coder.shoppinglist.data.db_model.ShopItemDbModel
import uz.coder.shoppinglist.domain.entity.ShopItem
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun mapEntityToDbModel(shopItem : ShopItem) : ShopItemDbModel {
        return ShopItemDbModel(
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            enabled = shopItem.enabled
        )
    }
     fun mapDbModelToEntity(shopItemDbModel : ShopItemDbModel) : ShopItem {
        return ShopItem(
            id = shopItemDbModel.id,
            name = shopItemDbModel.name,
            count = shopItemDbModel.count,
            enabled = shopItemDbModel.enabled
        )
    }

    fun mapListDbModelToListEntity(list : List<ShopItemDbModel>) : List<ShopItem>{
        val shopItemList = ArrayList<ShopItem>()
        for (shopItem in list){
            shopItemList.add(mapDbModelToEntity(shopItem))
        }
        return shopItemList
    }
}