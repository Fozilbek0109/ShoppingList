package uz.coder.shoppinglist.data.repoImpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import uz.coder.shoppinglist.data.db.AppDatabase
import uz.coder.shoppinglist.data.mapper.Mapper
import uz.coder.shoppinglist.domain.entity.ShopItem
import uz.coder.shoppinglist.domain.repository.ShopItemRepository
import javax.inject.Inject

class ShopListItemRepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val db: AppDatabase
)
     : ShopItemRepository {
    //    private val list = sortedSetOf(Comparator<ShopItem> { o1, o2 -> o1.id.compareTo(o2.id) })
//    private var autoIncrement = 0;

    private val shopItemDao = db.shopItemDao()


    //    init {
//        for (i in 0 .. 1000){
//            val shop  = ShopItem("Item $i",i,kotlin.random.Random.nextBoolean())
//            addShopItem(shop)
//        }
//    }
    override fun addShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun editShopItem(shopItem: ShopItem) =
        shopItemDao.addShopItem(mapper.mapEntityToDbModel(shopItem))


    override fun deleteShopItem(shopItem: ShopItem) = shopItemDao.deleteShopItem(shopItem.id)


    override fun getShopItemList(): LiveData<List<ShopItem>> =
        MediatorLiveData<List<ShopItem>>().apply {
            addSource(shopItemDao.getShopItemList()) {
                value = mapper.mapListDbModelToListEntity(it)
            }
        }

    override fun getShopItemById(id: Int): ShopItem =
        mapper.mapDbModelToEntity(shopItemDao.getShopItemById(id))


//    private fun update_ld() {
//        ld.value = db.shopItemDao().getShopItemList().value?.toList()
//    }
}