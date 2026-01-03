package io.github.yaemonilc.reze.napcat.entity.event

import io.github.yaemonilc.reze.napcat.entity.event.message.GroupMessageEvent
import io.github.yaemonilc.reze.napcat.entity.event.message.GroupTempSourceMessageEvent
import io.github.yaemonilc.reze.napcat.entity.event.message.MessageEvent
import io.github.yaemonilc.reze.napcat.entity.event.message.PrivateMessageEvent
import io.github.yaemonilc.reze.napcat.entity.event.meta.HeartbeatEvent
import io.github.yaemonilc.reze.napcat.entity.event.meta.LifecycleEvent
import io.github.yaemonilc.reze.napcat.entity.event.meta.MetaEvent
import io.github.yaemonilc.reze.napcat.entity.event.meta.MetaEventType
import io.github.yaemonilc.reze.napcat.entity.event.notice.BotOfflineEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.FriendAddEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.FriendPokeEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.FriendRecallEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupAdminEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupBanEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupCardEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupDecreaseEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupEssenceEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupIncreaseEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupMsgEmojiLikeEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupNameEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupNoticeEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupNotifyEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupPokeEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupRecallEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupTitleEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.GroupUploadEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.InputStatusEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.NoticeEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.NoticeType
import io.github.yaemonilc.reze.napcat.entity.event.notice.PokeEvent
import io.github.yaemonilc.reze.napcat.entity.event.notice.ProfileLikeEvent
import io.github.yaemonilc.reze.napcat.entity.event.request.FriendRequestEvent
import io.github.yaemonilc.reze.napcat.entity.event.request.GroupRequestEvent
import io.github.yaemonilc.reze.napcat.entity.event.request.RequestEvent
import io.github.yaemonilc.reze.napcat.entity.event.request.RequestType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(Event.Companion.Serializer::class)
abstract class Event {
    abstract val postType: PostType
    abstract val selfId: Long
    abstract val time: Long

    companion object {
        object Serializer : KSerializer<Event> {
            override val descriptor: SerialDescriptor
                get() = buildClassSerialDescriptor(
                    serialName = Event::class.qualifiedName!!
                )

            override fun serialize(
                encoder: Encoder,
                value: Event
            ) = (encoder as JsonEncoder).run {
                json.encodeToJsonElement(
                    serializer = when (value) {
                        is PrivateMessageEvent -> PrivateMessageEvent.serializer()
                        is GroupMessageEvent -> GroupMessageEvent.serializer()
                        is GroupTempSourceMessageEvent -> GroupTempSourceMessageEvent.serializer()
                        is MessageEvent -> MessageEvent.serializer()

                        is BotOfflineEvent -> BotOfflineEvent.serializer()
                        is FriendAddEvent -> FriendAddEvent.serializer()
                        is FriendRecallEvent -> FriendRecallEvent.serializer()
                        is GroupAdminEvent -> GroupAdminEvent.serializer()
                        is GroupBanEvent -> GroupBanEvent.serializer()
                        is GroupCardEvent -> GroupCardEvent.serializer()
                        is GroupDecreaseEvent -> GroupDecreaseEvent.serializer()
                        is GroupEssenceEvent -> GroupEssenceEvent.serializer()
                        is GroupIncreaseEvent -> GroupIncreaseEvent.serializer()
                        is GroupMsgEmojiLikeEvent -> GroupMsgEmojiLikeEvent.serializer()
                        is GroupNameEvent -> GroupNameEvent.serializer()
                        is GroupRecallEvent -> GroupRecallEvent.serializer()
                        is GroupTitleEvent -> GroupTitleEvent.serializer()
                        is GroupUploadEvent -> GroupUploadEvent.serializer()
                        is InputStatusEvent -> InputStatusEvent.serializer()
                        is FriendPokeEvent -> FriendPokeEvent.serializer()
                        is GroupPokeEvent -> GroupPokeEvent.serializer()
                        is PokeEvent -> PokeEvent.serializer()
                        is GroupNoticeEvent -> GroupNoticeEvent.serializer()
                        is NoticeEvent -> NoticeEvent.serializer()

                        is FriendRequestEvent -> FriendRequestEvent.serializer()
                        is GroupRequestEvent -> GroupRequestEvent.serializer()
                        is RequestEvent -> RequestEvent.serializer()

                        is LifecycleEvent -> LifecycleEvent.serializer()
                        is HeartbeatEvent -> HeartbeatEvent.serializer()
                        is MetaEvent -> MetaEvent.serializer()
                        else -> error("Unexpected event type")
                    } as KSerializer<Any>,
                    value = value
                ).jsonObject.let {
                    encodeJsonElement(it)
                }
            }

            override fun deserialize(
                decoder: Decoder
            ): Event = (decoder as JsonDecoder).run {
                decodeJsonElement().jsonObject.let { obj ->
                    json.decodeFromJsonElement(
                        deserializer = PostType.entries.associateBy {
                            it.value
                        }[obj["post_type"]?.jsonPrimitive?.content]?.let { postType ->
                            when (postType) {
                                PostType.MESSAGE -> {
                                    MessageEvent.MessageType.entries.associateBy {
                                        it.value
                                    }[obj["message_type"]?.jsonPrimitive?.content]?.let { messageType ->
                                        MessageEvent.SubType.entries.associateBy {
                                            it.value
                                        }[obj["sub_type"]?.jsonPrimitive?.content]?.let { subType ->
                                            when (messageType) {
                                                MessageEvent.MessageType.PRIVATE
                                                    if subType == MessageEvent.SubType.FRIEND ->
                                                    PrivateMessageEvent.serializer()
                                                MessageEvent.MessageType.GROUP
                                                    if (subType == MessageEvent.SubType.NORMAL || subType == MessageEvent.SubType.ANONYMOUS || subType == MessageEvent.SubType.NOTICE) ->
                                                    GroupMessageEvent.serializer()
                                                MessageEvent.MessageType.PRIVATE
                                                    if subType == MessageEvent.SubType.GROUP ->
                                                    GroupTempSourceMessageEvent.serializer()
                                                else -> GroupMessageEvent.serializer()
                                            }
                                        }
                                    }
                                }
                                PostType.NOTICE -> {
                                    NoticeType.entries.associateBy {
                                        it.value
                                    }[obj["notice_type"]?.jsonPrimitive?.content]?.let { noticeType ->
                                        when (noticeType) {
                                            NoticeType.BOT_OFFLINE -> BotOfflineEvent.serializer()
                                            NoticeType.FRIEND_ADD -> FriendAddEvent.serializer()
                                            NoticeType.FRIEND_RECALL -> FriendRecallEvent.serializer()
                                            NoticeType.GROUP_ADMIN -> GroupAdminEvent.serializer()
                                            NoticeType.GROUP_BAN -> GroupBanEvent.serializer()
                                            NoticeType.GROUP_CARD -> GroupCardEvent.serializer()
                                            NoticeType.ESSENCE -> GroupEssenceEvent.serializer()
                                            NoticeType.GROUP_DECREASE -> GroupDecreaseEvent.serializer()
                                            NoticeType.GROUP_INCREASE -> GroupIncreaseEvent.serializer()
                                            NoticeType.NOTIFY -> {
                                                GroupNotifyEvent.SubType.entries.associateBy {
                                                    it.value
                                                }[obj["sub_type"]?.jsonPrimitive?.content]?.let {
                                                    when (it) {
                                                        GroupNotifyEvent.SubType.GROUP_NAME -> GroupNameEvent.serializer()
                                                        GroupNotifyEvent.SubType.TITLE -> GroupTitleEvent.serializer()
                                                    }
                                                }?: ProfileLikeEvent.SubType.entries.associateBy {
                                                    it.value
                                                }[obj["sub_type"]?.jsonPrimitive?.content]?.let {
                                                    when (it) {
                                                        ProfileLikeEvent.SubType.PROFILE_LIKE -> ProfileLikeEvent.serializer()
                                                    }
                                                }
                                            }
                                            NoticeType.GROUP_RECALL -> GroupRecallEvent.serializer()
                                            NoticeType.GROUP_UPLOAD -> GroupUploadEvent.serializer()
                                            NoticeType.GROUP_MSG_EMOJI_LIKE -> GroupMsgEmojiLikeEvent.serializer()
                                        }
                                    }
                                }
                                PostType.REQUEST -> {
                                    RequestType.entries.associateBy {
                                        it.value
                                    }[obj["request_type"]?.jsonPrimitive?.content]?.let {
                                        when (it) {
                                            RequestType.FRIEND -> FriendRequestEvent.serializer()
                                            RequestType.GROUP -> GroupRequestEvent.serializer()
                                        }
                                    }
                                }
                                PostType.META_EVENT -> {
                                    MetaEventType.entries.associateBy {
                                        it.value
                                    }[obj["meta_event_type"]?.jsonPrimitive?.content]?.let {
                                        when (it) {
                                            MetaEventType.LIFECYCLE -> LifecycleEvent.serializer()
                                            MetaEventType.HEARTBEAT -> HeartbeatEvent.serializer()
                                        }
                                    }
                                }
                            }
                        } ?: error("Unexpected event type"),
                        element = obj
                    )
                }
            }

        }
    }
}

@Serializable
enum class PostType(
    val value: String
) {
    @SerialName("message")
    MESSAGE("message"),
    @SerialName("notice")
    NOTICE("notice"),
    @SerialName("request")
    REQUEST("request"),
    @SerialName("meta_event")
    META_EVENT("meta_event")
}