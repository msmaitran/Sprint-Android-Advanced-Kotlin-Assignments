package com.lambdaschool.conductor.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.lambdaschool.conductor.R

class RootController: BaseController() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.root_controller_layout, container, false)
        view.findViewById<TextView>(R.id.text_view).text = "Root Controller"
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        view?.findViewById<Button>(R.id.btn_sub_two)?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(FirstController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )
        }

        val prevButton = view?.findViewById<Button>(R.id.btn_sub_one)
        if (router.backstackSize <= 1) {
            prevButton?.visibility = View.GONE
        } else {
            prevButton?.setOnClickListener {
                router.popCurrentController()
            }
        }
    }
}