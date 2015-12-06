import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class RepoEncuesta {
  private List<Encuesta> escuentas;
  
  private Encuesta encuesta01;
  
  private Encuesta encuesta02;
  
  public RepoEncuesta() {
  }
  
  @Pure
  public List<Encuesta> getEscuentas() {
    return this.escuentas;
  }
  
  public void setEscuentas(final List<Encuesta> escuentas) {
    this.escuentas = escuentas;
  }
  
  @Pure
  public Encuesta getEncuesta01() {
    return this.encuesta01;
  }
  
  public void setEncuesta01(final Encuesta encuesta01) {
    this.encuesta01 = encuesta01;
  }
  
  @Pure
  public Encuesta getEncuesta02() {
    return this.encuesta02;
  }
  
  public void setEncuesta02(final Encuesta encuesta02) {
    this.encuesta02 = encuesta02;
  }
}
