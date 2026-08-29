package com.example.jbclockwidget

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory

class ClockWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = "com.example.jbclockwidget.ClockWidgetFactory"
    override fun getDisplayName(): String = "Clock Widget"
    override fun isAvailable(project: Project): Boolean = true
    override fun createWidget(project: Project): StatusBarWidget = ClockWidget()
    override fun disposeWidget(widget: StatusBarWidget) {}
    override fun canBeEnabledOn(statusBar: com.intellij.openapi.wm.StatusBar): Boolean = true
}