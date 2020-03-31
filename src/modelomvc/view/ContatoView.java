package modelomvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelomvc.controller.ContatoController;
import modelomvc.model.ContatoModel;

public class ContatoView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ContatoController controlador;
	
	private JLabel lblid;
	private JLabel lblnome;
	private JLabel lbltelefone;
	
	private JTextField txtid;
	private JTextField txtnome;
	private JTextField txttelefone;
	
	private JButton btnnovo;
	private JButton btnalterar;
	private JButton btnexcluir;
	private JButton btnsalvar;
	
	private String[] colunas = {"Id","Nome","Telefone"};
	private Object[][] FonteDeDados;
	private JTable tabela; 
	
	public ContatoView() {
		super("Agenda de Contatos 1.0");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(352, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		controlador = new ContatoController();
		initLayout();
		initListeners();
		initConfig();
	}
	
	public void abrir() {
		this.setVisible(true);
	}

	private void initLayout() {
		lblid = new JLabel("Id:");
		lblid.setBounds(20, 50, 50, 20);
		this.add(lblid);
		
		txtid = new JTextField("0");
		txtid.setBounds(90, 50, 50, 20);
		this.add(txtid);
		
		lblnome = new JLabel("Nome:");
		lblnome.setBounds(20, 75, 50, 20);
		this.add(lblnome);
		
		txtnome = new JTextField();
		txtnome.setBounds(90, 75, 200, 20);
		this.add(txtnome);
		
		lbltelefone = new JLabel("Telefone:");
		lbltelefone.setBounds(20, 100, 80, 20);
		this.add(lbltelefone);
		
		txttelefone = new JTextField();
		txttelefone.setBounds(90, 100, 100, 20);
		this.add(txttelefone);
		
		btnnovo = new JButton("Novo");
		btnnovo.setBounds(5, 140, 80, 30);
		this.add(btnnovo);
		
		btnsalvar = new JButton("Salvar");
		btnsalvar.setBounds(90, 140, 80, 30);
		this.add(btnsalvar);
		
		btnalterar = new JButton("Alterar");
		btnalterar.setBounds(175, 140, 80, 30);
		this.add(btnalterar);
		
		btnexcluir = new JButton("Excluir");
		btnexcluir.setBounds(260, 140, 80, 30);
		this.add(btnexcluir);
		
		tabela = new JTable(new DefaultTableModel(FonteDeDados,colunas));
		
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(5,180,336,280);
		
		this.add(scrollPane);

		tabela.setFillsViewportHeight(true);

	}
	
	private void initListeners() {
		btnnovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtid.setText("0");
				txtnome.setText("");
				txttelefone.setText("");
				btnnovo.setEnabled(false);
				btnsalvar.setEnabled(true);
				btnalterar.setEnabled(false);
				btnexcluir.setEnabled(false);
				txtnome.requestFocus();
			}
		});
		
		btnsalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.salvar(Integer.valueOf(txtid.getText()),
							txtnome.getText(),
							txttelefone.getText());
					
					JOptionPane.showMessageDialog (null, "Dados Salvo com sucesso!", "ATEN플O!",JOptionPane.INFORMATION_MESSAGE);
					
					txtid.setText("0");
					txtnome.setText("");
					txttelefone.setText("");
					btnnovo.setEnabled(true);
					btnsalvar.setEnabled(false);
					btnalterar.setEnabled(false);
					btnexcluir.setEnabled(false);
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog (null, ex.getMessage(), "ATEN플O!",JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		
		btnalterar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnnovo.setEnabled(false);
				btnsalvar.setEnabled(true);
				btnalterar.setEnabled(false);
				btnexcluir.setEnabled(false);
				txtnome.requestFocus();
				
			}
		});
	
		btnexcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.excluir(Integer.valueOf(txtid.getText()));
					
					txtid.setText("0");
					txtnome.setText("");
					txttelefone.setText("");
					btnnovo.setEnabled(true);
					btnsalvar.setEnabled(false);
					btnalterar.setEnabled(false);
					btnexcluir.setEnabled(false);
					
				}catch (Exception ex) {
					JOptionPane.showMessageDialog (null, ex.getMessage(), "ATEN플O!",JOptionPane.ERROR_MESSAGE);

				}
				
			}
		});
		
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int linha = tabela.getSelectedRow();
				txtid.setText(tabela.getValueAt(linha, 0).toString());
				txtnome.setText(tabela.getValueAt(linha, 1).toString());
				txttelefone.setText(tabela.getValueAt(linha, 2).toString());
				
				btnnovo.setEnabled(true);
				btnsalvar.setEnabled(true);
				btnalterar.setEnabled(false);
				btnexcluir.setEnabled(true);
				txtnome.requestFocus();
			}
		});
		
	}
	
	private void initConfig() {
		
		txtid.setText("0");
		txtnome.setText("");
		txttelefone.setText("");
		btnnovo.setEnabled(true);
		btnsalvar.setEnabled(false);
		btnalterar.setEnabled(false);
		btnexcluir.setEnabled(false);
		
		atualizaTabela();
	}
	
	private void atualizaTabela() {
        try {
			
        	DefaultTableModel tblRemove = (DefaultTableModel)tabela.getModel();
            
            if (tblRemove.getRowCount() > 0){
                for (int i=1;i<=tblRemove.getRowCount();i++){
                    tblRemove.removeRow(i);
                }            
            }
            
			for(ContatoModel contato: controlador.selecionarTodos()) {
				Vector linha = new Vector();
				linha.add(contato.getId());
				linha.add(contato.getNome());
				linha.add(contato.getTelefone());
				
				((DefaultTableModel)tabela.getModel()).addRow(linha); 

			}
			
		}catch (Exception ex) {
			JOptionPane.showMessageDialog (null, ex.getMessage(), "ATEN플O!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
