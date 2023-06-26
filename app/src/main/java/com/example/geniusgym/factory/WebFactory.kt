package com.example.geniusgym.factory

import com.example.geniusgym.util.WebRequestSpencer

class WebFactory : InstanceFactory{
    override fun craete(): Any {
        return WebRequestSpencer()
    }
}