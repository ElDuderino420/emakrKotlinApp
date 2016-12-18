package emakr.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import emakr.kotlinapp.model.Event
import kotlinx.android.synthetic.main.activity_events.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread

class EventsActivity : AppCompatActivity() {

    companion object {
        var events = mutableListOf(
                Event("1", "Event 1", "This is our first event!"),
                Event("2", "Event 2", "Our second event"),
                Event("3", "Event 3", "A third one")
        )

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        eventList.adapter = EventArrayAdapter(this, events)
        eventList.onItemClickListener = AdapterView.OnItemClickListener { parent, view, pos, id ->
            val clicked: Event = eventList.getItemAtPosition(pos) as Event
            val intent = Intent(this, EventActivity::class.java)

            intent.putExtra("event", clicked)
            startActivityForResult(intent,4712)
        }
    }

    private fun updateEvent(event: Event) {
        for (e in events){
            if(e._id == event._id) {
                e.name = event.name
                e.description = event.description
            }
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        toast("REQUEST CODE: $requestCode")
        if(data?.getSerializableExtra("event") != null) {
            val event: Event = data?.getSerializableExtra("event") as Event
            updateEvent(event)
            eventList.adapter = EventArrayAdapter(this, events)
        }
    }
}
