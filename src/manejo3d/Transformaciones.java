/*
 * Aquí se crean todas las transformaciones que se puedan ocupar para el modelo.
 */
package manejo3d;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author Yareli Avilés
 */
public class Transformaciones /*implements Runnable*/ {

    TransformGroup tg = new TransformGroup();
    Transform3D transform = new Transform3D();
    double factor = 0;
    Vector3f translada;
    Vector3d escala;

    public Transformaciones(TransformGroup tg) {
        this.tg = tg;
        //tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    }

    public void rotarRaymanX() {
        factor = factor + 0.01;
        transform.rotX(factor);
        tg.setTransform(transform);

    }

    public void rotarRaymanY() {
        factor = factor + 0.01;
        transform.rotY(factor);
        tg.setTransform(transform);
    }

    public void rotarRaymanZ() {
        factor = factor + 0.01;
        transform.rotZ(factor);
        tg.setTransform(transform);
    }

    public void trasladarRayman() {
        translada = new Vector3f(2F, 3F, -10F);
        transform.setTranslation(translada);
        tg.setTransform(transform);
    }

    public void escalaRayman() {
        escala = new Vector3d(3D, 1D, 2D);
        transform.setScale(escala);
        tg.setTransform(transform);
    }

    public TransformGroup getTg() {
        return tg;
    }
    
}
