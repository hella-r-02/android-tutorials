package ua.cn.stu.room.model.accounts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ua.cn.stu.room.model.accounts.room.entities.AccountDbEntity
import ua.cn.stu.room.model.accounts.room.entities.AccountSignInTuple
import ua.cn.stu.room.model.accounts.room.entities.AccountUpdateUsernameTuple

@Dao
interface AccountsDao {
    @Query("SELECT id, password from accounts where email=:email")
    suspend fun findByEmail(email: String): AccountSignInTuple?

    @Update(entity = AccountDbEntity::class)
    suspend fun updateUsername(updateUsernameTuple: AccountUpdateUsernameTuple)

    @Insert
    suspend fun createAccount(accountDbEntity: AccountDbEntity)

    @Query("Select * from accounts where id=:id")
    fun findById(id: Long): Flow<AccountDbEntity?>
}