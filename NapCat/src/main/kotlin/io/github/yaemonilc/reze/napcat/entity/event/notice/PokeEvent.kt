package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class PokeEvent : NoticeEvent() {
    override val noticeType: NoticeType = NoticeType.NOTIFY
    abstract val subType: SubType
    abstract val targetId: Long
    abstract val userId: Long

    @Serializable
    enum class SubType {
        @SerialName("poke")
        POKE
    }
}

@Serializable
data class FriendPokeEvent(
    override val selfId: Long,
    override val subType: SubType = SubType.POKE,
    override val targetId: Long,
    override val userId: Long,
    val senderId: Long
) : PokeEvent()

@Serializable
data class GroupPokeEvent(
    override val selfId: Long,
    override val subType: SubType = SubType.POKE,
    override val targetId: Long,
    override val userId: Long,
    val groupId: Long
) : PokeEvent()