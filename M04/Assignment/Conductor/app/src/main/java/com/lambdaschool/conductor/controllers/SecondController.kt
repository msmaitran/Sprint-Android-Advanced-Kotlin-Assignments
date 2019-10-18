package com.lambdaschool.conductor.controllers

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.lambdaschool.conductor.R
import kotlin.random.Random

class SecondController<T>(): BaseController()
        where T: Controller, T: SecondController.SecondContainer {

    constructor(targetController: T): this() {
        setTargetController(targetController)
    }

    interface SecondContainer {
        fun generateNumber(int: Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.root_controller_layout, container, false)
        view.findViewById<TextView>(R.id.text_view).text = "Second Controller"
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        val color = view?.findViewById<Button>(R.id.btn_sub_two)
        color?.setText("Generate Number")
        color?.setOnClickListener {
            (targetController as SecondContainer).generateNumber(Random.nextInt())
        }

        view?.findViewById<Button>(R.id.btn_sub_one)?.setOnClickListener {
            router.popCurrentController()
        }
    }
}