package Trabalho;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Trabalho.Arquivo.ManipuladorArquivo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Criar extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	public Criar() {
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
		lblInstrucao.setBounds(69, 183, 161, 14);
		contentPane.add(lblInstrucao);
		
		txtNome = new JTextField();
		txtNome.setBounds(230, 180, 126, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");

		btnCriar.setBounds(220, 246, 89, 23);
		contentPane.add(btnCriar);
		
		JButton btnMenu = new JButton("Voltar");

		btnMenu.setVisible(false);
		btnMenu.setBounds(220, 246, 89, 23);
		contentPane.add(btnMenu);
		
		JLabel lblSucesso = new JLabel("Arquivo Criado com Sucesso");
		lblSucesso.setForeground(Color.GREEN);
		lblSucesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSucesso.setVisible(false);
		lblSucesso.setBounds(164, 163, 205, 14);
		contentPane.add(lblSucesso);
		
		JLabel lblFracasso = new JLabel("Erro ao Criar Arquivo");
		lblFracasso.setVisible(false);
		lblFracasso.setForeground(Color.RED);
		lblFracasso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFracasso.setBounds(203, 163, 179, 14);
		contentPane.add(lblFracasso);
		
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String path = txtNome.getText();
                try {
					ManipuladorArquivo.escritor(path);
					lblSucesso.setVisible(true);
					lblInstrucao.setVisible(false);
					txtNome.setVisible(false);
				} catch (IOException e1) {
					lblFracasso.setVisible(true);
					e1.printStackTrace();
				}
                btnCriar.setVisible(false);
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
