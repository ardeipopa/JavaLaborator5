import java.io.File;
import java.io.Serializable;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/*clasa implementeaza interfata Serializable deoarece obiectele trebuie sa fie importabile/exportabile */
public class Catalog  implements Serializable  {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) throws IllegalArgumentException {
        Path parentPath = Paths.get(path).getParent();
        File f = new File(parentPath.toString());
        if (f.exists() && f.isDirectory()) {
            this.name = name;
            this.path = path;
        } else throw  new IllegalArgumentException("pathul " + path + " nu e valid");
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    boolean hasDocument(Document doc){
        if(documents.indexOf(doc)==-1)
            return false;
        return true;
    }

    public Document findById(int id)  {
        for (Document doc : documents) {
            if (doc.getId() == id) {
                return doc;
            }
        }
        return null;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
