/*
 * KaiTai_Frame.java
 *
 * Created on October 1, 2008, 3:25 PM
 */

package diningmis;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  wangqichun
 */
public class KaiTai_Frame extends javax.swing.JFrame {

    /** Creates new form KaiTai_Frame */
    static String zuohao;
    private Main_Frame mainf;

     public KaiTai_Frame() {
          initComponents(); 
     }

    public KaiTai_Frame(Main_Frame main) throws SQLException {
        initComponents();
        this.setDefaultCloseOperation(KaiTai_Frame.DISPOSE_ON_CLOSE);
        this.setBounds(350, 220, 300,335);
        refesh_Table();
        this.mainf = main;
    }

    //数据源URL：
    String theDataSource = "jdbc:hsqldb:hsql://localhost/mydb";
    String theUser = "sa";//数据库的用户名
    String thePassword = ""; //数据库的密码
    Connection theConnection;
    ResultSet rs;
    
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
        tilte.add("桌号");
        tilte.add("状态");
        tilte.add("备注");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(myModel);
        GetData(myModel);
    }
     /*取数据库数据**************/
    public void GetData(DefaultTableModel myModel) throws SQLException {
        this.executeQuery("select * from tableuse order by zuohao ASC");
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("开台");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel1.setText("选择桌号:");

        jButton1.setFont(new java.awt.Font("宋体", 0, 14));
        jButton1.setText("确定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("宋体", 0, 14));
        jButton2.setText("取消");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "请选择", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(48, 48, 48)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, 0, 217, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
    zuohao = (String) this.jComboBox1.getSelectedItem();
    this.executeQuery("select * from tableuse where zuohao='" + zuohao + "'");
    while (rs.next()) {
        if (rs.getString(3).equals("有人")) {
            JOptionPane.showConfirmDialog(rootPane, "您选择的桌号已有人", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.executeQuery("update tableuse set state='有人'where zuohao='" + zuohao + "'");
            DianCai_frame DC=new DianCai_frame(mainf);
           // new DianCai_frame().show();
            DC.show();
            DC.jComboBox1.addItem(zuohao);
            DC.jComboBox1.setSelectedItem(zuohao);
            DC.jComboBox1.setEnabled(false);
            this.dispose();
        }
    }
 } catch (SQLException ex) {
        Logger.getLogger(KaiTai_Frame.class.getName()).log(Level.SEVERE, null, ex);
    }    
     
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    this.mainf.setEnabled(true);
    this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here://开台
    int row=0;
    int zhuohao=0;
    row=this.jTable1.getSelectedRow();
    zhuohao= Integer.parseInt((String) this.jTable1.getValueAt(row,0));
    this.jComboBox1.setSelectedIndex(zhuohao);
}//GEN-LAST:event_jTable1MouseClicked

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    // TODO add your handling code here:
    this.mainf.setEnabled(true);
}//GEN-LAST:event_formWindowClosing
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KaiTai_Frame().setVisible(true);
      
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
