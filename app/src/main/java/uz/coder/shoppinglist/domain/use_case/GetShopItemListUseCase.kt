package uz.coder.shoppinglist.domain.use_case

import androidx.lifecycle.LiveData
import uz.coder.shoppinglist.domain.entity.ShopItem
import uz.coder.shoppinglist.domain.repository.ShopItemRepository
import javax.inject.Inject

class GetShopItemListUseCase @Inject constructor(private val repository: ShopItemRepository) {
    operator fun invoke():LiveData<List<ShopItem>> = repository.getShopItemList()

}