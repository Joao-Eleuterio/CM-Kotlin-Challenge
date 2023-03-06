package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos: Int, var cilindrada: Int) : Ligavel {
    var ligado: Boolean = false


    override fun desligar() {
        try {
            if (ligado) {
                ligado = false;
            } else {
                throw VeiculoDesligadoException("aaa")
            }
        } catch (e: VeiculoDesligadoException) {
            // handle the exception here
        }
    }

    override fun estaLigado() {
        super.estaLigado()
        ligado
    }

    override fun ligar() {
        try {
            if (!ligado) {
                ligado = true
            } else {
                throw VeiculoLigadoException("")
            }
        }catch (e: VeiculoLigadoException){}
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }


}