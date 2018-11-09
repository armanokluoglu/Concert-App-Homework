package DAL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {

	private boolean isInitialized = false;
	
	public TxtReader() {
		isInitialized = true;
	}
	
    public String readFromTxtFile(String fileDirectory) {
    	checkInitialization();
    	String lines = "";
        String txtFile = fileDirectory;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(txtFile));
            String line = bufferedReader.readLine();
            while (line != null) {
                lines += line;
                line = bufferedReader.readLine();
            }
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lines;
    }

    private void checkInitialization() {
    	if(!isInitialized) {
    		throw new IllegalStateException("Given reader object was not created properly.");
    	}
    }
}