package View;

import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import Controller.Main;
import javax.swing.JOptionPane;
public class LoginSignUp extends javax.swing.JFrame {
    int xx,xy;
    private Main Main;
    public LoginSignUp() {
        initComponents();
        
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(layar.width / 2  - this.getSize().width / 2, layar.height / 2 - this.getSize().height / 2);
        
        Main = new Main(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyondry");
        setBackground(java.awt.SystemColor.controlShadow);
        setMaximumSize(new java.awt.Dimension(1070, 590));
        setMinimumSize(new java.awt.Dimension(1070, 590));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 66, 66));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel1.setBackground(java.awt.SystemColor.controlDkShadow);
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EXIT");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1004, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/FullIcon.png"))); // NOI18N
        jLabel2.setText("[Image]");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 690, 540));

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField3.setNextFocusableComponent(jTextArea1);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 140, 214, -1));

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.setNextFocusableComponent(jTextField3);
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 100, 214, -1));

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setNextFocusableComponent(jTextField1);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 60, 214, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("No Telepon");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Alamat");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sign Up");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 380, 38));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Confirm Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 340, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setNextFocusableComponent(jPasswordField1);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 180, 210, 100));

        jPasswordField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPasswordField1.setNextFocusableComponent(jPasswordField2);
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 300, 210, 30));

        jPasswordField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 340, 210, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Login");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 38));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Email");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jTextField4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField4.setNextFocusableComponent(jPasswordField3);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 214, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Password");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jPasswordField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPasswordField3.setNextFocusableComponent(jButton2);
        jPanel1.add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 210, 30));

        jLabel13.setText("Login?");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 390, 80, -1));

        jLabel14.setText("Sign Up?");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 80, -1));

        jButton1.setBackground(new java.awt.Color(71, 120, 197));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign Up");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 390, 110, 40));

        jButton2.setBackground(new java.awt.Color(71, 120, 197));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1070, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        for (double i = 1.0; i >=0.0;i = i - 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(Exception e){}
        }
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <=1.0;i = i + 0.2)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_formWindowOpened

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setBackground(new Color(71,120,197));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(new Color(255,66,66));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jPanel4.setBackground(new Color(71,120,197));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        jPanel4.setBackground(new Color(255,66,66));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        AnimationClass anim = new AnimationClass();
        
        anim.jLabelXLeft(jLabel10.getX(), jLabel10.getX()-380, 1, 1, jLabel10);
        anim.jLabelXLeft(jLabel11.getX(), jLabel11.getX()-380, 1, 1, jLabel11);
        anim.jLabelXLeft(jLabel12.getX(), jLabel12.getX()-380, 1, 1, jLabel12);
        anim.jLabelXLeft(jLabel14.getX(), jLabel14.getX()-380, 1, 1, jLabel14);
        anim.jButtonXLeft(jButton2.getX(), jButton2.getX()-380, 1, 1, jButton2);
        anim.jTextFieldXLeft(jTextField4.getX(), jTextField4.getX()-380, 1, 1, jTextField4);
        anim.jPasswordFieldXLeft(jPasswordField3.getX(), jPasswordField3.getX()-380, 1, 1, jPasswordField3);
        
        anim.jLabelXLeft(jLabel2.getX(), 0, 1, 1, jLabel2);
        
        anim.jLabelXLeft(jLabel3.getX(), jLabel3.getX()-380, 2, 1, jLabel3);
        anim.jLabelXLeft(jLabel4.getX(), jLabel4.getX()-380, 2, 1, jLabel4);
        anim.jLabelXLeft(jLabel5.getX(), jLabel5.getX()-380, 2, 1, jLabel5);
        anim.jLabelXLeft(jLabel6.getX(), jLabel6.getX()-380, 2, 1, jLabel6);
        anim.jLabelXLeft(jLabel7.getX(), jLabel7.getX()-380, 2, 1, jLabel7);
        anim.jLabelXLeft(jLabel8.getX(), jLabel8.getX()-380, 2, 1, jLabel8);
        anim.jLabelXLeft(jLabel9.getX(), jLabel9.getX()-380, 2, 1, jLabel9);
        anim.jLabelXLeft(jLabel13.getX(), jLabel13.getX()-380, 2, 1, jLabel13);
        anim.jTextFieldXLeft(jTextField1.getX(), jTextField1.getX()-380, 2, 1, jTextField1);
        anim.jTextFieldXLeft(jTextField2.getX(), jTextField2.getX()-380, 2, 1, jTextField2);
        anim.jTextFieldXLeft(jTextField3.getX(), jTextField3.getX()-380, 2, 1, jTextField3);
        anim.jPasswordFieldXLeft(jPasswordField1.getX(), jPasswordField1.getX()-380, 2, 1, jPasswordField1);
        anim.jPasswordFieldXLeft(jPasswordField2.getX(), jPasswordField2.getX()-380, 2, 1, jPasswordField2);
        anim.jButtonXLeft(jButton1.getX(), jButton1.getX()-380, 2, 1, jButton1);
        anim.jTextAreaXLeft(jScrollPane1.getX(), jScrollPane1.getX()-380, 2, 1, jScrollPane1);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        AnimationClass anim = new AnimationClass();
        
        anim.jLabelXRight(jLabel10.getX(), jLabel10.getX()+380, 2, 1, jLabel10);
        anim.jLabelXRight(jLabel11.getX(), jLabel11.getX()+380, 2, 1, jLabel11);
        anim.jLabelXRight(jLabel12.getX(), jLabel12.getX()+380, 2, 1, jLabel12);
        anim.jLabelXRight(jLabel14.getX(), jLabel14.getX()+380, 2, 1, jLabel14);
        anim.jButtonXRight(jButton2.getX(), jButton2.getX()+380, 2, 1, jButton2);
        anim.jTextFieldXRight(jTextField4.getX(), jTextField4.getX()+380, 2, 1, jTextField4);
        anim.jPasswordFieldXRight(jPasswordField3.getX(), jPasswordField3.getX()+380, 2, 1, jPasswordField3);
        
        anim.jLabelXRight(jLabel2.getX(), jLabel2.getX()+380, 1, 1, jLabel2);
        
        anim.jLabelXRight(jLabel3.getX(), jLabel3.getX()+380, 1, 1, jLabel3);
        anim.jLabelXRight(jLabel4.getX(), jLabel4.getX()+380, 1, 1, jLabel4);
        anim.jLabelXRight(jLabel5.getX(), jLabel5.getX()+380, 1, 1, jLabel5);
        anim.jLabelXRight(jLabel6.getX(), jLabel6.getX()+380, 1, 1, jLabel6);
        anim.jLabelXRight(jLabel7.getX(), jLabel7.getX()+380, 1, 1, jLabel7);
        anim.jLabelXRight(jLabel8.getX(), jLabel8.getX()+380, 1, 1, jLabel8);
        anim.jLabelXRight(jLabel9.getX(), jLabel9.getX()+380, 1, 1, jLabel9);
        anim.jLabelXRight(jLabel13.getX(), jLabel13.getX()+380, 2, 1, jLabel13);
        anim.jTextFieldXRight(jTextField1.getX(), jTextField1.getX()+380, 1, 1, jTextField1);
        anim.jTextFieldXRight(jTextField2.getX(), jTextField2.getX()+380, 1, 1, jTextField2);
        anim.jTextFieldXRight(jTextField3.getX(), jTextField3.getX()+380, 1, 1, jTextField3);
        anim.jPasswordFieldXRight(jPasswordField1.getX(), jPasswordField1.getX()+380, 1, 1, jPasswordField1);
        anim.jPasswordFieldXRight(jPasswordField2.getX(), jPasswordField2.getX()+380, 1, 1, jPasswordField2);
        anim.jButtonXRight(jButton1.getX(), jButton1.getX()+380, 1, 1, jButton1);
        anim.jTextAreaXLeft(jScrollPane1.getX(), jScrollPane1.getX()+380, 1, 1, jScrollPane1);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Main.Login(jTextField4.getText(), jPasswordField3.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            if(jPasswordField1.getText().equals(jPasswordField2.getText())){
                Main.SignUp(
                        jTextField1.getText().toString()
                        , jTextField2.getText().toString()
                        , jTextField3.getText().toString()
                        , jPasswordField1.getText().toString()
                        , jTextArea1.getText().toString());
            }else{
                JOptionPane.showMessageDialog(null, "Password tidak sama");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Periksa Inputan Anda!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
