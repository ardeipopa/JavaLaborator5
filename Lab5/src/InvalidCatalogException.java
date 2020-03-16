public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }
    public InvalidCatalogException(String message) {
        super("message");
    }
}