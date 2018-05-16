import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The ChatClient class, which will create a new chat room window in a separate GUI for each client.
 * 
 */
public class ChatClient implements ChatClientInterface
{
    private BufferedReader in;
    private PrintWriter out;
    private JFrame chatBox = new JFrame("Chat Room");
    private JTextField messageTextField = new JTextField(40);
    private JTextArea messageBox = new JTextArea(15, 50);
    private Socket clientSocket;
    private static int PORT;
    
    public ChatClient()
    {
    	PORT = 9001;	
    	
    
    	chatBox.setVisible(true);
    	messageTextField.setEditable(false);
    	messageBox.setEditable(false);
        chatBox.getContentPane().add(messageTextField, "North");
        chatBox.getContentPane().add(new JScrollPane(messageBox), "Center");
        chatBox.pack();

        messageTextField.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                out.println(messageTextField.getText());
                messageTextField.setText("");
            }
        });
    }
    
    /**
     * Prompt for and return the desired screen name.
     * 
     * @return the screen name the user wishes to use
     */
    @Override
    public String getName()
    {
        return JOptionPane.showInputDialog(chatBox, "Choose a screen name:", "Screen name selection", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    /**
     * The port number that the server is using
     * 
     * @return the port number for the client to connect to the server
     */
	@Override
	public int getServerPort()
	{	
		return PORT;
	}

    /**
     * Connects to the server then enters the processing loop.
     */
    public void run()
    {    
        try
        {
       
           clientSocket = new Socket("localhost", getServerPort());          
            
            in = new BufferedReader(new InputStreamReader( clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
                   
	        while (true)
	        {
	            String line = in.readLine();
	            if (line.startsWith("SUBMITNAME"))
	            {
	                out.println(getName());
	            }             
	            else if (line.startsWith("NAMEACCEPTED"))
	            {
	            	messageTextField.setEditable(true);
	            }
	            else if (line.startsWith("MESSAGE"))
	            {
	            	messageBox.append(line.substring(8) + "\n");
	            }          
	        }
        }
		catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
