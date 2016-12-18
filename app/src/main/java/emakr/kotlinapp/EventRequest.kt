package emakr.kotlinapp

import android.util.Log
import java.net.URL
import com.google.gson.Gson
import emakr.kotlinapp.model.Event


class EventRequest(){
    fun run() {
        val eventJson = URL("http://emakr-blazeitdude.rhcloud.com/api/events").readText()
        Log.d(this.javaClass.simpleName, eventJson)
        val data = Gson().fromJson(eventJson, Array<Event>::class.java)
        EventsActivity.events = data.toMutableList()
    }
}