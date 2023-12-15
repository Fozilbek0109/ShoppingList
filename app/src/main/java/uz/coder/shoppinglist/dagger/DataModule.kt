package uz.coder.shoppinglist.dagger

import android.content.Context
import uz.coder.shoppinglist.data.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideosAppDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)
}