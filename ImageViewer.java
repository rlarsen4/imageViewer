/* Class:   imageviewer
 * Name:		Rick Larsen
 * Date:		11/25/2013 
 * Purpose:	Enables users to select image files to view.
 */
 
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.io.File;
 
 public class ImageViewer extends JFrame
 {
   // swing components
   private JPanel imagePanel;
   private JPanel buttonPanel;
   private JLabel imageLabel;
   private JButton button;
   private JFileChooser fileChooser;
   
   // constructor
   public ImageViewer()
   {
      // set the window title
      setTitle("Image Viewer");
            
      // set default close
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // build panels
      buildImagePanel();
      buildButtonPanel();
      
      // add the panels
      add(imagePanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
      
      // create file chooser
      fileChooser = new JFileChooser(".");
      
      // display window
      pack();
      setVisible(true);
   }
   
   private void buildImagePanel()
   {
      // create panel object
      imagePanel = new JPanel();
      
      // create label object
      imageLabel = new JLabel("Click button to view image");
      
      // add the components to the panel
      imagePanel.add(imageLabel);
   }
   
   private void buildButtonPanel()
   {
      // create panel object
      buttonPanel = new JPanel();
      
      // create label object
      button = new JButton("Get Image");
      button.setMnemonic(KeyEvent.VK_G);
      button.setToolTipText("Click here to load an image.");
      
      // add the components to the panel
      buttonPanel.add(button);

     // register action listener with the button
      button.addActionListener(new ButtonListener());
      
      // add button to panel.
      buttonPanel.add(button);
   }
   // action listener class
   private class ButtonListener implements ActionListener   
   {
      // actionPerformed method
      public void actionPerformed(ActionEvent e)
      {
         File selectedFile;      // reference selected file
         ImageIcon image;        // read the image from the file
         String fileName;        // hold name & path of file
         int fileChooserStatus;  // indicate status of open dialog box
         
         // open a dialog box
         fileChooserStatus = fileChooser.showOpenDialog(ImageViewer.this);
         
         if (fileChooserStatus == JFileChooser.APPROVE_OPTION)
         {
            // get a reference to selected file
            selectedFile = fileChooser.getSelectedFile();
            
            // get path of selected file.
            fileName = selectedFile.getPath();
            
            // read image from file
            image = new ImageIcon(fileName);
            
            // store the image in the image label
            imageLabel.setIcon(image);
            
            // if label displays text, remove it
            imageLabel.setText(null);
            
            // pack frame again
            pack();
         }
      }
   }
   
   public static void main(String[] args)
   {
      ImageViewer iv = new ImageViewer();
   }
}
 
 