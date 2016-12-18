package emakr.kotlinapp

import android.util.Log
import java.net.URL
import com.google.gson.Gson
import com.google.gson.JsonObject
import emakr.kotlinapp.model.Event
import org.json.JSONArray
import org.json.JSONObject


class EventRequest(){
    fun run() {
        val eventJson = URL("http://emakr-blazeitdude.rhcloud.com/api/events").readText()
        Log.d(this.javaClass.simpleName, eventJson)
        val json = JSONArray(eventJson)
        EventsActivity.events.clear()

        for (i in 0..json.length()){
            val event: JSONObject = json.getJSONObject(i)
            EventsActivity.events.add(Event(event.get("_id") as String,event.get("name") as String,event.get("description") as String))
        }

    }
}