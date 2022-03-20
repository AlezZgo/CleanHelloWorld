package domain

import ui.PhraseUI

data class PhraseDomain(private val name: String, private val surName: String) {
    fun toUI(): PhraseUI {
        return PhraseUI.Success(name, surName)
    }
}
