package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class Veiculo(open var identificador: String) : Movimentavel{
    var posicao = Posicao(0,0)
    abstract var dataDeAquisicao : LocalDate
    abstract fun requerCarta():Boolean

    override fun toString(): String {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val data = dataDeAquisicao.format(formatter)
        return "${this.javaClass.simpleName} | $identificador | $data | $posicao | x:${posicao.x} | y:${posicao.y}"
    }
}