package uz.coder.shoppinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import uz.coder.shoppinglist.domain.entity.ShopItem

class ShopListDiffCallback(
    private val oldShopList:List<ShopItem>,
    private val newShopList:List<ShopItem>
):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldShopList.size
    }

    override fun getNewListSize(): Int {
        return newShopList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldShopList[oldItemPosition].id == newShopList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldShopList[oldItemPosition] == newShopList[newItemPosition]
    }
}