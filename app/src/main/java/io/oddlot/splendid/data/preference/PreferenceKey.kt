package io.oddlot.splendid.data.preference

abstract class PreferenceKey {
    companion object {
        const val FIRST_RUN = "firstRun"
        const val THEME = "theme"
        const val USER_NAME = "userName"
        const val BASE_CURRENCY = "baseCurrency"
    }
}