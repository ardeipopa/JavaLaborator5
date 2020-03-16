import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    /* pentru a fi sigur ca id ul e unic am folosit o variabila statica pe care o incrementez in constructor*/
    private static int idCount = 0;
    private int id;
    private String name;
    private String location;
    /*campul isLocal e necesar pentru view: pentru a sti daca sa apelez desktop.open sau desktop.browse*/
    private boolean isLocal;
    private Map<String, Object> tags = new HashMap<>();

    public boolean isLocal() {
        return isLocal;
    }

    Document(String name, String location, boolean isLocal) throws  InvalidDocumentException {
        idCount++;
        this.name = name;
        this.id = idCount;
        this.isLocal=isLocal;
        if (isLocal) {
            File f = new File(location);
            if(f.exists() && !f.isDirectory())
                this.location=location;
            else throw new InvalidDocumentException("Fisierul local "+location+" nu exista sau e director");
        }
        else this.location=location;
    }
    public void addTag(String key, Object obj){
        tags.put(key, obj);
    }
    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}
