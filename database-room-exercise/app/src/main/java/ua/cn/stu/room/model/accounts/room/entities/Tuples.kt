package ua.cn.stu.room.model.accounts.room.entities

//tuples - когда не нужна вся информация из бд, берем tuples (или когда обновляем)
data class AccountSignInTuple(
    val id: Long,
    val password: String
)

//обязательно id
data class AccountUpdateUsernameTuple(
    val id: Long,
    val username: String
)