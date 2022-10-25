
import java.io.FileOutputStream;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    abstract public String getFileName();
    abstract public String getData();

    public void export(PrintStream stream) {
        // Please implement this method. You may create additional methods as you see fit.
        try {
            stream = new PrintStream(getFileName());
            stream.print(getData());
            stream.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
