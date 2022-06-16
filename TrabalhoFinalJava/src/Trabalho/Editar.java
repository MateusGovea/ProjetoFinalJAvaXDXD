package Trabalho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Trabalho.Arquivo.ManipuladorArquivo;

public class Editar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	public Editar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Criar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(230, 56, 65, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblInstrucao = new JLabel("Digite o nome do arquivo:");
		lblInstrucao.setBounds(72, 183, 158, 14);
		contentPane.add(lblInstrucao);
		
		txtNome = new JTextField();
		txtNome.setBounds(230, 180, 126, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar Agenda");

		btnAdicionar.setBounds(203, 246, 122, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnMenu = new JButton("Voltar");

		btnMenu.setVisible(false);
		btnMenu.setBounds(220, 246, 89, 23);
		contentPane.add(btnMenu);
		
		JLabel lblSucesso = new JLabel("Arquivo Editado com Sucesso");
		lblSucesso.setForeground(Color.GREEN);
		lblSucesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSucesso.setVisible(false);
		lblSucesso.setBounds(165, 163, 203, 14);
		contentPane.add(lblSucesso);
		
		JLabel lblFracasso = new JLabel("Erro ao Editar Arquivo");
		lblFracasso.setVisible(false);
		lblFracasso.setForeground(Color.RED);
		lblFracasso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFracasso.setBounds(203, 163, 179, 14);
		contentPane.add(lblFracasso);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String path = txtNome.getText();
                try {
					ManipuladorArquivo.escritorAgenda(path);
					lblSucesso.setVisible(true);
					lblInstrucao.setVisible(false);
					txtNome.setVisible(false);
				} catch (IOException e1) {
					lblFracasso.setVisible(true);
					e1.printStackTrace();
				}
                btnAdicionar.setVisible(false);
                btnMenu.setVisible(true);
			}
		});
		
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu().setVisible(true);
				dispose();
			}
		});
	}
}
