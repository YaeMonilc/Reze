package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class InputStatusEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.NOTIFY,
    val subType: String = "input_status",
    val statusText: String = "对方正在输入...",
    val eventType: Int = 1,
    val userId: Long? = null,
    val groupId: Long? = null
) : NoticeEvent()
