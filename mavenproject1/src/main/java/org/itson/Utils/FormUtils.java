package org.itson.Utils;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael Marchena
 */
public final class FormUtils {

    private FormUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Carga un form y oculta el actual.
     *
     * @param <T> subclase del JFrame actual.
     * @param cargar el frame a cargar.
     * @param actual el frame actual.
     * @throws InstantiationError InstantiationError.
     */
    public static <T extends JFrame> void cargarForm(
            final T cargar,
            final JFrame actual
    ) throws InstantiationError {

        if (cargar == null || actual == null) {
            throw new InstantiationError("Form no instanciado");
        }
        actual.dispose();
        cargar.setVisible(true);

    }

    /**
     * Regresa un a un form anterior, ocultando el actual.
     *
     * @param frmAnterior frame anterior.
     * @param actual frame actual.
     */
    public static void regresar(
            final JFrame actual,
            final JFrame frmAnterior
    ) {
        cargarForm(frmAnterior, actual);
    }
}
