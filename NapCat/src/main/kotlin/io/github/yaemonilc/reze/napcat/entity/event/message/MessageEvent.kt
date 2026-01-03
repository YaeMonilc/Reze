package io.github.yaemonilc.reze.napcat.entity.event.message

import io.github.yaemonilc.reze.napcat.entity.event.Event
import io.github.yaemonilc.reze.napcat.entity.event.PostType
import io.github.yaemonilc.reze.napcat.entity.type.Segment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class MessageEvent : Event() {
    override val postType: PostType = PostType.MESSAGE
    override val time: Long = System.currentTimeMillis()
    abstract val messageType: MessageType
    abstract val subType: SubType
    abstract val messageId: Long
    abstract val userId: Long
    abstract val message: List<Segment>
    abstract val rawMessage: String
    abstract val font: Int

    @Serializable
    enum class MessageType(
        val value: String
    ) {
        @SerialName("private")
        PRIVATE("private"),
        @SerialName("group")
        GROUP("group")
    }

    @Serializable
    enum class SubType(
        val value: String
    ) {
        @SerialName("friend")
        FRIEND("friend"),
        @SerialName("group")
        GROUP("group"),
        @SerialName("other")
        OTHER("other"),
        @SerialName("normal")
        NORMAL("normal"),
        @SerialName("anonymous")
        ANONYMOUS("anonymous"),
        @SerialName("notice")
        NOTICE("notice")
    }
}