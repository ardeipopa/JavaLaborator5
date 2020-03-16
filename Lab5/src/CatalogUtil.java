import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        File f = new File(path);
        if (!f.exists()) throw new InvalidCatalogException("catalog does not exits");
        try (var oos = new ObjectInputStream(
                new FileInputStream(path))) {
            Catalog catalog = (Catalog) oos.readObject();
            return catalog;
        }
    }

    public static void view(Catalog catalog, Document document) throws IOException, IllegalArgumentException, URISyntaxException {
        if (catalog.hasDocument(document)) {
            Desktop desktop = Desktop.getDesktop();
            //trebuie sa stim daca un document e identificat de un URI sau de un path local
            if (document.isLocal()) {
                File myFile = new File(document.getLocation());
                desktop.open(myFile);
            }
            else {
            URI uri=new URI(document.getLocation());
            desktop.browse(uri);
            }

        } else throw new IllegalArgumentException("The document with path " + document + " is not in the catalog");
    }
}
