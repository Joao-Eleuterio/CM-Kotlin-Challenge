package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import java.util.*

class Bicicleta(identificador:String) : Veiculo(identificador) {
    override var dataDeAquisicao = Date()

    override fun requerCarta(): Boolean {
        return false;
    }
    override fun moverPara(x: Int, y: Int) {
        if (posicao.x == x && posicao.y == y) {
            AlterarPosicaoException("Não pode ir para a mesma posicao")
        } else {
            posicao.alterarPosicaoPara(x, y)
        }

    }
}