package com.example.pokemon.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pokemon.R
import com.example.pokemon.data.model.Result
import com.example.pokemon.views.activity.PokemonDetailActivity

class PokemonGVAdapter(var fragment: Fragment, context: Context, courseModelArrayList: ArrayList<Result?>?) :
    ArrayAdapter<Result?>(context, 0, courseModelArrayList!!), OnItemClickListener {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.pokemon_item, parent, false)
        }

        val result: Result? = getItem(position)
        val textView = listitemView!!.findViewById<TextView>(R.id.idTVCourse)
        val imageView = listitemView.findViewById<ImageView>(R.id.idIVcourse)
        val id = getPokemonId(result);
        textView.setText(result!!.name)

        Glide.with(fragment)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/" + id + ".png")
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
        return listitemView
    }

    override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val intent: Intent? = Intent(fragment.activity, PokemonDetailActivity::class.java)
        val result: Result? = getItem(position)

        val id = getPokemonId(result);
        Log.e("TAG", "ID : " + id);
        intent?.putExtra("ID", id);
        fragment.requireActivity().startActivity(intent)
        fragment.requireActivity().finish()
    }

    fun getPokemonId(result: Result?) : String {
        val string = result?.url;
        val parts = string!!.split("/").toTypedArray()
        val id = parts[6];

        return id;
    }
}