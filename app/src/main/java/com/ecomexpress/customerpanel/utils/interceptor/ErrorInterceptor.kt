package com.ecomexpress.customerpanel.utils.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (!response.isSuccessful) {
          //  StateManager.setState(APIResultState.Exception(response.message))
            // Handle the error here
            //throw YourCustomException(response.code, response.message)
        }

        return response
    }
}
