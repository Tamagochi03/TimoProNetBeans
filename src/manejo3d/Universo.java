/*
 Esta clase crea el universo en el cual podrá vivir Rayman
 */
package manejo3d;

import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TransformGroup;


/**
 *
 * @author Yareli Avilés
 */
public class Universo {
    
    
    private BranchGroup group;
    private SimpleUniverse universe;
    private LoadScene ls;
    TransformGroup tg = new TransformGroup();
    //MaquinaEstado3D maquina;
    
    
    public Universo(Canvas3D canvas3D){
        
        universe = new SimpleUniverse(canvas3D);
        group = new BranchGroup();
        //maquina = new MaquinaEstado3D();
        setup3DGraphics();
    }
    
    void setup3DGraphics() {

      group = new BranchGroup();
      ls = new LoadScene("C:\\Users\\Shinsnake\\Documents\\NetBeansProjects\\MascotaVirtual_1\\src\\manejo3d\\recursos\\");
      ls.load();
      ls.listSceneNamedObjects();
      tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
      tg.addChild(ls.getParte());
      group.addChild(tg);
      universe.getViewingPlatform().setNominalViewingTransform();
      universe.addBranchGraph(group);
      
  }

    public TransformGroup getTg() {
        return tg;
    }
    
    public void setTg(TransformGroup tg){
        group.removeAllChildren();
        group.addChild(tg);
    }
    
    
   
}
