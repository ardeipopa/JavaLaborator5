import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //instanta din clasa main, pentru a putea apela functiile de testare
        Main work = new Main();
        work.testCreateSave();
        work.testLoadView();
        System.out.println("all good");
    }

    /**
     functie care testeaza crearea unui catalog respectiv document si salvarea lui(serializarea)
     */
    private void testCreateSave() {
        try {
            Catalog catalog = new Catalog("Java Resources", "C:\\Users\\Andrei Popa\\IdeaProjects\\Lab5\\myCatalog.ser");
            Document document = new Document("some page", "https://stackoverflow.com/questions/39601420/cannot-resolve-constructor-class-namejava-lang-string", false);
            Document document2 = new Document("myfile", "C:\\Users\\Andrei Popa\\IdeaProjects\\Lab5\\myfile.txt",true);
            document.addTag("type", "Slides");
            catalog.add(document);
            catalog.add(document2);
            CatalogUtil.save(catalog);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /***
     functie care testeaza loadul si view-ul pentru documente
     */
    private void testLoadView() {
        try {
            Catalog catalog = CatalogUtil.load("C:\\Users\\Andrei Popa\\IdeaProjects\\Lab5\\myCatalog.ser");
            Document doc = catalog.findById(2);
            CatalogUtil.view(catalog,doc);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
