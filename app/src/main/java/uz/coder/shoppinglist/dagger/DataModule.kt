package uz.coder.shoppinglist.dagger

import android.content.Context
import uz.coder.shoppinglist.data.db.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    @ApplicationScope
    fun provideosAppDatabase(context: Context): AppDatabase {
      return AppDatabase.getInstance(context)
    }
}