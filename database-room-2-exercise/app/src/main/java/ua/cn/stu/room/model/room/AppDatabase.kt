package ua.cn.stu.room.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.cn.stu.room.model.accounts.room.AccountsDao
import ua.cn.stu.room.model.accounts.room.entities.AccountDbEntity
import ua.cn.stu.room.model.boxes.room.BoxesDao
import ua.cn.stu.room.model.boxes.room.entities.AccountBoxSettingDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity
import ua.cn.stu.room.model.boxes.room.views.SettingDbView

@Database(
    // todo #10: increment DB version to 2 because we've added a new database view
    version = 1,
    entities = [
        AccountDbEntity::class,
        BoxDbEntity::class,
        AccountBoxSettingDbEntity::class
    ],
    views = [
        SettingDbView::class
    ]
    // todo #9: add a reference to the created database view here (use 'views' argument)
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAccountsDao(): AccountsDao

    abstract fun getBoxesDao(): BoxesDao

}