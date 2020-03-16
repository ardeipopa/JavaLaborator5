class InvalidDocumentException extends Exception {
    public InvalidDocumentException(Exception ex) {
        super("Invalid path for file file.", ex);
    }

    public InvalidDocumentException(String message) {
        super(message);
    }
}