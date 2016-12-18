package emakr.kotlinapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import emakr.kotlinapp.model.Event
import kotlinx.android.synthetic.main.event_item.view.*

class EventArrayAdapter(context: Context, events: List<Event>) :
        ArrayAdapter<Event>(context, 0 , events) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val event = getItem(position)
        var template : View =
                convertView ?:
                        LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
        template.ID.text = "#${event._id}"
        template.name.text = event.name
        template.description.text = event.description
        return template
    }
}
