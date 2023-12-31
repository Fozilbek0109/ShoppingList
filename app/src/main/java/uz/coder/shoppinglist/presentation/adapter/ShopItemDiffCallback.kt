package uz.coder.shoppinglist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import uz.coder.shoppinglist.domain.entity.ShopItem

class ShopItemDiffCallback:DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}