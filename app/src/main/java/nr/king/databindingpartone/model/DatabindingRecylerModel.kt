package nr.king.databindingpartone.model

import androidx.annotation.Keep

@Keep
data class DatabindingRecylerModel(
    var imageUrl:String?=null,
    var likeCount:String?=null,
    var isLiked:Boolean=false,
    var userName:String?=null
)
