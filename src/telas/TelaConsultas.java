package telas;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TelaConsultas extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaConsultas.class.getName());

    /**
     * Creates new form TelaConsultas
     */
    public TelaConsultas() {
        initComponents();
        setTitle("CONSTRUEX 1.0 - Consultas");
        setLocationRelativeTo(null);
    
        // Atualiza a label/campo com o nome de quem está logado
        txtColaborador.setText("Colaborador(a): " + br.com.construex.Sessao.nomeUsuario);
    
        // Trava de segurança para Funcionários (Esconde os botões de alteração)
        if (br.com.construex.Sessao.perfilUsuario.equalsIgnoreCase("Funcionário")) {
            // Botões dos Produtos
            //btnEditarProdutos.setVisible(false);
            btnApagarProdutos.setVisible(false);
            
            // Botões dos Clientes
            //btnEditarClientes.setVisible(false);
            btnApagarClientes.setVisible(false);
            
            // Nota: Mantivemos o btnConcluir visível para o Funcionário conseguir voltar à Dashboard
        }
        
        // Inicializa as tabelas trazendo tudo do banco assim que a tela abre
        pesquisarProdutos("");
        pesquisarClientes("");
        
        estilizarTabelasZebra();
        
        tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);   // ID (Estrito para números)
        tblProdutos.getColumnModel().getColumn(1).setPreferredWidth(180);  // Produto (Mais espaço para texto)
        tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(140);  // Fornecedor (Espaço moderado)
        tblProdutos.getColumnModel().getColumn(3).setPreferredWidth(75);   // Quantidade (Número pequeno)
        tblProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);  // Preço (Valor monetário)

        // ====================================================================
        // AJUSTE DE LARGURA DAS COLUNAS (tblClientes)
        // Colunas: 0=ID, 1=Nome, 2=CPF/CNPJ, 3=Endereço
        // ====================================================================
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(50);   // ID
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(180);  // Nome (Mais espaço para o nome completo)
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(115);  // CPF/CNPJ (Tamanho fixo de documento)
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(200);  // Endereço (Bastante espaço para ruas/números)
    } // <-- AQUI: Chave de fechamento do Construtor que estava faltando!

    // ==========================================
    // MÉTODOS NATIVOS DE PESQUISA (BANCO DE DADOS)
    // ==========================================
    
    public void pesquisarProdutos(String termo) {
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0); 
        
        // Busca tanto por Nome quanto pelo ID se o usuário digitar número!
        String sql = "SELECT * FROM produtos WHERE nome_produto LIKE ? OR id_produto LIKE ?";
        
        try (Connection con = br.com.construex.Conexao.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, termo + "%");
            pst.setString(2, termo + "%");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_produto"),
                    rs.getString("nome_produto"),
                    rs.getString("fornecedor"),
                    rs.getInt("quantidade"),
                    rs.getDouble("preco")
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao buscar produtos: " + e.getMessage());
        }
    }

    public void pesquisarClientes(String termo) {
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);
        
        String sql = "SELECT * FROM clientes WHERE nome LIKE ? OR id_cliente LIKE ?";
        
        try (Connection con = br.com.construex.Conexao.conectar();
             PreparedStatement pst = con.prepareStatement(sql)) {
            
            pst.setString(1, termo + "%");
            pst.setString(2, termo + "%");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_cliente"),
                    rs.getString("nome"),
                    rs.getString("cpf_cnpj"),
                    rs.getString("endereco")
                });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao buscar clientes: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnApagarProdutos = new javax.swing.JButton();
        btnApagarClientes = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnConcluir = new javax.swing.JButton();
        txtColaborador = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("CONSULTA DE PRODUTOS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("CONSULTA DE CLIENTES");

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Fornecedor", "Quantidade", "Preço Un. (R$)"
            }
        ));
        jScrollPane2.setViewportView(tblProdutos);

        btnApagarProdutos.setBackground(new java.awt.Color(255, 0, 0));
        btnApagarProdutos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnApagarProdutos.setForeground(new java.awt.Color(255, 255, 255));
        btnApagarProdutos.setText("Apagar");
        btnApagarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarProdutosActionPerformed(evt);
            }
        });
        btnApagarProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnApagarProdutosKeyReleased(evt);
            }
        });

        btnApagarClientes.setBackground(new java.awt.Color(255, 0, 0));
        btnApagarClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnApagarClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnApagarClientes.setText("Apagar");
        btnApagarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarClientesActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF/CNPJ", "Endereço"
            }
        ));
        jScrollPane3.setViewportView(tblClientes);

        btnConcluir.setBackground(new java.awt.Color(0, 51, 255));
        btnConcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnConcluir.setText("CONCLUIR");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        txtColaborador.setEditable(false);
        txtColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnApagarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(btnApagarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(402, 402, 402))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                                .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApagarProdutos)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApagarClientes)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluir)
                    .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CONSTRUEX MATERIAIS DE CONSTRUÇÃO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
       // 1. Define explicitamente os botões em português
    Object[] opcoes = {"Sim", "Não"};

    // 2. Pergunta ao usuário se ele deseja mesmo sair
    int resposta = javax.swing.JOptionPane.showOptionDialog(
            this,
            "Deseja fechar a tela de Consultas?",
            "Confirmar Saída",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[0]
    );

    // 3. Se a resposta for SIM
    if (resposta == 0) {
        try {
            // AQUI ESTÁ O PULO DO GATO:
            // 1. Fecha a tela de consultas primeiro para liberar o banco
            this.dispose(); 
            
            // 2. Instancia o Dashboard. Como o construtor do Dashboard chama 
            //    o atualizarContadores() e o carregarAlertas(), ele fará 
            //    novas consultas (SELECT) ao banco, trazendo os valores atualizados.
            TelaDashboard telaDash = new TelaDashboard();
            telaDash.setLocationRelativeTo(null);
            telaDash.setVisible(true);
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    "Erro ao retornar para o Dashboard: " + e.getMessage(),
                    "Erro de Sistema",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            // Se der erro, reabre a tela de consultas para não deixar o usuário perdido
            this.setVisible(true); 
        }
    }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void btnApagarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarProdutosActionPerformed
        int linhaSelecionada = tblProdutos.getSelectedRow();
        
if (linhaSelecionada == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto na tabela para apagar.");
    return;
}

// 🇧🇷 Força os botões em Português
Object[] opcoes = {"Sim", "Não"};

// 🛑 BARREIRA DE SEGURANÇA PERSONALIZADA
int confirmar = javax.swing.JOptionPane.showOptionDialog(
        this, 
        "Tem certeza que deseja apagar este produto permanentemente do banco de dados?", 
        "Atenção - Exclusão", 
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE,
        null,
        opcoes, // Array com os textos dos botões
        opcoes[1] // Botão padrão focado por segurança (Não)
);
        
if (confirmar == 0) { // 0 significa que clicou em "Sim"
    int idProduto = (int) tblProdutos.getValueAt(linhaSelecionada, 0);
    String sql = "DELETE FROM produtos WHERE id_produto = ?";
    
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sql)) {
         
        pst.setInt(1, idProduto);
        pst.executeUpdate();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
        pesquisarProdutos(""); 
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao apagar produto: " + e.getMessage());
    }
}
    }//GEN-LAST:event_btnApagarProdutosActionPerformed

    private void btnApagarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarClientesActionPerformed
    int linhaSelecionada = tblClientes.getSelectedRow();
            
if (linhaSelecionada == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela para apagar.");
    return;
}

// 🇧🇷 Força os botões em Português
Object[] opcoes = {"Sim", "Não"};

// 🛑 BARREIRA DE SEGURANÇA PERSONALIZADA
int confirmar = javax.swing.JOptionPane.showOptionDialog(
        this, 
        "Tem certeza que deseja apagar este cliente permanentemente?", 
        "Atenção - Exclusão", 
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE,
        null,
        opcoes, // Array com os textos dos botões
        opcoes[1] // Botão padrão focado por segurança (Não)
);
        
if (confirmar == 0) { // 0 significa que clicou em "Sim"
    int idCliente = (int) tblClientes.getValueAt(linhaSelecionada, 0);
    String sql = "DELETE FROM clientes WHERE id_cliente = ?";
    
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sql)) {
         
        pst.setInt(1, idCliente);
        pst.executeUpdate();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
        pesquisarClientes(""); 
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao apagar cliente: " + e.getMessage());
    }
}
    }//GEN-LAST:event_btnApagarClientesActionPerformed

    private void txtColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColaboradorActionPerformed

    private void btnApagarProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnApagarProdutosKeyReleased
        
    }//GEN-LAST:event_btnApagarProdutosKeyReleased

    private void estilizarTabelasZebra() {
        // 1. Configurações de Fontes
        java.awt.Font fonteCabecalho = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12);
        java.awt.Font fonteLinha = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 12);

        // 2. Renderizador das Linhas (Zebra)
        javax.swing.table.DefaultTableCellRenderer renderizadorZebra = new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(fonteLinha);
                
                if (isSelected) {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getSelectionForeground());
                } else {
                    // Alterna: linhas pares cinza claro, ímpares branco puro
                    if (row % 2 == 0) {
                        c.setBackground(new java.awt.Color(245, 245, 245)); 
                    } else {
                        c.setBackground(java.awt.Color.WHITE); 
                    }
                    c.setForeground(java.awt.Color.BLACK); 
                }
                return c;
            }
        };
        renderizadorZebra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // 3. Renderizador do Cabeçalho
        javax.swing.table.DefaultTableCellRenderer renderizadorCabecalho = new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setFont(fonteCabecalho);
                c.setBackground(new java.awt.Color(230, 230, 230)); // Fundo do cabeçalho em cinza fosco
                c.setForeground(new java.awt.Color(0, 51, 255));     // Texto no azul padrão da Construex
                
                javax.swing.JComponent jc = (javax.swing.JComponent) c;
                jc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
                
                return c;
            }
        };
        renderizadorCabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // 4. Aplica os efeitos de forma dinâmica na tblProdutos
        for (int i = 0; i < tblProdutos.getColumnCount(); i++) {
            tblProdutos.getColumnModel().getColumn(i).setCellRenderer(renderizadorZebra);
        }
        tblProdutos.getTableHeader().setDefaultRenderer(renderizadorCabecalho);
        tblProdutos.setRowHeight(28); // Altura limpa e confortável
        tblProdutos.setShowGrid(false);
        tblProdutos.setShowHorizontalLines(true); // Linhas sutis divisórias
        tblProdutos.setGridColor(new java.awt.Color(230, 230, 230));

        // 5. Aplica os mesmos efeitos de forma dinâmica na tblClientes
        for (int i = 0; i < tblClientes.getColumnCount(); i++) {
            tblClientes.getColumnModel().getColumn(i).setCellRenderer(renderizadorZebra);
        }
        tblClientes.getTableHeader().setDefaultRenderer(renderizadorCabecalho);
        tblClientes.setRowHeight(28);
        tblClientes.setShowGrid(false);
        tblClientes.setShowHorizontalLines(true);
        tblClientes.setGridColor(new java.awt.Color(230, 230, 230));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaConsultas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagarClientes;
    private javax.swing.JButton btnApagarProdutos;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtColaborador;
    // End of variables declaration//GEN-END:variables
}
