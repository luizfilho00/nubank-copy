package br.com.nubankcopy

import androidx.annotation.DrawableRes

data class MenuItem(
    val text: String,
    @DrawableRes val icon: Int
) {

    companion object {
        fun getMenu() = listOf(
            MenuItem("Indicar amigos", R.drawable.ic_invite_friends),
            MenuItem("Recarga de celular", R.drawable.ic_phone),
            MenuItem("Cobrar", R.drawable.ic_charge),
            MenuItem("Empréstimos", R.drawable.ic_emprestimo),
            MenuItem("Depositar", R.drawable.ic_deposit),
            MenuItem("Transferir", R.drawable.ic_transfer),
            MenuItem("Ajustar limite", R.drawable.ic_setup),
            MenuItem("Me ajuda", R.drawable.ic_question),
            MenuItem("Pagar", R.drawable.ic_pay),
            MenuItem("Bloquear cartão", R.drawable.ic_lock),
            MenuItem("Cartão virtual", R.drawable.ic_virtual_card),
            MenuItem("Pagar", R.drawable.ic_pay),
            MenuItem("Organizar atalhos", R.drawable.ic_setup_shortcuts)
        )
    }
}