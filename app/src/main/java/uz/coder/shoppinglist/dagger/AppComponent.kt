package uz.coder.shoppinglist.dagger

import android.content.Context
import uz.coder.shoppinglist.presentation.ui.App
import uz.coder.shoppinglist.presentation.ui.MainActivity
import uz.coder.shoppinglist.presentation.fr.ShopItemFragment
import dagger.BindsInstance
import dagger.Component
@ApplicationScope
@Component(modules = [DomainModule::class, DataModule::class, VievModelModule::class])
interface AppComponent {
    fun injectApp(app: App)
    fun injectMainAc(mainActivity: MainActivity)
    fun injectShopFr(shopItemFragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}


