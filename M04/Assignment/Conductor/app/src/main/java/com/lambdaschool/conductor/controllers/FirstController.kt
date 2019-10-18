package com.lambdaschool.conductor.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.lambdaschool.conductor.R
import kotlinx.android.synthetic.main.root_controller_layout.view.*

class FirstController: BaseController(), SecondController.SecondContainer {

    var text: String? = null

    override fun generateNumber(int: Int) {
        text = "$int"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.root_controller_layout, container, false)
        view.text_view.text = if (text.isNullOrEmpty()){
            "First Controller"
        } else {
            "First Controller\nGenerated Number: $text"
        }
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        val next = view?.findViewById<Button>(R.id.btn_sub_two)
        next?.setOnClickListener {
            router.pushController(RouterTransaction.with(SecondController(this))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }

        view?.findViewById<Button>(R.id.btn_sub_one)?.setOnClickListener {
            router.popCurrentController()
        }
    }
}