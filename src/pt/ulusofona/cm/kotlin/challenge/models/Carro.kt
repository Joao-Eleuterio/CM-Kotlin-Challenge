package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.time.LocalDate

class Carro(override var identificador:String, var motor:Motor) : Veiculo(identificador){
    override lateinit var dataDeAquisicao : LocalDate

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