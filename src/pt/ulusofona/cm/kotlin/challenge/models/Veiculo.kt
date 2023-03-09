package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.format.DateTimeFormatter
import java.util.*

abstract class Veiculo(open var identificador: String) : Movimentavel{
    var posicao = Posicao(0,0)
    abstract var dataDeAquisicao : Date
    abstract fun requerCarta():Boolean

    override fun toString(): String {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val data = dataDeAquisicao.toString().format(formatter)
        return "${this.javaClass.simpleName} | $identificador | $data | $posicao | x:${posicao.x} | y:${posicao.y}"
    }
}

