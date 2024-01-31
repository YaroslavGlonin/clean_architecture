package com.clean.data.network.interceptor

import okhttp3.Interceptor
class ErrorInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        //val token = runBlocking { tokenRepository.get()?.refresh }
        //  request = request.newBuilder().header("refresh", "${token?.refresh}").build()
        //  request = request.newBuilder().header("access", "${token?.access}").build()

        return chain.proceed(request)
    }
}