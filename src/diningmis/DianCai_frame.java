/*
 * DianCai_frame.java
 *
 * Created on October 1, 2008, 3:33 PM
 */

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

/**
 *
 * @author  wangqichun
 */
public class DianCai_frame extends javax.swing.JFrame {

    public DianCai_frame() throws SQLException {
        initComponents();
    }

    public DianCai_frame(Main_Frame mainf) throws SQLException {
        initComponents();
        this.setDefaultCloseOperation(DianCai_frame.DISPOSE_ON_CLOSE);
        this.setBounds(230, 220, 620,480);
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("桌号");
        tilte.add("菜名");
        tilte.add("数量");
        tilte.add("价格（元）");
        DefaultTableModel Model = new DefaultTableModel(contentl, tilte);
        this.jTable2.setModel(Model);
        refesh_Table1();
        this.mainf = mainf;
    }
      
    //数据源URL：
    String theDataSource = "jdbc:hsqldb:hsql://localhost/mydb";
    String theUser = "sa";//数据库的用户名
    String thePassword = ""; //数据库的密码
    Connection theConnection;
    ResultSet rs;
    private Main_Frame mainf;
    static boolean jiajie=false;


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
     /*取数据库数据**************/
    public void GetData(DefaultTableModel myModel) throws SQLException {
        this.executeQuery("select * from caishiinfo");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Vector col = new Vector();
            for (int i = 1; i <= columnCount; i++) {
                col.add(rs.getString(i));
            }
            myModel.addRow(col);
        }
        this.jTable1.setModel(myModel);
        rs.close();
        theConnection.close();
    }  
   /*刷新菜单**************/
    public void refesh_Table1() throws SQLException {
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("编号");
        tilte.add("菜名");
        tilte.add("价格（元）");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(myModel);
        GetData(myModel);
    }
    /*刷新帐单**************/
    public void refesh_Table2() throws SQLException {
       Vector contentl = new Vector();
        Vector tilte = new Vector();
       // tilte.add("编号");
        tilte.add("桌号");
        tilte.add("菜名");
        tilte.add("数量");
        tilte.add("价格（元）");
        DefaultTableModel Model = new DefaultTableModel(contentl, tilte);
        this.executeQuery("select * from paybill where zuohao='"+this.jComboBox1.getSelectedItem()+"'");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Vector col = new Vector();
            for (int i = 2; i <= columnCount; i++) {
                col.add(rs.getString(i));
            }
            Model.addRow(col);
        }
        this.jTable2.setModel(Model);
    }
    
    /*取数据库数据(帐单信息）**************/
    public void Select_insert(int row) throws SQLException {
        String sql;
        String name=null;
        String price=null;
        String ID=null;
        this.executeQuery("select *from caishiinfo where ID='"+row+"'");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
              name=rs.getString(2);
              price=rs.getString(3);
        }
        sql = "insert into paybill(ID,zuohao,cainame,cainum,caiprice )values(null,'"
        +this.jComboBox1.getSelectedItem()+"','" +name+ "',1,'"+price+ "')";
        this.executeQuery(sql);          
        refesh_Table2();        
        rs.close();
        theConnection.close();
    }  
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("点菜");
        setFont(new java.awt.Font("Algerian", 0, 14)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("宋体", 0, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("宋体", 0, 14));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setFont(new java.awt.Font("宋体", 0, 14));
        jButton1.setText(">>");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("宋体", 0, 14));
        jButton2.setText("<<");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("宋体", 0, 14));
        jButton3.setText("确定");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("宋体", 0, 14));
        jButton4.setText("取消");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel2.setText("金额总计:");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel3.setText("桌 号:");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "请选择", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                        .addComponent(jButton4))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton1)
                        .addGap(86, 86, 86)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
// TODO add your handling code here:点菜按钮
    if (this.jComboBox1.getSelectedItem().equals("请选择"))
        JOptionPane.showMessageDialog(rootPane, "请选择加减菜的桌号！");
    else if (this.jTable1.getSelectedRow() == -1)
        JOptionPane.showMessageDialog(rootPane, "请先选择菜项！");
    else {
        int row = 0;
        row = this.jTable1.getSelectedRow();
        try {
            Select_insert(row);
            this.executeQuery("select SUM(caiprice) from paybill where zuohao='" + this.jComboBox1.getSelectedItem() + "'");
            double count = 0;
            while (rs.next()) {
                count = rs.getDouble(1);
            }
            this.jTextField2.setText("" + count + " 元");
        } catch (SQLException ex) {
            Logger.getLogger(DianCai_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}//GEN-LAST:event_jButton1MouseClicked

private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
// TODO add your handling code here:减菜
    int row = 0;
    row = this.jTable2.getSelectedRow();
    String name = null;
    name = (String) this.jTable2.getValueAt(row, 1);
    this.executeQuery("delete from paybill where cainame='" + name + "'");
    try {
        this.executeQuery("select SUM(caiprice) from paybill where zuohao='" + this.jComboBox1.getSelectedItem() + "'");
        double count = 0;
        while (rs.next()) {
            count = rs.getDouble(1);
        }
        this.jTextField2.setText("" + count + " 元");
            refesh_Table2();//GEN-LAST:event_jButton2MouseClicked
    } catch (SQLException ex) {
        Logger.getLogger(DianCai_frame.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
   if(this.jTextField2.getText().equals("")||this.jTextField2.getText().equals("0.0 元"))
       JOptionPane.showMessageDialog(rootPane,"还未点菜！！！");
   else{
       JOptionPane.showConfirmDialog(rootPane, "点菜成功,请稍等片刻！！", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
       this.mainf.setEnabled(true);
       this.dispose();
   }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
   String zhuohao;
//    if (!DianCai_frame.jiajie) {
        zhuohao = (String) this.jComboBox1.getSelectedItem();
        this.executeQuery("delete from paybill where zuohao='" + zhuohao + "'");
        this.executeQuery("update tableuse set state='无人'where zuohao='" + zhuohao + "'");
    //}
    this.mainf.setEnabled(true);
    this.dispose();
}//GEN-LAST:event_jButton4ActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
    this.jButton4ActionPerformed(null);
}//GEN-LAST:event_formWindowClosing

private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
    try {
        this.jiajie = true;
        this.executeQuery("select state from tableuse where zuohao='" + this.jComboBox1.getSelectedItem().toString() + "'");
        while (rs.next()) {
            if (rs.getString(1).equals("无人")){
                this.jComboBox1.setSelectedIndex(0);
                JOptionPane.showMessageDialog(rootPane, "您还未开台，请先开台！");
            }
        }
        refesh_Table2();
    } catch (SQLException ex) {
        Logger.getLogger(DianCai_frame.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jComboBox1ItemStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DianCai_frame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DianCai_frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public javax.swing.JComboBox jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
