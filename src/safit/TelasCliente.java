
package safit;

import br.com.icefit.conexao.Conexao;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TelasCliente extends javax.swing.JInternalFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public TelasCliente() {
        initComponents();
        con = Conexao.conectar();
        desabilitarCampos();
    }

/*----------------------------------------------------------------------------*/    
        private void consultar(){
        String sql = "Select * from Cliente where id = ?";
        
        try {
            
            pst = con.prepareStatement(sql);
            pst.setString(1, txtCliId.getText());
            rs = pst.executeQuery();
            if(rs.next()){
                txtCliNome.setText(rs.getString(2));
                txtCliBairro.setText(rs.getString(3));
                txtCliCidade.setText(rs.getString(4));
                txtCliEstado.setText(rs.getString(5));
                txtCliCep.setText(rs.getString(6));
                cbmCliSexo.setSelectedItem(rs.getString(7));
                txtCliCpf.setText(rs.getString(8));
                txtCliRg.setText(rs.getString(9));
                cmbCliCivil.setSelectedItem(rs.getString(10));
                txtCliNasc.setText(rs.getString(11));
                txtCliCel.setText(rs.getString(12));
                txtCliEmail.setText(rs.getString(13));
            }else{
                desabilitarCampos();
                JOptionPane.showMessageDialog(null,"Erro");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
/*----------------------------------------------------------------------------*/
        private void update(){
    String sql = "UPDATE Cliente SET nome=?, bairro=?, cidade=?, estado=?, cep=?, sexo=?, cpf=?, rg=?, civil=?, nasc=?, cel=?, email=? WHERE id=?";
    
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,txtCliNome.getText());
            pst.setString(2,txtCliBairro.getText());
            pst.setString(3,txtCliCidade.getText());
            pst.setString(4,txtCliEstado.getText());
            pst.setString(5,txtCliCep.getText());
            pst.setString(6,cbmCliSexo.getSelectedItem().toString());
            pst.setString(7,txtCliCpf.getText());
            pst.setString(8,txtCliRg.getText());
            pst.setString(9,cmbCliCivil.getSelectedItem().toString());
            pst.setString(10,txtCliNasc.getText());
            pst.setString(11,txtCliCel.getText());
            pst.setString(12,txtCliEmail.getText());
            pst.setString(13,txtCliId.getText());
            int op = pst.executeUpdate();
            if(op>0){
                JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }   
}
/*----------------------------------------------------------------------------*/
private void inserir(){
    String sql = "Insert into Cliente(nome, bairro, cidade , estado, cep, sexo, cpf, rg, civil, nasc, cel, email)"
                    +"values(?,?,?,?,?,?,?,?,?,?,?,?)";
    
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,txtCliNome.getText());
            pst.setString(2,txtCliBairro.getText());
            pst.setString(3,txtCliCidade.getText());
            pst.setString(4,txtCliEstado.getText());
            pst.setString(5,txtCliCep.getText());
            pst.setString(6,cbmCliSexo.getSelectedItem().toString());
            pst.setString(7,txtCliCpf.getText());
            pst.setString(8,txtCliRg.getText());
            pst.setString(9,cmbCliCivil.getSelectedItem().toString());
            pst.setString(10,txtCliNasc.getText());
            pst.setString(11,txtCliCel.getText());
            pst.setString(12,txtCliEmail.getText());
            int op = pst.executeUpdate();
            if(op>0)
                JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
}        
/*----------------------------------------------------------------------------*/
private void deletar(){
    String sql = "DELETE FROM Cliente WHERE id=?";
        int confirma = JOptionPane.showConfirmDialog(null,"Deseja realmente deletar?","Atenção",JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            try{
                pst = con.prepareStatement(sql);
                pst.setString(1, txtCliId.getText());
                int op = pst.executeUpdate();
                if(op>0)
                    JOptionPane.showMessageDialog(null,"Deletado com sucesso!");
                desabilitarCampos();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
        }
    
}
/*----------------------------------------------------------------------------*/
private void desabilitarCampos() {
        
        txtCliNome.setText(null);
        txtCliBairro.setText(null);
        txtCliCidade.setText(null);
        txtCliEstado.setText(null);
        txtCliCep.setText(null);
        cbmCliSexo.setSelectedItem(null);
        txtCliCpf.setText(null);
        txtCliRg.setText(null);
        cmbCliCivil.setSelectedItem(null);
        txtCliNasc.setText(null);
        txtCliCel.setText(null);
        txtCliEmail.setText(null);
    }
/*----------------------------------------------------------------------------*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCliRg = new javax.swing.JTextField();
        txtCliNasc = new javax.swing.JTextField();
        txtCliCel = new javax.swing.JTextField();
        txtCliEmail = new javax.swing.JTextField();
        cbmCliSexo = new javax.swing.JComboBox<>();
        cmbCliCivil = new javax.swing.JComboBox<>();
        bntCliPesquisar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        bntInserir = new javax.swing.JButton();
        bntDeletar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCliId = new javax.swing.JTextField();
        txtCliNome = new javax.swing.JTextField();
        txtCliBairro = new javax.swing.JTextField();
        txtCliCidade = new javax.swing.JTextField();
        txtCliEstado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCliCep = new javax.swing.JTextField();
        txtCliCpf = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        cbmCliSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "masculino", "feminino", "outros" }));

        cmbCliCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "casado", "solteiro", "outros" }));

        bntCliPesquisar.setText("Pesquisar");
        bntCliPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCliPesquisarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        bntInserir.setText("Inserir");
        bntInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntInserirActionPerformed(evt);
            }
        });

        bntDeletar.setText("Deletar");
        bntDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntDeletarActionPerformed(evt);
            }
        });

        jLabel10.setText("RG:");

        jLabel11.setText("Estado Civil:");

        jLabel12.setText("Data Nascimento:");

        jLabel13.setText("CEL:");

        jLabel14.setText("Email:");

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("Estado:");

        jLabel7.setText("CEP:");

        jLabel8.setText("Sexo:");

        jLabel9.setText("CPF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGap(25, 25, 25))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(31, 31, 31)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCliCel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCliCidade)
                                            .addComponent(txtCliEstado)
                                            .addComponent(txtCliBairro)
                                            .addComponent(txtCliNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCliRg, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCliCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(cbmCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbCliCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCliNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bntCliPesquisar)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bntInserir)
                            .addGap(18, 18, 18)
                            .addComponent(bntDeletar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbmCliSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCliCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCliRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCliNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntCliPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(bntInserir)
                    .addComponent(bntDeletar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCliPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCliPesquisarActionPerformed
        consultar();
    }//GEN-LAST:event_bntCliPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        update();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void bntInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntInserirActionPerformed
        inserir();
    }//GEN-LAST:event_bntInserirActionPerformed

    private void bntDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntDeletarActionPerformed
        deletar();
    }//GEN-LAST:event_bntDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCliPesquisar;
    private javax.swing.JButton bntDeletar;
    private javax.swing.JButton bntInserir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cbmCliSexo;
    private javax.swing.JComboBox<String> cmbCliCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCliBairro;
    private javax.swing.JTextField txtCliCel;
    private javax.swing.JTextField txtCliCep;
    private javax.swing.JTextField txtCliCidade;
    private javax.swing.JTextField txtCliCpf;
    private javax.swing.JTextField txtCliEmail;
    private javax.swing.JTextField txtCliEstado;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliNasc;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliRg;
    // End of variables declaration//GEN-END:variables
}
