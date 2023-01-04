package ua.cn.stu.room.model.boxes.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import ua.cn.stu.room.model.boxes.room.entities.AccountBoxSettingDbEntity
import ua.cn.stu.room.model.boxes.room.entities.BoxAndSettingsTuple
import ua.cn.stu.room.model.boxes.room.entities.BoxDbEntity
import ua.cn.stu.room.model.boxes.room.views.SettingDbView
import ua.cn.stu.room.model.boxes.room.views.SettingWithEntitiesTuple

@Dao
interface BoxesDao {
//
//    @Query("SELECT * " +
//            "FROM boxes " +
//            "LEFT JOIN accounts_boxes_settings " +
//            "  ON boxes.id = accounts_boxes_settings.box_id AND accounts_boxes_settings.account_id = :accountId")
//    fun getBoxesAndSettings(accountId: Long): Flow<Map<BoxDbEntity, AccountBoxSettingDbEntity?>>

    //    @Query("SELECT * " +
//            "FROM boxes " +
//            "LEFT JOIN accounts_boxes_settings " +
//            "  ON boxes.id = accounts_boxes_settings.box_id AND accounts_boxes_settings.account_id = :accountId")
//    fun getBoxesAndSettings(accountId: Long): Flow<List<BoxAndSettingsTuple>>
//    @Query("Select * from settings_view where account_id=:accountId")
//    fun getBoxesAndSettings(accountId: Long): Flow<List<SettingDbView>>

    @Transaction
    @Query("Select * from settings_view where account_id=:accountId")
    fun getBoxesAndSettings(accountId: Long): Flow<List<SettingWithEntitiesTuple>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setActiveFlagForBox(accountBoxSetting: AccountBoxSettingDbEntity)

}
