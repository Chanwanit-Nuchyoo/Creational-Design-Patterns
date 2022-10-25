import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    @Override
    public String getFileName() {
        String fileName = "CSVBooks.csv";
        fileName = fileName.replaceAll("[\\\\/:*?\"<>|]", "_");
        return (fileName);
    }

    @Override
    public String getData() {
        try {
            BookMetadataFormatter formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.CSV);
            for (Book b : books)
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
