package com.example.androidsystemcomponent

import android.R
import android.app.Activity
import android.app.AppComponentFactory
import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class TelephonyManagerActivity : AppCompatActivity() {

    var textView1: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telephony_manager)

        textView1 = findViewById<View>(R.id.textView1) as TextView

        //Get the instance of TelephonyManager
        val tm =
            getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        //Calling the methods of TelephonyManager the returns the information
        val IMEINumber = tm.deviceId
        val subscriberID = tm.deviceId
        val SIMSerialNumber = tm.simSerialNumber
        val networkCountryISO = tm.networkCountryIso
        val SIMCountryISO = tm.simCountryIso
        val softwareVersion = tm.deviceSoftwareVersion
        val voiceMailNumber = tm.voiceMailNumber

        //Get the phone type
        var strphoneType = ""
        val phoneType = tm.phoneType
        when (phoneType) {
            TelephonyManager.PHONE_TYPE_CDMA -> strphoneType = "CDMA"
            TelephonyManager.PHONE_TYPE_GSM -> strphoneType = "GSM"
            TelephonyManager.PHONE_TYPE_NONE -> strphoneType = "NONE"
        }

        //getting information if phone is in roaming
        val isRoaming = tm.isNetworkRoaming
        var info = "Phone Details:\n"
        info += "\n IMEI Number:$IMEINumber"
        info += "\n SubscriberID:$subscriberID"
        info += "\n Sim Serial Number:$SIMSerialNumber"
        info += "\n Network Country ISO:$networkCountryISO"
        info += "\n SIM Country ISO:$SIMCountryISO"
        info += "\n Software Version:$softwareVersion"
        info += "\n Voice Mail Number:$voiceMailNumber"
        info += "\n Phone Network Type:$strphoneType"
        info += "\n In Roaming? :$isRoaming"
        textView1!!.text = info //displaying the information in the textView
    }
}
