package com.lambdaschool.conductor.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lambdaschool.conductor.R

class RootController: BaseController() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.root_controller_layout, container, false)
    }
}