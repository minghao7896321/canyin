package diningmis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class M_user extends javax.swing.JFrame {
    //数据源URL：
    String theDataSource = "jdbc:hsqldb:hsql://localhost/mydb";
    String theUser = "sa";//数据库的用户名
    String thePassword = ""; //数据库的密码
    Connection theConnection;
    ResultSet rs;
    Main_Frame main;

    static String mod_name=null;
    static String mod_pass=null;
    static String mod_sex=null;
    static String mod_competence=null;

      public M_user(Main_Frame main) throws SQLException{
       initComponents();
       this.main=main;
       refesh_Table();
       this.setDefaultCloseOperation(M_user.DISPOSE_ON_CLOSE);
       this.setBounds(280, 220, 420, 300);
      }
    
    public M_user() throws SQLException{
       initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("用户信息表");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("宋体", 0, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("宋体", 0, 14));
        jButton1.setText("添加");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("宋体", 0, 14));
        jButton2.setText("删除");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("宋体", 0, 14));
        jButton3.setText("修改");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("宋体", 0, 14));
        jButton4.setText("退出");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel1.setText("姓名：");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel2.setText("性别：");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel3.setText("密码：");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel4.setText("权限：");

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "普通用户", "超级用户" }));

        jComboBox2.setFont(new java.awt.Font("宋体", 0, 14));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "男", "女" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addGap(49, 49, 49)
                .addComponent(jButton3)
                .addGap(38, 38, 38)
                .addComponent(jButton4)
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordField1)
                            .addComponent(jComboBox1, 0, 122, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//添加数据
    String sql;
    boolean bl=true;
    if (this.jTextField1.getText().trim().equals(""))
        JOptionPane.showMessageDialog(rootPane, "姓名不能为空！！！");
    if (this.jPasswordField1.getText().trim().equals(""))
        JOptionPane.showMessageDialog(rootPane, "密码不能为空！！！");
    else{
            try {
                bl = this.GetUserName(this.jTextField1.getText().trim());
            } catch (SQLException ex) {
                Logger.getLogger(M_user.class.getName()).log(Level.SEVERE, null, ex);
            }
                if (!bl) {
                    JOptionPane.showMessageDialog(rootPane, "该用户名已存在！");
                } else {
                    sql = "insert into User(ID,name,pass,sex,competence)values(NULL," +
                            "'"+ this.jTextField1.getText().trim() + "'," +
                            "'"+ this.jPasswordField1.getText().trim() + "'," +
                            "'"+ this.jComboBox2.getSelectedItem()+ "'," +
                            "'"+ this.jComboBox1.getSelectedItem()+ "')";
                    Data_Insert(sql);
                    this.jTextField1.setText("");
                    this.jComboBox2.setSelectedItem("");
                    this.jComboBox1.setSelectedItem("");
                    this.jPasswordField1.setText("");
                }        
    }
    try {
        refesh_Table();
         } catch (SQLException ex) {
            Logger.getLogger(M_user.class.getName()).log(Level.SEVERE, null, ex);
        }
}
/*
        refesh();//GEN-LAST:event_jButton1ActionPerformed
     */
      

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:删除
       String sql;
       String a=null;
       int row=-1;
       row=this.jTable1.getSelectedRow();
       if(row!=-1){
           a=(String) this.jTable1.getValueAt(row, 0);
           sql= "delete from User where name='"+a+"'";
           Data_Delete(sql);
       }
       else
           JOptionPane.showMessageDialog(rootPane,"请选择要删除的行！！！");
        try {
            refesh_Table();
        } catch (SQLException ex) {
            Logger.getLogger(M_user.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
    main.setEnabled(true);
    this.dispose();
}//GEN-LAST:event_jButton4ActionPerformed

    @SuppressWarnings("empty-statement")
private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:修改
       int row=-1;
       row=this.jTable1.getSelectedRow();
       if(row==-1)
           JOptionPane.showMessageDialog(rootPane,"请选择要修改的行！！！");
       else{
           mod_name=(String) this.jTable1.getValueAt(row, 0);
           mod_pass=(String) this.jTable1.getValueAt(row, 1);
           mod_sex=(String) this.jTable1.getValueAt(row, 2);
           mod_competence=(String) this.jTable1.getValueAt(row, 3);
           this.setEnabled(false);
           new UI_Modify(this).show();
       }
}//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
            main.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing
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

    /*刷新表单**************/
    public void refesh_Table() throws SQLException {
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("姓名");
        tilte.add("密码");
        tilte.add("性别");
        tilte.add("权限");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(myModel);
        GetData(myModel);
    }
  
    /*插入数据*****************/
    public void Data_Insert(String sql) {
        this.executeQuery(sql);
    }

    /*删除数据*****************/
    public void Data_Delete(String sql) {
        this.executeQuery(sql);
    }

    /*验证用户名唯一性****************/
     public boolean GetUserName(String name) throws SQLException {
         this.executeQuery("select name from User");
         while (rs.next()) {
             if (rs.getString(1).equals(name))
                 return false;             
         }
         rs.close();
         theConnection.close();
         return true;
    }

    /*取数据库数据**************/
    public void GetData(DefaultTableModel myModel) throws SQLException {
        this.executeQuery("select * from User");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Vector col = new Vector();
            for (int i = 2; i <= columnCount; i++) {
                col.add(rs.getString(i));
            }
            myModel.addRow(col);
        }
        this.jTable1.setModel(myModel);
        rs.close();
        theConnection.close();
    }

    public static void main(String args[]) throws SQLException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new M_user().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(M_user.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
