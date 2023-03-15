package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.util.*

class Carro(override var identificador:String, var motor:Motor) : Veiculo(identificador), Ligavel {
    override var dataDeAquisicao = Date()
    var ligado: Boolean = false


    override fun desligar() {
        if (ligado) {
            ligado = false;
        } else {
            throw VeiculoDesligadoException("Não pode desligar um carro desligado")
        }
    }

    override fun estaLigado():Boolean {
        return ligado
    }

    override fun ligar() {
        if (!ligado) {
            ligado = true
        } else {
            throw VeiculoLigadoException("Não pode ligar um carro ligado")
        }
    }
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x && posicao.y == y) {
            throw AlterarPosicaoException("Não pode ir para a mesma posicao")
        } else {
            motor.ligar()
            posicao.alterarPosicaoPara(x, y)
            motor.desligar()
        }

    }

}