package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class BotOfflineEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.BOT_OFFLINE,
    val userId: Long,
    val tag: String = "BotOfflineEvent",
    val message: String = "BotOfflineEvent"
) : NoticeEvent()
