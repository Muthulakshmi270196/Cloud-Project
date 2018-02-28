
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;


class TextAreaOutput extends OutputStream {

    JTextArea textControl;
    public TextAreaOutput(JTextArea jTextArea1) {
        textControl=jTextArea1;
    }

    @Override
    public void write(int b) throws IOException {
        textControl.append( String.valueOf( ( char )b ) );
    }
    
}
