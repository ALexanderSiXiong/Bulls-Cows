package Setting;

import java.io.IOException;
import java.io.OutputStream;

/**
 to let the information save in a file
 and can be displayed in the console at the same time
 */
public class SaveInFile extends OutputStream {
    OutputStream output1;
    OutputStream output2;

    public SaveInFile(OutputStream output1, OutputStream output2) {
        this.output1 = output1;
        this.output2 = output2;
    }

    @Override
    public void write(int b) throws IOException {
        // TODO Auto-generated method stub
        output1.write(b);
        output2.write(b);
    }
}
