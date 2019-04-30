package com.mcssoft.callreminder.util

/**
 * Utility object to define a set of app constants.
 */
object Constants {

    const val ONE_MINUTE: Long = 60000      // one minute in milli seconds.

    const val KEY_PH_NO: String = "KEY_PH_NO"         // bundle extras key.
    const val TEST_PH_NO: String = "(650) 555-1212"   // bundle extras value (from emulator).

    const val KEY_ALARM_TYPE: String = "KEY_ALARM_TYPE"
    const val ALARM_TYPE_CALL: Int = 0x02
    const val ALARM_TYPE_SMS: Int = 0x03
}