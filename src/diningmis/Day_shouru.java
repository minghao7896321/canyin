/*
 * Day_shouru.java
 *
 * Created on 2008年10月6日, 下午7:06
 */

package diningmis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  wangqichun
 */
public class Day_shouru extends javax.swing.JFrame {

    /** Creates new form Day_shouru */
    public Day_shouru() {
        initComponents();
    }
    public Day_shouru(Main_Frame main) {
        initComponents();
        this.setDefaultCloseOperation(DianCai_frame.DISPOSE_ON_CLOSE);     
        this.setBounds(280, 220,525,335);
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("收入金额（元）");
        tilte.add("收入日期");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(myModel);
        this.main=main;
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
      /*刷新菜单**************/
    public void refesh_Table() throws SQLException {
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("收入金额（元）");
        tilte.add("收入日期");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(myModel);
        GetData(myModel);
    }
    /*取数据库数据**************/
    public void GetData(DefaultTableModel myModel) throws SQLException {
        this.executeQuery("select * from shouru");
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

      public void Select_data() throws SQLException {
        Vector contentl = new Vector();
        Vector tilte = new Vector();
        tilte.add("收入金额（元）");
        tilte.add("收入日期");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        String Riqi=new Date().toLocaleString();
        Riqi=Riqi.substring(0,Riqi.length()-9);
        if(this.jComboBox1.getSelectedItem().equals("本日收入"))
        {
            this.executeQuery("select sum(Dayshouru) from shouru where timeshouru='"+ Riqi+"'");
             while (rs.next()) {
                this.jTextField1.setText(rs.getString(1));
             }
            this.executeQuery("select * from shouru where timeshouru='"+Riqi+"'");
        }
        else
        {
            int year=1900+new Date().getYear();
            String riqi=year+"-";
            int month=1+new Date().getMonth();
            riqi="like '%"+riqi+month+"%'";
            this.executeQuery("select sum(Dayshouru) from shouru where timeshouru "+riqi+"");
            if (rs.next()) {
                this.jTextField2.setText(rs.getString(1));
            }
            this.executeQuery("select * from shouru where timeshouru "+riqi+"");
        }
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("财务查询");
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("              收入详细清单");

        jLabel2.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel2.setText("选择查询日期:");

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "选择", "本日收入", "本月收入" }));

        jButton1.setFont(new java.awt.Font("宋体", 0, 14));
        jButton1.setText("返回");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel3.setText("本日收入总计：");

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel4.setText("本月收入总计：");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("宋体", 0, 14));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("宋体", 0, 14));

        jLabel5.setFont(new java.awt.Font("宋体", 0, 14));
        jLabel5.setText("按时间段查询总计：");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("宋体", 0, 14));

        jButton2.setFont(new java.awt.Font("宋体", 0, 14));
        jButton2.setText("查询");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("宋体", 0, 14));
        jButton3.setText("刷新表单");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1))))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here
        this.main.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:;
        if (this.jComboBox1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "请选择查询类别");
        } else {
            try {
                this.Select_data();
            } catch (SQLException ex) {
                Logger.getLogger(Day_shouru.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        Vector contentl = new Vector();
        Vector tilte = new Vector();
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        tilte.add("收入金额(元）");
        tilte.add("收入日期");
        DefaultTableModel myModel = new DefaultTableModel(contentl, tilte);
        this.jTable1.setModel(myModel);
            
    }//GEN-LAST:event_jButton3MouseClicked

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
                new Day_shouru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}
