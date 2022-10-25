import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLBookMetadataExporter extends BookMetadataExporter{

    @Override
    public String getFileName() {
        String fileName = "XMLBooks.xml";
        fileName = fileName.replaceAll("[\\\\/:*?\"<>|]", "_");
        return (fileName);
    }

    @Override
    public String getData() {
        try {
            BookMetadataFormatter formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.XML);
            for(Book b: books)
                formatter.append(b);
            return formatter.getMetadataString();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
