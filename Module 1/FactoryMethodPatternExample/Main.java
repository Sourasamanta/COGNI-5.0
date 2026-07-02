import java.util.Scanner;

interface Document {
    void create();
}

class WordDocument implements Document {

    public void create() {
        System.out.println("Word Document Created");
    }
}

class PdfDocument implements Document {

    public void create() {
        System.out.println("PDF Document Created");
    }
}

class ExcelDocument implements Document {

    public void create() {
        System.out.println("Excel Document Created");
    }
}

class DocumentFactory {

    public static Document getDocument(String type) {

        if (type.equalsIgnoreCase("Word")) {
            return new WordDocument();
        }
        else if (type.equalsIgnoreCase("Pdf")) {
            return new PdfDocument();
        }
        else if (type.equalsIgnoreCase("Excel")) {
            return new ExcelDocument();
        }

        return null;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter document type: ");
        String type = sc.nextLine();

        Document doc = DocumentFactory.getDocument(type);

        if (doc != null) {
            doc.create();
        } else {
            System.out.println("Invalid document type.");
        }
    }
}