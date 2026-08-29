package com.example.jbclockwidget

import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidget.TextPresentation
import com.intellij.util.Alarm
import java.awt.Component
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.awt.event.MouseEvent
import com.intellij.util.Consumer

class ClockWidget : StatusBarWidget, TextPresentation {
    private val formatter = DateTimeFormatter.ofPattern("HH:mm")
    private val alarm = Alarm(Alarm.ThreadToUse.SWING_THREAD, this)
    private var statusBar: StatusBar? = null

    override fun ID(): String = "com.example.jbclockwidget.ClockWidget"
    override fun getPresentation(): StatusBarWidget.WidgetPresentation = this

    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar
        scheduleTick()
    }

    override fun dispose() {
        statusBar = null
    }

    private fun scheduleTick() {
        alarm.addRequest({
            statusBar?.updateWidget(ID())
            scheduleTick()
        }, 60_000)
    }

    override fun getText(): String = LocalTime.now().format(formatter)
    override fun getAlignment(): Float = Component.CENTER_ALIGNMENT
    override fun getTooltipText(): String? = null
    override fun getClickConsumer(): Consumer<MouseEvent>? = null
}