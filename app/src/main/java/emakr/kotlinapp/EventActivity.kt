package emakr.kotlinapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import emakr.kotlinapp.model.Event
import kotlinx.android.synthetic.main.activity_event.*

class EventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        val event = intent.getSerializableExtra("event") as Event
        eventId.text = event._id.toString()
        eventName.setText(event.name)
        eventDescription.setText(event.description)
    }

    fun okButtonClicked(view: View){
        finish()
    }

    override fun finish() {
        val event = Event(
            eventId.text.toString().toInt(),
            eventName.text.toString(),
            eventDescription.text.toString()
        )
        val result = Intent()
        result.putExtra("event", event)
        setResult(Activity.RESULT_OK, result)
        super.finish()
    }
}
