
import java.awt.Color;
import java.awt.Graphics;

public class GuessFrame extends javax.swing.JFrame {

    private String hidden = "";
    private String guessWord = "";
    boolean started = false;
    private String guess = "";
    private int tries = 0;
    private boolean correctGuess = false;
    private WordManager Manager = new WordManager("words.txt");
    private SoundManager SFX = new SoundManager();

    public GuessFrame() {
        initComponents();
        guessStart.setEnabled(false);
        guessResult.setEditable(false);
        setResizable(false);

    }

    public void drawStuff() {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.BLACK);
        if (tries >= 1) {
            g.drawLine(100, 250, 200, 250);
        }
        if (tries >= 2) {
            g.drawLine(150, 250, 150, 50);
        }
        if (tries >= 3) {
            g.drawLine(150, 50, 250, 50);
        }
        if (tries >= 4) {
            g.drawLine(250, 50, 250, 75);
        }
        if (tries >= 5) {
            g.drawLine(150, 75, 175, 50);
        }
        if (tries >= 6) {
            g.drawOval(230, 75, 40, 40);
        }
        if (tries >= 7) {
            g.drawLine(250, 115, 250, 175);
        }
        if (tries >= 8) {
            g.drawLine(250, 175, 225, 200);
        }
        if (tries >= 9) {
            g.drawLine(250, 175, 275, 200);
        }
        if (tries >= 10) {
            g.drawLine(250, 130, 225, 140);
        }
        if (tries >= 11) {
            g.drawLine(250, 130, 275, 140);
            try {
                SFX.playSFX("avii.wav");
            } catch (Exception e) {
            }
            guessField.setText("YOU LOSE! THE WORD WAS: " + guessWord);
            tries = 0;
            guessStart.setText("Generate word to play again!");
            guessField.setEditable(false);
            guessStart.setEnabled(false);
        }

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

        guessField.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        guessField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        guessStart.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        guessStart.setText("Guess");
        guessStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessStartActionPerformed(evt);
            }
        });

        guessResult.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        guessResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
            .addGap(0, 453, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
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
            .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guessField, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(guessResult)
                    .addComponent(guessStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guessStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guessResult, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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
            if (guess.equals(guessWord.substring(i, i + 1))) {
                hidden = hidden.substring(0, i) + guess + hidden.substring(i + 1);
                guessResult.setText(hidden);
                correctGuess = true;
            }
        }
        if (hidden.equals(guessWord)) {
            try {
                SFX.playSFX("win.wav");
            } catch (Exception e) {
            }
            guessField.setText("YOU WIN!");
            tries = 0;
            guessStart.setText("Generate word to play again!");
            guessField.setEditable(false);
            guessStart.setEnabled(false);

        }
        if (!correctGuess) {
            tries++;
            try {
                SFX.playSFX("flash_grenade_00.wav");
            } catch (Exception e) {
            }
            drawStuff();
        } else {
            try {
                SFX.playSFX("ignite.wav");
            } catch (Exception e) {
            }
            drawStuff();
        }


    }//GEN-LAST:event_guessStartActionPerformed


    private void generateWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateWordActionPerformed
        guessWord = Manager.getWord();
        try {
            SFX.playSFX("43578 - pilot_killed_indicator_BU.wav");
        } catch (Exception e) {
        }
        tries = 0;
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
