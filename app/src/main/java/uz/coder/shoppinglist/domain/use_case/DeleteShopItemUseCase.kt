package uz.coder.shoppinglist.domain.use_case

import uz.coder.shoppinglist.domain.entity.ShopItem
import uz.coder.shoppinglist.domain.repository.ShopItemRepository
import javax.inject.Inject

class DeleteShopItemUseCase @Inject constructor(private val repository: ShopItemRepository) {
    operator fun invoke(shopItem: ShopItem) = repository.deleteShopItem(shopItem)

}