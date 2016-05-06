/*
 * Login.java
 * Created on September 29, 2008, 10:41 PM
 */
package diningmis;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
        this.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
        //this.setBounds(this.getWidth(), 230, 360, 180);
        this.setBounds(320, 230, 360, 180);
    }

     public Login(Main_Frame main) {
        initComponents();
        this.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
        this.setBounds(320, 230, 360, 180);
        this.change=true;
        this.main=main;
        this.setTitle("切换用户");
    }

    //数据源URL：
    String theDataSource = "jdbc:hsqldb:hsql://localhost/mydb";
    String theUser = "sa";//数据库的用户名
    String thePassword = ""; //数据库的密码
    Connection theConnection;
    ResultSet rs;
    boolean change=false;
    Main_Frame main;
    
   //**********连接数据*****************
    public void executeQuery(String sql) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
        }
        try {
            //建立数据库的连接。
            theConnection = DriverManager.getConnection(theDataSource, theUser, thePassword);
            rs = theConnection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setTitle("用户登录");
        setResizable(false);

        jButton1.setFont(new java.awt.Font("宋体", 0, 14));
        jButton1.setText("登录");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("宋体", 0, 14));
        jButton2.setText("取消");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel1.setText("用户名:");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel2.setText("密  码:");

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/diningmis/login.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*验证登录用户信息**************/
    public boolean comparison(String name,String pass) throws SQLException {
        String p = null;
        String _sql="select* from User where name='"+name+"' and pass= '"+pass+"'";
        this.executeQuery(_sql); 
        while (rs.next()) {
               p=rs.getString(3).trim();
       } 
        int id=rs.getRow();
        if(id!=0){
            rs.close();
            theConnection.close();
            return true;
        }
        else{
            rs.close();
            theConnection.close();  
            return false;
        }
    }
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    if(!change)
        System.exit(1);
    else
    {
        main.setVisible(true);
        this.dispose();
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        boolean key = false;
    if (this.jTextField1.getText().trim().equals(""))
        JOptionPane.showMessageDialog(rootPane, "请输入用户名！！！","提示",1);
    else{
        if(this.jPasswordField1.getText().equals(""))
          JOptionPane.showMessageDialog(rootPane, "请输入密码！！！", "提示",1);
        else{
                try {//验证登录用户信息
                    key = comparison(this.jTextField1.getText().trim(), this.jPasswordField1.getText().trim());
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(key){
                JOptionPane.showMessageDialog(rootPane, "登录成功","提示", 1);
                this.dispose();
                //new Main_Frame().show();
               String p = null;
               String _sql="select competence  from User where name='"+this.jTextField1.getText()+"' and pass= '"+this.jPasswordField1.getText()+"'";
               this.executeQuery(_sql);
                    try {
                        while (rs.next()) {
                            p = rs.getString(1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Main_Frame tb=new Main_Frame();
                if(!p.equals("超级用户"))
                    tb.jMenuItem1.setEnabled(false);
                tb.show();
            }
            else{                   
                this.jTextField1.setText("");
                this.jPasswordField1.setText("");
                JOptionPane.showConfirmDialog(rootPane, "用户名或密码不正确!","提示",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);   
            }
        }
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
// TODO add your handling code here:
   // this.jButton1ActionPerformed(null);
}//GEN-LAST:event_jButton1KeyReleased

private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
    // TODO add your handling code here:
    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    this.jButton1ActionPerformed(null);
}//GEN-LAST:event_jPasswordField1KeyPressed
              
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
