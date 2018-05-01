package org.openasr.idear.ide

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.playback.commands.ActionCommand
import com.intellij.openapi.util.ActionCallback

object IDEService {
    /**
     * @param actionId - see [com.intellij.openapi.actionSystem.IdeActions]
     */
    fun invokeAction(actionId: String): ActionCallback =
            with(ActionManager.getInstance()) {
                var callback: ActionCallback? = null
                ApplicationManager.getApplication().invokeAndWait {
                    callback = tryToExecute(getAction(actionId),
                            ActionCommand.getInputEvent(actionId), null, null, true)
                }
                return callback!!
            }

    fun invokeAction(actionId: AnAction): ActionCallback =
                with(ActionManager.getInstance()) {
                    var callback: ActionCallback? = null
                    ApplicationManager.getApplication().invokeAndWait {
                        callback = tryToExecute(actionId,
                                ActionCommand.getInputEvent(null), null, null, true)
                    }
                    return callback!!
                }

    fun type(vararg keys: Int) = Keyboard.type(*keys)

    fun pressShift() = Keyboard.pressShift()

    fun releaseShift() = Keyboard.releaseShift()

    fun type(vararg keys: Char) = Keyboard.type(*keys)

    fun type(string: String) = Keyboard.type(string)

    fun getEditor(dataContext: DataContext? = null) =
            if (dataContext != null) CommonDataKeys.EDITOR.getData(dataContext)
            else FileEditorManager.getInstance(ProjectManager
                    .getInstance().openProjects[0]).run {
                selectedTextEditor ?: allEditors[0] as Editor
            }

    fun getProject(dataContext: DataContext? = null) = getEditor(dataContext)?.project

    fun Bookmark(c: String) {
        IDEService.type(VK_CONTROL, VK_F11)
        IDEService.type(c)
        MaryTTS.say("Bookmark" + c + "created")
    }

    fun goToBookmark(c: String) {
        IDEService.type(VK_SHIFT, VK_F11)

    }
    fun readFromBookmark(c: String) {
        IDEService.type(VK_SHIFT, VK_F11)
        IDEService.invokeAction("goto line")

    }
    fun readFrom(c: String) {
        IDEService.invokeAction("goto line")
        MaryTTS.readLine()
    }
    fun readInTreeview(c: String) {
        IDEService.type(VK_ALT, VK_7)
        MaryTTS.readLine()
    }
    fun buildUpdates(c: String) {
        IDEService.type(VK_SHIFT, VK_F10)
        MaryTTS.readLine()
    }
}
package org.openasr.idear.ide

import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.playback.commands.ActionCommand
import com.intellij.openapi.util.ActionCallback

object IDEService {
    /**
     * @param actionId - see [com.intellij.openapi.actionSystem.IdeActions]
     */
    fun invokeAction(actionId: String): ActionCallback =
            with(ActionManager.getInstance()) {
                var callback: ActionCallback? = null
                ApplicationManager.getApplication().invokeAndWait {
                    callback = tryToExecute(getAction(actionId),
                            ActionCommand.getInputEvent(actionId), null, null, true)
                }
                return callback!!
            }

    fun invokeAction(actionId: AnAction): ActionCallback =
                with(ActionManager.getInstance()) {
                    var callback: ActionCallback? = null
                    ApplicationManager.getApplication().invokeAndWait {
                        callback = tryToExecute(actionId,
                                ActionCommand.getInputEvent(null), null, null, true)
                    }
                    return callback!!
                }

    fun type(vararg keys: Int) = Keyboard.type(*keys)

    fun pressShift() = Keyboard.pressShift()

    fun releaseShift() = Keyboard.releaseShift()

    fun type(vararg keys: Char) = Keyboard.type(*keys)

    fun type(string: String) = Keyboard.type(string)

    fun getEditor(dataContext: DataContext? = null) =
            if (dataContext != null) CommonDataKeys.EDITOR.getData(dataContext)
            else FileEditorManager.getInstance(ProjectManager
                    .getInstance().openProjects[0]).run {
                selectedTextEditor ?: allEditors[0] as Editor
            }

    fun getProject(dataContext: DataContext? = null) = getEditor(dataContext)?.project

    fun Bookmark(c: String) {
        IDEService.type(VK_CONTROL, VK_F11)
        IDEService.type(c)
        MaryTTS.say("Bookmark" + c + "created")
    }

    fun goToBookmark(c: String) {
        IDEService.type(VK_SHIFT, VK_F11)

    }
    fun readFromBookmark(c: String) {
        IDEService.type(VK_SHIFT, VK_F11)
        IDEService.invokeAction("goto line")

    }
    fun readFrom(c: String) {
        IDEService.invokeAction("goto line")
        MaryTTS.readLine()
    }
    fun readInTreeview(c: String) {
        IDEService.type(VK_ALT, VK_7)
        MaryTTS.readLine()
    }
    fun buildUpdates(c: String) {
        IDEService.type(VK_SHIFT, VK_F10)
        MaryTTS.readLine()
    }
}
