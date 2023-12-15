package uz.coder.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.coder.shoppinglist.data.dao.ShopItemDAO
import uz.coder.shoppinglist.data.db_model.ShopItemDbModel



@Database(entities = [ShopItemDbModel::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun shopItemDao(): ShopItemDAO

    companion object{
        private var myDb: AppDatabase? = null
        @Synchronized
        fun getInstance(context:Context): AppDatabase {
            if (myDb == null) {
                myDb = Room.databaseBuilder(
                    context, AppDatabase::class.java,
                    "main_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return myDb!!
        }

        }
    }
