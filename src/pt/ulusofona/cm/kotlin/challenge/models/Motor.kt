package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(var cavalos:Int,var cilindrada:Int):Ligavel{
    var ligado:Boolean = false


    override fun desligar() {
        super.desligar()
        ligado=false;
    }

    override fun estaLigado() {
        super.estaLigado()
        ligado
    }

    override fun ligar() {
        super.ligar()
        ligado= true
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }



}