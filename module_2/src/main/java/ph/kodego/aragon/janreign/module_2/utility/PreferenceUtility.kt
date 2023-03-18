package ph.kodego.aragon.janreign.module_2.utility

import android.content.Context
import android.content.SharedPreferences

//added, Jan 26, 2023
class PreferenceUtility {
     private var appPreferences: SharedPreferences? = null
     private val PREFS = "appPreferences"

     constructor(context: Context)  {
         appPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
     }

    fun saveStringPreferences(key: String?, value: String?){
        val prefsEditor = appPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
//        prefsEditor.commit() // commit = immediately save, apply = handled by backend (success or fail)
    }

    fun getStringPreferences(key: String?): String? {
        return  appPreferences!!.getString(key, "")
    }
}