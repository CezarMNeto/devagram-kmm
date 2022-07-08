package com.devaria.devagram

class Validacoes {

    fun validarNome (nome: String): Boolean{
        return nome.length >= 3
    }

    fun validarEmail (email: String): Boolean{
        if(!email.isEmpty()){
//           return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        return false
    }

    fun validarSenha (senha: String): Boolean{
        return senha.length >= 4
    }

    fun validarConfirmacaoSenha (senha: String, confirmacao: String): Boolean{
        return senha.equals(confirmacao)
    }
}