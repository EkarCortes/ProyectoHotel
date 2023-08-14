/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Models.Empleado;

/**
 *
 * @author ekard
 */
public enum Puesto {
    RECEPCIONISTA(800000),
    GERENTE(1400000),
    CONSERJE(550000),
    SUPERVISOR(1100000),
    MANTENIMIENTO(650000);

    private final double salario;

    Puesto(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
}
