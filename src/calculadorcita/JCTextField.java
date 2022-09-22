package calculadorcita;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * 
 * @author Yessid Murcia
 */
public class JCTextField extends JTextField{
    
    private Dimension dmCelda = new Dimension(36,36);
    
    /** Constructor de clase*/
    JCTextField()
    {
        setSize(dmCelda);
        setPreferredSize(dmCelda);
        setText("0");
        setHorizontalAlignment(JTextField.CENTER);        
        setVisible(true);
                
        //
        addFocusListener(new FocusListener() {
            @Override 
            public void focusLost(final FocusEvent pE) {}
            @Override 
            public void focusGained(final FocusEvent pE) {
                selectAll();
            }
        });
        /*
        //Solo numeros enteros
        ((AbstractDocument) getDocument()).setDocumentFilter(new DocumentFilter() {
            
            Pattern regEx = Pattern.compile("\\d+");

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
                                AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) { 
                    return;
                }               
                super.replace(fb, offset, length, text, attrs);
            }
        });
        */
        //
        addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
               if( getText().length()>0 && isEditable() )
                    if ( Integer.valueOf(getText())>999 ){
                        JOptionPane.showMessageDialog(null, "Solo numeros del 0 el 999", "Atención", JOptionPane.INFORMATION_MESSAGE);    
                        setText("0");
                    }
            }         
          
        });       
      
    }   

    public Dimension getDmCelda() {
        return dmCelda;
    }

    public void setDmCelda(Dimension dmCelda) {
        this.dmCelda = dmCelda;
    }
   
}

