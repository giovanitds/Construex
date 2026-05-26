package telas;

import br.com.construex.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.construex.Sessao;

public class TelaVendas extends javax.swing.JFrame {
    private double valorTotalAcumulado = 0.0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaVendas.class.getName());
    
    public TelaVendas() {        
        initComponents();
        setTitle("CONSTRUEX 1.0");
        
        txtColaborador.setText("Colaborador(a): " + Sessao.nomeUsuario);

        txtQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume(); 
                }
            }
        });

        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != ',') {
                    evt.consume();
                }
            }
        });

        txtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String texto = txtPreco.getText().trim();
                if (!texto.isEmpty()) {
                    try {
                        double valor = Double.parseDouble(texto.replace(",", "."));
                        txtPreco.setText(String.format(java.util.Locale.forLanguageTag("pt-BR"), "%.2f", valor));
                    } catch (NumberFormatException e) {
                        txtPreco.setText("0,00");
                    }
                } else {
                    txtPreco.setText("0,00");
                }
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResumo = new javax.swing.JTextArea();
        cbPagamento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnConcluir = new javax.swing.JButton();
        txtColaborador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSTRUEX MATERIAIS DE CONSTRUÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("IDENTIFICAÇÃO E ITENS");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Código - Nome do Produto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Cliente (CPF / CNPJ):");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Preço Un. (R$):");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Qtd.:");

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        txtResumo.setEditable(false);
        txtResumo.setColumns(20);
        txtResumo.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtResumo.setRows(5);
        jScrollPane2.setViewportView(txtResumo);

        cbPagamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forma de Pagto:", "1 - Dinheiro", "2 - Cartão", "3 - Pix" }));
        cbPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagamentoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("VALOR TOTAL (R$):");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));

        btnAdicionar.setBackground(new java.awt.Color(255, 153, 0));
        btnAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(btnAdicionar)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPreco)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnCancelar)
                                    .addGap(10, 10, 10))))
                        .addComponent(jLabel8)
                        .addComponent(txtProduto))
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("RESUMO DO PEDIDO");

        btnConcluir.setBackground(new java.awt.Color(0, 204, 51));
        btnConcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnConcluir.setText("CONCLUIR VENDA");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        txtColaborador.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConcluir)
                    .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
   String produto = txtProduto.getText().trim();
        String cliente = txtCliente.getText().trim();
        String qtdStr = txtQtd.getText().trim();
        String precoStr = txtPreco.getText().trim();

        if (produto.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Por favor, digite o Produto antes de adicionar!", 
                    "Produto Obrigatório", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            txtProduto.requestFocus();
            return; 
        }

        if (cliente.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Não é possível adicionar produtos!\nPor favor, informe o CPF ou CNPJ do comprador.", 
                    "Identificação Obrigatória", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            txtCliente.requestFocus(); 
            return; 
        }

        if (qtdStr.isEmpty() || precoStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha a quantidade e o preço antes de adicionar!");
            return;
        }

        try {
            int qtd = Integer.parseInt(qtdStr);
            double precoUnidade = Double.parseDouble(precoStr.replace(",", "."));
            double subtotal = qtd * precoUnidade;
            
            valorTotalAcumulado += subtotal;
            
            String novaLinha = qtd + "x " + produto + " - Subtotal: R$ " + String.format("%.2f", subtotal) + "\n";
            txtResumo.append(novaLinha);
            
            txtQtd.setText("");
            txtPreco.setText("");
            
            if (cbPagamento.getSelectedIndex() > 0) {
                txtTotal.setText(String.format(java.util.Locale.forLanguageTag("pt-BR"), "%.2f", valorTotalAcumulado));
            }

            txtProduto.requestFocus();

        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro nos valores informados. Verifique a quantidade e preço.");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
// 1. Validação: Verifica se o carrinho está vazio
        if (txtResumo.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Não é possível concluir a venda!\nO carrinho de compras está vazio.", 
                    "Erro de Operação", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return; 
        }

        // 2. Validação: Verifica a forma de pagamento
        if (cbPagamento.getSelectedIndex() == 0 || txtTotal.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Por favor, selecione uma Forma de Pagamento válida!", 
                    "Aviso", 
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return; 
        }

        // 3. PERGUNTA DE CONFIRMAÇÃO (Com botões explícitos em Português)
        Object[] opcoes = {"Sim", "Não"};
        int confirmacao = javax.swing.JOptionPane.showOptionDialog(
                this,
                "Deseja realmente finalizar e concluir esta venda?",
                "Confirmar Fechamento de Venda",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0] // Foco padrão no botão "Sim"
        );

        // Se o operador clicar em "Não" (posição 1) ou fechar a caixinha no "X"
        if (confirmacao != 0) {
            return; // Aborta a operação aqui mesmo. Nada muda na tela e nada vai pro banco.
        }

        // 4. GRAVAÇÃO NO BANCO DE DADOS (Só roda se o operador clicou em "Sim")
        String sql = "INSERT INTO vendas (valor_venda) VALUES (?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDouble(1, valorTotalAcumulado);
            stmt.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar venda no banco: " + e.getMessage());
            return; // Interrompe caso falhe a gravação
        }

        // 5. MENSAGEM DE SUCESSO FINAL
        String formaPgto = cbPagamento.getSelectedItem().toString();
        javax.swing.JOptionPane.showMessageDialog(this, 
                "Venda realizada com sucesso!\n\n" +
                "Forma de Pagamento: " + formaPgto + "\n" +
                "Valor Total: R$ " + txtTotal.getText(), 
                "CONSTRUEX - Sucesso", 
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

        valorTotalAcumulado = 0.0;

        // 6. RETORNO AO DASHBOARD
        try {
            TelaDashboard telaDash = new TelaDashboard();
            telaDash.setLocationRelativeTo(null);
            telaDash.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "Erro ao retornar para o Dashboard: " + e.getMessage(), 
                    "Erro de Sistema", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (!txtResumo.getText().isEmpty()) {
            txtResumo.setText("");        
            txtTotal.setText("");         
            valorTotalAcumulado = 0.0;    
            cbPagamento.setSelectedIndex(0); 
            javax.swing.JOptionPane.showMessageDialog(this, "Carrinho limpo! Você pode reiniciar a venda.");
        } else {
            TelaDashboard telaDash = new TelaDashboard();
            telaDash.setLocationRelativeTo(null);
            telaDash.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void cbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagamentoActionPerformed
        if (cbPagamento.getSelectedIndex() > 0 && !txtResumo.getText().isEmpty()) {
            txtTotal.setText(String.format(java.util.Locale.forLanguageTag("pt-BR"), "%.2f", valorTotalAcumulado));
        } else {
            txtTotal.setText("");
        }
    }//GEN-LAST:event_cbPagamentoActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaVendas().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JComboBox<String> cbPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtColaborador;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextArea txtResumo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

