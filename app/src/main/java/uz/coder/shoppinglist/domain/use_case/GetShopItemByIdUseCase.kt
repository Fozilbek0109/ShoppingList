package uz.coder.shoppinglist.domain.use_case

import uz.coder.shoppinglist.domain.entity.ShopItem
import uz.coder.shoppinglist.domain.repository.ShopItemRepository
import javax.inject.Inject

class GetShopItemByIdUseCase @Inject constructor(private val repository: ShopItemRepository) {
   operator fun invoke(id:Int): ShopItem? =  repository.getShopItemById(id)

}