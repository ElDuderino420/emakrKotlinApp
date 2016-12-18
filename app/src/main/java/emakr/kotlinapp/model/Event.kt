package emakr.kotlinapp.model

import java.io.Serializable
import java.util.*

data class Event(
        val map: MutableMap<String, Any?>) : Serializable {
    var _id: Int by map
    var name: String by map
    var description: String by map


    constructor(
            id: Int,
            name: String,
            description: String
    ) : this(HashMap()){
        this._id = id
        this.name = name
        this.description = description
    }
}

object EventTable {
    val NAME = "EVENTS"
    val ID = "_id"
    val EVENT_NAME = "name"
    val DESCRIPTION = "description"
}