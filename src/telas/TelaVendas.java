package telas;

import br.com.construex.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.construex.Sessao;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.*;

public class TelaVendas extends javax.swing.JFrame {
    private double valorTotalAcumulado = 0.0;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaVendas.class.getName());
    private java.util.ArrayList<ItemVenda> carrinho = new java.util.ArrayList<>();
    private double totalGeral = 0.0;
    
    
    
    private class ItemVenda {
    String nome;
    int qtd;
    ItemVenda(String n, int q) { this.nome = n; this.qtd = q; }
}
    
    public TelaVendas() {        
        initComponents();
        carregarProdutosNoCombo();
        carregarClientesNoCombo();
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
    
    
    public void carregarProdutosNoCombo() {
        cbProduto.removeAllItems();
        cbProduto.addItem("Selecione um produto..."); // Opcional, para ficar bonito
        
        String sql = "SELECT nome_produto FROM produtos";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                cbProduto.addItem(rs.getString("nome_produto"));
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }
    
    public void carregarClientesNoCombo() {
    // 1. Limpa o combo para evitar duplicatas
    cbCliente.removeAllItems(); 
    cbCliente.addItem("Selecione um cliente..."); 
    
    // 2. Busca apenas os nomes dos clientes na tabela
    String sql = "SELECT nome FROM clientes";
    
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
         
        while (rs.next()) {
            // 3. Adiciona o nome vindo do banco ao combo
            cbCliente.addItem(rs.getString("nome"));
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar clientes: " + e.getMessage());
    }
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
        cbProduto = new javax.swing.JComboBox<>();
        cbCliente = new javax.swing.JComboBox<>();
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
        jLabel9.setText("Cliente:");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Preço Un. (R$):");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Qtd.:");

        txtPreco.setEditable(false);
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

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Item 2", "Item 3", "Item 4" }));
        cbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutoItemStateChanged(evt);
            }
        });
        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione:", "Item 2", "Item 3", "Item 4" }));
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(114, 114, 114))
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
   // 1. TRAVA DO CLIENTE (Nova validação)
    // Verifica se o combo de cliente está na posição padrão (geralmente "Selecione..." ou vazio)
    if (cbCliente.getSelectedIndex() <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Atenção!\nPor favor, selecione o cliente ANTES de adicionar produtos ao carrinho.");
        cbCliente.requestFocus(); // Dá foco ao campo do cliente para o usuário escolher
        return; // Bloqueia e impede o avanço
    }

    // 2. Validações de produto e quantidade
    if (cbProduto.getSelectedIndex() <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione um produto!");
        return;
    }

    String produto = cbProduto.getSelectedItem().toString();
    int qtdDesejada;

    try {
        qtdDesejada = Integer.parseInt(txtQtd.getText().trim());
        if (qtdDesejada <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Digite uma quantidade válida!");
        return;
    }

    // 3. Validação de estoque no banco
    String sqlBusca = "SELECT quantidade FROM produtos WHERE nome_produto = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement pst = conn.prepareStatement(sqlBusca)) {
        
        pst.setString(1, produto);
        try (java.sql.ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                int qtdEstoque = rs.getInt("quantidade");
                
                if (qtdEstoque <= 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Produto indisponível! Estoque zerado.");
                    return;
                }
                
                if (qtdDesejada > qtdEstoque) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Estoque insuficiente!\nQuantidade disponível: " + qtdEstoque);
                    return;
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Produto não encontrado no banco de dados!");
                return;
            }
        }
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao validar estoque: " + e.getMessage());
        return;
    }

    // 4. Cálculos (Só executa se passou por todas as travas acima)
    double precoUnitario = Double.parseDouble(txtPreco.getText().replace(",", "."));
    double subtotalItem = precoUnitario * qtdDesejada;

    // Atualiza a variável global
    totalGeral += subtotalItem;

    // Monta o resumo: "Qtd x Produto = Valor"
    String linha = String.format("%d x %s = R$ %.2f\n", qtdDesejada, produto, subtotalItem);
    txtResumo.append(linha);

    // Limpa para a próxima inserção
    txtQtd.setText("1");
    cbProduto.requestFocus();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
    // 1. Validações visuais essenciais da tela
    if (cbCliente.getSelectedIndex() <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente!");
        return;
    }
    if (cbPagamento.getSelectedIndex() <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione uma forma de pagamento!");
        return; 
    }
    if (totalGeral <= 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "O carrinho está vazio!");
        return;
    }

    // 2. Comandos SQL (Apenas insere a venda e atualiza o estoque)
    String sqlVenda = "INSERT INTO vendas (valor_venda, nome_cliente, forma_pagamento) VALUES (?, ?, ?)";
    String sqlBaixa = "UPDATE produtos SET quantidade = quantidade - ? WHERE nome_produto = ?";

    try (Connection conn = Conexao.conectar()) {
        conn.setAutoCommit(false); // Inicia transação segura para o banco

        // PASSO A: Grava a Venda (Isso já soma o valor ao faturamento no banco)
        try (PreparedStatement stmt = conn.prepareStatement(sqlVenda)) {
            stmt.setDouble(1, totalGeral); 
            stmt.setString(2, cbCliente.getSelectedItem().toString());
            stmt.setString(3, cbPagamento.getSelectedItem().toString());
            stmt.executeUpdate();
        }

        // PASSO B: Dá baixa automática no estoque do produto vendido
        try (PreparedStatement pstBaixa = conn.prepareStatement(sqlBaixa)) {
            int qtdVendida = Integer.parseInt(txtQtd.getText().trim());
            pstBaixa.setInt(1, qtdVendida);
            pstBaixa.setString(2, cbProduto.getSelectedItem().toString());
            pstBaixa.executeUpdate();
        }

        conn.commit(); // Confirma e salva tudo definitivamente no MySQL
        javax.swing.JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");

        // 3. Fecha a tela de vendas e envia o usuário de volta para a Tela 2 (Dashboard)
        this.dispose();
        TelaDashboard telaDashboard = new TelaDashboard(); 
        telaDashboard.setVisible(true);

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao concluir a venda: " + e.getMessage());
    }
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Object[] opcoes = {"Sim", "Não"};

    // CASO 1: O carrinho TEM ITENS -> Pergunta se quer LIMPAR
    if (!txtResumo.getText().isEmpty()) {
        int confirmacaoLimpar = javax.swing.JOptionPane.showOptionDialog(
            this,
            "O carrinho contém itens. Deseja limpar todos os campos?",
            "Limpar Carrinho",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null, opcoes, opcoes[1]
        );

        if (confirmacaoLimpar == 0) { // Clicou em "Sim"
            txtResumo.setText("");
            txtTotal.setText("");
            txtQtd.setText("");
            txtPreco.setText("");
            valorTotalAcumulado = 0.0;
            cbPagamento.setSelectedIndex(0);
            carrinho.clear(); // Limpa a nossa lista de controle!
            javax.swing.JOptionPane.showMessageDialog(this, "Carrinho limpo com sucesso!");
        }
    } 
    // CASO 2: O carrinho ESTÁ VAZIO -> Pergunta se quer SAIR da tela
    else {
        int confirmacaoSair = javax.swing.JOptionPane.showOptionDialog(
            this,
            "Deseja cancelar a operação e retornar?",
            "Retornar ao Dashboard",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE,
            null, opcoes, opcoes[1]
        );

        if (confirmacaoSair == 0) { // Clicou em "Sim"
            TelaDashboard telaDash = new TelaDashboard();
            telaDash.setLocationRelativeTo(null);
            telaDash.setVisible(true);
            this.dispose();
        }
    }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void cbPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagamentoActionPerformed
        if (totalGeral > 0) {
        String totalFormatado = String.format(java.util.Locale.forLanguageTag("pt-BR"), "%.2f", totalGeral);
        txtTotal.setText(totalFormatado);
    }
    }//GEN-LAST:event_cbPagamentoActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        if (cbProduto.getSelectedIndex() <= 0) {
        txtPreco.setText("");
        return;
    }

    String produtoSelecionado = cbProduto.getSelectedItem().toString().trim();
    String sql = "SELECT preco FROM produtos WHERE nome_produto = ?";
    
    // Debug: isso aparecerá no rodapé do NetBeans
    System.out.println("Buscando no banco: " + produtoSelecionado);
    
    try (Connection conn = Conexao.conectar();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.setString(1, produtoSelecionado);
        java.sql.ResultSet rs = pst.executeQuery();
        
        if (rs.next()) {
            double preco = rs.getDouble("preco");
            System.out.println("Preço encontrado: " + preco);
            txtPreco.setText(String.format(java.util.Locale.forLanguageTag("pt-BR"), "%.2f", preco));
        } else {
            System.out.println("Nenhum preço encontrado para este produto.");
            txtPreco.setText("0,00");
        }
        
    } catch (Exception e) {
        System.err.println("ERRO CRÍTICO NO SQL: " + e.getMessage());
    }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // 1. A PROTEÇÃO: Se o ComboBox for nulo ou não tiver seleção, sai imediatamente.
    if (cbCliente.getSelectedItem() == null) {
        return;
    }

    // 2. Se o texto for o nosso "título" de seleção, não faz nada
    if (cbCliente.getSelectedIndex() <= 0) {
        return;
    }

    // 3. Só agora, com segurança, pegamos o valor
    String clienteSelecionado = cbCliente.getSelectedItem().toString();

    try (Connection conn = Conexao.conectar()) {
        conn.setAutoCommit(false);

        // ... (seu loop de baixa de estoque continua aqui)

        // Salva a venda com o cliente
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO vendas (preco, nome_cliente) VALUES (?, ?)")) {
    stmt.setDouble(1, valorTotalAcumulado);
    stmt.setString(2, cbCliente.getSelectedItem().toString());
    stmt.executeUpdate();
    }

        conn.commit();
        // ...
    } catch (Exception e) {
        // ...
    }
    }//GEN-LAST:event_cbClienteActionPerformed

    private void cbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProdutoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProdutoItemStateChanged

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
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbPagamento;
    private javax.swing.JComboBox<String> cbProduto;
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
    private javax.swing.JTextField txtColaborador;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextArea txtResumo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

