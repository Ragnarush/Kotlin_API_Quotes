package com.example.m14_final_2210043

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m14_final_2210043.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL


// commentaire
// jai du jaune dans mon logcat, semble y avoir des warnings ,..  de reflection en autre mais ca fonctionne
// si tu pouvais me dire si cest normal dans le corriger , jaimerais bien , sinon cest pas bien grave.

// clicker sur le recycler view, jai jamais fait ca, ca me dit rien, je recherche sur internet, je fait un peu nimporte quoi et ca ne fonctionne pas ,.....
// jai essayer du code de internet, je te lefface pour ne pas polluer ....  et je nais pas reussis a fair eun onclick les item du rv
// je trouve pas la solution pour le onclick ,... si on a vu ca, je me souvien pus dutout.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val endpoint = "https://strangerthings-quotes.vercel.app/api/quotes/20"
        val targetType = object: TypeToken<List<Resultats>>(){}.type

        lifecycleScope.launch(Dispatchers.Default) {
            val strResultats =  URL(endpoint).readText()
            val resultats = Gson().fromJson<List<Resultats>>(strResultats, targetType)

            this@MainActivity.runOnUiThread {
                binding.rv.adapter = RvAdapter(resultats)
                binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}