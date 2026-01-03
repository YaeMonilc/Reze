package io.github.yaemonilc.reze.napcat.entity.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Sex {
    @SerialName("male")
    MALE,
    @SerialName("female")
    FEMALE,
    @SerialName("unknown")
    UNKNOWN
}

@Serializable
data class FriendSender(
    val userId: Long,
    val nickname: String,
    val sex: Sex? = null,
    val age: Int? = null
)

@Serializable
data class GroupTempSourceSender(
    val userId: Long,
    val nickname: String,
    val sex: Sex? = null,
    val age: Int? = null,
    val groupId: Long? = null
)

@Serializable
data class GroupSender(
    val userId: Long,
    val nickname: String,
    val sex: Sex? = null,
    val age: Int? = null,
    val card: String? = null,
    val area: String? = null,
    val level: Int? = null,
    val role: Role,
    val title: String? = null
) {
    @Serializable
    enum class Role {
        @SerialName("owner")
        OWNER,
        @SerialName("admin")
        ADMIN,
        @SerialName("member")
        MEMBER
    }
}