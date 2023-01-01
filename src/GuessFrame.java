
import java.awt.Color;
import java.awt.Graphics;



public class GuessFrame extends javax.swing.JFrame {
    String hidden = "";
    private String guessWord = "";
    boolean started = false;
    private String guess = "";
    private int tries = 0;
    private boolean correctGuess = false;
    private WordManager Manager = new WordManager();
    
    //private WordManager Manager = new WordManager("words.txt");
    
    
    public GuessFrame() {
        initComponents();
        guessStart.setEnabled(false);
        guessResult.setEditable(false);
    }
    
    public void drawStuff() {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,drawPanel.getWidth(), drawPanel.getHeight() );
        g.setColor(Color.BLUE);
        g.drawString("hello", 50, 200);
        g.drawOval(100,100,80,30);
        g.drawLine(50, 150, 200, 180);
        g.drawRect(100, 50, 40, 60);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guessField = new javax.swing.JTextField();
        guessStart = new javax.swing.JButton();
        guessResult = new javax.swing.JTextField();
        drawPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        generateWord = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        guessField.setText("Guess Here");
        guessField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessFieldActionPerformed(evt);
            }
        });
        guessField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                guessFieldKeyTyped(evt);
            }
        });

        guessStart.setText("Guess");
        guessStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessStartActionPerformed(evt);
            }
        });

        guessResult.setText("Generate Word First!");
        guessResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jMenu1.setText("Guess Game");

        generateWord.setText("Generate Word");
        generateWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateWordActionPerformed(evt);
            }
        });
        jMenu1.add(generateWord);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(guessResult, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(guessStart)
                            .addGap(83, 83, 83)))
                    .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guessStart)
                .addGap(18, 18, 18)
                .addComponent(guessResult, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guessFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guessFieldActionPerformed

    private void guessStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessStartActionPerformed
        guess = guessField.getText();
        correctGuess = false;
        for (int i = 0; i < guessWord.length(); i++) {
            if (guess.equals(guessWord.substring(i, i+1))) {
                hidden = hidden.substring(0, i) + guess + hidden.substring(i+1);
                guessResult.setText(hidden);
                correctGuess = true;
            }
        }
        if (hidden.equals(guessWord)) {
         
            guessField.setText("YOU WIN!");
            guessField.setEditable(false);
            guessStart.setEnabled(false);
            
            
        }
        if (!correctGuess) {
            tries++;
            drawStuff();
        } else {
            drawStuff();
        }

        
    }//GEN-LAST:event_guessStartActionPerformed
    

    private void generateWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateWordActionPerformed
        guessWord = Manager.getWord();
        guessField.setEditable(true);
        guessStart.setText("Guess");
        guessStart.setEnabled(true);
        hidden = "";
        for (int i = 0; i < guessWord.length(); i++) {
            hidden = hidden + "-";
        }
        guessResult.setText(hidden);
        started = true;
        guessField.setText("");
    }//GEN-LAST:event_generateWordActionPerformed

    private void guessResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guessResultActionPerformed
        
        
    }//GEN-LAST:event_guessResultActionPerformed

    private void guessFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guessFieldKeyTyped
      
        guessField.setText("");
       
    }//GEN-LAST:event_guessFieldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuessFrame().setVisible(true);
            }
        });
    }
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel drawPanel;
    private javax.swing.JMenuItem generateWord;
    private javax.swing.JTextField guessField;
    private javax.swing.JTextField guessResult;
    private javax.swing.JButton guessStart;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

 
}
