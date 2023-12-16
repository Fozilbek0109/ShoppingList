package uz.coder.shoppinglist.dagger


import uz.coder.shoppinglist.data.repoImpl.ShopListItemRepositoryImpl
import uz.coder.shoppinglist.domain.repository.ShopItemRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindsShopItemRepo(repo: ShopListItemRepositoryImpl): ShopItemRepository

}