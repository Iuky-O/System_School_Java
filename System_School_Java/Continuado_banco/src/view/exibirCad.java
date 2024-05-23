
package view;

import control.ConnectBD;
import java.awt.Dimension;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Cadastros;

/**
 *
 * @author Iumy P.F
 */
public class exibirCad extends javax.swing.JFrame {

    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private Cadastros exibirCadastros;
    
    public exibirCad() {
        initComponents();
        
        
        criarTabela();

        exibirCadastros = new Cadastros();
        exibirCadastros.setModeloTabela(modeloTabela);

        modeloTabela.addTableModelListener(e -> {
   
        });

        atualizarTabela();
    }

    private void criarTabela() {

        tabela = new JTable();
        modeloTabela = new DefaultTableModel();

        modeloTabela.addColumn("ID");
        modeloTabela.addColumn("NOME");
        modeloTabela.addColumn("ENDEREÇO");
        modeloTabela.addColumn("SEXO");
        modeloTabela.addColumn("TELEFONE");
        modeloTabela.addColumn("CPF");
        modeloTabela.addColumn("TIPO SANGUINEO");
        modeloTabela.addColumn("FATOR RH");
        modeloTabela.addColumn("CURSO");
        modeloTabela.addColumn("NOME EMERGÊNCIA");
        modeloTabela.addColumn("TEL EMERGÊNCIA");

        tabela.setModel(modeloTabela);

        JScrollPane scrollPane = new JScrollPane(tabela);

        setLayout(null);

        scrollPane.setBounds(50, 150, 900, 400);

        add(scrollPane);
    }

    private void atualizarTabela() {
        
        modeloTabela.setRowCount(0);

        for (Cadastros cad : Cadastros.listaCadastros) {
            exibirCadastros.adicionarCads(cad);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel1.setText("ESTUDANTES CADASTRADOS");

        jButton1.setText("Deletar Estudante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar Informações");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cadastrar Estudante");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/Brasaouepa-mini.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)))))
                .addContainerGap(363, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Função para deletar cadastro
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int index = tabela.getSelectedRow();
        System.out.print(index);
        String id = (String) tabela.getValueAt​(index, 0);
        System.out.print(id);
        
        ConnectBD bd = new ConnectBD();

        if (index != -1) {
            
            bd.deleteCadastros(parseInt(id)); //pois inica-se de 0 no java
            
            ((DefaultTableModel) tabela.getModel()).removeRow(index);
            Cadastros.listaCadastros.remove(index);

        } else {
            
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
        
        bd.desconnectBD();
    }//GEN-LAST:event_jButton1ActionPerformed

    //Função para alterar cadastro
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        
        int index = tabela.getSelectedRow();
        System.out.print(index);
        String campo = null;
        String valor = null;
        
        
        String id = (String) tabela.getValueAt​(index, 0);
        String nome = (String) tabela.getValueAt​(index, 1);
        String endereco = (String) tabela.getValueAt​(index, 2);
        String sexo = (String) tabela.getValueAt​(index, 3);
        String telefone = (String) tabela.getValueAt​(index, 4);
        String num_cpf = (String) tabela.getValueAt​(index, 5);
        String tipo_sangue = (String) tabela.getValueAt​(index, 6);
        String fator_rh = (String) tabela.getValueAt​(index, 7);
        String curso = (String) tabela.getValueAt​(index, 8);
        String nome_emerg = (String) tabela.getValueAt​(index, 9);
        String tel_emerg = (String) tabela.getValueAt​(index, 10);
        
        ConnectBD bd = new ConnectBD();

        if (index != -1) {
            
            String op = JOptionPane.showInputDialog(this, "1 - NOME\n 2 - ENDERECO\n 3 - TELEFONE\n 4 - EMERGENCIA\n Escolha um valor a ser alterado: ");
            
          
            switch(op){
                case "1":
                     nome = JOptionPane.showInputDialog(this, "Digite o novo nome:");
                     
                     Cadastros.listaCadastros.get(index).setNome(nome);
                     modeloTabela.setValueAt(nome, index, 1);
                     
                     campo = "nome";
                     valor = nome;
                        
                    break;
                    
                case "2":
                    endereco = JOptionPane.showInputDialog(this, "Digite o novo endereco:");
                    
                     Cadastros.listaCadastros.get(index).setEndereco(endereco);
                     modeloTabela.setValueAt(endereco, index, 2);
                     
                     campo = "endereco";
                     valor = endereco;
                    break;
                    
                case "3":
                    telefone = JOptionPane.showInputDialog(this, "Digite o novo telefone:");
                    
                     Cadastros.listaCadastros.get(index).setTelefone(telefone);
                     modeloTabela.setValueAt(telefone, index, 4);
                     
                     campo = "telefone";
                     valor = telefone;
                    break;
                    
                    
                case "4":
                    tel_emerg = JOptionPane.showInputDialog(this, "Digite o novo telefone de emergencia:");
                    
                    campo = "tel_emerg";
                    valor = tel_emerg;
                     Cadastros.listaCadastros.get(index).setTel_emerg(tel_emerg);
                     modeloTabela.setValueAt(tel_emerg, index, 10);
                     
                    break;
                    
                default:
                    
                    JOptionPane.showInputDialog(this, "OPCAO INVALIDA!");
                    
                    break;
            }
               
           bd.alterCadastros(campo, valor, parseInt(id));
           

        } else {
            
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
            
        }
        
        bd.desconnectBD();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        new InterfaceGrafica().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(exibirCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(exibirCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(exibirCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(exibirCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new exibirCad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
