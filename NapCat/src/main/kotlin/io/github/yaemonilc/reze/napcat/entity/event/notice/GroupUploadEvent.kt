package io.github.yaemonilc.reze.napcat.entity.event.notice

import kotlinx.serialization.Serializable

@Serializable
data class GroupUploadEvent(
    override val selfId: Long,
    override val noticeType: NoticeType = NoticeType.GROUP_UPLOAD,
    override val userId: Long,
    override val groupId: Long,
    val file: File
) : GroupNoticeEvent() {
    @Serializable
    data class File(
        val id: String,
        val name: String,
        val size: Long,
        val busid: Long
    )
}
