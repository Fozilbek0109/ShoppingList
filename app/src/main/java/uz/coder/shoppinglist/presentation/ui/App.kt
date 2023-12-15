package uz.coder.shoppinglist.presentation.ui

import android.app.Application
import uz.coder.shoppinglist.dagger.DaggerAppComponent


class App:Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
    override fun onCreate() {
        component.injectApp(this)
        super.onCreate()
    }


}