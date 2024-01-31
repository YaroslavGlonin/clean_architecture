package com.clean.domain.state

sealed class State<out r> {

    data class success<out t>(val data: t) : State<t>()
    data class error(val exception: Exception) : State<Nothing>()
    object Loading : State<Nothing>()

    companion object {
        inline fun <T> on(f: () -> T): State<T> = try {
            success(f())
        } catch (ex: Exception) {
            error(ex)
        }
    }
}