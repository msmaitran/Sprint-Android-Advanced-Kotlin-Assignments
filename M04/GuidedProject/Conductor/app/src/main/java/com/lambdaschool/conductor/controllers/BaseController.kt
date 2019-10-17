package com.lambdaschool.conductor.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

abstract class BaseController: Controller {
    protected constructor()

    protected constructor(args: Bundle): super(args)
}