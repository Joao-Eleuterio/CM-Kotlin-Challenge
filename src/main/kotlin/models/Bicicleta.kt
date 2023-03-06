package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Bicicleta(override var identificador:String) : Veiculo(identificador) {
    override lateinit var dataDeAquisicao: Date


    override fun requerCarta(): Boolean {
        return false;
    }
}