package io.github.yaemonilc.reze.napcat.entity.type

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
sealed class Segment

@Serializable
@SerialName("text")
data class TextSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val text: String
    )
}

@Serializable
@SerialName("face")
data class FaceSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val id: String
    )
}

@Serializable
@SerialName("image")
data class ImageSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val file: String,
        val type: String? = null,
        val url: String? = null,
        val cache: Boolean? = null,
        val proxy: Boolean? = null,
        val timeout: Long? = null
    )
}

@Serializable
@SerialName("record")
data class RecordSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val file: String,
        val magic: Boolean? = null,
        val url: String? = null,
        val cache: Boolean? = null,
        val proxy: Boolean? = null,
        val timeout: Long? = null
    )
}

@Serializable
@SerialName("video")
data class VideoSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val file: String,
        val url: String? = null,
        val cache: Boolean? = null,
        val proxy: Boolean? = null,
        val timeout: Long? = null
    )
}

@Serializable
@SerialName("at")
data class AtSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val qq: String,
        val name: String? = null
    )
}

@Serializable
@SerialName("rps")
object RpsSegment : Segment()

@Serializable
@SerialName("dice")
object DiceSegment : Segment()

@Serializable
@SerialName("shake")
data class ShakeSegment(
    val data: JsonElement
) : Segment()

@Serializable
@SerialName("poke")
data class PokeSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val type: String,
        val id: String,
        val name: String? = null
    )
}

@Serializable
@SerialName("anonymous")
data class AnonymousSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val ignore: Boolean? = null
    )
}

@Serializable
@SerialName("share")
data class ShareSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val url: String,
        val title: String,
        val content: String? = null,
        val image: String? = null
    )
}

@Serializable
@SerialName("contact")
data class ContactSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val type: Type,
        val id: String
    ) {
        @Serializable
        enum class Type {
            @SerialName("qq")
            QQ,
            @SerialName("group")
            GROUP
        }
    }
}

@Serializable
@SerialName("location")
data class LocationSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val lat: String,
        val lon: String,
        val title: String? = null,
        val content: String? = null
    )
}

@Serializable
@SerialName("music")
data class MusicSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val type: Type,
        val id: String
    ) {
        @Serializable
        enum class Type {
            @SerialName("qq")
            QQ,
            @SerialName("163")
            MUSIC163,
            @SerialName("xm")
            XM,
        }
    }
}

@Serializable
@SerialName("reply")
data class ReplySegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val id: String
    )
}

@Serializable
@SerialName("file")
data class FileSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val file: String
    )
}

@Serializable
@SerialName("forward")
data class ForwardSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val id: String
    )
}

@Serializable
@SerialName("xml")
data class XmlSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val data: String
    )
}

@Serializable
@SerialName("json")
data class JsonSegment(
    val data: Data
) : Segment() {
    @Serializable
    data class Data(
        val data: String
    )
}