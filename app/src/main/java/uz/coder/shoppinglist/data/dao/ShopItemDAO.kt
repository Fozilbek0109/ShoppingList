package uz.coder.shoppinglist.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import uz.coder.shoppinglist.data.db_model.ShopItemDbModel

@Dao
interface ShopItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopItem(shopItem: ShopItemDbModel)
    @Update
    fun editShopItem(shopItem: ShopItemDbModel)

    @Query("DELETE FROM shop_items WHERE id = :id")
    fun deleteShopItem(id: Int)
    @Query("Select * from shop_items")
    fun getShopItemList(): LiveData<List<ShopItemDbModel>>
    @Query("Select * from shop_items where id = :id LIMIT 1")
    fun getShopItemById(id:Int): ShopItemDbModel
}