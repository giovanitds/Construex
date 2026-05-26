package telas;

import java.sql.*;

public class TelaCadastro extends javax.swing.JFrame {
    
    private int idEditando = -1;
    private String modoEditando = "NOVO"; 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastro.class.getName());
    
    public TelaCadastro() {
    initComponents();
    setTitle("CONSTRUEX 1.0 - Novo Cadastro");
    setLocationRelativeTo(null);
    
    // Atualiza a label/campo com o nome de quem está logado
        txtColaborador.setText("Colaborador(a): " + br.com.construex.Sessao.nomeUsuario);
    
    // Garante que o sistema saiba que não estamos editando ninguém
    this.idEditando = -1;
    this.modoEditando = "NOVO";
    }

    public TelaCadastro(int idProduto, String nome, String fornecedor, int quantidade, double preco) {
    initComponents();
    setTitle("CONSTRUEX 1.0 - Editando Produto #" + idProduto);
    setLocationRelativeTo(null);
    
    // Salva os estados nas variáveis de controle
    this.idEditando = idProduto;
    this.modoEditando = "PRODUTO";
    
    // Preenche os seus JTextFields da tela com os dados antigos (Ajuste os nomes das suas variáveis se forem diferentes!)
    txtProduto.setText(nome);        
    txtFornecedor.setText(fornecedor);
    txtQtd.setText(String.valueOf(quantidade));
    txtPreco.setText(String.valueOf(preco));
    }
    
    public TelaCadastro(int idCliente, String nome, String cpfCnpj, String endereco) {
    initComponents();
    setTitle("CONSTRUEX 1.0 - Editando Cliente #" + idCliente);
    setLocationRelativeTo(null);
    
    // Salva os estados nas variáveis de controle
    this.idEditando = idCliente;
    this.modoEditando = "CLIENTE";
    
    // Preenche os seus JTextFields da tela com os dados antigos (Ajuste os nomes se necessário!)
    txtCliente.setText(nome);
    txtCpfCnpj.setText(cpfCnpj);
    txtContato.setText(endereco);
    
    // Se usar abas, pode forçar a aba do cliente a abrir:
    // seuTabbedPane.setSelectedIndex(1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnCadastrarCliente = new javax.swing.JButton();
        btnLimparCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        btnCadastrarProduto = new javax.swing.JButton();
        btnLimparProduto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtColaborador = new javax.swing.JTextField();
        btnConcluir = new javax.swing.JButton();

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
                .addContainerGap(118, Short.MAX_VALUE)
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
        jLabel2.setText("CADASTRO DE PRODUTOS");

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Código - Nome do Produto:");

        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Fornecedor:");

        txtFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFornecedorActionPerformed(evt);
            }
        });

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });
        txtQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtdKeyTyped(evt);
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
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecoKeyReleased(evt);
            }
        });

        btnCadastrarCliente.setBackground(new java.awt.Color(255, 153, 0));
        btnCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCadastrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        btnLimparCliente.setBackground(new java.awt.Color(255, 0, 0));
        btnLimparCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimparCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCliente.setText("Limpar");
        btnLimparCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparClienteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Nome:");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("CPF / CNPJ:");

        txtCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfCnpjActionPerformed(evt);
            }
        });
        txtCpfCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCpfCnpjKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Endereço e Contato:");

        txtContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContatoActionPerformed(evt);
            }
        });

        btnCadastrarProduto.setBackground(new java.awt.Color(255, 153, 0));
        btnCadastrarProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCadastrarProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarProduto.setText("Cadastrar");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });

        btnLimparProduto.setBackground(new java.awt.Color(255, 0, 0));
        btnLimparProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimparProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparProduto.setText("Limpar");
        btnLimparProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel11)
                            .addComponent(btnCadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(btnLimparProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimparCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrarCliente)
                        .addComponent(btnLimparCliente))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrarProduto)
                        .addComponent(btnLimparProduto)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("CADASTRO DE CLIENTES");

        txtColaborador.setEditable(false);
        txtColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColaboradorActionPerformed(evt);
            }
        });

        btnConcluir.setBackground(new java.awt.Color(0, 51, 255));
        btnConcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnConcluir.setText("CONCLUIR");
        btnConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConcluir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoActionPerformed

    private void txtFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFornecedorActionPerformed

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        String texto = txtQtd.getText();

// Se o texto não estiver vazio e não for composto apenas por números
if (!texto.isEmpty() && !texto.matches("\\d+")) {
    // Exibe o aviso educado
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Digite somente números!", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    
    // Remove tudo o que não for número do campo automaticamente
    txtQtd.setText(texto.replaceAll("[^0-8-9]", ""));
}
    }//GEN-LAST:event_txtQtdActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        String texto = txtPreco.getText();

// Verifica se o texto contém letras ou símbolos inválidos (permite apenas números, pontos e vírgulas)
if (!texto.isEmpty() && !texto.matches("[0-9.,]*")) {
    
    // 1. Exibe o aviso direto para o preço
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Este campo aceita apenas números e separadores decimais.", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    
    // 2. Remove na hora as letras e mantém apenas os números, pontos e vírgulas
    txtPreco.setText(texto.replaceAll("[^0-9.,]", ""));
}
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        // Captura os dados dos seus JTextFields de Cliente
String nomeCli = txtCliente.getText().trim();
String cpfCnpj = txtCpfCnpj.getText().trim();
String endereco = txtContato.getText().trim();

if (nomeCli.isEmpty() || cpfCnpj.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha o nome e o CPF/CNPJ do cliente.");
    return;
}

// 🇧🇷 Força os botões em Português
Object[] opcoes = {"Sim", "Não"};

// Definição dinâmica do texto da pergunta baseado no modo atual
String mensagemPergunta = modoEditando.equals("CLIENTE") ? 
    "Deseja salvar as alterações feitas neste cliente?" : 
    "Confirma o cadastro deste novo cliente no sistema?";

// 🛑 BARREIRA DE SEGURANÇA PERSONALIZADA
int resposta = javax.swing.JOptionPane.showOptionDialog(
        this, 
        mensagemPergunta, 
        "Confirmar Gravação", 
        javax.swing.JOptionPane.YES_NO_OPTION, 
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null, 
        opcoes, // Array com os textos dos botões em PT-BR
        opcoes[0] // Foca no botão "Sim"
);

// Se o usuário clicar em "Não" (retorno diferente de 0), o código para aqui
if (resposta != 0) {
    System.out.println("Gravação de cliente cancelada pelo operador.");
    return;
}

// Se clicou em "Sim" (retorno 0), o fluxo prossegue para o banco de dados:
if (modoEditando.equals("CLIENTE")) {
    // Modo Edição -> Executa o UPDATE
    String sqlUpdateCliente = "UPDATE clientes SET nome = ?, cpf_cnpj = ?, endereco = ? WHERE id_cliente = ?";
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sqlUpdateCliente)) {
        
        pst.setString(1, nomeCli);
        pst.setString(2, cpfCnpj);
        pst.setString(3, endereco);
        pst.setInt(4, idEditando);
        
        pst.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(this, "Dados do cliente atualizados com sucesso!");
        
        // Retorna para a tela de consultas
        TelaConsultas telaCons = new TelaConsultas();
        telaCons.setLocationRelativeTo(null); // Centraliza ao reabrir
        telaCons.setVisible(true);
        this.dispose();
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar cliente: " + e.getMessage());
    }
} else {
    // Modo Padrão -> Executa o INSERT de cliente (O seu código original)
    String sqlInsertCliente = "INSERT INTO clientes (nome, cpf_cnpj, endereco) VALUES (?, ?, ?)";
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sqlInsertCliente)) {
        
        pst.setString(1, nomeCli);
        pst.setString(2, cpfCnpj);
        pst.setString(3, endereco);
        
        pst.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
        
        // Se quiser redirecionar ou limpar o formulário para um novo cliente, pode fazer aqui
        TelaConsultas telaCons = new TelaConsultas();
        telaCons.setLocationRelativeTo(null);
        telaCons.setVisible(true);
        this.dispose();
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar cliente: " + e.getMessage());
    }
}
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnLimparClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparClienteActionPerformed
       // 🇧🇷 Força os botões em Português
Object[] opcoes = {"Sim", "Não"};

// 🛑 BARREIRA DE SEGURANÇA PERSONALIZADA
int resposta = javax.swing.JOptionPane.showOptionDialog(
        this, 
        "Deseja mesmo limpar os campos de cliente?", 
        "Confirmar Limpeza", 
        javax.swing.JOptionPane.YES_NO_OPTION, 
        javax.swing.JOptionPane.WARNING_MESSAGE, // Alerta amarelo para perda de dados digitados
        null, 
        opcoes, // Array com os textos traduzidos
        opcoes[1] // Foca no "Não" por segurança
);

// No showOptionDialog, o índice 0 significa que clicou em "Sim"
if (resposta == 0) {
    txtCliente.setText("");
    txtCpfCnpj.setText("");
    txtContato.setText("");
    
    txtCliente.requestFocus(); // Devolve o cursor para o primeiro campo de cliente
} else {
    System.out.println("Limpeza de campos de cliente cancelada.");
}
    }//GEN-LAST:event_btnLimparClienteActionPerformed

    private void btnConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcluirActionPerformed
        // 1. Define explicitamente os botões em português
Object[] opcoes = {"Sim", "Não"};

// 2. Pergunta ao usuário se ele deseja mesmo sair da tela de cadastros
int resposta = javax.swing.JOptionPane.showOptionDialog(
        this, 
        "Deseja mesmo sair da tela de Cadastros?", 
        "Confirmar Saída", 
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes,
        opcoes[0] // Define o "Sim" como foco padrão
);

// 3. Se a resposta for SIM (posição 0 do array), fecha a tela atual e abre o Dashboard
if (resposta == 0) { 
    try {
        TelaDashboard telaDash = new TelaDashboard();
        telaDash.setLocationRelativeTo(null);
        telaDash.setVisible(true);
        
        this.dispose(); // Fecha de forma limpa a TelaCadastro
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, 
                "Erro ao retornar para o Dashboard: " + e.getMessage(), 
                "Erro de Sistema", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}
// 4. Se a resposta for NÃO (posição 1 ou fechar a janela), o código simplesmente termina aqui 
// e o operador continua exatamente onde estava na tela de cadastros.
    }//GEN-LAST:event_btnConcluirActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        String texto = txtCliente.getText();

// Se o texto contiver números
if (!texto.isEmpty() && texto.matches(".*\\d.*")) {
    // Exibe o aviso educado
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Digite somente letras!", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    
    // Remove todos os números do campo automaticamente
    txtCliente.setText(texto.replaceAll("[0-8-9]", ""));
}// TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfCnpjActionPerformed

    private void txtContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContatoActionPerformed

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        // Captura os dados dos seus JTextFields de Produto
String nome = txtProduto.getText().trim();
String supplier = txtFornecedor.getText().trim();

// Validação simples para não dar erro de conversão se o campo estiver vazio
if (nome.isEmpty() || txtQtd.getText().isEmpty() || txtPreco.getText().isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios do produto.");
    return;
}

// 🇧🇷 Força os botões em Português
Object[] opcoes = {"Sim", "Não"};

// Definição dinâmica do texto da pergunta baseado no modo atual
String mensagemPergunta = modoEditando.equals("PRODUTO") ? 
    "Deseja salvar as alterações feitas neste produto?" : 
    "Confirma o cadastro deste novo produto no sistema?";

// 🛑 BARREIRA DE SEGURANÇA PERSONALIZADA
int resposta = javax.swing.JOptionPane.showOptionDialog(
        this, 
        mensagemPergunta, 
        "Confirmar Gravação", 
        javax.swing.JOptionPane.YES_NO_OPTION, 
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null, 
        opcoes, // Array com os textos dos botões em PT-BR
        opcoes[0] // Foca no botão "Sim"
);

// Se o usuário clicar em "Não" (retorno diferente de 0), o código para aqui
if (resposta != 0) {
    System.out.println("Gravação de produto cancelada pelo operador.");
    return;
}

// Se clicou em "Sim" (retorno 0), o fluxo prossegue para o banco de dados:
int qtd = Integer.parseInt(txtQtd.getText().trim());
String precoTexto = txtPreco.getText().trim().replace(",", ".");
double preco = Double.parseDouble(precoTexto);

// DECISÃO: Se veio da dashboard (NOVO) ou se veio da TelaConsultas (PRODUTO)
if (modoEditando.equals("PRODUTO")) {
    // Modo Edição -> Executa o UPDATE
    String sqlUpdate = "UPDATE produtos SET nome_produto = ?, fornecedor = ?, quantidade = ?, preco = ? WHERE id_produto = ?";
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sqlUpdate)) {
        
        pst.setString(1, nome);
        pst.setString(2, supplier);
        pst.setInt(3, qtd);
        pst.setDouble(4, preco);
        pst.setInt(5, idEditando); // O ID que capturamos da linha da tabela
        
        pst.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
        
        // Retorna para a tela de consultas para ver o resultado
        TelaConsultas telaCons = new TelaConsultas();
        telaCons.setLocationRelativeTo(null); // Centraliza a tela ao abrir
        telaCons.setVisible(true);
        this.dispose();
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao atualizar produto: " + e.getMessage());
    }
} else {
    // Modo Padrão -> Executa o INSERT (O seu código original de cadastro)
    String sqlInsert = "INSERT INTO produtos (nome_produto, fornecedor, quantidade, preco) VALUES (?, ?, ?, ?)";
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sqlInsert)) {
        
        pst.setString(1, nome);
        pst.setString(2, supplier);
        pst.setInt(3, qtd);
        pst.setDouble(4, preco);
        
        pst.executeUpdate();
        javax.swing.JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        
        // Se quiser que a tela de consultas abra logo após cadastrar um novo:
        TelaConsultas telaCons = new TelaConsultas();
        telaCons.setLocationRelativeTo(null);
        telaCons.setVisible(true);
        this.dispose();
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto: " + e.getMessage());
    }
}
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnLimparProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparProdutoActionPerformed
        // 🇧🇷 Força os botões em Português
Object[] opcoes = {"Sim", "Não"};

// 🛑 BARREIRA DE SEGURANÇA PERSONALIZADA
int resposta = javax.swing.JOptionPane.showOptionDialog(
        this, 
        "Deseja mesmo limpar os campos de produto?", 
        "Confirmar Limpeza", 
        javax.swing.JOptionPane.YES_NO_OPTION, 
        javax.swing.JOptionPane.WARNING_MESSAGE, // Ícone amarelo de alerta
        null, 
        opcoes, // Array com os textos traduzidos
        opcoes[1] // Foca no "Não" por segurança (evita que um "Enter" acidental apague tudo)
);

// No showOptionDialog, o índice 0 é o "Sim"
if (resposta == 0) {
    txtProduto.setText("");
    txtFornecedor.setText("");
    txtQtd.setText("");
    txtPreco.setText("");
    
    txtProduto.requestFocus(); // Devolve o cursor para o primeiro campo
} else {
    System.out.println("Limpeza de campos cancelada.");
}
    }//GEN-LAST:event_btnLimparProdutoActionPerformed

    private void txtQtdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyTyped
    char c = evt.getKeyChar();

// Verifica se NÃO é um número
if (c < '0' || c > '9') {
    evt.consume(); // 1º Passo: Destrói o caractere imediatamente (não aparece na tela)
    
    // 2º Passo: Exibe o aviso para o operador
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Digite somente números!", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_txtQtdKeyTyped

    private void txtClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteKeyTyped

    private void txtClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyReleased
    String texto = txtCliente.getText();

// Se o texto contiver números
if (!texto.isEmpty() && texto.matches(".*\\d.*")) {
    // Exibe o aviso educado
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Digite somente letras!", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
    
    // Remove todos os números do campo automaticamente
    txtCliente.setText(texto.replaceAll("[0-8-9]", ""));
}
    }//GEN-LAST:event_txtClienteKeyReleased

    private void txtPrecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyReleased
        String texto = txtPreco.getText();

// 1. Se o texto contiver qualquer letra ou caractere inválido
if (!texto.isEmpty() && !texto.matches("[0-9.,]*")) {
    
    // 2. FORÇA a limpeza imediata do campo limpando a letra da tela ANTES do aviso abrir
    txtPreco.setText(texto.replaceAll("[^0-9.,]", ""));
    
    // 3. Exibe o aviso para o operador
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Este campo aceita apenas números e separadores decimais.", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
}// TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoKeyReleased

    private void txtCpfCnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfCnpjKeyReleased
        String texto = txtCpfCnpj.getText();

// 1. Se o texto contiver qualquer letra ou caractere inválido (aceita apenas números)
if (!texto.isEmpty() && !texto.matches("\\d*")) {
    
    // 2. FORÇA a limpeza imediata do campo, arrancando a letra ANTES do aviso abrir
    txtCpfCnpj.setText(texto.replaceAll("[^0-9]", ""));
    
    // 3. Exibe o aviso direto para o operador
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Este campo aceita apenas números.", 
            "Aviso de Digitação", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_txtCpfCnpjKeyReleased

    private void txtColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColaboradorActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnConcluir;
    private javax.swing.JButton btnLimparCliente;
    private javax.swing.JButton btnLimparProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtColaborador;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}
