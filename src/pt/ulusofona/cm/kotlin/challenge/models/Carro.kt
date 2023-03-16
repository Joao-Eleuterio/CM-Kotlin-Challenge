package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import java.util.*

class Carro(override var identificador:String,var motor:Motor) : Veiculo(identificador), Ligavel {
    override var dataDeAquisicao = Date()

    override fun desligar() {
        if (motor.estaLigado()) {
            motor.desligar();
        } else {
            throw VeiculoDesligadoException("Veiculo já desligado")
        }
    }

    override fun estaLigado(): Boolean {
        return motor.estaLigado()
    }
    override fun ligar() {
        if (!estaLigado()) {
            motor.ligar()
        } else {
            throw VeiculoLigadoException("Veiculo já ligado")
        }
    }
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x && posicao.y == y) {
            throw AlterarPosicaoException("${this.javaClass.simpleName} não pode ir para a mesma posicao")
        } else {
            if(estaLigado()){
                posicao.alterarPosicaoPara(x, y)
                desligar()
            }
        }

    }

}