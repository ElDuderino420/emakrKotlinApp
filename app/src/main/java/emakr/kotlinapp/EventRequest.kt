package emakr.kotlinapp

import android.util.Log
import java.net.URL
import com.google.gson.Gson
import com.google.gson.JsonObject
import emakr.kotlinapp.model.Event


class EventRequest(){
    fun run() {
        val eventJson = URL("http://emakr-blazeitdude.rhcloud.com/api/events").readText()
        Log.d(this.javaClass.simpleName, eventJson)
        
        val data = Gson().fromJson(eventJson, Array<Event>::class.java)
        Log.d(this.javaClass.simpleName, "marco is a faggot" + eventJson[0])
//        EventsActivity.events = data.toMutableList()

    }
}