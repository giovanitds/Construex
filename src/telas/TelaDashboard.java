package telas;

import java.sql.*;
import br.com.construex.Sessao;

public class TelaDashboard extends javax.swing.JFrame {
    
    private void atualizarContadores() {
    // Agora usando os componentes reais do seu initComponents()
    jLabel5.setText(String.valueOf(contarProdutos()));   // Atualiza os produtos
    jLabel10.setText(String.valueOf(contarClientes()));  // Atualiza os clientes
    jLabel3.setText(String.format("R$ %.2f", calcularFaturamento())); // Atualiza o faturamento
}

private int contarProdutos() {
    // Começa com os 5 que você pediu + o que estiver no banco
    int total = 5; 
    String sql = "SELECT COUNT(*) FROM produtos";
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
            total += rs.getInt(1);
        }
    } catch (Exception e) {
        System.out.println("Erro ao contar produtos: " + e.getMessage());
    }
    return total;
}

private int contarClientes() {
    // Começa com os 5 que você pediu + o que estiver no banco
    int total = 5; 
    String sql = "SELECT COUNT(*) FROM clientes";
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
            total += rs.getInt(1);
        }
    } catch (Exception e) {
        System.out.println("Erro ao contar clientes: " + e.getMessage());
    }
    return total;
}

private double calcularFaturamento() {
    // Começa com o valor base de R$ 4.508,76
    double faturamentoTotal = 4508.76; 
    
    // Substitua 'vendas' e 'valor_venda' pelos nomes reais da sua tabela/coluna de vendas
    String sql = "SELECT SUM(valor_venda) FROM vendas"; 
    try (Connection con = br.com.construex.Conexao.conectar();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        if (rs.next()) {
            faturamentoTotal += rs.getDouble(1);
        }
    } catch (Exception e) {
        System.out.println("Erro ao calcular faturamento: " + e.getMessage());
    }
    return faturamentoTotal;
}
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaDashboard.class.getName());

    public TelaDashboard() {
        initComponents();
        setLocationRelativeTo(null);
        atualizarContadores();
        setTitle("CONSTRUEX 1.0");
    
    // Atualiza o label com o nome da pessoa que logou (João, Paulo ou Ana)
    txtColaborador.setText("Colaborador(a): " + Sessao.nomeUsuario);
        
        // 1. Criamos as fontes personalizadas
    java.awt.Font fonteCabecalho = new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12);
    java.awt.Font fonteLinha = new java.awt.Font("Tahoma", java.awt.Font.ITALIC, 12);

    // 2. Criamos o renderizador "Zebra" para as linhas do miolo
    javax.swing.table.DefaultTableCellRenderer renderizadorZebra = new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(fonteLinha); // Aplica o itálico
        
        // Se a linha for selecionada pelo usuário, mantém a cor padrão de seleção
        if (isSelected) {
            c.setBackground(table.getSelectionBackground());
            c.setForeground(table.getSelectionForeground());
        } else {
            // O PULO DO GATO: Se a linha for par (0, 2, 4...), pinta de cinza bem clarinho. Se for ímpar, fica branca.
            if (row % 2 == 0) {
                c.setBackground(new java.awt.Color(240, 240, 240)); // Cinza claro elegante
            } else {
                c.setBackground(java.awt.Color.WHITE); // Branco
            }
            c.setForeground(java.awt.Color.BLACK); // Texto sempre preto
        }
        return c;
    }
    };
    renderizadorZebra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Centraliza as linhas

    // 3. Aplicamos o renderizador Zebra nas três colunas (0, 1 e 2)
    tabelaAlertas.getColumnModel().getColumn(0).setCellRenderer(renderizadorZebra);
    tabelaAlertas.getColumnModel().getColumn(1).setCellRenderer(renderizadorZebra);
    tabelaAlertas.getColumnModel().getColumn(2).setCellRenderer(renderizadorZebra);

    // 4. Criamos o renderizador para o cabeçalho (Negrito + Borda Inferior Cinza)
    javax.swing.table.DefaultTableCellRenderer renderizadorCabecalho = new javax.swing.table.DefaultTableCellRenderer() {
    @Override
    public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        java.awt.Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(fonteCabecalho);
        c.setBackground(new java.awt.Color(230, 230, 230)); // Dá um leve destaque cinza no fundo do cabeçalho também
        
        // Borda sutil embaixo do cabeçalho para separar do miolo
        javax.swing.JComponent jc = (javax.swing.JComponent) c;
        jc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.LIGHT_GRAY));
        
        return c;
    }
    };
    renderizadorCabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    tabelaAlertas.getTableHeader().setDefaultRenderer(renderizadorCabecalho);

    // 5. Configuração das Linhas da Grade (Visual Clean)
    tabelaAlertas.setShowGrid(false);             // Remove a malha de linhas tradicional
    tabelaAlertas.setShowHorizontalLines(false);   // Remove as linhas horizontais (as faixas coloridas já separam)
    tabelaAlertas.setShowVerticalLines(false);     // Remove as linhas verticais que dividem as colunas

    // 6. Mantém a altura das linhas confortável
    tabelaAlertas.setRowHeight(32);

    // 7. Atualiza o visual
    tabelaAlertas.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlertas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnCadastros = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnLogoff = new javax.swing.JButton();
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
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Clientes Cadastrados");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel10.setText("16");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel10)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Produtos em Estoque");

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setText("Clientes Cadastrados");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setText("14");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Faturamento Diário");

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        jLabel9.setText("Clientes Cadastrados");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("R$ 4.508,76");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(34, 34, 34))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tabelaAlertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Cimento Campeão 50kg", "3", "Comprar"},
                {"Cimento Campeão 25kg", "4", "Comprar"},
                {"LED 100W Eletrix", "1", "Comprar"},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Qtd. Atual", "Ação"
            }
        ));
        tabelaAlertas.setRowHeight(30);
        jScrollPane1.setViewportView(tabelaAlertas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("ALERTAS DE ESTOQUE BAIXO (ABAIXO DE 5 UNIDADES)");

        btnCadastros.setBackground(new java.awt.Color(0, 51, 255));
        btnCadastros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCadastros.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastros.setText("Cadastros");
        btnCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrosActionPerformed(evt);
            }
        });

        btnVendas.setBackground(new java.awt.Color(0, 204, 51));
        btnVendas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVendas.setForeground(new java.awt.Color(255, 255, 255));
        btnVendas.setText("Vendas");
        btnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasActionPerformed(evt);
            }
        });

        btnConsultas.setBackground(new java.awt.Color(255, 153, 0));
        btnConsultas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultas.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnLogoff.setBackground(new java.awt.Color(255, 0, 0));
        btnLogoff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogoff.setForeground(new java.awt.Color(255, 255, 255));
        btnLogoff.setText("Logoff");
        btnLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoffActionPerformed(evt);
            }
        });

        txtColaborador.setEditable(false);
        txtColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnCadastros)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultas))
                            .addComponent(txtColaborador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastros)
                    .addComponent(btnLogoff)
                    .addComponent(btnConsultas)
                    .addComponent(btnVendas))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrosActionPerformed
        // 1. Pegamos o nome de quem está logado de forma segura
String usuarioLogado = "";
if (Sessao.nomeUsuario != null) {
    usuarioLogado = Sessao.nomeUsuario.trim().toLowerCase();
}

// 2. REGRA DE BLOQUEIO: Se for o Paulo ou a Ana, barra na hora!
if (usuarioLogado.contains("paulo") || usuarioLogado.contains("ana")) {
    
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Acesso Negado!\nFuncionários (Paulo/Ana) não têm permissão para acessar a tela de Cadastros.", 
            "Permissão Insuficiente", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
            
    return; // Para o código aqui e não deixa abrir a tela para eles
}

// 3. FLUXO DO GERENTE: Se o Java passar do 'if' acima, significa que NÃO é funcionário.
// Portanto, é o Gerente. Aqui o código roda normal:
try {
    TelaCadastro telaCadastro = new TelaCadastro();
    telaCadastro.setLocationRelativeTo(null);
    telaCadastro.setVisible(true);
    this.dispose(); // Fecha o Dashboard com segurança
} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, 
            "Erro ao abrir a tela de Cadastro: " + e.getMessage(), 
            "Erro de Inicialização", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btnCadastrosActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
// 1. Instancia a Tela 2 (Vendas)
TelaVendas telaVendas = new TelaVendas();

// 2. Centraliza a tela de Vendas no meio do monitor
telaVendas.setLocationRelativeTo(null);

// 3. Torna a Tela de Vendas visível para o operador
telaVendas.setVisible(true);

// 4. Fecha/Oculta o Dashboard atual de forma limpa
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
    // 1. Instancia a tela de consultas
    TelaConsultas telaCons = new TelaConsultas();
    
    // 2. Torna a tela de consultas visível
    telaCons.setVisible(true);
    
    // 3. Fecha a Dashboard atual para manter o ambiente limpo
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoffActionPerformed
// 1. Limpa os dados da sessão por segurança
Sessao.nomeUsuario = null;
Sessao.perfilUsuario = null;

// 2. Abre a tela de login usando o nome correto: TelaInicial
TelaInicial telaLogin = new TelaInicial();
telaLogin.setVisible(true);

// 3. Fecha a tela atual (Dashboard / Tela 2) em que o usuário estava
this.dispose();
    }//GEN-LAST:event_btnLogoffActionPerformed

    private void txtColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColaboradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColaboradorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Força o Java Swing a usar as mensagens e botões em Português do Brasil
    javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
    javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
    javax.swing.UIManager.put("OptionPane.cancelButtonText", "Cancelar");
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            TelaDashboard frame = new TelaDashboard();
            frame.setLocationRelativeTo(null); // <--- Isso faz a tela nascer bem no centro do monitor!
            frame.setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCadastros;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnLogoff;
    private javax.swing.JButton btnVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAlertas;
    private javax.swing.JTextField txtColaborador;
    // End of variables declaration//GEN-END:variables
}
