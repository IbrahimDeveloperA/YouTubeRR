package com.on.youtuberr

import android.app.Application
import com.on.youtuberr.repository.Repository

class App : Application() {

    companion object {
        val repository: Repository by lazy {
            Repository()
        }
    }
}