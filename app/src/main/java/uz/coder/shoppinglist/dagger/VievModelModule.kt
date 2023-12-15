package uz.coder.shoppinglist.dagger

import androidx.lifecycle.ViewModel
import uz.coder.shoppinglist.presentation.vm.MyViewModel
import uz.coder.shoppinglist.presentation.vm.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
interface VievModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    fun bindsMyViewMode(myViewModel: MyViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindsShopItemViewMode(shopItemViewModel: ShopItemViewModel):ViewModel
}