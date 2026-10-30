package demo;

import contratos.Estadisticas;
import entidades.Entidad;
import fisica.Material;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.Random;
import motor.Entrada;
import motor.Escena;
import motor.Mundo;
import provisorio.ListaProvisoria;
import ui.HudBasico;
import ui.Texto;

public class EscenaDemo extends Escena implements Estadisticas {

    // Atributos
    private final Random azar = new Random();
    private Mundo mundo;
    private HudBasico hud;
    private Material material = Material.GOMA;
    private int creadas;

    // Entrada a la escena
    @Override
    public void alEntrar() {
        mundo = new Mundo(getContexto().getAncho(), getContexto().getAlto(), new ListaProvisoria<Entidad>());
        hud = new HudBasico(this, getContexto().getAncho());
    }

    // Actualización
    @Override
    public void actualizar(double dt) {
        Entrada entrada = getEntrada();
        Material[] materiales = Material.values();
        for (int i = 0; i < materiales.length; i++) {
            if (entrada.fuePresionada(KeyEvent.VK_1 + i)) {
                material = materiales[i];
            }
        }
        if (entrada.fuePresionada(KeyEvent.VK_R)) {
            mundo.vaciar();
        }
        if (entrada.huboClick()) {
            double radio = 10 + azar.nextInt(14);
            PelotaDemo pelota = new PelotaDemo(entrada.getMouseX(), entrada.getMouseY(), radio, material);
            pelota.setVelocidad(azar.nextInt(301) - 150, -azar.nextInt(300));
            mundo.agregar(pelota);
            creadas++;
        }
        mundo.actualizar(dt);
    }

    // Dibujo
    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(new Color(20, 24, 36));
        g.fillRect(0, 0, getContexto().getAncho(), getContexto().getAlto());
        mundo.dibujar(g);
        hud.dibujar(g);
        String ayuda = "1-5: material   click: crear pelota   R: limpiar";
        Texto.centrado(g, ayuda, getContexto().getAncho() / 2.0, 54, 14, Color.GRAY);
    }

    // Estadísticas para el HUD
    @Override
    public int getPuntaje() {
        return creadas;
    }

    @Override
    public int getVidas() {
        return 3;
    }

    @Override
    public int getNivel() {
        return 1;
    }

    @Override
    public String getMensaje() {
        return material.name() + "  (" + mundo.cantidad() + " en pantalla)";
    }
}
