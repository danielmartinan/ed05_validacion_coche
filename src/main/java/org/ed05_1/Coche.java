package org.ed05_1;

import java.awt.*;

public class Coche {
    private String numBastidor;
    private String marca;
    private String modelo;
    private String color;
    private int velocidadMaxima;

    public Coche(String numBastidor, String marca, String modelo, Color color, int velocidadMaxima) {
        if(validarNumBastidor(numBastidor)) {
            this.numBastidor = numBastidor;
        }
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getNumBastidor() {
        return numBastidor;
    }


    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }


    public String getColor() {
        return color;
    }


    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }


    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Color: " + color + "\n" +
                "Velocidad: " + velocidadMaxima + "\n" +
                "Número de bastidor: " + numBastidor + "\n";
    }

    public static boolean validarNumBastidor(String numBastidor) {
        if (numBastidor == null) {
            throw new IllegalArgumentException("El número de bastidor no puede ser nulo");
        }
        if (numBastidor.length() != 17) {
            throw new IllegalArgumentException("El número de bastidor debe tener 17 caracteres");
        }
        if (numBastidor.contains("I") || numBastidor.contains("O") || numBastidor.contains("Q")) {
            throw new IllegalArgumentException("El número de bastidor no puede contener las letras I, O o Q");
        }
        return true;
    }
}
