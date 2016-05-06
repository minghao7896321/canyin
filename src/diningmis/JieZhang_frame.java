package diningmis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author  wangqichun
 */
public class JieZhang_frame extends javax.swing.JFrame {
    public JieZhang_frame(Main_Frame main) {
        initComponents();
        this.setDefaultCloseOperation(JieZhang_frame.DISPOSE_ON_CLOSE);
        this.setBounds(260,220, 540,310);
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("菜名");
        tilte.add("数量");
        tilte.add("价格（元）");
        DefaultTableModel Model = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(Model);
        this.main=main;
    }
        public JieZhang_frame() {
        initComponents();
    }
     //数据源URL：
    String theDataSource = "jdbc:hsqldb:hsql://localhost/mydb";
    String theUser = "sa";//数据库的用户名
    String thePassword = ""; //数据库的密码
    Connection theConnection;
    ResultSet rs;
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
     /*取数据库数据(餐桌结帐)**************/
    public void GetData(String zhuohao) throws SQLException {
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("菜名");
        tilte.add("数量");
        tilte.add("价格（元）");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.executeQuery("select * from paybill where zuohao='"+zhuohao+"'");
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Vector col = new Vector();
            for (int i = 3; i <= columnCount; i++) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("结帐");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel1.setText("桌 号:");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel2.setText("应 收:");

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel3.setText("实 收:");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel4.setText("找 零:");

        jButton1.setFont(new java.awt.Font("宋体", 0, 14));
        jButton1.setText("结帐");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("宋体", 0, 14));
        jButton2.setText("返回");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("宋体", 0, 14));
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
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("宋体", 0, 18));
        jLabel5.setText("消费明细");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("宋体", 0, 14));

        jTextField2.setFont(new java.awt.Font("宋体", 0, 14));
        jTextField2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField2CaretUpdate(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("宋体", 0, 14));

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "请选择", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel6.setText("元");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
 // TODO add your handling code here:选择桌结帐   
    try {
            String zhuohao = (String) this.jComboBox1.getSelectedItem();
            GetData(zhuohao);
            double count = 0;
            this.executeQuery("select SUM(caiprice) from paybill where zuohao='" + zhuohao + "'");
            while (rs.next()) {
                count = rs.getDouble(1);
            }
            this.jTextField1.setText(""+count+" 元");
            this.jTextField2.setText("");
            this.jTextField3.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(JieZhang_frame.class.getName()).log(Level.SEVERE, null, ex);
        }   
}//GEN-LAST:event_jComboBox1ItemStateChanged

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    this.main.setEnabled(true);
    this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

private void jTextField2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField2CaretUpdate
  // TODO add your handling code here:
    try {
            double shishou = 0,zhaoling = 0, yingshou = 0;
            if(!this.jComboBox1.getSelectedItem().equals("请选择")){
                this.executeQuery("select SUM(caiprice) from paybill where zuohao='" + this.jComboBox1.getSelectedItem() + "'");
            while (rs.next()) {
                yingshou = rs.getDouble(1);
            }
            shishou = Double.parseDouble(this.jTextField2.getText().trim());
            zhaoling = shishou - yingshou;
            this.jTextField3.setText("" + zhaoling + " 元");
            }
        } catch (SQLException ex) {//GEN-LAST:event_jTextField2CaretUpdate
            Logger.getLogger(JieZhang_frame.class.getName()).log(Level.SEVERE, null, ex);
        }
}

private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
// TODO add your handling code here:
//    if(evt.getKeyCode()==KeyEvent.VK_ENTER)
       this.jButton1MouseClicked(null);
       this.dispose();
}//GEN-LAST:event_jButton1KeyReleased

private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
// TODO add your handling code here:
    try {
        if (this.jComboBox1.getSelectedItem() == "请选择"){
            JOptionPane.showConfirmDialog(rootPane, "请选择结帐桌号!!!", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
        else
            if (this.jTextField1.getText().equals("0.0 元"))
            {
                JOptionPane.showMessageDialog(rootPane, "该桌目前无帐单！！！");
                this.jComboBox1.setSelectedIndex(0);
            }
        else{
            double count = 0;
            this.executeQuery("select SUM(caiprice) from paybill where zuohao='" + this.jComboBox1.getSelectedItem() + "'");
            while (rs.next()) {
                count = rs.getDouble(1);
            }
            JOptionPane.showMessageDialog(rootPane,"结帐成功！");
            String Riqi=null;
            Riqi=new Date().toLocaleString();
            Riqi=Riqi.substring(0,Riqi.length()-9);
            this.executeQuery("insert into shouru(ID,Dayshouru ,timeshouru )values(null,'" + count + "','"+ Riqi+"')");
            this.executeQuery("update tableuse set state='无人'where zuohao='" + this.jComboBox1.getSelectedItem() + "'");
            this.executeQuery("delete from paybill where zuohao='" + this.jComboBox1.getSelectedItem() + "'");
            this.jComboBox1.setSelectedIndex(0);
        }
    } catch (SQLException ex) {
        Logger.getLogger(JieZhang_frame.class.getName()).log(Level.SEVERE, null, ex);
    }

}//GEN-LAST:event_jButton1MouseClicked

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    // TODO add your handling code here:
    this.main.setEnabled(true);
}//GEN-LAST:event_formWindowClosing
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JieZhang_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
